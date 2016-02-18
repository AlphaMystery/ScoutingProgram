package falconrobotics.scoutingprogram;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Francisco Martinez on 2/7/2016.
 * DESCRIPTION: basically displayed in pit scouting and will add the
 *              team information to show in the data viewing fragment part
 */
public class Frame_Fragment_PS extends Fragment {
    View rootView;
    TextView capButton;
    ImageView imageView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.frame_layout_p_create,null);

        imageView = (ImageView)rootView.findViewById(R.id.pit_image_view_robot);
        capButton = (TextView)rootView.findViewById(R.id.pit_button_robot_cap);

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
            bp = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bp);
        }
    }
}