package falconrobotics.scoutingprogram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Arrays;

/**
 * Created on 2/7/2016.
 */
public class Fragment_S_Post extends Fragment {
    private View rootView;

    private static Button save;

    private static Spinner safeSpot,
    climb;

    private static Helper helper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_s_post, null);
        helper = new Helper();

         init();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                update();
            }
        });


        return rootView;
    }

    private void init()
    {
        save = (Button) rootView.findViewById(R.id.matchCreate_post_save);

        safeSpot = (Spinner) rootView.findViewById(R.id.matchCreate_spinner_safespot);
        safeSpot.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.numbers)));

        climb = (Spinner) rootView.findViewById(R.id.matchCreate_climbing);
        climb.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.ChallengeClimb)));


        assignDefault();
    }

    public static void assignDefault()
    {
        climb.setSelection(0);
        safeSpot.setSelection(0);
    }

    public static void assignPre() {
        Model_Match model_match = helper.match_readTeam(Tab_Fragment_S.getMatchNum(), Tab_Fragment_S.getTeamNum());

        climb.setSelection(model_match.getClimb());
        safeSpot.setSelection(model_match.getSafeSpot());
    }


    public void update(Model_Match model)
    {
        model.setSafeSpot(safeSpot.getSelectedItemPosition());
        model.setClimb(climb.getSelectedItemPosition());
    }
}
