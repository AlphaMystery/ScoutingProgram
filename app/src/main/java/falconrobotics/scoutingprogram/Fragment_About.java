package falconrobotics.scoutingprogram;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.io.File;

/**
 * Created by Francisco Martinez on 2/11/2016.
 * DESCRIPTION: This fragment intentionally left blank.
 */
public class Fragment_About extends Fragment implements Dialog_Helper.NoticeDialogListener{
    public static EditText eventCode;
    private static View rootView;
    private DialogFragment dialogFragment;

    public static String mainDir;
    public static String picDir;
    public static String dbDir;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_about, null);

        /**
         * prompts for event code, necessary for storing data acquired
         */
        dialogFragment = new Dialog_Helper(R.layout.prompt_layout_event);
        dialogFragment.show(this.getFragmentManager(), "Event Code");

        return rootView;
    }


    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        eventCode = (EditText)dialog.getDialog().findViewById(R.id.event_code);
        mainDir = Environment.getExternalStorageDirectory()
                + File.separator + R.string.dir_path
                + File.separator + eventCode.getText().toString();
        picDir = mainDir + File.separator + "pictures";
        dbDir = mainDir + File.separator + "database";

        File main = new File(mainDir);
        if (!main.exists())
            main.mkdirs();

        File pics = new File(picDir);
        if (!pics.exists())
            pics.mkdirs();

        File db = new File(dbDir);
        if (!db.exists())
            db.mkdirs();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }

}
