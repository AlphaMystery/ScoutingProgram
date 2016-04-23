package falconrobotics.scoutingprogram;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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

/**
 * Created on 2/22/2016.
 */
public class Helper extends SQLiteOpenHelper
{
    //table names
    public static final String TABLE_MATCHES ="Matches",
            TABLE_PIT ="Pit",
            TABLE_SCHEDULE ="Schedule",
            TABLE_TEAMS ="Teams";

    //common key, won't be included in every table
    public static final String KEY_SYNCNUM ="syncNum";

    public static final String INTEGER =" INTEGER NOT NULL, ";
    public static final String TEXT =" TEXT NOT NULL, ";

    //Match Table  keys
    public static final String KEY_MATCH_ID ="_id",
            KEY_MATCH_TEAMNUM ="teamNum",
            KEY_MATCH_AUTODEF1MISS ="autoDef1Miss",
            KEY_MATCH_AUTODEF1HIT ="autoDef1Hit",
            KEY_MATCH_AUTODEF2MISS ="autoDef2Miss",
            KEY_MATCH_AUTODEF2HIT ="autoDef2Hit",
            KEY_MATCH_AUTODEF3MISS ="autoDef3Miss",
            KEY_MATCH_AUTODEF3HIT ="autoDef3Hit",
            KEY_MATCH_AUTODEF4MISS ="autoDef4Miss",
            KEY_MATCH_AUTODEF4HIT ="autoDef4Hit",
            KEY_MATCH_AUTODEF5MISS ="autoDef5Miss",
            KEY_MATCH_AUTODEF5HIT ="autoDef5Hit",
            KEY_MATCH_AUTOLOWMISS ="autoLowMiss",
            KEY_MATCH_AUTOLOWHIT ="autoLowHit",
            KEY_MATCH_AUTOHIGHMISS ="autoHighMiss",
            KEY_MATCH_AUTOHIGHHIT ="autoHighHit",
            KEY_MATCH_TELELOWMISS ="teleLowMiss",
            KEY_MATCH_TELELOWHIT ="teleLowHit",
            KEY_MATCH_TELEHIGHMISS ="teleHighMiss",
            KEY_MATCH_TELEHIGHHIT ="teleHighHit",
            KEY_MATCH_LOWBARMISS = "lowBarMiss",
            KEY_MATCH_LOWBARHIT = "lowBarHit",
            KEY_MATCH_DRAWBRIDGEMISS = "drawbridgeMiss",
            KEY_MATCH_DRAWBRIDGEHIT = "drawbridgeHit",
            KEY_MATCH_SALLYPORTMISS = "sallyPortMiss",
            KEY_MATCH_SALLYPORTHIT = "sallyPortHit",
            KEY_MATCH_SAFESPOT = "safeSpot",
            KEY_MATCH_CLIMB ="climb";
    public static final String[] ARRAY_MATCH = {
            KEY_MATCH_ID,
            KEY_MATCH_TEAMNUM,
            KEY_MATCH_AUTODEF1MISS,
            KEY_MATCH_AUTODEF1HIT,
            KEY_MATCH_AUTODEF2MISS,
            KEY_MATCH_AUTODEF2HIT,
            KEY_MATCH_AUTODEF3MISS,
            KEY_MATCH_AUTODEF3HIT,
            KEY_MATCH_AUTODEF4MISS,
            KEY_MATCH_AUTODEF4HIT,
            KEY_MATCH_AUTODEF5MISS,
            KEY_MATCH_AUTODEF5HIT,
            KEY_MATCH_AUTOLOWMISS,
            KEY_MATCH_AUTOLOWHIT,
            KEY_MATCH_AUTOHIGHMISS,
            KEY_MATCH_AUTOHIGHHIT,
            KEY_MATCH_TELELOWMISS,
            KEY_MATCH_TELELOWHIT,
            KEY_MATCH_TELEHIGHMISS,
            KEY_MATCH_TELEHIGHHIT,
            KEY_MATCH_LOWBARMISS,
            KEY_MATCH_LOWBARHIT,
            KEY_MATCH_DRAWBRIDGEMISS,
            KEY_MATCH_DRAWBRIDGEHIT,
            KEY_MATCH_SALLYPORTMISS,
            KEY_MATCH_SALLYPORTHIT,
            KEY_MATCH_SAFESPOT,
            KEY_MATCH_CLIMB,
            KEY_SYNCNUM};

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
    public static final String[] ARRAY_PIT = {
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
    public static final String[] ARRAY_SCHEDULE = {
            KEY_SCHEDULE_ID,
            KEY_SCHEDULE_DESCRIPTION,
            KEY_SCHEDULE_BLUEROBOT1,
            KEY_SCHEDULE_BLUEROBOT2,
            KEY_SCHEDULE_BLUEROBOT3,
            KEY_SCHEDULE_REDROBOT1,
            KEY_SCHEDULE_REDROBOT2,
            KEY_SCHEDULE_REDROBOT3};

    //Teams Table  keys
    public static final String KEY_TEAMS_ID = "_id",
            KEY_TEAMS_SHORTNAME = "shortName";
    public static final String[] ARRAY_TEAMS ={
            KEY_TEAMS_ID,
            KEY_TEAMS_SHORTNAME
    };

    //Match Table  create statement
    public static final String CREATE_TABLE_MATCH =
            "CREATE TABLE IF NOT EXISTS "
                    + TABLE_MATCHES + "("
                    + KEY_MATCH_ID + " INT PRIMARY KEY NOT NULL, "
                    + KEY_MATCH_TEAMNUM + INTEGER
                    + KEY_MATCH_AUTODEF1MISS + INTEGER
                    + KEY_MATCH_AUTODEF1HIT + INTEGER
                    + KEY_MATCH_AUTODEF2MISS + INTEGER
                    + KEY_MATCH_AUTODEF2HIT + INTEGER
                    + KEY_MATCH_AUTODEF3MISS + INTEGER
                    + KEY_MATCH_AUTODEF3HIT + INTEGER
                    + KEY_MATCH_AUTODEF4MISS + INTEGER
                    + KEY_MATCH_AUTODEF4HIT + INTEGER
                    + KEY_MATCH_AUTODEF5MISS + INTEGER
                    + KEY_MATCH_AUTODEF5HIT + INTEGER
                    + KEY_MATCH_AUTOLOWMISS + INTEGER
                    + KEY_MATCH_AUTOLOWHIT + INTEGER
                    + KEY_MATCH_AUTOHIGHMISS + INTEGER
                    + KEY_MATCH_AUTOHIGHHIT + INTEGER
                    + KEY_MATCH_TELELOWMISS + INTEGER
                    + KEY_MATCH_TELELOWHIT + INTEGER
                    + KEY_MATCH_TELEHIGHMISS + INTEGER
                    + KEY_MATCH_TELEHIGHHIT + INTEGER
                    + KEY_MATCH_LOWBARMISS + INTEGER
                    + KEY_MATCH_LOWBARHIT + INTEGER
                    + KEY_MATCH_DRAWBRIDGEMISS + INTEGER
                    + KEY_MATCH_DRAWBRIDGEHIT + INTEGER
                    + KEY_MATCH_SALLYPORTMISS + INTEGER
                    + KEY_MATCH_SALLYPORTHIT + INTEGER
                    + KEY_MATCH_SAFESPOT + INTEGER
                    + KEY_MATCH_CLIMB + INTEGER
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

    public static String mainDirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "falconrobotics2016";
    public static String picDirPath = mainDirPath + File.separator + "pictures";
    public static String dbDirPath = mainDirPath + File.separator + "databases";

    public Helper() {
        super(MainActivity.context, dbDirPath + File.separator + MainActivity.eventName, null, 1);
    }

    /**
     * For easy access from the outside for on the go execution.
     *
     * @param statement
     *          An executable SQLite statement.
     */
    public void exec(String statement){
        getWritableDatabase().execSQL(statement);
    }

    /**
     * Creates the necessary directories.
     *
     * Static because helps with accessibility.
     */
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

    /**
     * Updates the pit table, only adds or replaces information, no deletion.
     *
     * @param updateStatement
     *          INSERT OR REPLACE; INSERT; REPLACE; All found as a static String in MainActivity.
     * @param pitObject
     *          A model for the pit data structure, need it to update the information on the database file.
     */
    public void pit_update(String updateStatement, Model_Pit pitObject)
    {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            db.execSQL( updateStatement + " INTO " + TABLE_PIT +
                    "(_id, driverXP, operatorXP,  drivetrain, pneumatics, shooterType, shootingType, " +
                    "climb, climbSpeed, weight, robotDimensions, " +
                    "portcullis, chevalDeFrise, moat, ramparts, drawbridge, sallyPort, rockWall, " +
                    "roughTerrain, lowBar, comments, robotPhoto, syncNum)" +
                    " VALUES(" +
                    pitObject.get_id() + ", " + pitObject.getDriverXP() + ", " + pitObject.getOperatorXP() + ", " + pitObject.getDrivetrain() + ", " + pitObject.getPneumatics() + ", " +
                    pitObject.getShooterType() + ", " + pitObject.getShootingType() + ", " + pitObject.getClimb() + ", " + pitObject.getClimbSpeed() + ", " + pitObject.getWeight() + ", '" + pitObject.getRobotDimensions()+ "', " +
                    pitObject.getPortcullis() + ", " + pitObject.getChevalDeFrise() + ", " + pitObject.getMoat() + ", " + pitObject.getRamparts() + ", " + pitObject.getDrawbridge() + ", " + pitObject.getSallyPort() + ", " + pitObject.getRockWall() + ", " +
                    pitObject.getRoughTerrain() + ", " + pitObject.getLowBar() + ", '" + pitObject.getComments() + "', " + pitObject.getRobotPhoto() + ", " + pitObject.getSyncNum() + ")");
            db.close();
        }

        export(TABLE_PIT);
    }

