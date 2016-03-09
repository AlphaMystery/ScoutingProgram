package falconrobotics.scoutingprogram;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created on 3/4/2016.
 */
public class DBHelper_Pit {
    public static final String DATABASE_TABLE = "Pit";
    private final Context context;
    private DBHelper dbHelper;
    private SQLiteDatabase db;


    public DBHelper_Pit(Context context) {
        this.context = context;
    }

    public void open() {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Cursor get(long _id, String key) throws SQLException {

        Cursor mCursor = db.query(true, DATABASE_TABLE,
                new String[]{key}, "_id=" + _id, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public SQLiteDatabase getDB() {
        return db;
    }
}