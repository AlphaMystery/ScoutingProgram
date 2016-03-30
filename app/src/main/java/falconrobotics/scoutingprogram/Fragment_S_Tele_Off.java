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
 * Created on 2/7/2016.
 */
public class Fragment_S_Tele_Off extends Fragment implements View.OnClickListener {
    private View rootView;

    private int high_goal_h = 0,
            high_goal_m = 0,
            low_goal_h = 0,
            low_goal_m = 0,
            boulder_h = 0,
            boulder_m = 0,
            def_push = 0,
            def_block = 0;
    private Button
            lowHitAdd,
            lowHitSub,
            lowMissAdd,
            lowMissSub,
            highHitAdd,
            highHitSub,
            highMissAdd,
            highMissSub;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_s_tele_off, null);

        initButtons();

        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tele_high_goal_miss_sub:
                high_goal_m--;
                setText(R.id.tele_high_goal_miss_score, high_goal_m);
                break;
            case R.id.tele_high_goal_miss_add:
                high_goal_m++;
                setText(R.id.tele_high_goal_miss_score, high_goal_m);
                break;
        }
    }

    public void setText(int id, int score) {
        ((TextView) rootView.findViewById(id)).setText(score + "");
    }

    public void initButtons() {
        lowHitAdd = (Button) rootView.findViewById(R.id.tele_low_goal_hit_add);
        lowHitAdd.setOnClickListener(this);

        lowHitSub = (Button) rootView.findViewById(R.id.tele_low_goal_hit_sub);
        lowHitSub.setOnClickListener(this);

        lowMissAdd = (Button) rootView.findViewById(R.id.tele_low_goal_miss_add);
        lowMissAdd.setOnClickListener(this);

        lowMissSub = (Button) rootView.findViewById(R.id.tele_low_goal_miss_sub);
        lowMissSub.setOnClickListener(this);

        highHitAdd = (Button) rootView.findViewById(R.id.tele_high_goal_hit_add);
        highHitAdd.setOnClickListener(this);

        highHitSub = (Button) rootView.findViewById(R.id.tele_high_goal_hit_sub);
        highHitSub.setOnClickListener(this);

        highMissAdd = (Button) rootView.findViewById(R.id.tele_high_goal_miss_add);
        highMissAdd.setOnClickListener(this);

        highMissSub = (Button) rootView.findViewById(R.id.tele_high_goal_miss_sub);
        highMissSub.setOnClickListener(this);
    }
}