    /**
     * Updates the matches table, only adds or replaces information, no deletion.
     *
     * @param updateStatement
     *          INSERT OR REPLACE; INSERT; REPLACE; All found as a static String in MainActivity.
     * @param matchObject
     *          A model for the match data structure, need it to update the information on the database file.
     */
    public void match_update(String updateStatement, Model_Match matchObject)
    {
        SQLiteDatabase db = getWritableDatabase();

        if(db!=null) {
            db.execSQL(updateStatement + " INTO " + TABLE_MATCHES +
                    "(_id, teamNum, " +
                    "autoDef1Miss, autoDef1Hit, autoDef2Miss, autoDef2Hit, autoDef3Miss, autoDef3Hit, autoDef4Miss, autoDef4Hit, autoDef5Miss, autoDef5Hit, " +
                    "autoLowMiss, autoLowHit, autoHighMiss, autoHighHit, " +
                    "teleLowMiss, teleLowHit, teleHighMiss, teleHighHit, " +
                    "lowBarMiss, lowBarHit, drawbridgeMiss, drawbridgeHit, sallyPortMiss, sallyPortHit, safeSpot, " +
                    "climb, syncNum)" +
                    " VALUES(" +
                    matchObject.get_id() + ", " + matchObject.getTeamNum() + ", " +
                    matchObject.getAutoDef1Miss() + ", " + matchObject.getAutoDef1Hit() + ", " + matchObject.getAutoDef2Miss() + ", " + matchObject.getAutoDef2Hit() + ", " + matchObject.getAutoDef3Miss() + ", " + matchObject.getAutoDef3Hit() + ", " + matchObject.getAutoDef4Miss() + ", " + matchObject.getAutoDef4Hit() + ", " + matchObject.getAutoDef5Miss() + ", " + matchObject.getAutoDef5Hit() + ", " +
                    matchObject.getAutoLowMiss() + ", " + matchObject.getAutoLowHit() + ", " + matchObject.getAutoHighMiss() + ", " + matchObject.getAutoHighHit() + ", " +
                    matchObject.getTeleLowMiss() + ", " + matchObject.getTeleLowHit() + ", " + matchObject.getTeleHighMiss() + ", " + matchObject.getTeleHighHit() + ", " +
                    matchObject.getTeleLowBarMiss() + ", " + matchObject.getTeleLowBarHit() + ", " + matchObject.getTeleDrawbridgeMiss() + ", " + matchObject.getTeleDrawbridgeHit() + ", " + matchObject.getTeleSallyPortMiss() + ", " + matchObject.getTeleSallyPortHit() + ", " + matchObject.getSafeSpot() + ", " +
                    matchObject.getClimb() + ", " + matchObject.getSyncNum() + ")");
            db.close();
        }

        export(TABLE_MATCHES);
    }

