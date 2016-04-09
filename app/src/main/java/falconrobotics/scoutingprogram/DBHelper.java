package falconrobotics.scoutingprogram;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created on 2/22/2016.
 */
public class DBHelper extends SQLiteOpenHelper
{

    //tables in the Google Sheet
    public static final String TABLE_MATCHES ="Matches",
            TABLE_PIT ="Pit",
            TABLE_SCHEDULE ="Schedule",
            TABLE_TEAMS ="Teams";

    //Match, Pit, Schedule  common key, won't be included in every table
    public static final String KEY_SYNCNUM ="syncNum"; // not sure if this is correct

    public static final String INTEGER =" INTEGER NOT NULL, ";
    public static final String TEXT =" TEXT NOT NULL, ";

    //Match Table  keys
    public static final String KEY_MATCH_ID ="_id",
            KEY_MATCH_TEAMNUM ="teamNum",
            KEY_MATCH_AUTODEF1 ="autoDef1",
            KEY_MATCH_AUTODEF2 ="autoDef2",
            KEY_MATCH_AUTODEF3 ="autoDef3",
            KEY_MATCH_AUTODEF4 ="autoDef4",
            KEY_MATCH_AUTODEF5 ="autoDef5",
            KEY_MATCH_AUTOLOWMISS ="autoLowMiss",
            KEY_MATCH_AUTOLOWMAKE ="autoLowMake",
            KEY_MATCH_AUTOHIGHMISS ="autoHighMiss",
            KEY_MATCH_AUTOHIGHMAKE ="autoHighMake",
            KEY_MATCH_TELEDEF1MISS ="teleDef1Miss",
            KEY_MATCH_TELEDEF1MAKE ="teleDef1Make",
            KEY_MATCH_TELEDEF2MISS ="teleDef2Miss",
            KEY_MATCH_TELEDEF2MAKE ="teleDef2Make",
            KEY_MATCH_TELEDEF3MISS ="teleDef3Miss",
            KEY_MATCH_TELEDEF3MAKE ="teleDef3Make",
            KEY_MATCH_TELEDEF4MISS ="teleDef4Miss",
            KEY_MATCH_TELEDEF4MAKE ="teleDef4Make",
            KEY_MATCH_TELEDEF5MISS ="teleDef5Miss",
            KEY_MATCH_TELEDEF5MAKE ="teleDef5Make",
            KEY_MATCH_TELELOWMISS ="teleLowMiss",
            KEY_MATCH_TELELOWMAKE ="teleLowMake",
            KEY_MATCH_TELEHIGHMISS ="teleHighMiss",
            KEY_MATCH_TELEHIGHMAKE ="teleHighMake",
            KEY_MATCH_TELEBLOCK1 ="teleBlock1",
            KEY_MATCH_TELEBLOCK2 ="teleBlock2",
            KEY_MATCH_TELEBLOCK3 ="teleBlock3",
            KEY_MATCH_CLIMB ="climb",
            KEY_MATCH_CHALLENGED ="challenged",
            KEY_MATCH_CARDED ="carded",
            KEY_MATCH_STOPPED ="stopped",
            KEY_MATCH_COMMENTS ="comments";

