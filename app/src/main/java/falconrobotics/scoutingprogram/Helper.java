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
            KEY_MATCH_AUTOLOWMISS ="autoLowMiss",
            KEY_MATCH_AUTOLOWHIT ="autoLowHit",
            KEY_MATCH_AUTOHIGHMISS ="autoHighMiss",
            KEY_MATCH_AUTOHIGHHIT ="autoHighHit",
            KEY_MATCH_AUTOLOWBARMISS ="autoLowBarMiss",
            KEY_MATCH_AUTOLOWBARHIT ="autoLowBarHit",
            KEY_MATCH_AUTOCMISS ="autoCMiss",
            KEY_MATCH_AUTOCHIT ="autoCHit",
            KEY_MATCH_TELELOWBARMISS = "teleLowBarMiss",
            KEY_MATCH_TELELOWBARHIT = "teleLowBarHit",
            KEY_MATCH_TELECMISS = "teleCMiss",
            KEY_MATCH_TELECHIT = "teleCHit",
            KEY_MATCH_TELESECTOR1MISS = "teleSector1Miss",
            KEY_MATCH_TELESECTOR1HIT = "teleSector1Hit",
            KEY_MATCH_TELESECTOR2MISS = "teleSector2Miss",
            KEY_MATCH_TELESECTOR2HIT = "teleSector2Hit",
            KEY_MATCH_TELESECTOR3MISS = "teleSector3Miss",
            KEY_MATCH_TELESECTOR3HIT = "teleSector3Hit",
            KEY_MATCH_TELESECTOR4MISS = "teleSector4Miss",
            KEY_MATCH_TELESECTOR4HIT = "teleSector4Hit",
            KEY_MATCH_TELESECTOR5MISS = "teleSector5Miss",
            KEY_MATCH_TELESECTOR5HIT = "teleSector5Hit",
            KEY_MATCH_TELESECTOR6MISS = "teleSector6Miss",
            KEY_MATCH_TELESECTOR6HIT = "teleSector6Hit",
            KEY_MATCH_POSTCLIMB ="postClimb",
            KEY_MATCH_POSTCOMMENTS = "postComments";
    public static final String[] ARRAY_MATCH = {
            KEY_MATCH_ID,
            KEY_MATCH_TEAMNUM,
            KEY_MATCH_AUTOLOWMISS,
            KEY_MATCH_AUTOLOWHIT,
            KEY_MATCH_AUTOHIGHMISS,
            KEY_MATCH_AUTOHIGHHIT,
            KEY_MATCH_AUTOLOWBARMISS,
            KEY_MATCH_AUTOLOWBARHIT,
            KEY_MATCH_AUTOCMISS,
            KEY_MATCH_AUTOCHIT,
            KEY_MATCH_TELELOWBARMISS,
            KEY_MATCH_TELELOWBARHIT,
            KEY_MATCH_TELECMISS,
            KEY_MATCH_TELECHIT,
            KEY_MATCH_TELESECTOR1MISS,
            KEY_MATCH_TELESECTOR1HIT,
            KEY_MATCH_TELESECTOR2MISS,
            KEY_MATCH_TELESECTOR2HIT,
            KEY_MATCH_TELESECTOR3MISS,
            KEY_MATCH_TELESECTOR3HIT,
            KEY_MATCH_TELESECTOR4MISS,
            KEY_MATCH_TELESECTOR4HIT,
            KEY_MATCH_TELESECTOR5MISS,
            KEY_MATCH_TELESECTOR5HIT,
            KEY_MATCH_TELESECTOR6MISS,
            KEY_MATCH_TELESECTOR6HIT,
            KEY_MATCH_POSTCLIMB,
            KEY_MATCH_POSTCOMMENTS,
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
                    + KEY_MATCH_ID + " INTEGER PRIMARY KEY NOT NULL, "
                    + KEY_MATCH_TEAMNUM + INTEGER
                    + KEY_MATCH_AUTOLOWMISS + INTEGER
                    + KEY_MATCH_AUTOLOWHIT + INTEGER
                    + KEY_MATCH_AUTOHIGHMISS + INTEGER
                    + KEY_MATCH_AUTOHIGHHIT + INTEGER
                    + KEY_MATCH_AUTOLOWBARMISS + INTEGER
                    + KEY_MATCH_AUTOLOWBARHIT + INTEGER
                    + KEY_MATCH_AUTOCMISS + INTEGER
                    + KEY_MATCH_AUTOCHIT + INTEGER
                    + KEY_MATCH_TELELOWBARMISS + INTEGER
                    + KEY_MATCH_TELELOWBARHIT + INTEGER
                    + KEY_MATCH_TELECMISS + INTEGER
                    + KEY_MATCH_TELECHIT + INTEGER
                    + KEY_MATCH_TELESECTOR1MISS + INTEGER
                    + KEY_MATCH_TELESECTOR1HIT + INTEGER
                    + KEY_MATCH_TELESECTOR2MISS + INTEGER
                    + KEY_MATCH_TELESECTOR2HIT + INTEGER
                    + KEY_MATCH_TELESECTOR3MISS + INTEGER
                    + KEY_MATCH_TELESECTOR3HIT + INTEGER
                    + KEY_MATCH_TELESECTOR4MISS + INTEGER
                    + KEY_MATCH_TELESECTOR4HIT + INTEGER
                    + KEY_MATCH_TELESECTOR5MISS + INTEGER
                    + KEY_MATCH_TELESECTOR5HIT + INTEGER
                    + KEY_MATCH_TELESECTOR6MISS + INTEGER
                    + KEY_MATCH_TELESECTOR6HIT + INTEGER
                    + KEY_MATCH_POSTCLIMB + INTEGER
                    + KEY_MATCH_POSTCOMMENTS + TEXT
                    + KEY_SYNCNUM + " INT NOT NULL"
                    + ");";
    //Pit Table  create statement
    public static final String CREATE_TABLE_PIT =
            "CREATE TABLE IF NOT EXISTS "
                    + TABLE_PIT + "("
                    + KEY_PIT_ID + " INTEGER PRIMARY KEY NOT NULL, "
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
    public void createDir() {
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
                    "autoLowMiss, autoLowHit, autoHighMiss, autoHighHit, autoLowBarMiss, autoLowBarHit, autoCMiss, autoCHit, " +
                    "teleLowBarMiss, teleLowBarHit, teleCMiss, teleCMiss, " +
                    "teleSector1Miss, teleSector1Hit, teleSector2Miss, teleSector2Hit, teleSector3Miss, teleSector3Hit, teleSector4Miss, teleSector4Hit, teleSector5Miss, teleSector5Hit, teleSector6Miss, teleSector6Hit, " +
                    "postClimb, postComments, syncNum)" +
                    " VALUES(" +
                    matchObject.get_id() + ", " + matchObject.getTeamNum() + ", " +
                    matchObject.getAutoLowMiss() + ", " + matchObject.getAutoLowHit() + ", " + matchObject.getAutoHighMiss() + ", " + matchObject.getAutoHighHit() + ", " + matchObject.getAutoLowBarMiss() + ", " + matchObject.getAutoLowBarHit() + ", " + matchObject.getAutoCMiss() + ", " + matchObject.getAutoCHit() + ", " +
                    matchObject.getTeleLowBarMiss() + ", " + matchObject.getTeleLowBarHit() + ", " + matchObject.getTeleCMiss() + ", " + matchObject.getTeleCMiss() + ", " +
                    matchObject.getTeleSector1Miss() + ", " + matchObject.getTeleSector1Hit() + ", " + matchObject.getTeleSector2Miss() + ", " + matchObject.getTeleSector2Hit() + ", " + matchObject.getTeleSector3Miss() + ", " + matchObject.getTeleSector3Hit() + ", " + matchObject.getTeleSector4Miss() + ", " + matchObject.getTeleSector4Hit() + ", " + matchObject.getTeleSector5Miss() + ", " + matchObject.getTeleSector5Hit() + ", " + matchObject.getTeleSector6Miss() + ", " + matchObject.getTeleSector6Hit() + ", " +
                    matchObject.getPostClimb() + ", '" + matchObject.getPostComments() + "', " + matchObject.getSyncNum() + ")");
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

        if(db == null) {
            Toast.makeText(MainActivity.context,"I failed to load the database!",Toast.LENGTH_SHORT).show();
            return null;
        }

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_MATCHES + " WHERE _id =? AND teamNum =? ", new String[]{_id + "", teamNum + ""});
        Model_Match model;

        if(c.getCount() > 0) {
            c.moveToFirst();

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
                    c.getString(27),
                    c.getInt(28)
            );

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
        createDir();

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
    {if(areYouSure)
    {
        if(dir.exists())
        {
            File[] files = dir.listFiles();
            for(File file : files)
            {
                if(file.isDirectory())
                {
                    resetData(file, true);
                }
                else
                {
                    file.delete();
                }
            }
        }
        if(dir.delete()) Toast.makeText(MainActivity.context, "Success!", Toast.LENGTH_SHORT).show();

        onCreate(getWritableDatabase());
        doRestart(MainActivity.context);
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
        String filename = table + "_export.csv";
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

        c.close();
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