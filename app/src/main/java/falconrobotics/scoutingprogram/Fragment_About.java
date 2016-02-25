package falconrobotics.scoutingprogram;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Francisco Martinez on 2/11/2016.
 * DESCRIPTION: This fragment intentionally left blank.
 */
public class Fragment_About extends Fragment{
    private static View rootView;
    private static  EditText eventCodeInput;
    private static String code;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_about, null);

        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(rootView.getContext());
        View promptsView = li.inflate(R.layout.prompt_layout_event, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                rootView.getContext());
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        eventCodeInput = (EditText) promptsView
                .findViewById(R.id.event_code);
        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("SUBMIT",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                code = eventCodeInput.getText().toString();
                            }
                        })
                .setNegativeButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();

        DBHelper.setEventCode(code);

        DBHelper.makeDirectories();
        DBHelper db = new DBHelper(rootView.getContext());

        return rootView;
    }
}
