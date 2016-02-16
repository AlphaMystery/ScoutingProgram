package falconrobotics.scoutingprogram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Install on 2/7/2016.
 */
public class Fragment_GS_Pre extends Fragment {
    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_gs_pre,null);


        final Button submit = (Button)rootView.findViewById(R.id.submit_button);
        final Spinner alliance = (Spinner)rootView.findViewById(R.id.input_alliance);
        final EditText team_number = (EditText)rootView.findViewById(R.id.input_team_number);
        final EditText match_number = (EditText) rootView.findViewById(R.id.input_match_number);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.submit_button:
                        //to test if it works
                        submit.setText(team_number.getText() + "\n" + match_number.getText() + "\n" + alliance.getSelectedItem().toString());
                        // DO SOMETHING
                        break;
                }

            }
        });


        return rootView;
    }
}