    //Pit Table  keys
    public static final String KEY_PIT_ID ="_id",
            KEY_PIT_DRIVER_XP ="driverXP",
            KEY_PIT_OPERATOR_XP = "operatorXP",
            KEY_PIT_DRIVETRAIN ="drivetrain",
            KEY_PIT_PNEUMATICS = "pneumatics",
            KEY_PIT_SHOOTER_TYPE ="shooterType",
            KEY_PIT_SHOOTING_TYPE = "shootingType",
            KEY_PIT_CLIMB ="climb",
            KEY_PIT_CLIMBSPEED ="climbSpeed",
            KEY_PIT_WEIGHT = "weight",
            KEY_PIT_ROBOT_DIMENSIONS = "robotDimensions",
            KEY_PIT_PORTCULLIS ="portcullis",
            KEY_PIT_CHEVALDEFRISE ="chevalDeFrise",
            KEY_PIT_MOAT ="moat",
            KEY_PIT_RAMPARTS ="ramparts",
            KEY_PIT_DRAWBRIDGE ="drawbridge",
            KEY_PIT_SALLYPORT ="sallyPort",
            KEY_PIT_ROCKWALL ="rockWall",
            KEY_PIT_ROUGHTERRAIN ="roughTerrain",
            KEY_PIT_LOWBAR ="lowBar",
            KEY_PIT_COMMENTS ="comments",
            KEY_PIT_ROBOTPHOTO ="robotPhoto";
    public static final String[] ARRAY_PIT = new String[]{
            KEY_PIT_ID,
            KEY_PIT_DRIVER_XP,
            KEY_PIT_OPERATOR_XP,
            KEY_PIT_DRIVETRAIN,
            KEY_PIT_PNEUMATICS,
            KEY_PIT_SHOOTER_TYPE,
            KEY_PIT_SHOOTING_TYPE,
            KEY_PIT_CLIMB,
            KEY_PIT_CLIMBSPEED,
            KEY_PIT_WEIGHT,
            KEY_PIT_ROBOT_DIMENSIONS,
            KEY_PIT_PORTCULLIS,
            KEY_PIT_CHEVALDEFRISE,
            KEY_PIT_MOAT,
            KEY_PIT_RAMPARTS,
            KEY_PIT_DRAWBRIDGE,
            KEY_PIT_SALLYPORT,
            KEY_PIT_ROCKWALL,
            KEY_PIT_ROUGHTERRAIN,
            KEY_PIT_LOWBAR,
            KEY_PIT_COMMENTS,
            KEY_PIT_ROBOTPHOTO,
            KEY_SYNCNUM};

    //Schedule Table  keys
    public static final String KEY_SCHEDULE_ID ="_id",
            KEY_SCHEDULE_DESCRIPTION ="description",
            KEY_SCHEDULE_BLUEROBOT1 ="blueRobot1",
            KEY_SCHEDULE_BLUEROBOT2 ="blueRobot2",
            KEY_SCHEDULE_BLUEROBOT3 ="blueRobot3",
            KEY_SCHEDULE_REDROBOT1 ="redRobot1",
            KEY_SCHEDULE_REDROBOT2 ="redRobot2",
            KEY_SCHEDULE_REDROBOT3 ="redRobot3";

    //Teams Table  keys
    public static final String KEY_TEAMS_ID = "_id";
    public static final String KEY_TEAMS_SHORTNAME = "shortName";

