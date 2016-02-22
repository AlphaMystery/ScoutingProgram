package falconrobotics.scoutingprogram;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
    String teamName = "842";
    Intent intent;


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
                intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

        return rootView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap photo;
        if (resultCode != 0) {
            photo = rotateImageIfRequired(rootView.getContext(), (Bitmap)data.getExtras().get("data"));

            imageView.setImageBitmap(photo);
        }
    }


    /**
     * Rotate an image if required.
     * @param img
     * @return
     */
    private static Bitmap rotateImageIfRequired(Context context,Bitmap img) {
        // Detect rotation
        int rotation=getRotation(context);
        if(rotation!=0){
            Matrix matrix = new Matrix();
            matrix.postRotate(rotation);
            Bitmap rotatedImg = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, true);
            img.recycle();
            return rotatedImg;
        }else{
            return img;
        }
    }

    /**
     * Get the rotation of the last image added.
     * @param context
     * @return
     */
    private static int getRotation(Context context) {
        int rotation =0;
        ContentResolver content = context.getContentResolver();


        Cursor mediaCursor = content.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[] { "orientation", "date_added" },null, null,"date_added desc");

        if (mediaCursor != null && mediaCursor.getCount() !=0 ) {
            while(mediaCursor.moveToNext()){
                rotation = mediaCursor.getInt(0);
                break;
            }
        }
        mediaCursor.close();
        return rotation;
    }
}