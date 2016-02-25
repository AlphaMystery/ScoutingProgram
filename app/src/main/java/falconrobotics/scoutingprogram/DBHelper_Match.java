package falconrobotics.scoutingprogram;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by 842 on 2/20/2016.
 */
public class DBHelper_Match {
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String[] allColumns =
            {
                    DBHelper.KEY_MATCH_MATCHNUM,
                    DBHelper.KEY_MATCH_TEAMNUM,
                    DBHelper.KEY_MATCH_AUTODEF1,
                    DBHelper.KEY_MATCH_AUTODEF2,
                    DBHelper.KEY_MATCH_AUTODEF3,
                    DBHelper.KEY_MATCH_AUTODEF4,
                    DBHelper.KEY_MATCH_AUTODEF5,
                    DBHelper.KEY_MATCH_AUTOBOULDER,
                    DBHelper.KEY_MATCH_AUTOLOWMISS,
                    DBHelper.KEY_MATCH_AUTOLOWMAKE,
                    DBHelper.KEY_MATCH_AUTOHIGHMISS,
                    DBHelper.KEY_MATCH_AUTOHIGHMAKE,
                    DBHelper.KEY_MATCH_TELEDEF1MISS,
                    DBHelper.KEY_MATCH_TELEDEF1MAKE,
                    DBHelper.KEY_MATCH_TELEDEF2MISS,
                    DBHelper.KEY_MATCH_TELEDEF2MAKE,
                    DBHelper.KEY_MATCH_TELEDEF3MISS,
                    DBHelper.KEY_MATCH_TELEDEF3MAKE,
                    DBHelper.KEY_MATCH_TELEDEF4MISS,
                    DBHelper.KEY_MATCH_TELEDEF4MAKE,
                    DBHelper.KEY_MATCH_TELEDEF5MISS,
                    DBHelper.KEY_MATCH_TELEDEF5MAKE,
                    DBHelper.KEY_MATCH_TELELOWMISS,
                    DBHelper.KEY_MATCH_TELELOWMAKE,
                    DBHelper.KEY_MATCH_TELEHIGHMISS,
                    DBHelper.KEY_MATCH_TELEHIGHMAKE,
                    DBHelper.KEY_MATCH_BOULDERPASS,
                    DBHelper.KEY_MATCH_TELEBLOCK1,
                    DBHelper.KEY_MATCH_TELEBLOCK2,
                    DBHelper.KEY_MATCH_TELEBLOCK3,
                    DBHelper.KEY_MATCH_CLIMB,
                    DBHelper.KEY_MATCH_CHALLENGED,
                    DBHelper.KEY_MATCH_SCORETOTAL,
                    DBHelper.KEY_MATCH_SCOREAUTO,
                    DBHelper.KEY_MATCH_SCOREFOUL,
                    DBHelper.KEY_MATCH_CARDED,
                    DBHelper.KEY_MATCH_STOPPED,
                    DBHelper.KEY_MATCH_COMMENTS,
                    DBHelper.KEY_SYNCNUM
            };

    public DBHelper_Match(Context context)
    {
        dbHelper = new DBHelper(new DBContext(context));
    }

