package falconrobotics.scoutingprogram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;

/**
 * Created by Francisco Martinez on 2/11/2016.
 * DESCRIPTION: This fragment intentionally left blank.
 */
public class Fragment_About extends Fragment{
    private static View rootView;
    private static String eventCode = "TEST_CODE";
    private static String mainDirPath = System.getenv("EXTERNAL_STORAGE") + "/falconrobotics2016/" + eventCode;
    private static String picDirPath = mainDirPath + "/pictures";
    private static String dbDirPath = mainDirPath + "/databases";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_about, null);

        setup();

        return rootView;
    }

    private void setup()
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

    public static String getMainPath()
    {
        return mainDirPath;
    }
    public static String getPicDirPath()
    {
        return picDirPath;
    }
    public static String getDbDirPath()
    {
        return dbDirPath;
    }

}
