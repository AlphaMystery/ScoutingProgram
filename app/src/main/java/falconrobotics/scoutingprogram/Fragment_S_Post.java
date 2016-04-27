package falconrobotics.scoutingprogram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Arrays;

/**
 * Created on 2/7/2016.
 */
public class Fragment_S_Post extends Fragment {
    private View rootView;

    private static Button save;

    private static Spinner postClimb;
    private static EditText postComments;

    private static Helper helper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_s_post, container, false);
        helper = new Helper();

         init();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                refresh();
            }
        });

        return rootView;
    }

    private void init()
    {
        save = (Button) rootView.findViewById(R.id.matchCreate_post_save);

        postClimb = (Spinner) rootView.findViewById(R.id.matchCreate_post_climbing);
        postClimb.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.ChallengeClimb)));
        postClimb.setSelection(Match_Model_Save.postClimb);

        postComments = (EditText) rootView.findViewById(R.id.matchCreate_post_comments);
        postComments.setText(Match_Model_Save.postComments);
    }


    private void update()
    {
        Model_Match model = new Model_Match(
                Match_Model_Save._id,
                Match_Model_Save.teamNum,
                Match_Model_Save.autoLowMiss,
                Match_Model_Save.autoLowHit,
                Match_Model_Save.autoHighMiss,
                Match_Model_Save.autoHighHit,
                Match_Model_Save.autoLowBarMiss,
                Match_Model_Save.autoLowBarHit,
                Match_Model_Save.autoCMiss,
                Match_Model_Save.autoCHit,
                Match_Model_Save.teleLowBarMiss,
                Match_Model_Save.teleLowBarHit,
                Match_Model_Save.teleCMiss,
                Match_Model_Save.teleCHit,
                Match_Model_Save.teleSector1Miss,
                Match_Model_Save.teleSector1Hit,
                Match_Model_Save.teleSector2Miss,
                Match_Model_Save.teleSector2Hit,
                Match_Model_Save.teleSector3Miss,
                Match_Model_Save.teleSector3Hit,
                Match_Model_Save.teleSector4Miss,
                Match_Model_Save.teleSector4Hit,
                Match_Model_Save.teleSector5Miss,
                Match_Model_Save.teleSector5Hit,
                Match_Model_Save.teleSector6Miss,
                Match_Model_Save.teleSector6Hit,
                Match_Model_Save.postClimb,
                Match_Model_Save.postComments,
                1
        );

        helper.match_update(MainActivity.insertOrReplace, model);
        Match_Model_Save.reset();
        refresh();
    }

    private void refresh()
    {
        Fragment fragment = new Tab_Fragment_S();

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerView, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
