//package falconrobotics.scoutingprogram;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.os.Environment;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import java.io.File;
//
///**
// * Created on 2/7/2016.
// */
//public class Fragment_Email extends Fragment {
//    View rootView;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        rootView = inflater.inflate(R.layout.layout_email, null);
//        String filename = "";
//
//        File filelocation = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), filename);
//        Uri path = Uri.fromFile(filelocation);
//        Intent emailIntent = new Intent(Intent.ACTION_SEND);
//// set the type to 'email'
//        emailIntent.setType("vnd.android.cursor.dir/email");
//        String to[] = {"842databases@gmail.com"};
//        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
//// the attachment
//        emailIntent.putExtra(Intent.EXTRA_STREAM, path);
//// the mail subject
//        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
//        startActivity(Intent.createChooser(emailIntent, "Send email..."));
//
//        return rootView;
//    }
//}