    /**
     * Reads all the information on the specified team in the pit table in the database.
     * All information provided must already be in the database.
     *
     * @param teamNum
     *          The number of the team the data is wanted from.
     * @return
     *          The model structure with the information of the team from pit scouting table.
     */
    public Model_Pit pit_readTeam(int teamNum)
    {
        SQLiteDatabase db = getReadableDatabase();

        if(db == null) return null;

        Cursor c = db.query(TABLE_PIT, ARRAY_PIT, KEY_PIT_ID + "=?",
                new String[]{String.valueOf(teamNum)}, null, null, null, null);
        Model_Pit model;

        if(c != null) {
            c.moveToFirst();

            model = new Model_Pit(
                    c.getInt(0),
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

    /**
     * Reads all the information on the specified team in the match table in the database.
     * All information provided must already be in the database.
     *
     * @param _id
     *          Match number with level.
     * @param teamNum
     *          Number of the team the data is wanted from.
     * @return
     *          The model structure with the information of the team in the specified match from the match scouting table.
     */
    public Model_Match match_readTeam(int _id, int teamNum)
    {
        SQLiteDatabase db = getReadableDatabase();

        if(db == null) return null;

        Cursor c = db.query(TABLE_MATCHES, ARRAY_MATCH, KEY_MATCH_ID + " =? AND " + KEY_MATCH_TEAMNUM + " =? ",
                new String[]{String.valueOf(_id), String.valueOf(teamNum)}, null, null, null, null);
        Model_Match model;

        if(c!=null)
        {
            model = new Model_Match(
                    c.getInt(0),
                    c.getInt(1),
                    c.getInt(2),
                    c.getInt(3),
                    c.getInt(4),
                    c.getInt(5),
                    c.getInt(6),
                    c.getInt(7),
                    c.getInt(8),
                    c.getInt(9),
                    c.getInt(10),
                    c.getInt(11),
                    c.getInt(12),
                    c.getInt(13),
                    c.getInt(14),
                    c.getInt(15),
                    c.getInt(16),
                    c.getInt(17),
                    c.getInt(18),
                    c.getInt(19),
                    c.getInt(20),
                    c.getInt(21),
                    c.getInt(22),
                    c.getInt(23),
                    c.getInt(24),
                    c.getInt(25),
                    c.getInt(26),
                    c.getInt(27),
                    c.getInt(28)
            );


            db.close();
            c.close();
            return model;
        }

        return null;
    }

    /**
     * Create statement for all the tables.
     *
     * @param db
     *          Database in use.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MATCH);
        db.execSQL(CREATE_TABLE_PIT);
        db.execSQL(CREATE_TABLE_SCHEDULE);
        db.execSQL(CREATE_TABLE_TEAMS);
    }

    /**
     * Should probably drop the table but won't be working with this for now I think.
     * @param db
     *          Database in use.
     * @param oldVersion
     *          Version number of the previous database.
     * @param newVersion
     *          Version number of the new database.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // DO NOTHING
        // SHOULD PROBABLY DROP IT
    }

    /**
     * WILL DELETE ALL DATA.
     *
     * @param areYouSure
     *          Whether or not you really want to delete all associated files with the app.
     */
    public void resetData(File dir, boolean areYouSure)
    {if(areYouSure){
        if( dir.exists() ) {
            File[] files = dir.listFiles();
            for(int i=0; i<files.length; i++) {
                if(files[i].isDirectory()) {
                    resetData(files[i], true);
                }
                else {
                    files[i].delete();
                }
            }
        }
        if(dir.delete())
            Toast.makeText(MainActivity.context, "Success!", Toast.LENGTH_SHORT).show();

        createDir();

        Helper helper = new Helper();
    }}

    /**
     * Checks whether or not the data exists in the pit scouting table in the database.
     *
     * @param _id
     *          Team number.
     * @return
     *          True for the data exists, False for it doesn't.
     */
    public boolean pitDataCheck(int _id) {
        return DatabaseUtils.longForQuery(getReadableDatabase(), "SELECT COUNT(*) FROM " + TABLE_PIT + " WHERE _id=? LIMIT 1", new String[] {_id + ""}) > 0;
    }

    /**
     * Checks whether or not the data exists in the match scouting table in the database.
     *
     * @param _id
     *          Match number with level.
     * @param teamNum
     *          Team number.
     * @return
     *          True for the data exists, False for it doesn't.
     */
    public boolean matchDataCheck(int _id, int teamNum) {
        return DatabaseUtils.longForQuery(getReadableDatabase(), "SELECT COUNT(*) FROM " + TABLE_MATCHES + " WHERE _id=? AND teamNum=? ", new String[] {_id + "", teamNum + ""}) > 0;
    }

    /**
     * Exports the specified table name to a csv file in the main folder.
     *
     * @param table
     *          Table name to be
     */
    private void export(String table)
    {
        Cursor c = getWritableDatabase().rawQuery("SELECT * FROM "+ table, null);
        int rowcount = 0;
        int colcount = 0;
        String filename = "export_" + table + "_.csv";
        try{
            File saveFile = new File(new File(Helper.mainDirPath), filename);
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
        } catch (Exception ex) {
            Toast.makeText(MainActivity.context, "Error exporting " + table, Toast.LENGTH_LONG).show();
        }
    }

    public void doRestart(Context c) {
        final String TAG = (R.string.app_name + "");
        try {
            //check if the context is given
            if (c != null) {
                //fetch the packagemanager so we can get the default launch activity
                // (you can replace this intent with any other activity if you want
                PackageManager pm = c.getPackageManager();
                //check if we got the PackageManager
                if (pm != null) {
                    //create the intent with the default start activity for your application
                    Intent mStartActivity = pm.getLaunchIntentForPackage(
                            c.getPackageName()
                    );
                    if (mStartActivity != null) {
                        mStartActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //create a pending intent so the application is restarted after System.exit(0) was called.
                        // We use an AlarmManager to call this intent in 100ms
                        int mPendingIntentId = 223344;
                        PendingIntent mPendingIntent = PendingIntent
                                .getActivity(c, mPendingIntentId, mStartActivity,
                                        PendingIntent.FLAG_CANCEL_CURRENT);
                        AlarmManager mgr = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
                        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
                        //kill the application
                        System.exit(0);
                    } else {
                        Log.e(TAG, "Was not able to restart application, mStartActivity null");
                    }
                } else {
                    Log.e(TAG, "Was not able to restart application, PM null");
                }
            } else {
                Log.e(TAG, "Was not able to restart application, Context null");
            }
        } catch (Exception ex) {
            Log.e(TAG, "Was not able to restart application");
        }
    }
}