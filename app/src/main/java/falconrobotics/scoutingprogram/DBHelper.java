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
