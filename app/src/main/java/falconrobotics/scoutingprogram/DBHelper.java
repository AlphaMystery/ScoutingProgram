package falconrobotics.scoutingprogram;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.File;

/**
 * Created on 2/22/2016.
 */
public class DBHelper extends SQLiteOpenHelper
{
    //tables in the Google Sheet
    public static final String TABLE_MATCHES = " Matches ";
    public static final String TABLE_PIT = " Pit ";
    public static final String TABLE_SCHEDULE = " Schedule ";
    public static final String TABLE_TEAMS = " Teams ";

    //Match, Pit, Schedule  common key, won't be included in every table
    public static final String KEY_SYNCNUM = " syncNum "; // not sure if this is correct

    public static final String INTEGER = " INTEGER, ";
    public static final String TEXT = " TEXT ";

    //Match Table  keys
    public static final String KEY_MATCH_ID = " _id ";
    public static final String KEY_MATCH_TEAMNUM = " teamNum ";
    public static final String KEY_MATCH_AUTODEF1 = " autoDef1 ";
    public static final String KEY_MATCH_AUTODEF2 = " autoDef2 ";
    public static final String KEY_MATCH_AUTODEF3 = " autoDef3 ";
    public static final String KEY_MATCH_AUTODEF4 = " autoDef4 ";
    public static final String KEY_MATCH_AUTODEF5 = " autoDef5 ";
    public static final String KEY_MATCH_AUTOBOULDER = " autoBoulder ";
    public static final String KEY_MATCH_AUTOLOWMISS = " autoLowMiss ";
    public static final String KEY_MATCH_AUTOLOWMAKE = " autoLowMake ";
    public static final String KEY_MATCH_AUTOHIGHMISS = " autoHighMiss ";
    public static final String KEY_MATCH_AUTOHIGHMAKE = " autoHighMake ";
    public static final String KEY_MATCH_TELEDEF1MISS = " teleDef1Miss ";
    public static final String KEY_MATCH_TELEDEF1MAKE = " teleDef1Make";
    public static final String KEY_MATCH_TELEDEF2MISS = " teleDef2Miss ";
    public static final String KEY_MATCH_TELEDEF2MAKE = " teleDef2Make ";
    public static final String KEY_MATCH_TELEDEF3MISS = " teleDef3Miss ";
    public static final String KEY_MATCH_TELEDEF3MAKE = " teleDef3Make ";
    public static final String KEY_MATCH_TELEDEF4MISS = " teleDef4Miss ";
    public static final String KEY_MATCH_TELEDEF4MAKE = " teleDef4Make ";
    public static final String KEY_MATCH_TELEDEF5MISS = " teleDef5Miss ";
    public static final String KEY_MATCH_TELEDEF5MAKE = " teleDef5Make ";
    public static final String KEY_MATCH_TELELOWMISS = " teleLowMiss ";
    public static final String KEY_MATCH_TELELOWMAKE = " teleLowMake ";
    public static final String KEY_MATCH_TELEHIGHMISS = " teleHighMiss ";
    public static final String KEY_MATCH_TELEHIGHMAKE = " teleHighMake ";
    public static final String KEY_MATCH_TELEBLOCK1 = " teleBlock1 ";
    public static final String KEY_MATCH_TELEBLOCK2 = " teleBlock2 ";
    public static final String KEY_MATCH_TELEBLOCK3 = " teleBlock3 ";
    public static final String KEY_MATCH_CLIMB = " climb ";
    public static final String KEY_MATCH_CHALLENGED = " challenged ";
    public static final String KEY_MATCH_BOULDERPASS = " boulderPass ";
    public static final String KEY_MATCH_SCORETOTAL = " scoreTotal ";
    public static final String KEY_MATCH_SCOREAUTO = " scoreAuto ";
    public static final String KEY_MATCH_SCOREFOUL = " scoreFoul ";
    public static final String KEY_MATCH_CARDED = " carded ";
    public static final String KEY_MATCH_STOPPED = " stopped ";
    public static final String KEY_MATCH_COMMENTS = " comments ";
    public static final String[] KEYS_MATCH = new String[]{
            " _id ",
            " teamNum ",
            " autoDef1 ",
            " autoDef2 ",
            " autoDef3 ",
            " autoDef4 ",
            " autoDef5 ",
            " autoBoulder ",
            " autoLowMiss ",
            " autoLowMake ",
            " autoHighMiss ",
            " autoHighMake ",
            " teleDef1Miss ",
            " teleDef1Make ",
            " teleDef2Miss ",
            " teleDef2Make ",
            " telDef3Miss ",
            " teleDef3Make ",
            " teleDef4Miss ",
            " teleDef4Make ",
            " teleDef5Miss ",
            " teleDef5Make ",
            " teleLowMiss ",
            " teleLowMake ",
            " teleHighMiss ",
            " teleHighMake ",
            " boulderPass ",
            " teleBlock1 ",
            " teleBlock2 ",
            " teleBlock3 ",
            " climb ",
            " challenged ",
            " scoreTotal ",
            " scoreAuto ",
            " scoreFoul ",
            " carded ",
            " stoped ",
            " comments ",
            " syncNum "
    };

