//package falconrobotics.scoutingprogram;
//
//import android.util.Log;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//
///**
// * Sync the Pit scouting data from one dB to another.
// * <p/>
// * This is POC work for syncing pit scouting data between 2 SQLite dBs.  The code looks for any Pit records that meet the sync criteria of the caller (e.g. syncNum=0
// * if on the App or syncNum=-1 or > 0 if on the Server with -1 being used ONLY for the initial sync to the App, after that the value requested by the App should be > 1)
// * <p/>
// * This code will read data from one databases Pit table, extracting any records that should be sync'd to a second database and then insert/update those records in the
// * second databases Pit table.
// * <p/>
// * The find new entries logic is from ListPitAsSCV.  The insert / update entries logic is new code seen for the first time here.  The insert/update logic borrows its CSV
// * disection logic partly from PitData in the old Plasma code (at least initially I thought it would but it may not be the case by the time Im done.)
// * <p/>
// * Version 0.1 - Initial version
// */
//public class SyncPitData {
//    static String pitScoutingTable = "Pit";
//
//
//    /*
//     * The names of the SQLite tables that this code will read from.  We do them here so in case we want to change the names
//     * later we do not have to make manual edits in 452 different places and hardcoded strings.
//     */
//
////    public static void main( String[] args )
////    {
////        String appEventCode = "SCMBApp1";
////        String serverEventCode = "SCMBSrv1";
////        String season = "2016";
////
////        // Note:
////        // Set to -2 if you want to do a full initial sync down to the client since syncNum inits to -1 when the table is created
////        // Set to 0 if you are looking for records that need to be sent back to the server (e.g. they were scouted by the App)
////        // Set to > 0 if you are looking for records that need to be sent to the app (e.g. they were scouted by another App and sync'd to the server)
////        int syncNum = 0;
////
////        ArrayList<String> csvRecordsToSync = findPitRecords( season, appEventCode, syncNum );
////
//////        System.out.println( "Found " + csvRecordsToSync.size() + " records for syncNum=" + syncNum + " in " + season + appEventCode + ".db" );
//////        for ( String pitRecordCSV : csvRecordsToSync )
//////        {
//////            System.out.println( pitRecordCSV );
//////        }
////
////    // Only try to update the other sides dB if we have records that changed!
////
////    if ( csvRecordsToSync.size() > 0 )
////    {
////        for ( String pitRecordCSV : csvRecordsToSync )
////        {
////            updatePitRecord( season, serverEventCode, pitRecordCSV );
////        }
////
////        //  Time to update the syncNum of the records we received
////
////        updatePitSyncNums( season, serverEventCode );
////    }
////}
//
//
//    //ClientDatabase and Server Database not csv
//
//    /**
//     * Find any Pit scouting records that match the syncNum criteria of the caller.
//     *
//     * @param season    - The year to get the team list for.
//     * @param eventCode - The FIRST event code to get the pit records from
//     * @param syncNum   - The syncNum value to use for finding results.
//     *                  Use -2 for all records.
//     *                  Use 0 for only app scouted records (that need to go back to the server)
//     *                  use 1 or higher for server scouted records that the app does not have yet
//     */
//    public static ArrayList<String> findPitRecords(String season, String eventCode, int syncNum) {
//        // Create an empty Strings array to hold any results we want to return and a counter to track how many we have
//
//        ArrayList<String> pitRecordsCSVArray = new ArrayList<String>();
//
//        try {
//            Connection c = null;
//            Statement stmt = null;
//
//            Class.forName("org.sqlite.JDBC");
//
//            // Connect to the dB thats just for the specific event & season.  We use season then
//            // event code so that all dBs for a given year are easily found.
//
//            c = DriverManager.getConnection("jdbc:sqlite:" + season + eventCode + ".db");
//            c.setAutoCommit(false);
//
////            System.out.println("Opened database " + season + eventCode + ".db successfully");
//            Log.d("Opened Db",season+eventCode+".db successfully");
//
//            // Create a "statement" that will handle our command execution
//
//            stmt = c.createStatement();
//
//            // Look up all records from the Pit scouting table that meet our criteria:
//            // -2 = Initial sync down to the the app (syncNum = -1)
//            // 0 = All to be sync'd to server from app
//            // >0 = All that need to be sync'd to the app from the server
//
//            String rootSearchQuery = "SELECT * FROM " + pitScoutingTable + " WHERE syncNum ";
//            String searchQuery = (syncNum == 0) ? "= 0" : "> " + syncNum;
//
//            ResultSet rs = stmt.executeQuery(rootSearchQuery + searchQuery);
//
////            System.out.println( "Query: " + rootSearchQuery + searchQuery );
////
////            System.out.println( "Format: _id,yearDriver,wheels,weight,shooter,canClimb,climbSpeed,robotWidth,crossDef1,crossDef2,crossDef3,crossDef4,crossDef5,crossDef6,crossDef7,crossDef8,crossDef9,comments,robotPhoto,syncNum" );
//
//            // Recode all records we got back into a CSV format
//
//            while (rs.next()) {
//                String csvPitRecord = Integer.toString(rs.getInt("_id")) + "," + Integer.toString(rs.getInt("yearDriver")) + "," +
//                        Integer.toString(rs.getInt("wheels")) + "," + Integer.toString(rs.getInt("weight")) + "," + Integer.toString(rs.getInt("shooter")) + "," +
//                        Integer.toString(rs.getInt("canClimb")) + "," + Integer.toString(rs.getInt("climbSpeed")) + "," +
//                        Integer.toString(rs.getInt("robotWidth")) + "," + Integer.toString(rs.getInt("crossDef1")) + "," +
//                        Integer.toString(rs.getInt("crossDef2")) + "," + Integer.toString(rs.getInt("crossDef3")) + "," +
//                        Integer.toString(rs.getInt("crossDef4")) + "," + Integer.toString(rs.getInt("crossDef5")) + "," +
//                        Integer.toString(rs.getInt("crossDef6")) + "," + Integer.toString(rs.getInt("crossDef7")) + "," +
//                        Integer.toString(rs.getInt("crossDef8")) + "," + Integer.toString(rs.getInt("crossDef9")) + ",\"" +
//                        rs.getString("comments") + "\"," + Integer.toString(rs.getInt("robotPhoto")) + "," +
//                        Integer.toString(rs.getInt("syncNum"));
//
//                pitRecordsCSVArray.add(csvPitRecord);
//            }
//
//            rs.close();
//            stmt.close();
//            c.close();
//        } catch (Exception e) {
//            Log.e("Exception",e.toString());
//        }
//
//        return (pitRecordsCSVArray);
//    }
//
//    /**
//     * Insert or update the given CSV record into the Pit scouting table.  When the scouting app initially sync's from the server the
//     * table MAY be empty (unless we preload the database using DDMS)  For other cases there should already be a Pit scouting record
//     * for the _id in the CSV so we will be doing an UPDATE to the database instead.
//     * <p/>
//     * Note: The use of INSERT OR REPLACE will cause SQLite to delete any existing record and insert a new one at a different ROWID
//     * if you are 'replacing' an existing record.  Its not as clean as using UPDATE which we probably should because we know in advance
//     * that the tables have ALL the records we will ever want thanks to the code that creates and sets up the dB!   SOOOOO if you want
//     * to be nice and tidy (and not reorder any tables) then you should use the updatePitRecord method instead...
//     *
//     * @param season       - The year to get the team list for.
//     * @param eventCode    - The FIRST event code to get the pit records from
//     * @param csvPitRecord - A CSV encoded Pit scouting record from the remote system.
//     */
//    public static void insertOrUpdatePitRecord(String season, String eventCode, String csvPitRecord) {
//        try {
//            Connection c = null;
//            Statement stmt = null;
//
//            // Carve up the Pit CSV record into individual data elements that we can the use to update the database
//
//            String data[] = csvPitRecord.split(",");
//
//            // System.out.println( "The CSV record has " + data.length + " fields:" );
//            // for ( int j = 0; j < data.length; j++)
//            // 	{
//            // 	System.out.println( "  " + j + ": " + data[ j ]);
//            // 	}
//
//            Class.forName("org.sqlite.JDBC");
//
//            // Connect to the dB thats just for the specific event & season.  We use season then
//            // event code so that all dBs for a given year are easily found.
//
//            c = DriverManager.getConnection("jdbc:sqlite:" + season + eventCode + ".db");
//            // c.setAutoCommit( false );
//
////            System.out.println("Opened database " + season + eventCode + ".db successfully");
//
//            // Create a "statement" that will handle our command execution
//
//            stmt = c.createStatement();
//
//            //System.out.println( "Format: _id,yearDriver,wheels,weight,shooter,canClimb,climbSpeed,robotWidth,crossDef1,crossDef2,crossDef3,crossDef4,crossDef5,crossDef6,crossDef7,crossDef8,crossDef9,comments,robotPhoto,syncNum" );
//
//            // Pre build the SQLite command for inserting or updating the CSV data we have.
//
//            String rootPitInserOrUpdateQuery = "INSERT OR REPLACE INTO " + pitScoutingTable + "(_id,yearDriver,wheels,weight,shooter,canClimb,climbSpeed,robotWidth,crossDef1,crossDef2,crossDef3,crossDef4,crossDef5,crossDef6,crossDef7,crossDef8,crossDef9,comments,robotPhoto,syncNum) VALUES (";
//
//            stmt.executeUpdate(rootPitInserOrUpdateQuery +
//                    Integer.parseInt(data[0]) + "," + // _id
//                    Integer.parseInt(data[1]) + "," + // yearDriver
//                    Integer.parseInt(data[2]) + "," + // wheels
//                    Integer.parseInt(data[3]) + "," + // weight
//                    Integer.parseInt(data[4]) + "," + // shooter
//                    Integer.parseInt(data[5]) + "," + // canClimb
//                    Integer.parseInt(data[6]) + "," + // climbSpeed
//                    Integer.parseInt(data[7]) + "," + // robotWidth
//                    Integer.parseInt(data[8]) + "," + // crossDef1
//                    Integer.parseInt(data[9]) + "," + // crossDef2
//                    Integer.parseInt(data[10]) + "," + // crossDef3
//                    Integer.parseInt(data[11]) + "," + // crossDef4
//                    Integer.parseInt(data[12]) + "," + // crossDef5
//                    Integer.parseInt(data[13]) + "," + // crossDef6
//                    Integer.parseInt(data[14]) + "," + // crossDef7
//                    Integer.parseInt(data[15]) + "," + // crossDef8
//                    Integer.parseInt(data[16]) + "," + // crossDef9
//                    data[17] + "," +                     // comments
//                    Integer.parseInt(data[18]) + "," + // robotPhoto
//                    Integer.parseInt(data[19]) + ")"   // syncNum
//            );
//
//            stmt.close();
//            c.close();
//        } catch (Exception e) {
//            Log.e("Exception",e.toString());
//        }
//    }
//
//    /**
//     * Update the given CSV record into the Pit scouting table.
//     * <p/>
//     * Note: This method uses the SQLite UPDATE command to update an existing record in the Pit scouting table since we know that every
//     * team will have one to begin with.  This keeps the data in the table happy by not reordering records like INSERT OR REPLACE
//     * would do (see insertOrUpdatePitRecord() for more)
//     *
//     * @param season       - The year to get the team list for.
//     * @param eventCode    - The FIRST event code to get the pit records from
//     * @param csvPitRecord - A CSV encoded Pit scouting record from the remote system.
//     */
//    public static void updatePitRecord(String season, String eventCode, String csvPitRecord) {
//        try {
//            Connection c = null;
//            Statement stmt = null;
//
//            // Carve up the Pit CSV record into individual data elements that we can the use to update the database
//
//            String data[] = csvPitRecord.split(",");
//
//            // System.out.println( "The CSV record has " + data.length + " fields:" );
//            // for ( int j = 0; j < data.length; j++)
//            // 	{
//            // 	System.out.println( "  " + j + ": " + data[ j ]);
//            // 	}
//
//            Class.forName("org.sqlite.JDBC");
//
//            // Connect to the dB thats just for the specific event & season.  We use season then
//            // event code so that all dBs for a given year are easily found.
//
//            c = DriverManager.getConnection("jdbc:sqlite:" + season + eventCode + ".db");
//
////            System.out.println("Opened database " + season + eventCode + ".db successfully");
//            Log.d("Opened database",season+eventCode+".db successfully");
//            // Create a "statement" that will handle our command execution
//
//            stmt = c.createStatement();
//
//            //System.out.println( "Format: _id,yearDriver,wheels,weight,shooter,canClimb,climbSpeed,robotWidth,crossDef1,crossDef2,crossDef3,crossDef4,crossDef5,crossDef6,crossDef7,crossDef8,crossDef9,comments,robotPhoto,syncNum" );
//
//            // Have SQLite update the Pit record we have
//
//            stmt.executeUpdate("UPDATE " + pitScoutingTable + " SET " +
//                            "yearDriver=" + Integer.parseInt(data[1]) + ", " +
//                            "wheels=" + Integer.parseInt(data[2]) + "," +
//                            "weight=" + Integer.parseInt(data[3]) + "," +
//                            "shooter=" + Integer.parseInt(data[4]) + "," +
//                            "canClimb=" + Integer.parseInt(data[5]) + "," +
//                            "climbSpeed=" + Integer.parseInt(data[6]) + "," +
//                            "robotWidth=" + Integer.parseInt(data[7]) + "," +
//                            "crossDef1=" + Integer.parseInt(data[8]) + "," +
//                            "crossDef2=" + Integer.parseInt(data[9]) + "," +
//                            "crossDef3=" + Integer.parseInt(data[10]) + "," +
//                            "crossDef4=" + Integer.parseInt(data[11]) + "," +
//                            "crossDef5=" + Integer.parseInt(data[12]) + "," +
//                            "crossDef6=" + Integer.parseInt(data[13]) + "," +
//                            "crossDef7=" + Integer.parseInt(data[14]) + "," +
//                            "crossDef8=" + Integer.parseInt(data[15]) + "," +
//                            "crossDef9=" + Integer.parseInt(data[16]) + "," +
//                            "comments=" + data[17] + "," +
//                            "robotPhoto=" + Integer.parseInt(data[18]) + "," +
//                            "syncNum==" + Integer.parseInt(data[19]) + " " +
//                            "WHERE _id = " + Integer.parseInt(data[0])
//            );
//
//            stmt.close();
//            c.close();
//        } catch (Exception e) {
//            Log.e("Exeception",e.toString());
//        }
//    }
//
//    /**
//     * Set a new syncNum value for any newly sync'd Pit scouting records.  Any record that has a syncNum of 0 now needs to be updated to be the current max
//     * non-negative syncNum value + 1.  This is what both the scouting app and the server will do once the Pit scouting data is sync'd between one another.
//     * <p/>
//     * Note that this will cause every Pit scouting record in every scouting app will have the same syncNum for the the same Pit records.  That happens because
//     * the syncNum that gets used is always 1 higher than any current value already there.  To make it easier to follow I will describe 2 scouts using 2 separate apps
//     * and describe how this all works.
//     * <p/>
//     * Both apps scout the pits (different teams).  They both set their syncNum values on scouted teams to 0 from -1.  When app1 syncs to the server its records will
//     * get inserted as syncNum=0 on the server.  Once all app1 Pit updates are done the server will scan for the highest syncNum in the Pit table.  It finds only the
//     * app1 records at 0 so it bumps them all to syncNum=1.  App1 in the mean time does the same thing once it finishes syncing its Pit records to the servers.  This
//     * puts both app1 and the server in agreement.
//     * <p/>
//     * Now app2 will send its separate Pit scouting records to the server.  After syncing is done the server scans its records and finds the highest syncNum = 1 so it
//     * updates all the app2 sync'd records to syncNum=2.  App2 received updates from the server before it pushed up its un-sync'd records so it has app1s updates
//     * and all of its own data.  App2 performs the same scan for a highest syncNum, finds syncNum=1 from the app1 records and sets all of its syncNum=0 records to be
//     * syncNum=2 now.
//     * <p/>
//     * This puts App2 and the server in sync.  App1 is mostly in sync.  If it syncs later it will first pull any new updates from the server (by asking for any records
//     * with a syncNum > 1 since it already has syncNum=1).  Server will find the app2 records and send them back to app1.  It will update its Pit scouting dB and now
//     * app1, app2 and the server are all in sync.
//     * <p/>
//     * The key to this is to always pull from the server before pushing changes to it. That way the app can accurately update its locally collected records to the
//     * right syncNum that the server will (if there any to push after pulling).
//     *
//     * @param season    - The year to get the team list for.
//     * @param eventCode - The FIRST event code to get the pit records from
//     */
//    public static void updatePitSyncNums(String season, String eventCode) {
//        try {
//            Connection c = null;
//            Statement stmt = null;
//
//            Class.forName("org.sqlite.JDBC");
//
//            // Connect to the dB thats just for the specific event & season.  We use season then
//            // event code so that all dBs for a given year are easily found.
//
//            c = DriverManager.getConnection("jdbc:sqlite:" + season + eventCode + ".db");
//            // c.setAutoCommit( false );
//
////            System.out.println("Opened database " + season + eventCode + ".db successfully");
//            Log.d("Opened database",season+eventCode+".db succesfully");
//
//
//
//            // Create a "statement" that will handle our command execution
//
//            stmt = c.createStatement();
//
//            //System.out.println( "Format: _id,yearDriver,wheels,weight,shooter,canClimb,climbSpeed,robotWidth,crossDef1,crossDef2,crossDef3,crossDef4,crossDef5,crossDef6,crossDef7,crossDef8,crossDef9,comments,robotPhoto,syncNum" );
//
//            // Pre build the SQLite command for inserting or updating the CSV data we have.
//
//            String pitScanQuery = "SELECT * FROM " + pitScoutingTable + " WHERE syncNum > -1";
//
//            ResultSet rs = stmt.executeQuery(pitScanQuery);
//
////            System.out.println("Query: " + pitScanQuery);
//            Log.d("Query",pitScanQuery);
//
//
//            // Scan all records we got back for the highest positive syncNum
//
//            int maxSyncNum = 0;
//            Boolean bNeedToUpdate = false;        // Assume we have no syncNum=0 records unless we see one while we scan
//
//            while (rs.next()) {
//                int syncNum = rs.getInt("syncNum");    // Only get it once from the object to avoid repeated object access overhead
//
//                if (syncNum > maxSyncNum)
//                    maxSyncNum = syncNum;
//
//                if (syncNum == 0)
//                    bNeedToUpdate = true;
//            }
//
//            // If we have no records to update then we are done.  Otherwise we need to update their syncNums
//
//            if (bNeedToUpdate) {
////                System.out.println("We found at least one record to assign syncNum=" + maxSyncNum + " to.");
//                Log.d("Found0,","We found at least one record to assign SyncNum="+maxSyncNum+"to.");
//
//                // Bump the syncNum...
//                maxSyncNum++;
//
//                // and then update all syncNum=0 records with the new value...
//                stmt.executeUpdate("UPDATE " + pitScoutingTable + " SET syncNum=" + maxSyncNum + " WHERE syncNum=0");
//            } else {
////                System.out.println("We found NO Pit records to update the syncNum on.");
//                Log.d("found","NO pit records found");
//            }
//
//            stmt.close();
//            c.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
