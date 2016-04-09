package falconrobotics.scoutingprogram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created on 2/11/2016.
 */
public class Fragment_S_Auto extends Fragment implements View.OnClickListener {
    View rootView;
    private int
            low_miss = 0,
            low_hit = 0,
            high_miss = 0,
            high_hit = 0,
            def1_miss = 0,
            def1_hit = 0,
            def2_miss = 0,
            def2_hit = 0,
            def3_miss = 0,
            def3_hit = 0,
            def4_miss = 0,
            def4_hit = 0,
            def5_miss = 0,
            def5_hit = 0;
    private boolean boulderStart = false,
            defBreached = false;
    private Button
            auto_high_goal_miss_add,
            auto_high_goal_miss_sub,
            auto_high_goal_hit_add,
            auto_high_goal_hit_sub,
            auto_low_goal_miss_add,
            auto_low_goal_miss_sub,
            auto_low_goal_hit_add,
            auto_low_goal_hit_sub,
            auto_def1_miss_add,
            auto_def1_miss_sub,
            auto_def1_hit_add,
            auto_def1_hit_sub,
            auto_def2_miss_add,
            auto_def2_miss_sub,
            auto_def2_hit_add,
            auto_def2_hit_sub,
            auto_def3_miss_add,
            auto_def3_miss_sub,
            auto_def3_hit_add,
            auto_def3_hit_sub,
            auto_def4_miss_add,
            auto_def4_miss_sub,
            auto_def4_hit_add,
            auto_def4_hit_sub,
            auto_def5_miss_add,
            auto_def5_miss_sub,
            auto_def5_hit_add,
            auto_def5_hit_sub;
    private ToggleButton
            auto_boulder_start,
            auto_def_reached;


    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_s_auto, null);

        initButtons();

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.auto_high_goal_miss_add:
                high_miss++;
                setText(R.id.auto_high_goal_miss_score, high_miss);
                break;
            case R.id.auto_high_goal_miss_sub:
                high_miss--;
                setText(R.id.auto_high_goal_miss_score, high_miss);
                break;
            case R.id.auto_high_goal_hit_add:
                high_hit++;
                setText(R.id.auto_high_goal_hit_score, high_hit);
                break;
            case R.id.auto_high_goal_hit_sub:
                high_hit--;
                setText(R.id.auto_high_goal_hit_score, high_hit);
                break;
            case R.id.auto_low_goal_miss_add:
                low_miss++;
                setText(R.id.auto_low_goal_miss_score, low_miss);
                break;
            case R.id.auto_low_goal_miss_sub:
                low_miss--;
                setText(R.id.auto_low_goal_miss_score, low_miss);
                break;
            case R.id.auto_low_goal_hit_add:
                low_hit++;
                setText(R.id.auto_low_goal_hit_score, low_hit);
                break;
            case R.id.auto_low_goal_hit_sub:
                low_hit--;
                setText(R.id.auto_low_goal_hit_score, low_hit);
                break;
            case R.id.auto_def_1_attempt_add:
                def1_miss++;
                setText( R.id.auto_def_1_attempt_score, def1_miss);
                break;
            case R.id.auto_def_1_attempt_sub:
                def1_miss--;
                setText(R.id.auto_def_1_attempt_score, def1_miss);
                break;
            case R.id.auto_def_1_cross_add:
                def1_hit++;
                setText(R.id.auto_def_1_cross_score, def1_hit);
                break;
            case R.id.auto_def_1_cross_sub:
                def1_hit--;
                setText(R.id.auto_def_1_cross_score, def1_hit);
                break;
            case R.id.auto_def_2_attempt_add:
                def2_miss++;
                setText( R.id.auto_def_2_attempt_score, def2_miss);
                break;
            case R.id.auto_def_2_attempt_sub:
                def2_miss--;
                setText(R.id.auto_def_2_attempt_score, def2_miss);
                break;
            case R.id.auto_def_2_cross_add:
                def2_hit++;
                setText(R.id.auto_def_2_cross_score, def2_hit);
                break;
            case R.id.auto_def_2_cross_sub:
                def2_hit--;
                setText(R.id.auto_def_2_cross_score, def2_hit);
                break;
            case R.id.auto_def_3_attempt_add:
                def3_miss++;
                setText( R.id.auto_def_3_attempt_score, def3_miss);
                break;
            case R.id.auto_def_3_attempt_sub:
                def3_miss--;
                setText(R.id.auto_def_3_attempt_score, def3_miss);
                break;
            case R.id.auto_def_3_cross_add:
                def3_hit++;
                setText(R.id.auto_def_3_cross_score, def3_hit);
                break;
            case R.id.auto_def_3_cross_sub:
                def3_hit--;
                setText(R.id.auto_def_3_cross_score, def3_hit);
                break;
            case R.id.auto_def_4_attempt_add:
                def4_miss++;
                setText( R.id.auto_def_4_attempt_score, def4_miss);
                break;
            case R.id.auto_def_4_attempt_sub:
                def4_miss--;
                setText(R.id.auto_def_4_attempt_score, def4_miss);
                break;
            case R.id.auto_def_4_cross_add:
                def4_hit++;
                setText(R.id.auto_def_4_cross_score, def4_hit);
                break;
            case R.id.auto_def_4_cross_sub:
                def4_hit--;
                setText(R.id.auto_def_4_cross_score, def4_hit);
                break;
            case R.id.auto_def_5_attempt_add:
                def5_miss++;
                setText( R.id.auto_def_5_attempt_score, def5_miss);
                break;
            case R.id.auto_def_5_attempt_sub:
                def5_miss--;
                setText(R.id.auto_def_5_attempt_score, def5_miss);
                break;
            case R.id.auto_def_5_cross_add:
                def5_hit++;
                setText(R.id.auto_def_5_cross_score, def5_hit);
                break;
            case R.id.auto_def_5_cross_sub:
                def5_hit--;
                setText(R.id.auto_def_5_cross_score, def5_hit);
                break;
                
        }
    }

    private void setText(int id, int score) {
        ((TextView) rootView.findViewById(id)).setText(score + "");
    }

    private void initButtons() {
        auto_boulder_start = (ToggleButton) rootView.findViewById(R.id.auto_toggle_boulder_start);

        auto_def_reached = (ToggleButton) rootView.findViewById(R.id.auto_toggle_reached_def);

        auto_high_goal_miss_add = (Button) rootView.findViewById(R.id.auto_high_goal_miss_add);
        auto_high_goal_miss_add.setOnClickListener(this);

        auto_high_goal_miss_sub = (Button) rootView.findViewById(R.id.auto_high_goal_miss_sub);
        auto_high_goal_miss_sub.setOnClickListener(this);

        auto_high_goal_hit_add = (Button) rootView.findViewById(R.id.auto_high_goal_hit_add);
        auto_high_goal_hit_add.setOnClickListener(this);

        auto_high_goal_hit_sub = (Button) rootView.findViewById(R.id.auto_high_goal_hit_sub);
        auto_high_goal_hit_sub.setOnClickListener(this);

        auto_low_goal_miss_add = (Button) rootView.findViewById(R.id.auto_low_goal_miss_add);
        auto_low_goal_miss_add.setOnClickListener(this);

        auto_low_goal_miss_sub = (Button) rootView.findViewById(R.id.auto_low_goal_miss_sub);
        auto_low_goal_miss_sub.setOnClickListener(this);

        auto_low_goal_hit_add = (Button) rootView.findViewById(R.id.auto_low_goal_hit_add);
        auto_low_goal_hit_add.setOnClickListener(this);

        auto_low_goal_hit_sub = (Button) rootView.findViewById(R.id.auto_low_goal_hit_sub);
        auto_low_goal_hit_sub.setOnClickListener(this);

        auto_def1_miss_add = (Button) rootView.findViewById(R.id.auto_def_1_attempt_add);
        auto_def1_miss_add.setOnClickListener(this);
        
        auto_def1_miss_sub = (Button) rootView.findViewById(R.id.auto_def_1_attempt_sub);
        auto_def1_miss_sub.setOnClickListener(this);
        
        auto_def1_hit_add = (Button) rootView.findViewById(R.id.auto_def_1_cross_add);
        auto_def1_hit_add.setOnClickListener(this);
        
        auto_def1_hit_sub = (Button) rootView.findViewById(R.id.auto_def_1_cross_sub);
        auto_def1_hit_sub.setOnClickListener(this);

        auto_def2_miss_add = (Button) rootView.findViewById(R.id.auto_def_2_attempt_add);
        auto_def2_miss_add.setOnClickListener(this);

        auto_def2_miss_sub = (Button) rootView.findViewById(R.id.auto_def_2_attempt_sub);
        auto_def2_miss_sub.setOnClickListener(this);
        
        auto_def2_hit_add = (Button) rootView.findViewById(R.id.auto_def_2_cross_add);
        auto_def2_hit_add.setOnClickListener(this);

        auto_def2_hit_sub = (Button) rootView.findViewById(R.id.auto_def_2_cross_sub);
        auto_def2_hit_sub.setOnClickListener(this);

        auto_def3_miss_add = (Button) rootView.findViewById(R.id.auto_def_3_attempt_add);
        auto_def3_miss_add.setOnClickListener(this);

        auto_def3_miss_sub = (Button) rootView.findViewById(R.id.auto_def_3_attempt_sub);
        auto_def3_miss_sub.setOnClickListener(this);
        
        auto_def3_hit_add = (Button) rootView.findViewById(R.id.auto_def_3_cross_add);
        auto_def3_hit_add.setOnClickListener(this);

        auto_def3_hit_sub = (Button) rootView.findViewById(R.id.auto_def_3_cross_sub);
        auto_def3_hit_sub.setOnClickListener(this);

        auto_def4_miss_add = (Button) rootView.findViewById(R.id.auto_def_4_attempt_add);
        auto_def4_miss_add.setOnClickListener(this);

        auto_def4_miss_sub = (Button) rootView.findViewById(R.id.auto_def_4_attempt_sub);
        auto_def4_miss_sub.setOnClickListener(this);

        auto_def4_hit_add = (Button) rootView.findViewById(R.id.auto_def_4_cross_add);
        auto_def4_hit_add.setOnClickListener(this);

        auto_def4_hit_sub = (Button) rootView.findViewById(R.id.auto_def_4_cross_sub);
        auto_def4_hit_sub.setOnClickListener(this);

        auto_def5_miss_add = (Button) rootView.findViewById(R.id.auto_def_5_attempt_add);
        auto_def5_miss_add.setOnClickListener(this);

        auto_def5_miss_sub = (Button) rootView.findViewById(R.id.auto_def_5_attempt_sub);
        auto_def5_miss_sub.setOnClickListener(this);

        auto_def5_hit_add = (Button) rootView.findViewById(R.id.auto_def_5_cross_add);
        auto_def5_hit_add.setOnClickListener(this);

        auto_def5_hit_sub = (Button) rootView.findViewById(R.id.auto_def_5_cross_sub);
        auto_def5_hit_sub.setOnClickListener(this);
    }

    private void assignButtons(Model_Match model)
    {
        Model_Match model_match = model;

    }
}