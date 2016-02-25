package falconrobotics.scoutingprogram;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

/**
 * Created by 842 on 2/22/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static String eventCode = "TEST_CODE";
    public static String mainDirPath = System.getenv("EXTERNAL_STORAGE") + "/falconrobotics2016";
    public static String picDirPath = mainDirPath + "/pictures";
    public static String dbDirPath = mainDirPath + "/databases";

    //version
    private static final int DATABASE_VERSION = 1;

    //name
    private static final String DATABASE_NAME = "AppData.db";

    //path
    public static final String  DATABASE_FILE_PATH = dbDirPath;

    //tables in the Google Sheet
    private static final String TABLE_MATCH = "match";
    private static final String TABLE_PIT = "pit";
    private static final String TABLE_SCHEDULE = "schedule";
    private static final String TABLE_TEAMS = "teams";

    //Match, Pit, Schedule - common key, won't be included in every table
    private static final String KEY_SYNCNUM = "syncNum"; // not sure if this is correct

    private static final String INTEGER = " INTEGER,";
    private static final String TEXT = " TEXT,";

    //Match Table - keys
    private static final String KEY_MATCH_MATCHNUM = "matchNum";
    private static final String KEY_MATCH_TEAMNUM = "teamNum";
    private static final String KEY_MATCH_AUTODEF1 = "autoDef1";
    private static final String KEY_MATCH_AUTODEF2 = "autoDef2";
    private static final String KEY_MATCH_AUTODEF3 = "autoDef3";
    private static final String KEY_MATCH_AUTODEF4 = "autoDef4";
    private static final String KEY_MATCH_AUTODEF5 = "autoDef5";
    private static final String KEY_MATCH_AUTOBOULDER = "autoBoulder";
    private static final String KEY_MATCH_AUTOLOWMISS = "autoLowMiss";
    private static final String KEY_MATCH_AUTOLOWMAKE = "autoLowMake";
    private static final String KEY_MATCH_AUTOHIGHMISS = "autoHighMiss";
    private static final String KEY_MATCH_AUTOHIGHMAKE = "autoHighMake";
    private static final String KEY_MATCH_TELEDEF1MISS = "teleDef1Miss";
    private static final String KEY_MATCH_TELEDEF1MAKE = "teleDef1Make";
    private static final String KEY_MATCH_TELEDEF2MISS = "teleDef2Miss";
    private static final String KEY_MATCH_TELEDEF2MAKE = "teleDef2Make";
    private static final String KEY_MATCH_TELEDEF3MISS = "teleDef3Miss";
    private static final String KEY_MATCH_TELEDEF3MAKE = "teleDef3Make";
    private static final String KEY_MATCH_TELEDEF4MISS = "teleDef4Miss";
    private static final String KEY_MATCH_TELEDEF4MAKE = "teleDef4Make";
    private static final String KEY_MATCH_TELEDEF5MISS = "teleDef5Miss";
    private static final String KEY_MATCH_TELEDEF5MAKE = "teleDef5Make";
    private static final String KEY_MATCH_TELELOWMISS = "teleLowMiss";
    private static final String KEY_MATCH_TELELOWMAKE = "teleLowMake";
    private static final String KEY_MATCH_TELEHIGHMISS = "teleHighMiss";
    private static final String KEY_MATCH_TELEHIGHMAKE = "teleHighMake";
    //    private static final String KEY_MATCH_TELEPUSH = "telePush";  not used, depends on scouter
    private static final String KEY_MATCH_TELEBLOCK1 = "teleBlock1";
    private static final String KEY_MATCH_TELEBLOCK2 = "teleBlock2";
    private static final String KEY_MATCH_TELEBLOCK3 = "teleBlock3";
    private static final String KEY_MATCH_CLIMB = "climb";
    private static final String KEY_MATCH_CHALLENGED = "challenged";
    private static final String KEY_MATCH_BOULDERPASS = "boulderPass";
    private static final String KEY_MATCH_SCORETOTAL = "scoreTotal";
    private static final String KEY_MATCH_SCOREAUTO = "scoreAuto";
    private static final String KEY_MATCH_SCOREFOUL = "scoreFoul";
    private static final String KEY_MATCH_CARDED = "carded";
    private static final String KEY_MATCH_STOPPED = "stopped";
    private static final String KEY_MATCH_COMMENTS = "comments";

    //Pit Table - keys
    private static final String KEY_PIT_TEAMNUM = "teamNum";
    private static final String KEY_PIT_YEARDRIVER = "yearDriver";
    private static final String KEY_PIT_WHEELS = "wheels";
    private static final String KEY_PIT_WEIGHT = "weight";
    private static final String KEY_PIT_SHOOTER = "shooter";
    private static final String KEY_PIT_CANCLIMB = "canClimb";
    private static final String KEY_PIT_CLIMBSPEED = "climbSpeed";
    private static final String KEY_PIT_ROBOTDIMENSIONS = "robotDimensions";
    private static final String KEY_PIT_PORTCULLIS = "portcullis";
    private static final String KEY_PIT_CHEVALDEFRISE = "chevalDeFrise";
    private static final String KEY_PIT_MOAT = "moat";
    private static final String KEY_PIT_RAMPARTS = "ramparts";
    private static final String KEY_PIT_DRAWBRIDGE = "drawbridge";
    private static final String KEY_PIT_SALLYPORT = "drawbridge";
    private static final String KEY_PIT_ROCKWALL = "rockWall";
    private static final String KEY_PIT_ROUGHTERRAIN = "roughTerrain";
    private static final String KEY_PIT_LOWBAR = "lowBar";
    private static final String KEY_PIT_COMMENTS = "comments";
    private static final String KEY_PIT_ROBOTPHOTO = "robotPhoto";

    //Schedule Table - keys
    private static final String KEY_SCHEDULE_MATCHLEVEL = "matchLevel";
    private static final String KEY_SCHEDULE_MATCHNUM = "matchNum";
    private static final String KEY_SCHEDULE_BLUEROBOT1 = "blueRobot1";
    private static final String KEY_SCHEDULE_BLUEROBOT2 = "blueRobot2";
    private static final String KEY_SCHEDULE_BLUEROBOT3 = "blueRobot3";
    private static final String KEY_SCHEDULE_REDROBOT1 = "redRobot1";
    private static final String KEY_SCHEDULE_REDROBOT2 = "redRobot2";
    private static final String KEY_SCHEDULE_REDROBOT3 = "redRobot3";

    //Teams Table - keys
    private static final String KEY_TEAMS_TEAMNUM = "teamNum";
    private static final String KEY_TEAMS_SHORTNAME = "shortName";

    //Match Table - create statement
    private static final String CREATE_TABLE_MATCH =
            "CREATE TABLE "
                    + TABLE_MATCH + "("
                    + KEY_MATCH_MATCHNUM + INTEGER
                    + KEY_MATCH_TEAMNUM + INTEGER
                    + KEY_MATCH_AUTODEF1 + INTEGER
                    + KEY_MATCH_AUTODEF2 + INTEGER
                    + KEY_MATCH_AUTODEF3 + INTEGER
                    + KEY_MATCH_AUTODEF4 + INTEGER
                    + KEY_MATCH_AUTODEF5 + INTEGER
                    + KEY_MATCH_AUTOBOULDER + INTEGER
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
                    + KEY_MATCH_BOULDERPASS + INTEGER
                    + KEY_MATCH_TELEBLOCK1 + INTEGER
                    + KEY_MATCH_TELEBLOCK2 + INTEGER
                    + KEY_MATCH_TELEBLOCK3 + INTEGER
                    + KEY_MATCH_CLIMB + INTEGER
                    + KEY_MATCH_CHALLENGED + INTEGER
                    + KEY_MATCH_SCORETOTAL + INTEGER
                    + KEY_MATCH_SCOREAUTO + INTEGER
                    + KEY_MATCH_SCOREFOUL + INTEGER
                    + KEY_MATCH_CARDED + INTEGER
                    + KEY_MATCH_STOPPED + INTEGER
                    + KEY_MATCH_COMMENTS + TEXT
                    + KEY_SYNCNUM + INTEGER
                    + ")";

    //Pit Table - create statement
    private static final String CREATE_TABLE_PIT =
            "CREATE TABLE "
                    + TABLE_PIT + "("
                    + KEY_PIT_TEAMNUM + INTEGER
                    + KEY_PIT_YEARDRIVER + INTEGER
                    + KEY_PIT_WHEELS + INTEGER
                    + KEY_PIT_WEIGHT + INTEGER
                    + KEY_PIT_SHOOTER + INTEGER
                    + KEY_PIT_CANCLIMB + INTEGER
                    + KEY_PIT_CLIMBSPEED + INTEGER
                    + KEY_PIT_ROBOTDIMENSIONS + INTEGER
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
                    + KEY_SYNCNUM + INTEGER
                    + ")";

    //Schedule Table - create statement
    private static final String CREATE_TABLE_SCHEDULE =
            "CREATE TABLE "
                    + TABLE_SCHEDULE + "("
                    + KEY_SCHEDULE_MATCHLEVEL + INTEGER
                    + KEY_SCHEDULE_MATCHNUM + INTEGER
                    + KEY_SCHEDULE_BLUEROBOT1 + INTEGER
                    + KEY_SCHEDULE_BLUEROBOT2 + INTEGER
                    + KEY_SCHEDULE_BLUEROBOT3 + INTEGER
                    + KEY_SCHEDULE_REDROBOT1 + INTEGER
                    + KEY_SCHEDULE_REDROBOT2 + INTEGER
                    + KEY_SCHEDULE_REDROBOT3 + INTEGER
                    + KEY_SYNCNUM + INTEGER
                    + ")";

    //Team Table - create statement
    private static final String CREATE_TABLE_TEAMS =
            "CREATE TABLE "
                    + TABLE_TEAMS + "("
                    + KEY_TEAMS_TEAMNUM + INTEGER
                    + KEY_TEAMS_SHORTNAME + TEXT
                    + KEY_SYNCNUM + INTEGER
                    + ")";

    public DBHelper(Context context) {
        super(new DBContext(context), DATABASE_NAME, /*factory (examples show this as null)*/ null, DATABASE_VERSION);
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
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_MATCH);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_PIT);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_SCHEDULE);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_TEAMS);

        onCreate(db);
    }

    public static void makeDirectories()
    {
        try
        {
            File mainDir = new File(mainDirPath);
            if (!mainDir.exists())
                if (!mainDir.mkdirs())
                    System.exit(0);
            File picDir = new File(picDirPath);
            if (!picDir.exists())
                if (!picDir.mkdirs())
                    System.exit(0);
            File dbDir = new File(dbDirPath);
            if (!dbDir.exists())
                if (!dbDir.mkdirs())
                    System.exit(0);
        }catch(Exception e){}
    }

    public static void setEventCode(String newCode)
    {
        mainDirPath += "/" + newCode;
        eventCode = newCode;
    }
    public static String getEventCode()
    {
        return eventCode;
    }
}
