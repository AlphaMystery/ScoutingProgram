package falconrobotics.scoutingprogram;

import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

/**
 * Created on 2/7/2016.
 */
public class Frame_Fragment_PS extends Fragment {
    private static final int REQUEST_TAKE_PHOTO = 1;
    private View rootView;
    private int teamNum;
    private EditText teamNumInput;
    private File photoFile;

    private LayoutInflater li;

    private ImageView imageView;
    private TextView capButton;
    private Button save;
    private Spinner
            spinner_driverExperience,
            spinner_wheelType,
            spinner_climbsTower,
            spinner_climbSpeed,
            spinner_portcullis,
            spinner_chevalDeFrise,
            spinner_moat,
            spinner_ramparts,
            spinner_drawbridge,
            spinner_sallyPort,
            spinner_rockWall,
            spinner_roughtTerrain,
            spinner_lowBar;
    private EditText editText_width;

    private DBHelper_Pit db;

    private static Bitmap rotateImageIfRequired(Context context, Bitmap img) {
        int rotation = getRotation(context);

        if (rotation != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(rotation);
            Bitmap rotatedImg = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, true);
            img.recycle();
            return rotatedImg;
        } else {
            return img;
        }
    }

    private static int getRotation(Context context) {
        int rotation = 0;
        ContentResolver content = context.getContentResolver();

        Cursor mediaCursor = content.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{"orientation", "date_added"}, null, null, "date_added desc");

        if (mediaCursor != null && mediaCursor.getCount() != 0) {
            while (mediaCursor.moveToNext()) {
                rotation = mediaCursor.getInt(0);
                break;
            }
        }
        mediaCursor.close();
        return rotation;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frame_layout_p_create, null);

        initItems();
        dialog();

        db = new DBHelper_Pit(rootView.getContext());

        capButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                updateLoop();
            }
        });

        return rootView;
    }

    private void initItems() {
        imageView = (ImageView) rootView.findViewById(R.id.pitCreate_image_view_robot);
        capButton = (TextView) rootView.findViewById(R.id.pitCreate_button_robot_cap);

        spinner_driverExperience = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_driver_xp);
        spinner_wheelType = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_wheel_type);
        spinner_climbsTower = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_tower_climb);
        spinner_climbSpeed = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_climb_speed);
//        spinner_climbSpeed.setAdapter(new ArrayAdapter<String>(rootView, android.R.layout.simple_spinner_item, Arrays.asList(Interface_Pit.NoYes)).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item));

        editText_width = (EditText) rootView.findViewById(R.id.pitCreate_input_robot_width);

        spinner_portcullis = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_portcullis);
        spinner_chevalDeFrise = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_cheval_de_frise);
        spinner_moat = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_moat);
        spinner_ramparts = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_ramparts);
        spinner_drawbridge = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_drawbridge);
        spinner_sallyPort = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_sally_port);
        spinner_rockWall = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_rock_wall);
        spinner_roughtTerrain = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_rough_terrain);
        spinner_lowBar = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_low_bar);

        save = (Button) rootView.findViewById(R.id.pitCreate_save);
    }

    public void updateLoop() {
        Spinner[] spinners = new Spinner[]
                {spinner_driverExperience,
                        spinner_wheelType,
                        spinner_climbsTower,
                        spinner_climbSpeed,
                        spinner_portcullis,
                        spinner_chevalDeFrise,
                        spinner_moat,
                        spinner_ramparts,
                        spinner_drawbridge,
                        spinner_sallyPort,
                        spinner_rockWall,
                        spinner_roughtTerrain,
                        spinner_lowBar};

        int count = 0;

        for (Spinner spinner : spinners) {
            db.getDB().execSQL("UPDATE " + DBHelper_Pit.DATABASE_TABLE + " SET teamNum=" + teamNum + " WHERE ");
            count++;
        }

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageView.setImageBitmap(
                rotateImageIfRequired(rootView.getContext(),
                        Bitmap.createScaledBitmap(
                                BitmapFactory.decodeFile(
                                        photoFile.getAbsolutePath()), 2000, 2000, true)));
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(rootView.getContext().getPackageManager()) != null) {
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
            }

            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    private File createImageFile() throws IOException {
        String imageFileName = teamNum + "";
        File storageDir = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString());
        File image = File.createTempFile
                (
                        imageFileName,  /* prefix */
                        ".jpg",         /* suffix */
                        storageDir      /* directory */
                );

        File from = new File(image.getPath());
        File to = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString(),
                teamNum + ".jpg");
        from.renameTo(to);

        return to;
    }

    private void dialog() {
        li = LayoutInflater.from(rootView.getContext());
        View promptsView = li.inflate(R.layout.prompt_layout_team_number, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                rootView.getContext());

        alertDialogBuilder.setView(promptsView);

        teamNumInput = (EditText) promptsView
                .findViewById(R.id.pit_robot_number);

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("SUBMIT",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                teamNum = teamNumInput.getText() == null
                                        ? 1 : Integer.parseInt(teamNumInput.getText().toString());
                            }
                        })
                .setNegativeButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }
}