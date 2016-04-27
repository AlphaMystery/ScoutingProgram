package falconrobotics.scoutingprogram;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.File;
import java.util.Arrays;

/**
 * Created on 2/7/2016.
 */
public class Fragment_Sync extends Fragment {
    private View rootView;
    private Helper helper;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.layout_sync, null);
        helper = new Helper();

//        Button delete = (Button) rootView.findViewById(R.id.sync_delete_ALL);
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                helper.resetData(new File(Helper.mainDirPath), true);
//            }
//        });

        Button send = (Button) rootView.findViewById(R.id.sync_email_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email(Helper.TABLE_PIT);
            }
        });

        return rootView;
    }

    private void email(String table)
    {
        String filename="export_" + table + "_.csv";
        File filelocation = new File(Helper.mainDirPath, filename);
        Uri path = Uri.fromFile(filelocation);
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
// set the type to 'email'
        emailIntent .setType("vnd.android.cursor.dir/email");
        String to[] = {"martinez.francisco.842@gmail.com"};
        emailIntent .putExtra(Intent.EXTRA_EMAIL, to);
// the attachment
        emailIntent .putExtra(Intent.EXTRA_STREAM, path);
// the mail subject
        emailIntent .putExtra(Intent.EXTRA_SUBJECT, table + " data export");
        startActivity(Intent.createChooser(emailIntent , "Send email..."));
    }
}
