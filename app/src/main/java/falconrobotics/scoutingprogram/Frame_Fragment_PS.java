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
public class Frame_Fragment_PS extends Fragment{
    private static final int REQUEST_TAKE_PHOTO = 1;
    private View rootView;
    private int teamNum = 0;
    private EditText teamNumInput;
    private File photoFile;

    private LayoutInflater li;

    private ImageView imageView;
    private TextView capButton;
    private Button save;
    private Spinner
            spinner_driverExperience,
            spinner_operatorExperience,
            spinner_drivetrain,
            spinner_pneumatics,
            spinner_climb,
            spinner_climbSpeed,
            spinner_shooter,
            spinner_shooting,
            spinner_portcullis,
            spinner_chevalDeFrise,
            spinner_moat,
            spinner_ramparts,
            spinner_drawbridge,
            spinner_sallyPort,
            spinner_rockWall,
            spinner_roughTerrain,
            spinner_lowBar,
            spinner_weight;
    private EditText comments,
            robotDimensions;

    private int robotPhoto = 0;
    private Helper helper;

    public static Bitmap rotateImageIfRequired(Context context, Bitmap img) {
        int rotation = getRotation(context);

        if (rotation != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(rotation);
            img.recycle();

            return Bitmap.createBitmap(img, 0, 0, 1080, 720, matrix, true);
        } else {
            return Bitmap.createScaledBitmap(img, 1080, 720, false);
        }
    }

    public static int getRotation(Context context) {
        int rotation = 0;
        ContentResolver content = context.getContentResolver();

        Cursor mediaCursor = content.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{"orientation", "date_added"}, null, null, "date_added desc");

