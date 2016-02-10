package falconrobotics.scoutingprogram;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Install on 2/7/2016.
 */
public class MatchInfo_Fragment extends Fragment implements View.OnClickListener{
    View rootView;
    TextView text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.comments_layout,null);

        text = (TextView)rootView.findViewById(R.id.text2);

        text.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
            Toast.makeText(rootView.getApplicationContext(), "Text2 was clicked",
                    Toast.LENGTH_LONG).show();
            text.setText("Visit us: http://examples.javacodegeeks.com");

            if(text.getLinksClickable() == true) {
                text.setLinkTextColor(Color.BLUE);
    }
}
