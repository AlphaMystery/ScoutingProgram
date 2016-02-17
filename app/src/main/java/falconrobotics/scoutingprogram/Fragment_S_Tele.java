package falconrobotics.scoutingprogram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Install on 2/7/2016.
 */
public class Fragment_S_Tele extends Fragment implements View.OnClickListener{
    private View rootView;

    private int high_goal_h = 0;
    private int high_goal_m = 0;
    private int low_goal_h = 0;
    private int low_goal_m = 0;
    private int boulder_h = 0;
    private int boulder_m = 0;
    private int def_push = 0;
    private int def_block = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_s_tele,null);

        {
            Button lowHitAdd = (Button) rootView.findViewById(R.id.tele_low_goal_hit_add);
            lowHitAdd.setOnClickListener(this);

            Button lowHitSub = (Button) rootView.findViewById(R.id.tele_low_goal_hit_sub);
            lowHitSub.setOnClickListener(this);

            Button lowMissAdd = (Button) rootView.findViewById(R.id.tele_low_goal_miss_add);
            lowMissAdd.setOnClickListener(this);

            Button lowMissSub = (Button) rootView.findViewById(R.id.tele_low_goal_miss_sub);
            lowMissSub.setOnClickListener(this);

            Button highHitAdd = (Button) rootView.findViewById(R.id.tele_high_goal_hit_add);
            highHitAdd.setOnClickListener(this);

            Button highHitSub = (Button) rootView.findViewById(R.id.tele_high_goal_hit_sub);
            highHitSub.setOnClickListener(this);

            Button highMissAdd = (Button) rootView.findViewById(R.id.tele_high_goal_miss_add);
            highMissAdd.setOnClickListener(this);

            Button highMissSub = (Button) rootView.findViewById(R.id.tele_high_goal_miss_sub);
            highMissSub.setOnClickListener(this);
        }

        return rootView;
    }


    /**
     * Sets the clickable event and adds or subtracts bsed on the button pressed
     * @param v
     *          The event being called or view, in this case the buttons.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId())
        { //lmao there's probably a better way to do this
            case R.id.tele_high_goal_miss_sub:
                high_goal_m--;
                ((TextView)rootView.findViewById(R.id.tele_high_goal_miss_score)).setText(high_goal_m + "");
                break;
            case R.id.tele_high_goal_miss_add:
                high_goal_m--;
                ((TextView)rootView.findViewById(R.id.tele_high_goal_miss_score)).setText(high_goal_m + "");
                break;
        }
    }
}