        if (mediaCursor != null && mediaCursor.getCount() != 0) {
            while (mediaCursor.moveToNext()) {
                rotation = mediaCursor.getInt(0);
                break;
            }
            mediaCursor.close();
        }
        return rotation;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frame_layout_pits, null);
        helper = new Helper();

        dialog();
        init();

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

    private void init() {
        imageView = (ImageView) rootView.findViewById(R.id.pitCreate_photo_robot);

        capButton = (TextView) rootView.findViewById(R.id.pitCreate_robot_cap);

        spinner_driverExperience = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_driver_xp);
        spinner_driverExperience.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.EXPERIENCE)));
        spinner_operatorExperience = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_operator_xp);
        spinner_operatorExperience.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.EXPERIENCE)));
        spinner_drivetrain = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_drivetrain);
        spinner_drivetrain.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.DrivetrainType)));
        spinner_pneumatics = (Spinner) rootView.findViewById(R.id.pitCreate_pneumatics);
        spinner_pneumatics.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.NoYes)));
        spinner_shooter = (Spinner) rootView.findViewById(R.id.pitCreate_shooter_type);
        spinner_shooter.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.ShooterType)));
        spinner_shooting = (Spinner) rootView.findViewById(R.id.pitCreate_shooting_type);
        spinner_shooting.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.ShootingType)));
        spinner_climb = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_tower_climb);
        spinner_climb.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.NoYes)));
        spinner_climbSpeed = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_climb_speed);
        spinner_climbSpeed.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.ClimbSpeed)));
        spinner_weight = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_weight);
        spinner_weight.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.Weight)));
        spinner_portcullis = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_portcullis);
        spinner_portcullis.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.NoAutoTeleBoth)));
        spinner_chevalDeFrise = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_cheval_de_frise);
        spinner_chevalDeFrise.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.NoAutoTeleBoth)));
        spinner_moat = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_moat);
        spinner_moat.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.NoAutoTeleBoth)));
        spinner_ramparts = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_ramparts);
        spinner_ramparts.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.NoAutoTeleBoth)));
        spinner_drawbridge = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_drawbridge);
        spinner_drawbridge.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.NoAutoTeleBoth)));
        spinner_sallyPort = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_sally_port);
        spinner_sallyPort.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.NoAutoTeleBoth)));
        spinner_rockWall = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_rock_wall);
        spinner_rockWall.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.NoAutoTeleBoth)));
        spinner_roughTerrain = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_rough_terrain);
        spinner_roughTerrain.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.NoAutoTeleBoth)));
        spinner_lowBar = (Spinner) rootView.findViewById(R.id.pitCreate_spinner_low_bar);
        spinner_lowBar.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.NoAutoTeleBoth)));

        comments = (EditText)rootView.findViewById(R.id.pitCreate_comments);

        robotDimensions = (EditText) rootView.findViewById(R.id.pitCreate_robotDimensions);

        save = (Button) rootView.findViewById(R.id.pitCreate_save);


        assignDefault();
    }

    public void assignDefault() {
        spinner_driverExperience.setSelection(0);
        spinner_operatorExperience.setSelection(0);
        spinner_drivetrain.setSelection(0);
        spinner_pneumatics.setSelection(0);
        spinner_shooter.setSelection(0);
        spinner_shooting.setSelection(0);
        spinner_climb.setSelection(0);
        spinner_climbSpeed.setSelection(0);
        spinner_weight.setSelection(0);
        spinner_pneumatics.setSelection(0);
        spinner_chevalDeFrise.setSelection(0);
        spinner_moat.setSelection(0);
        spinner_ramparts.setSelection(0);
        spinner_drawbridge.setSelection(0);
        spinner_sallyPort.setSelection(0);
        spinner_rockWall.setSelection(0);
        spinner_roughTerrain.setSelection(0);
        spinner_lowBar.setSelection(0);

        comments.setText("");
        robotDimensions.setText("");
    }

    public void assignPre() {
        Model_Pit model_pit = helper.pit_readTeam(teamNum);

        spinner_driverExperience.setSelection(model_pit.getDriverXP());
        spinner_operatorExperience.setSelection(model_pit.getOperatorXP());
        spinner_drivetrain.setSelection(model_pit.getDrivetrain());
        spinner_pneumatics.setSelection(model_pit.getPneumatics());
        spinner_climb.setSelection(model_pit.getClimb());
        spinner_climbSpeed.setSelection(model_pit.getClimbSpeed());
        spinner_shooter.setSelection(model_pit.getShooterType());
        spinner_shooting.setSelection(model_pit.getShootingType());
        spinner_portcullis.setSelection(model_pit.getPortcullis());
        spinner_chevalDeFrise.setSelection(model_pit.getChevalDeFrise());
        spinner_moat.setSelection(model_pit.getMoat());
        spinner_ramparts.setSelection(model_pit.getRamparts());
        spinner_drawbridge.setSelection(model_pit.getDrawbridge());
        spinner_sallyPort.setSelection(model_pit.getSallyPort());
        spinner_rockWall.setSelection(model_pit.getRockWall());
        spinner_roughTerrain.setSelection(model_pit.getRoughTerrain());
        spinner_lowBar.setSelection(model_pit.getLowBar());

        try {
            imageView.setImageURI(Uri.fromFile(new File(Helper.picDirPath + File.separator + teamNum + "team" + ".jpg")));
        } catch(NullPointerException e) {
            Toast.makeText(MainActivity.context, "No image available", Toast.LENGTH_LONG).show();}


        comments.setText(model_pit.getComments());
        robotDimensions.setText(model_pit.getRobotDimensions());
    }

    public void update() {
        Model_Pit model = new Model_Pit(
                teamNum,
                spinner_driverExperience.getSelectedItemPosition(),
                spinner_operatorExperience.getSelectedItemPosition(),
                spinner_drivetrain.getSelectedItemPosition(),
                spinner_pneumatics.getSelectedItemPosition(),
                spinner_shooter.getSelectedItemPosition(),
                spinner_shooting.getSelectedItemPosition(),
                spinner_climb.getSelectedItemPosition(),
                spinner_climbSpeed.getSelectedItemPosition(),
                spinner_weight.getSelectedItemPosition(),
                "",
                spinner_portcullis.getSelectedItemPosition(),
                spinner_chevalDeFrise.getSelectedItemPosition(),
                spinner_moat.getSelectedItemPosition(),
                spinner_ramparts.getSelectedItemPosition(),
                spinner_drawbridge.getSelectedItemPosition(),
                spinner_sallyPort.getSelectedItemPosition(),
                spinner_rockWall.getSelectedItemPosition(),
                spinner_roughTerrain.getSelectedItemPosition(),
                spinner_lowBar.getSelectedItemPosition(),
                "",
                robotPhoto,
                1);
        if(!comments.getText().toString().matches(""))model.setComments(comments.getText().toString());
        if(!robotDimensions.getText().toString().matches("")) model.setRobotDimensions(robotDimensions.getText().toString());

        Helper helper = new Helper();
        helper.pit_update(MainActivity.insertOrReplace, model);

        teamNum = 0;

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();

        assignDefault();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            imageView.setImageBitmap(rotateImageIfRequired(rootView.getContext(), BitmapFactory.decodeFile(photoFile.getAbsolutePath())));
        }catch (Exception e){
            Toast.makeText(MainActivity.context, "Woops! I didn't receive the picture taken!", Toast.LENGTH_LONG).show();
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(rootView.getContext().getPackageManager()) != null) {
            try {
                photoFile = createImageFile();
            } catch (IOException ioException) {
                Toast.makeText(MainActivity.context, "Woops! I was not able to create the image file!", Toast.LENGTH_LONG).show();
            }

            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(photoFile));

                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    private File createImageFile() throws IOException {
        String imageFileName = teamNum + "team";

        return new File(Helper.picDirPath, imageFileName + ".jpg");
    }

    private void dialog() {
        li = LayoutInflater.from(rootView.getContext());
        View promptsView = li.inflate(R.layout.prompt_layout_team_num, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(rootView.getContext());

        alertDialogBuilder.setView(promptsView);

        teamNumInput = (EditText) promptsView.findViewById(R.id.pit_robot_number);

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("SUBMIT",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if(teamNumInput.getText().toString().matches("") || teamNumInput.getText().toString().matches("0")) {
                                    Toast.makeText(MainActivity.context, "Woops! Please enter a valid team number!", Toast.LENGTH_LONG).show();

                                    Fragment fragment = new Frame_Fragment_PS();

                                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                    fragmentTransaction.replace(R.id.containerView, fragment);
                                    fragmentTransaction.addToBackStack(null);
                                    fragmentTransaction.commit();
                                }
                                else {

                                    teamNum = Integer.parseInt(teamNumInput.getText().toString());

                                    if (helper.pitDataCheck(teamNum)) assignPre();
                                }
                            }
                        })
                .setNegativeButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Fragment fragment = new Fragment_Sync();

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