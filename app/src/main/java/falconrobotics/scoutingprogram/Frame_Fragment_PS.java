package falconrobotics.scoutingprogram;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

/**
 * Created by Francisco Martinez on 2/7/2016.
 * DESCRIPTION: basically displayed in pit scouting and will add the
 *              team information to show in the data viewing fragment part.
 */
public class Frame_Fragment_PS extends Fragment {
    View rootView;
    TextView capButton;
    ImageView imageView;
    EditText teamNumberInput;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.frame_layout_p_create,null);

        imageView = (ImageView)rootView.findViewById(R.id.pit_image_view_robot);
        capButton = (TextView)rootView.findViewById(R.id.pit_button_robot_cap);
        teamNumberInput = (EditText)rootView.findViewById(R.id.pit_robot_number);

        capButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

        return rootView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bp;
        if (resultCode != 0) {
            bp = (Bitmap)data.getExtras().get("data");

        }
    }

    public static Bitmap rotateImage(Bitmap source, float angle) {
        Bitmap retVal;

        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        retVal = Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);

        return retVal;
    }

    private File createImageFile(int teamNumber) throws IOException {
        // Create an image file name
        String imageFileName = teamNumber + "";
        File storageDir = new File(Fragment_About.picDir);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".png",         /* suffix */
                storageDir      /* directory */
        );

        return image;
    }
}