    //Match Table  create statement
    public static final String CREATE_TABLE_MATCH =
            "CREATE TABLE IF NOT EXISTS "
                    + TABLE_MATCHES + "("
                    + KEY_MATCH_ID + " INT PRIMARY KEY NOT NULL, "
                    + KEY_MATCH_TEAMNUM + INTEGER
                    + KEY_MATCH_AUTODEF1 + INTEGER
                    + KEY_MATCH_AUTODEF2 + INTEGER
                    + KEY_MATCH_AUTODEF3 + INTEGER
                    + KEY_MATCH_AUTODEF4 + INTEGER
                    + KEY_MATCH_AUTODEF5 + INTEGER
                    + KEY_MATCH_AUTOLOWMISS + INTEGER
                    + KEY_MATCH_AUTOLOWMAKE + INTEGER
                    + KEY_MATCH_AUTOHIGHMISS + INTEGER
                    + KEY_MATCH_AUTOHIGHMAKE + INTEGER
                    + KEY_MATCH_TELEDEF1MISS + INTEGER
                    + KEY_MATCH_TELEDEF1MAKE + INTEGER
                    + KEY_MATCH_TELEDEF2MISS + INTEGER
                    + KEY_MATCH_TELEDEF2MAKE + INTEGER
                    + KEY_MATCH_TELEDEF3MISS + INTEGER
                    + KEY_MATCH_TELEDEF3MAKE + INTEGER
                    + KEY_MATCH_TELEDEF4MISS + INTEGER
                    + KEY_MATCH_TELEDEF4MAKE + INTEGER
                    + KEY_MATCH_TELEDEF5MISS + INTEGER
                    + KEY_MATCH_TELEDEF5MAKE + INTEGER
                    + KEY_MATCH_TELELOWMISS + INTEGER
                    + KEY_MATCH_TELELOWMAKE + INTEGER
                    + KEY_MATCH_TELEHIGHMISS + INTEGER
                    + KEY_MATCH_TELEHIGHMAKE + INTEGER
                    + KEY_MATCH_TELEBLOCK1 + INTEGER
                    + KEY_MATCH_TELEBLOCK2 + INTEGER
                    + KEY_MATCH_TELEBLOCK3 + INTEGER
                    + KEY_MATCH_CLIMB + INTEGER
                    + KEY_MATCH_CHALLENGED + INTEGER
                    + KEY_MATCH_CARDED + INTEGER
                    + KEY_MATCH_STOPPED + INTEGER
                    + KEY_MATCH_COMMENTS + TEXT
                    + KEY_SYNCNUM + " INT NOT NULL"
                    + ");";
    //Pit Table  create statement
    public static final String CREATE_TABLE_PIT =
            "CREATE TABLE IF NOT EXISTS "
                    + TABLE_PIT + "("
                    + KEY_PIT_ID + " INT PRIMARY KEY NOT NULL, "
                    + KEY_PIT_DRIVER_XP + INTEGER
                    + KEY_PIT_OPERATOR_XP + INTEGER
                    + KEY_PIT_DRIVETRAIN + INTEGER
                    + KEY_PIT_PNEUMATICS + INTEGER
                    + KEY_PIT_SHOOTER_TYPE + INTEGER
                    + KEY_PIT_SHOOTING_TYPE + INTEGER
                    + KEY_PIT_CLIMB + INTEGER
                    + KEY_PIT_CLIMBSPEED + INTEGER
                    + KEY_PIT_WEIGHT + INTEGER
                    + KEY_PIT_ROBOT_DIMENSIONS + INTEGER
                    + KEY_PIT_PORTCULLIS + INTEGER
                    + KEY_PIT_CHEVALDEFRISE + INTEGER
                    + KEY_PIT_MOAT + INTEGER
                    + KEY_PIT_RAMPARTS + INTEGER
                    + KEY_PIT_DRAWBRIDGE + INTEGER
                    + KEY_PIT_SALLYPORT + INTEGER
                    + KEY_PIT_ROCKWALL + INTEGER
                    + KEY_PIT_ROUGHTERRAIN + INTEGER
                    + KEY_PIT_LOWBAR + INTEGER
                    + KEY_PIT_COMMENTS + TEXT
                    + KEY_PIT_ROBOTPHOTO + INTEGER
                    + KEY_SYNCNUM + " INT NOT NULL "
                    + ");";
    //Schedule Table  create statement
    public static final String CREATE_TABLE_SCHEDULE =
            "CREATE TABLE IF NOT EXISTS "
                    + TABLE_SCHEDULE + "("
                    + KEY_SCHEDULE_ID + " INT PRIMARY KEY NOT NULL, "
                    + KEY_SCHEDULE_DESCRIPTION + TEXT
                    + KEY_SCHEDULE_BLUEROBOT1 + INTEGER
                    + KEY_SCHEDULE_BLUEROBOT2 + INTEGER
                    + KEY_SCHEDULE_BLUEROBOT3 + INTEGER
                    + KEY_SCHEDULE_REDROBOT1 + INTEGER
                    + KEY_SCHEDULE_REDROBOT2 + INTEGER
                    + KEY_SCHEDULE_REDROBOT3 + INTEGER
                    + KEY_SYNCNUM + " INT NOT NULL "
                    + ");";
    //Team Table  create statement
    public static final String CREATE_TABLE_TEAMS =
            "CREATE TABLE IF NOT EXISTS "
                    + TABLE_TEAMS + "("
                    + KEY_TEAMS_ID + " INT PRIMARY KEY NOT NULL, "
                    + KEY_TEAMS_SHORTNAME + TEXT
                    + KEY_SYNCNUM + " INT NOT NULL "
                    + ");";