    //Pit Table  keys
    public static final String KEY_PIT_ID = " _id ";
    public static final String KEY_PIT_YEARDRIVER = " yearDriver ";
    public static final String KEY_PIT_WHEELS = " wheels ";
    public static final String KEY_PIT_WEIGHT = " weight ";
    public static final String KEY_PIT_SHOOTER = " shooter ";
    public static final String KEY_PIT_CANCLIMB = " canClimb ";
    public static final String KEY_PIT_CLIMBSPEED = " climbSpeed ";
    public static final String KEY_PIT_PORTCULLIS = " portcullis ";
    public static final String KEY_PIT_CHEVALDEFRISE = " chevalDeFrise ";
    public static final String KEY_PIT_MOAT = " moat ";
    public static final String KEY_PIT_RAMPARTS = " ramparts ";
    public static final String KEY_PIT_DRAWBRIDGE = " drawbridge ";
    public static final String KEY_PIT_SALLYPORT = " sallyPort ";
    public static final String KEY_PIT_ROCKWALL = " rockWall ";
    public static final String KEY_PIT_ROUGHTERRAIN = " roughTerrain ";
    public static final String KEY_PIT_LOWBAR = " lowBar ";
    public static final String KEY_PIT_COMMENTS = " comments ";
    public static final String KEY_PIT_ROBOTPHOTO = " robotPhoto ";
    public static final String[] KEYS_PIT = new String[]{
            " _id ",
            " yearDriver ",
            " wheels ",
            " weight ",
            " shooter ",
            " canClimb ",
            " climbSpeed ",
            " portcullis ",
            " chevalDeFrise ",
            " moat ",
            " ramparts ",
            " drawbridge ",
            " sallyPort ",
            " rockWall ",
            " rougthTerrain ",
            " lowBar ",
            " comments ",
            " robotPhoto ",
            " syncNum "
    };
    public static final String[] KEYS_PIT_SPINNERS = new String[]{
            " yearDriver ",
            " wheels ",
            " weight ",
            " shooter ",
            " canClimb ",
            " climbSpeed ",
            " portcullis ",
            " chevalDeFrise ",
            " moat ",
            " ramparts ",
            " drawbridge ",
            " sallyPort ",
            " rockWall ",
            " rougthTerrain ",
            " lowBar ",
    };

    //Schedule Table  keys
    public static final String KEY_SCHEDULE_ID = " _id";
    public static final String KEY_SCHEDULE_DESCRIPTION = " description ";
    public static final String KEY_SCHEDULE_BLUEROBOT1 = " blueRobot1 ";
    public static final String KEY_SCHEDULE_BLUEROBOT2 = " blueRobot2 ";
    public static final String KEY_SCHEDULE_BLUEROBOT3 = " blueRobot3 ";
    public static final String KEY_SCHEDULE_REDROBOT1 = " redRobot1 ";
    public static final String KEY_SCHEDULE_REDROBOT2 = " redRobot2 ";
    public static final String KEY_SCHEDULE_REDROBOT3 = " redRobot3 ";
    public static final String[] KEYS_SCHEDULE = new String[]{
            " _id ",
            " description ",
            " blueRobot1 ",
            " blueRobot2 ",
            " blueRobot3 ",
            " redRobot1 ",
            " redRobot2 ",
            " redRobot3 ",
            " syncNum "
    };

    //Teams Table  keys
    public static final String KEY_TEAMS_ID = " _id ";
    public static final String KEY_TEAMS_SHORTNAME = " shortName ";
    public static final String[] KEYS_TEAMS = new String[]{
            " _id ",
            " shortName ",
            " syncNum "
    };

