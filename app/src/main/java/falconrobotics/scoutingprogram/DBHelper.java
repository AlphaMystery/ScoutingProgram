package falconrobotics.scoutingprogram;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

/**
 * Created by 842 on 2/22/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static String eventCode = "TEST_CODE";
    public static String mainDirPath = System.getenv("EXTERNAL_STORAGE") + "/falconrobotics2016/" + eventCode;
    public static String picDirPath = mainDirPath + "/pictures";
    public static String dbDirPath = mainDirPath + "/databases";

    //tables in the Google Sheet
    private static final String TABLE_MATCH = "match";
    private static final String TABLE_PIT = "pit";
    private static final String TABLE_SCHEDULE = "schedule";
    private static final String TABLE_TEAMS = "teams";

    //Match, Pit, Schedule - common key, won't be included in every table
    private static final String KEY_SYNCNUM = "syncNum";

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
    private static final String KEY_MATCH_TELEPUSH = "telePush";
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

    //Teams Table - keys
    private static final String KEY_TEAMS_TEAMNUM = "teamNum";
    private static final String KEY_TEAMS_SHORTNAME = "shortName";

    //Schedule Table - keys
    private static final String KEY_SCHEDULE_MATCHLEVEL = "matchLevel";
    private static final String KEY_SCHEDULE_MATCHNUM = "matchNum";
    private static final String KEY_SCHEDULE_blueRobot1 = "blueRobot1";
    private static final String KEY_SCHEDULE_blueRobot2 = "blueRobot2";
    private static final String KEY_SCHEDULE_blueRobot3 = "blueRobot3";
    private static final String KEY_SCHEDULE_redRobot1 = "redRobot1";
    private static final String KEY_SCHEDULE_redRobot2 = "redRobot2";
    private static final String KEY_SCHEDULE_redRobot3 = "redRobot3";

    //Match Table - create statement
    private static final String CREATE_TABLE_MATCH =
            "CREATE TABLE"
            + TABLE_MATCH + "("
            + KEY_MATCH_MATCHNUM + "INTEGER,"
            + KEY_MATCH_TEAMNUM + "INTEGER,"




    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

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
}