    private String dbName = "DEFAULTNAME.db";
    public static String mainDirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "falconrobotics2016";
    public static String picDirPath = mainDirPath + File.separator + "pictures";
    public static String dbDirPath = mainDirPath + File.separator + "databases";

    public DBHelper(String dbName) {
        super(MainActivity.context, dbDirPath + File.separator + dbName, null, 1);
        this.dbName = dbName;
    }

    public static void createDir() {
        File picDir = new File(picDirPath);
        if (!picDir.exists()) {
            if (!picDir.mkdirs()) {
                //  WARN USER
                Toast.makeText(MainActivity.context, "WARNING! UNABLE TO CREATE WORKING DIRECTORY. PLEASE REINSTALL AND DELETE ALL ASSOCIATED FILES", Toast.LENGTH_LONG).show();
            }
        }
        File dbDir = new File(dbDirPath);
        if (!dbDir.exists()) {
            if (!dbDir.mkdirs()) {
                // WARN USER
                Toast.makeText(MainActivity.context, "WARNING! UNABLE TO CREATE WORKING DIRECTORY. PLEASE REINSTALL AND DELETE ALL ASSOCIATED FILES", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void pit_InsertReplace(Model_Pit pitObject)
    {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            db.execSQL("INSERT OR REPLACE INTO " + TABLE_PIT
                    + "(_id, driverXP, operatorXP,  drivetrain, pneumatics, shooterType, shootingType"
                    + ", climb, climbSpeed, weight, robotDimensions"
                    + ", portcullis, chevalDeFrise, moat, ramparts, drawbridge, sallyPort, rockWall"
                    + ", roughTerrain, lowBar, comments, robotPhoto, syncNum)"
                    + " VALUES(" +
                    pitObject.get_id() + ", " + pitObject.getDriverXP() + ", " + pitObject.getOperatorXP() + ", " + pitObject.getDrivetrain() + ", " + pitObject.getPneumatics() + ", " +
                    pitObject.getShooterType() + ", " + pitObject.getShootingType() + ", " + pitObject.getClimb() + ", " + pitObject.getClimbSpeed() + ", " + pitObject.getWeight() + ", '" + pitObject.getRobotDimensions()+ "', " +
                    pitObject.getPortcullis() + ", " + pitObject.getChevalDeFrise() + ", " + pitObject.getMoat() + ", " + pitObject.getRamparts() + ", " + pitObject.getDrawbridge() + ", " + pitObject.getSallyPort() + ", " + pitObject.getRockWall() + ", " +
                    pitObject.getRoughTerrain() + ", " + pitObject.getLowBar() + ", '" + pitObject.getComments() + "', " + pitObject.getRobotPhoto() + ", " + pitObject.getSyncNum() + ")");
            db.close();
        }

        export();
    }

    public void match_InsertReplace(Model_Match matchObject)
    {
        SQLiteDatabase db = getWritableDatabase();

        if(db!=null)
        {
            db.execSQL("INSERT OR REPLACE INTO " + TABLE_MATCHES +
                    "(_id, teamNum, autoDef1, autoDef2, autoDef3, autoDef4, autoDef5, " +
                    "autoLowMiss, autoLowMake, autoHighMiss, autoHighMake," +
                    "teleDef1Miss, teleDef1Make, teleDef2Miss, teleDef2Make, teleDef3Miss, teleDef3Make, teleDef4Miss, teleDef4Make, teleDef5Miss, teleDef5Make, ");
        }
    }

    public Model_Pit pit_readAll(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        if(db == null) return null;

        Cursor c = db.query(TABLE_PIT, ARRAY_PIT, KEY_PIT_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        Model_Pit model;

        if(c != null) {
            c.moveToFirst();

            model = new Model_Pit(c.getInt(0),
                    c.getInt(1),
                    c.getInt(2),
                    c.getInt(3),
                    c.getInt(4),
                    c.getInt(5),
                    c.getInt(6),
                    c.getInt(7),
                    c.getInt(8),
                    c.getInt(9),
                    c.getString(10),
                    c.getInt(11),
                    c.getInt(12),
                    c.getInt(13),
                    c.getInt(14),
                    c.getInt(15),
                    c.getInt(16),
                    c.getInt(17),
                    c.getInt(18),
                    c.getInt(19),
                    c.getString(20),
                    c.getInt(21),
                    c.getInt(22));

            db.close();
            c.close();
            return model;
        }

        return null;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MATCH);
        db.execSQL(CREATE_TABLE_PIT);
        db.execSQL(CREATE_TABLE_SCHEDULE);
        db.execSQL(CREATE_TABLE_TEAMS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // DO NOTHING
        // SHOULD PROBABLY DROP IT
    }

    /**
     * WILL DELETE ALL DATA MADE.
     *
     * @param areYouSure
     *          Whether or not you really want to delete all associated files.
     */
    public void purge(boolean areYouSure)
    {
        // DELETE EVERYTHING!@#!$!@
    }

    public boolean CheckIsDataAlreadyInDBorNot(String TableName, int _id) {
        return DatabaseUtils.longForQuery(getReadableDatabase(), "select count(*) from " + TableName + " where _id=? limit 1", new String[] {_id + ""}) > 0;
    }

//    private void exportDB() {
//
//        File dbFile=getDatabasePath("MyDBName.db");
//        File exportDir = new File(Environment.getExternalStorageDirectory(), "");
//        if (!exportDir.exists())
//        {
//            exportDir.mkdirs();
//        }
//
//        File file = new File(exportDir, "csvname.csv");
//        try
//        {
//            file.createNewFile();
//            CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
//            SQLiteDatabase db = getReadableDatabase();
//            Cursor curCSV = db.rawQuery("SELECT * FROM contacts",null);
//            csvWrite.writeNext(curCSV.getColumnNames());
//            while(curCSV.moveToNext())
//            {
//                //Which column you want to exprort
//                String arrStr[] ={curCSV.getString(0),curCSV.getString(1), curCSV.getString(2)};
//                csvWrite.writeNext(arrStr);
//            }
//            csvWrite.close();
//            curCSV.close();
//        }
//        catch(Exception sqlEx)
//        {
//            Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
//        }}

    private void export()
    {
        Cursor c = getWritableDatabase().rawQuery("SELECT * FROM "+ DBHelper.TABLE_PIT, null);
        int rowcount = 0;
        int colcount = 0;
        String filename = "export_" + MainActivity.getEventName() +  "_.csv";
        try{
        // the name of the file to export with
        File saveFile = new File(new File(DBHelper.mainDirPath), filename);
        FileWriter fw = new FileWriter(saveFile);
        BufferedWriter bw = new BufferedWriter(fw);
        rowcount = c.getCount();
        colcount = c.getColumnCount();
        if (rowcount > 0) {
            c.moveToFirst();
            for (int i = 0; i < colcount; i++) {
                if (i != colcount - 1) {
                    bw.write(c.getColumnName(i) + ",");
                } else {
                    bw.write(c.getColumnName(i));
                }
            }
            bw.newLine();
            for (int i = 0; i < rowcount; i++) {
                c.moveToPosition(i);
                for (int j = 0; j < colcount; j++) {
                    if (j != colcount - 1)
                        bw.write(c.getString(j) + ",");
                    else
                        bw.write(c.getString(j));
                }
                bw.newLine();
            }
            bw.flush();
        }
    } catch (Exception ex) {}
    }
}