    //Match Table  create statement
    public static final String CREATE_TABLE_MATCH =
            " CREATE TABLE "
                    + TABLE_MATCHES + " ( "
                    + KEY_MATCH_ID + " INT PRIMARY KEY NOT NULL, "
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
                    + KEY_MATCH_COMMENTS + TEXT + ", "
                    + KEY_SYNCNUM + " INT NOT NULL "
                    + " ) ";
    //Pit Table  create statement
    public static final String CREATE_TABLE_PIT =
            " CREATE TABLE "
                    + TABLE_PIT + " ( "
                    + KEY_PIT_ID + " INT PRIMARY KEY NOT NULL, "
                    + KEY_PIT_YEARDRIVER + INTEGER
                    + KEY_PIT_WHEELS + INTEGER
                    + KEY_PIT_WEIGHT + INTEGER
                    + KEY_PIT_SHOOTER + INTEGER
                    + KEY_PIT_CANCLIMB + INTEGER
                    + KEY_PIT_CLIMBSPEED + INTEGER
                    + KEY_PIT_PORTCULLIS + INTEGER
                    + KEY_PIT_CHEVALDEFRISE + INTEGER
                    + KEY_PIT_MOAT + INTEGER
                    + KEY_PIT_RAMPARTS + INTEGER
                    + KEY_PIT_DRAWBRIDGE + INTEGER
                    + KEY_PIT_SALLYPORT + INTEGER
                    + KEY_PIT_ROCKWALL + INTEGER
                    + KEY_PIT_ROUGHTERRAIN + INTEGER
                    + KEY_PIT_LOWBAR + INTEGER
                    + KEY_PIT_COMMENTS + TEXT + ", "
                    + KEY_PIT_ROBOTPHOTO + INTEGER
                    + KEY_SYNCNUM + " INT NOT NULL "
                    + " ) ";
    //Schedule Table  create statement
    public static final String CREATE_TABLE_SCHEDULE =
            " CREATE TABLE "
                    + TABLE_SCHEDULE + "("
                    + KEY_SCHEDULE_ID + " INT PRIMARY KEY NOT NULL, "
                    + KEY_SCHEDULE_DESCRIPTION + TEXT + ", "
                    + KEY_SCHEDULE_BLUEROBOT1 + INTEGER
                    + KEY_SCHEDULE_BLUEROBOT2 + INTEGER
                    + KEY_SCHEDULE_BLUEROBOT3 + INTEGER
                    + KEY_SCHEDULE_REDROBOT1 + INTEGER
                    + KEY_SCHEDULE_REDROBOT2 + INTEGER
                    + KEY_SCHEDULE_REDROBOT3 + INTEGER
                    + KEY_SYNCNUM + " INT NOT NULL "
                    + " ) ";
    //Team Table  create statement
    public static final String CREATE_TABLE_TEAMS =
            " CREATE TABLE "
                    + TABLE_TEAMS + " ( "
                    + KEY_TEAMS_ID + " INT PRIMARY KEY NOT NULL, "
                    + KEY_TEAMS_SHORTNAME + TEXT + ", "
                    + KEY_SYNCNUM + " INT NOT NULL "
                    + " ) ";

    public static final String DATABASE_NAME = "2016AZFL.db";
    public static String mainDirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "falconrobotics2016";
    public static String picDirPath = mainDirPath + File.separator + "pictures";
    public static String dbDirPath = mainDirPath + File.separator + "databases";

    public DBHelper(Context context) {
        super(context, dbDirPath + File.separator + DATABASE_NAME, null, 1);
    }

    public static void create_DirDb() {
        try {
            File picDir = new File(picDirPath);
            if (!picDir.exists()) {
                if (!picDir.mkdirs()) {
                    System.exit(0);
                }
            }
            File dbDir = new File(dbDirPath);
            if (!dbDir.exists()) {
                if (!dbDir.mkdirs()) {
                    System.exit(0);
                }
            }
        } catch (Exception e) {
        }
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
    }

//    public void closeDB() {
//        SQLiteDatabase db = getWritableDatabase();
//        if (db != null) db.close();
//    }

    public synchronized void pit_Insert(Model_Pit pitObject)
    {
        SQLiteDatabase db = null;
        try {
            db = getWritableDatabase();
            if (db != null) {
                ContentValues values = new ContentValues();
                values.put("_id", pitObject.get_id());
                values.put("yearDriver", pitObject.getYearDriver());
                values.put("wheels", pitObject.getWheels());
                values.put("weight", pitObject.getWeight());
                values.put("shooter", pitObject.getShooter());
                values.put("canClimb", pitObject.getCanClimb());
                values.put("portcullis", pitObject.getPortcullis());
                values.put("chevalDeFrise", pitObject.getChevalDeFrise());
                values.put("moat", pitObject.getMoat());
                values.put("ramparts", pitObject.getRamparts());
                values.put("drawbridge", pitObject.getDrawbridge());
                values.put("sallyPort", pitObject.getSallyPort());
                values.put("rockWall", pitObject.getRockWall());
                values.put("lowBar", pitObject.getLowBar());
                values.put("comments", pitObject.getComments());
                values.put("robotPhoto", pitObject.getRobotPhoto());
                values.put("syncNum", pitObject.getSyncNum());

                db.insert("Pit", null, values);
                db.close();
            }
        } catch (SQLiteException e) {
            if (db != null) {
                db.close();
                db = null;
            }
        }
    }

//    public synchronized void  match_Update(Model_Match matchObject)
//    {
//        SQLiteDatabase db;
//        try
//        {
//            db = getWritableDatabase();
//            if(db != null)
//            {
//                ContentValues values = new ContentValues();
//                values.put("_id", matchObject.get_id());
//                values.put("teamNum", matchObject.getTeamNum());
//                values.put("autoDef1", matchObject.getAutoDef1());
//            }
//        }
//    }
}
