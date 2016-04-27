//package falconrobotics.scoutingprogram;
//
//import android.util.Base64;
//import android.widget.Toast;
//
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.sql.Connection;
//import java.util.ArrayList;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
///**
// * Retrieve the match schedule for a particular event using the FRC Events API 2.0
// *
// * It pulls the registered team list for a single event AND saves it to a database based on the year and event code.  Any match data already in such a named dB will
// * be permanently lost if you ask for Qualifier level matches!  If you ask for Playoff level matches then the existing tables are left intact!
// *
// * This code will populate the Matches and Schedule tables.
// *
// * Version 0.1 - Initial version
// * Version 0.2 - Replaced teamNum with _id as the primary key for Androids benefit.  That way the scouting app does not have to use an "as _id"
// * 					alias in the SELECT it uses.
// * 				 Added new encoding to _id (aka matchNum) so that we can have all levels of matches in a single table.  Instead of adding a matchLevel
// * 					field to the tables we will use range encoding: Values 1001-1999 are for Qualifier matches 1-999 and values 2001-2999 are for Playoff
// * 					matches 1-999
// * 				 We now only erase the Matches and Schedule tables if the we are pulling Qualifier match info.  If pulling Playoff match info for an
// * 					event we leave the current tables intact.
// * 				 Added match description from FIRST API to the Schedule database
// * Version 0.3 - Updated the Matches table to be in sync with the design doc in Drive:
// * 					telePush - Removed
// * 					teleBlock - Expanded to teleBlock1, teleBlock2 & teleBlock3
// * 					challenged - Added
// * Version 0.4 - Updated the column names according to the ones in the spreadsheet
// *                     https://docs.google.com/spreadsheets/d/1aqM893R4QEiJy74CJP4Bptboi3IGDWOjDeHWYMlhKPA/edit#gid=0
// *              Also adapted the original class to fit the needs of the app. Took out the create table statements
// */
//public class Util_GetMatchList {
//    /*
//     * The URL to the PRODUCTION server (for live FIRST info)
//     */
//    static String webPageRoot = "https://frc-api.firstinspires.org/v2.0/";
//
//	/*
//	 * The URL to the STAGING server (for app demo/testing)
//	 */
//    // static String webPageRoot = "https://frc-staging-api.firstinspires.org/v2.0/";
//
//    /*
//     * FRC Events API 2.0 issued credentials.  These are used to gain access to the FIRST Events APIs.
//     *
//     * DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE
//     * DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE
//     * DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE
//     */
//    static String name = "BruceKahn";
//    static String password = "27461226-AFF6-4A7B-8011-C44AA19DD1A5";
//
//	/* END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING
//	 * END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING
//	 * END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING
//	 */
//
//	/*
//	 * The names of the SQLite tables that this code will update.  We do them here so in case we want to change the names
//	 * later we do not have to make manual edits in 452 different places and hardcoded strings.
//	 */
//
//    static String scheduleTable = Helper.TABLE_SCHEDULE;
//
//    /*
//     * These are used to make doing match slot identification cleaner in code.
//     */
//    static String slotRed1 = "Red1";
//    static String slotRed2 = "Red2";
//    static String slotRed3 = "Red3";
//    static String slotBlue1 = "Blue1";
//    static String slotBlue2 = "Blue2";
//    static String slotBlue3 = "Blue3";
//
//
//    /**
//     * Setup and populate the Matches table that our scouting app will use.
//     *
//     * Query the FIRST Events API for the match schedule at a specific event.  Use the list to (re)create the Matches table in an
//     * SQLite dB that will be named based on the inputs.  For instance, if eventCode="AZFL" and season=2016 then the database will be named 2016azfl.db.
//     * This design allows us to easily populate event databases for multiple Regionals.
//     *
//     * NOTE: ALL existing data in the events current Match list table WILL BE LOST!  Do NOT use this method on a live scouting dB
//     * that you have data in that you want to preserve; it will be lost!  You have been warned!!
//     *
//     * @param eventCode - The FIRST event code to get the team list for
//     * @param season - The year to get the team list for.
//     * @param tournamentLevel - The tournament level we want match info for (qual or playoff)
//     */
//    public static void setupMatchListTableForEvent( String eventCode , String season, String tournamentLevel )
//    {
//
//        Helper helper;
//        Connection c = null;
//
//        ArrayList<Integer> interfaceFiller = new ArrayList<Integer>();
//
//        try
//        {
//            helper = new Helper();
//
//            // Lastly we query the FIRST Event API so we can populate the team numbers (and default values)
//            //
//            // Construct the URL to retrieve the desired regional list of participating teams
//
//            URL url = new URL( webPageRoot + "/" + season + "/schedule/" + eventCode + "?tournamentlevel=" + tournamentLevel );
//            HttpURLConnection httpConnection  = (HttpURLConnection) url.openConnection();
//
//            // Include the required authentication info and the fact we want data in JSON
//
//            String authString = name + ":" + password;
//            byte[] authEncBytes = Base64.encode/*changed from Base64.encode64*/( authString.getBytes() , 0);
//            String authStringEnc = new String( authEncBytes );
//
//            httpConnection.setRequestProperty( "Authorization", "Basic " + authStringEnc );
//            httpConnection.setRequestProperty( "Accept", "application/json" );
//
//            InputStream is = httpConnection.getInputStream();
//
//            InputStreamReader isr = new InputStreamReader( is );
//
//            int numCharsRead;
//            char[] charArray = new char[ 1024 ];		// Read 1K of data at a time
//            StringBuffer sb = new StringBuffer();
//
//            // Read all the data they want to send and save it away for processing when they are done
//
//            while ( ( numCharsRead = isr.read( charArray ) ) > 0 )
//            {
//                sb.append( charArray, 0, numCharsRead );
//            }
//
//            String result = sb.toString();
//
////            System.out.println( "*** BEGIN MATCH LIST DATA ***" );
////            System.out.println( result );
////            System.out.println( "*** END MATCH LIST DATA ***" );
//
//            // Lets do a little quick JSON data processing:
//
//            JSONObject json = new JSONObject( result );
//
//            JSONArray matchScheduleArray = json.getJSONArray( "Schedule" );
//
//            // Get the non-alliance level info we intend to log
//
//            int matchLevel = 0;
//
//            if ( tournamentLevel.equalsIgnoreCase( "qual" ) )
//                matchLevel = 1000;
//            else
//                matchLevel = 2000;
//
//            for ( int i = 0; i < matchScheduleArray.length(); i++ )
//            {
//                JSONObject matchInfo = matchScheduleArray.getJSONObject( i );
//
//                // The team numbers are buried in the Teams array.  We need to extract the teamNumber JSON value and assign it to one of 6 slots
//                // (3 red and 3 blue).  There is no guarantee on the order so we will simply parse over the Teams sub-array and use the station value
//                // to decide what slot to put the values into.   Once we do that, we can save off the match info into the database
//                //
//                // NOTE: All of this slot identification is NOT needed for creating the Match scouting table.  It IS needed for creating the
//                // APIScoreDetails table which will be the next routine I create.  So I am leaving this in place for now and will edit out
//                // when the new routine gets created.
//
//                int red1 = 0;
//                int red2 = 0;
//                int red3 = 0;
//                int blue1 = 0;
//                int blue2 = 0;
//                int blue3 = 0;
//
//                // In the interest of speed lets get the match number once from the JSON data instead of looking it up as needed later on
//
//                int matchNum = matchInfo.getInt( "matchNumber" );
//
//                JSONArray teamsArray = matchInfo.getJSONArray( "Teams" );
//
//                if ( teamsArray != null )
//                {
//                    JSONObject teamInfo;
//
//                    for ( int j = 0; j < teamsArray.length(); j++ )
//                    {
//                        teamInfo = teamsArray.getJSONObject( j );
//
//                        String station = teamInfo.getString( "station" );
//
//                        try
//                        {
//                            if ( station != null )
//                            {
//                                // We found a station value so see which one it matches so we can assign the team number to the right slot.
//                                // That way after we see all the teams in the schedule we can create a single Schedule record entry (even though
//                                // technically its the simplest of the 2 tables)
//
//                                if ( slotRed1.equals( station ) )
//                                    red1 = teamInfo.getInt( "teamNumber" );
//                                else if ( slotRed2.equals( station ) )
//                                    red2 = teamInfo.getInt( "teamNumber" );
//                                else if ( slotRed3.equals( station ) )
//                                    red3 = teamInfo.getInt( "teamNumber" );
//                                else if ( slotBlue1.equals( station ) )
//                                    blue1 = teamInfo.getInt( "teamNumber" );
//                                else if ( slotBlue2.equals( station ) )
//                                    blue2 = teamInfo.getInt( "teamNumber" );
//                                else if ( slotBlue3.equals( station ) )
//                                    blue3 = teamInfo.getInt( "teamNumber" );
//                            }
//
//                            // First we will do the ugly one, the Match Scouting records since we can do that as we see each team number
//                            //
//                            // Note: Since Comments are optional (e.g. can be NULL) we will not create any default ones.  That is why
//                            // that item is NOT in the INSERT command below.
//                            //
//                            // We will use a syncNum value of -1 to mean "Not yet scouted"  That way the app can set the value to 0 when it pit scouts so it knows which records
//                            // need to get sync'd to the server.  The server will then set the syncNum to be something positive so that it can tell which ones it needs to push
//                            // back down to other apps when they sync.
//                            // This approach also allows the server to tell when a match scouting record is NOT the one it created initially.  It can then either ignore or ask someone
//                            // to rule on if a change sync'd up from a different app should replace what is already there or not (e.g. the match was replayed!?)
//
////                            stmt.executeUpdate( "INSERT INTO " + matchesTable + "(_id,teamNum,autoDef1,autoDef2,autoDef3,autoDef4,autoDef5," +
////                                    "autoBoulder,autoLowMiss,autoLowMake,autoHighMiss,autoHighMake," +
////                                    "teleDef1Miss,teleDef1Make,teleDef2Miss,teleDef2Make,teleDef3Miss,teleDef3Make,teleDef4Miss,teleDef4Make,teleDef5Miss,teleDef5Make," +
////                                    "teleLowMiss,teleLowMake,teleHighMiss,teleHighMake,boulderPass," +
////                                    "teleBlock1,teleBlock2,teleBlock3,climb,challenged,"+
////                                    "scoreTotal,scoreAuto,scoreFoul,carded,stoped,syncNum)" +
////                                    " VALUES (" + ( matchLevel + matchNum )  + "," + teamInfo.getInt( "teamNumber" ) + ",0,0,0,0,0," +
////                                    "0,0,0,0,0," +
////                                    "0,0,0,0,0,0,0,0,0,0," +
////                                    "0,0,0,0,0," +
////                                    "0,0,0,0,0,"+
////                                    "0,0,0,0,0,-1)" );
//
//
//                            helper.match_update(MainActivity.insert, new Model_Match(
//                                    ( matchLevel + matchNum ),teamInfo.getInt( "teamNumber" ),
//                                    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1));
//                            Interface_Spinners.Teams.add(teamInfo.getInt( "teamNumber" ));
//                            Interface_Spinners.Matches.add(matchNum);
//                            Interface_Spinners.MatchesWLevel.add(matchLevel + matchNum);
//                        }
//                        catch ( JSONException je )
//                        {
//                            Toast.makeText(MainActivity.context,"Unable to fully parse match and schedule data for match " + matchNum + " so skipping for now" , Toast.LENGTH_LONG).show();
//                        }
//                    } // for (j)
//
//                    // Now that we have fully scanned the teams in the match record we can create a single Schedule record with the right team numbers in the right slots
//
//                    // We should only insert full schedule records so we do not have to do "updates" to partials.  Thats work left for once we get the larger sync
//                    // code working...
//
//                    if ( blue1 != 0 && blue2 != 0 && blue3 != 0 && red1 != 0 && red2 != 0 && red3 != 0 )
//                        helper.exec( "INSERT OR REPLACE INTO " +  scheduleTable + " (_id,description,blueRobot1,blueRobot2,blueRobot3,redRobot1,redRobot2,redRobot3,syncNum)" +
//                                " VALUES (" + ( matchLevel + matchNum ) + ",\"" +  matchInfo.getString( "description" ).trim() + "\"," + blue1 + "," + blue2 + "," + blue3 + "," + red1 + "," + red2 + "," + red3 + ",0)" );
//
//                } // teamInfo != null
//            } // for (i)
//
//            // All done, time to clean up
//
//            c.close();
//        }
//        catch ( Exception e )
//        {
//            Toast.makeText(MainActivity.context,
//                    "ERROR: " + e.getClass().getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
//            System.exit( 0 );
//        }
//    }
//}
