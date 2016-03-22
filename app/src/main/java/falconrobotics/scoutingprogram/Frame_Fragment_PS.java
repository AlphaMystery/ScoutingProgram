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
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created on 2/7/2016.
 */
public class Frame_Fragment_PS extends Fragment {
    private static final int REQUEST_TAKE_PHOTO = 1;
    private View rootView;
    private int teamNum;
    private EditText teamNumInput;
    private File photoFile;

    private LayoutInflater dialogLayoutInflator;

    private ImageView imageView;
    private TextView capButton;
    private Button save;
    private Spinner
            spinner_driverExperience,
            spinner_wheelType,
            spinner_weight,
            spinner_climbsTower,
            spinner_climbSpeed,
            spinner_shooter,
            spinner_portcullis,
            spinner_chevalDeFrise,
            spinner_moat,
            spinner_ramparts,
            spinner_drawbridge,
            spinner_sallyPort,
            spinner_rockWall,
            spinner_roughTerrain,
            spinner_lowBar;
    private EditText comments;
    private int robotPhoto = 0;

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

        if (mediaCursor != null) {
            if (mediaCursor.getCount() != 0) {
                while (mediaCursor.moveToNext()) {
                    rotation = mediaCursor.getInt(0);
                    break;
                }
            }
            mediaCursor.close();
        }
        return rotation;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frame_layout_p_create, null);

        initItems();
        dialog();

        capButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        return rootView;
    }

    private void initItems() {
        imageView = (ImageView) rootView.findViewById(R.id.pitCreate_image_view_robot);
        capButton = (TextView) rootView.findViewById(R.id.pitCreate_button_robot_cap);

        spinner_driverExperience = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_driver_xp);
        spinner_driverExperience.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.driverExperience)));
        spinner_wheelType = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_wheel_type);
        spinner_wheelType.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.Wheels)));
        spinner_climbsTower = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_tower_climb);
        spinner_climbsTower.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.NoYes)));
        spinner_climbSpeed = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_climb_speed);
        spinner_climbSpeed.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.climbSpeed)));
        spinner_weight = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_weight);
        spinner_weight.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.Weight)));
        spinner_shooter = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_shooter);
        spinner_shooter.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.Shooter)));
        spinner_portcullis = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_portcullis);
        spinner_portcullis.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.NoAutoTeleBoth)));
        spinner_chevalDeFrise = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_cheval_de_frise);
        spinner_chevalDeFrise.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.NoAutoTeleBoth)));
        spinner_moat = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_moat);
        spinner_moat.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.NoAutoTeleBoth)));
        spinner_ramparts = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_ramparts);
        spinner_ramparts.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.NoAutoTeleBoth)));
        spinner_drawbridge = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_drawbridge);
        spinner_drawbridge.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.NoAutoTeleBoth)));
        spinner_sallyPort = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_sally_port);
        spinner_sallyPort.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.NoAutoTeleBoth)));
        spinner_rockWall = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_rock_wall);
        spinner_rockWall.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.NoAutoTeleBoth)));
        spinner_roughTerrain = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_rough_terrain);
        spinner_roughTerrain.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.NoAutoTeleBoth)));
        spinner_lowBar = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_low_bar);
        spinner_lowBar.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Pit.NoAutoTeleBoth)));

        comments = (EditText) rootView.findViewById(R.id.pitCreate_input_comments);

        save = (Button) rootView.findViewById(R.id.pitCreate_save);
    }

    public void update() {
        if (teamNum == 0) return;
        Model_Pit model = new Model_Pit();
        model.set_id(teamNum);
        model.setYearDriver(spinner_driverExperience.getSelectedItemPosition());
        model.setWheels(spinner_wheelType.getSelectedItemPosition());
        model.setWeight(spinner_weight.getSelectedItemPosition());
        model.setShooter(spinner_shooter.getSelectedItemPosition());
        model.setCanClimb(spinner_climbsTower.getSelectedItemPosition());
        model.setClimbSpeed(spinner_climbSpeed.getSelectedItemPosition());
        model.setPortcullis(spinner_portcullis.getSelectedItemPosition());
        model.setChevalDeFrise(spinner_chevalDeFrise.getSelectedItemPosition());
        model.setMoat(spinner_moat.getSelectedItemPosition());
        model.setRamparts(spinner_ramparts.getSelectedItemPosition());
        model.setDrawbridge(spinner_ramparts.getSelectedItemPosition());
        model.setSallyPort(spinner_sallyPort.getSelectedItemPosition());
        model.setRockWall(spinner_rockWall.getSelectedItemPosition());
        model.setRoughTerrain(spinner_roughTerrain.getSelectedItemPosition());
        model.setLowBar(spinner_lowBar.getSelectedItemPosition());
        if(comments.getText().toString().contains("1") || comments.getText().toString().contains("2"))model.setComments(comments.getText().toString());
        else model.setComments("NO COMMENT");
        model.setRobotPhoto(robotPhoto);
        model.setSyncNum(1);

        DBHelper helper = new DBHelper();
        helper.pit_InsertReplace(model);
//        Toast.makeText(MainActivity.context, "Data saved.", Toast.LENGTH_LONG).show();

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
        if (imageView.getDrawable() != null) robotPhoto = 1;
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
        File storageDir = new File(DBHelper.picDirPath);
        File image = File.createTempFile
                (
                        imageFileName,  /* prefix */
                        ".jpg",         /* suffix */
                        storageDir      /* directory */
                );

        File from = new File(image.getPath());
        File to = new File(new File(DBHelper.picDirPath),
                teamNum + ".jpg");
        from.renameTo(to);

        return to;
    }

    private void dialog() {
        dialogLayoutInflator = LayoutInflater.from(rootView.getContext());
        View promptsView = dialogLayoutInflator.inflate(R.layout.prompt_layout_team_number, null);

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
                                        ? 0 : Integer.parseInt(teamNumInput.getText().toString());
                            }
                        })
                .setNegativeButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Fragment fragment = new Fragment_Bluetooth();

                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.containerView, fragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }
}