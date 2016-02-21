package falconrobotics.scoutingprogram;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Layout;
import android.view.LayoutInflater;

/**
 * Created by Francisco Martinez on 2/18/2016.
 * DESCRIPTION: builds pre match dialog
 */
@SuppressLint("ValidFragment")
public class Dialog_Helper extends DialogFragment {
    LayoutInflater inflater;
    int layout;
    AlertDialog.Builder builder;

    public Dialog_Helper(int layout)
    {
        this.layout = layout;
    }


    /* The activity that creates an instance of this dialog fragment must
 * implement this interface in order to receive event callbacks.
 * Each method passes the DialogFragment in case the host needs to query it. */
    public interface NoticeDialogListener {
        void onDialogPositiveClick(DialogFragment dialog);
        void onDialogNegativeClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    NoticeDialogListener mListener;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(layout, null)).setCancelable(false)
                .setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do something
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}