    public void open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
    }

    public void close()
    {
        dbHelper.close();
    }

    public void addMatch(
            int matchNum,
            int teamNum,
            int autoDef1,
            int autoDef2,
            int autoDef3,
            int autoDef4,
            int autoDef5,
            int autoBoulder,
            int autoLowMiss,
            int autoLowMake,
            int autoHighMiss,
            int autoHighMake,
            int teleDef1Miss,
            int teleDef1Make,
            int teleDef2Miss,
            int teleDef2Make,
            int teleDef3Miss,
            int teleDef3Make,
            int teleDef4Miss,
            int teleDef4Make,
            int teleDef5Miss,
            int teleDef5Make,
            int teleLowMiss,
            int teleLowMake,
            int teleHighMiss,
            int teleHighMake,
            int boulderPass,
            int teleBlock1,
            int teleBlock2,
            int teleBlock3,
            int climb,
            int challenged,
            int scoreTotal,
            int scoreAuto,
            int scoreFoul,
            int carded,
            int stopped,
            String comments,
            int syncNum)
    {
        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_MATCH_MATCHNUM,matchNum);
        values.put(DBHelper.KEY_MATCH_TEAMNUM, teamNum);
        values.put(DBHelper.KEY_MATCH_AUTODEF1, autoDef1);
        values.put(DBHelper.KEY_MATCH_AUTODEF2, autoDef2);
        values.put(DBHelper.KEY_MATCH_AUTODEF3, autoDef3);
        values.put(DBHelper.KEY_MATCH_AUTODEF4, autoDef4);
        values.put(DBHelper.KEY_MATCH_AUTODEF5, autoDef5);
        values.put(DBHelper.KEY_MATCH_AUTOBOULDER, autoBoulder);
        values.put(DBHelper.KEY_MATCH_AUTOLOWMISS, autoLowMiss);
        values.put(DBHelper.KEY_MATCH_AUTOLOWMAKE, autoLowMake);
        values.put(DBHelper.KEY_MATCH_AUTOHIGHMISS, autoHighMiss);
        values.put(DBHelper.KEY_MATCH_AUTOHIGHMAKE, autoHighMake);
        values.put(DBHelper.KEY_MATCH_TELEDEF1MISS, teleDef1Miss);
        values.put(DBHelper.KEY_MATCH_TELEDEF1MAKE, teleDef1Make);
        values.put(DBHelper.KEY_MATCH_TELEDEF2MISS, teleDef2Miss);
        values.put(DBHelper.KEY_MATCH_TELEDEF2MAKE, teleDef2Make);
        values.put(DBHelper.KEY_MATCH_TELEDEF3MISS, teleDef3Miss);
        values.put(DBHelper.KEY_MATCH_TELEDEF3MAKE, teleDef3Make);
        values.put(DBHelper.KEY_MATCH_TELEDEF4MISS, teleDef4Miss);
        values.put(DBHelper.KEY_MATCH_TELEDEF4MAKE, teleDef4Make);
        values.put(DBHelper.KEY_MATCH_TELEDEF5MISS, teleDef5Miss);
        values.put(DBHelper.KEY_MATCH_TELEDEF5MAKE, teleDef5Make);
        values.put(DBHelper.KEY_MATCH_TELELOWMISS, teleLowMiss);
        values.put(DBHelper.KEY_MATCH_TELELOWMAKE, teleLowMake);
        values.put(DBHelper.KEY_MATCH_TELEHIGHMISS, teleHighMiss);
        values.put(DBHelper.KEY_MATCH_TELEHIGHMAKE, teleHighMake);
        values.put(DBHelper.KEY_MATCH_BOULDERPASS, boulderPass);
        values.put(DBHelper.KEY_MATCH_TELEBLOCK1, teleBlock1);
        values.put(DBHelper.KEY_MATCH_TELEBLOCK2, teleBlock2);
        values.put(DBHelper.KEY_MATCH_TELEBLOCK3, teleBlock3);
        values.put(DBHelper.KEY_MATCH_CLIMB, climb);
        values.put(DBHelper.KEY_MATCH_CHALLENGED, challenged);
        values.put(DBHelper.KEY_MATCH_SCORETOTAL, scoreTotal);
        values.put(DBHelper.KEY_MATCH_SCOREAUTO, scoreAuto);
        values.put(DBHelper.KEY_MATCH_SCOREFOUL, scoreFoul);
        values.put(DBHelper.KEY_MATCH_CARDED, carded);
        values.put(DBHelper.KEY_MATCH_STOPPED, stopped);
        values.put(DBHelper.KEY_MATCH_COMMENTS, comments);
        values.put(DBHelper.KEY_SYNCNUM, syncNum);
    }

}
