package falconrobotics.scoutingprogram;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
                    DBHelper.KEY_MATCH_AUTOBOULDER,
                    DBHelper.KEY_MATCH_AUTODEF1,
                    DBHelper.KEY_MATCH_AUTODEF2,
                    DBHelper.KEY_MATCH_AUTODEF3,
                    DBHelper.KEY_MATCH_AUTODEF4,
                    DBHelper.KEY_MATCH_AUTODEF5,
                    DBHelper.KEY_MATCH_AUTOHIGHMAKE,
                    DBHelper.KEY_MATCH_AUTOHIGHMISS,
                    DBHelper.KEY_MATCH_AUTOLOWMAKE,
                    DBHelper.KEY_MATCH_AUTOLOWMISS,
                    DBHelper.KEY_MATCH_BOULDERPASS,
                    DBHelper.KEY_MATCH_CARDED,
                    DBHelper.KEY_MATCH_CHALLENGED,
                    DBHelper.KEY_MATCH_CLIMB,
                    DBHelper.KEY_MATCH_COMMENTS,
                    DBHelper.KEY_MATCH_MATCHNUM,
                    DBHelper.KEY_MATCH_SCOREAUTO,
                    DBHelper.KEY_MATCH_SCOREFOUL,
                    DBHelper.KEY_MATCH_SCORETOTAL,
                    DBHelper.KEY_MATCH_STOPPED,
                    DBHelper.KEY_MATCH_TEAMNUM,
                    DBHelper.KEY_MATCH_TELEBLOCK1,
                    DBHelper.KEY_MATCH_TELEBLOCK2,
                    DBHelper.KEY_MATCH_TELEBLOCK3,
                    DBHelper.KEY_MATCH_TELEDEF1MAKE,
                    DBHelper.KEY_MATCH_TELEDEF1MISS,
                    DBHelper.KEY_MATCH_TELEDEF2MAKE,
                    DBHelper.KEY_MATCH_TELEDEF2MISS,
                    DBHelper.KEY_MATCH_TELEDEF3MAKE,
                    DBHelper.KEY_MATCH_TELEDEF3MISS,
                    DBHelper.KEY_MATCH_TELEDEF4MAKE,
                    DBHelper.KEY_MATCH_TELEDEF4MISS,
                    DBHelper.KEY_MATCH_TELEDEF5MAKE,
                    DBHelper.KEY_MATCH_TELEDEF5MISS,
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

}
