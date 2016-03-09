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
public class Fragment_S_Auto extends Fragment implements View.OnClickListener{
    View rootView;
    private int
            score_low_miss = 0,
            score_low_hit = 0,
            score_high_miss = 0,
            score_high_hit = 0,
            score_auto_def_1 = 0,
            score_auto_def_2 = 0,
            score_auto_def_3 = 0,
            score_auto_def_4 = 0,
            score_auto_def_5 = 0;
    private Button
            button_auto_high_goal_miss_add,
            button_auto_high_goal_miss_sub,
            button_auto_high_goal_hit_add,
            button_auto_high_goal_hit_sub,
            button_auto_low_goal_miss_add,
            button_auto_low_goal_miss_sub,
            button_auto_low_goal_hit_add,
            button_auto_low_goal_hit_sub,
            button_auto_def_1,
            button_auto_def_2,
            button_auto_def_3,
            button_auto_def_4,
            button_auto_de_f5;
    private ToggleButton
            toggleButton_auto_boulder_start,
            toggleButton_auto_def_reached;


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
                score_high_miss++;
                setText(R.id.auto_high_goal_miss_score, score_high_miss);
                break;
            case R.id.auto_high_goal_miss_sub:
                score_high_miss--;
                setText(R.id.auto_high_goal_miss_score, score_high_miss);
                break;
            case R.id.auto_high_goal_hit_add:
                score_high_hit++;
                setText(R.id.auto_high_goal_hit_score, score_high_hit);
                break;
            case R.id.auto_high_goal_hit_sub:
                score_high_hit--;
                setText(R.id.auto_high_goal_hit_score, score_high_hit);
                break;
            case R.id.auto_low_goal_miss_add:
                score_low_miss++;
                setText(R.id.auto_low_goal_miss_score, score_low_miss);
                break;
            case R.id.auto_low_goal_miss_sub:
                score_low_miss--;
                setText(R.id.auto_low_goal_miss_score, score_low_miss);
                break;
            case R.id.auto_low_goal_hit_add:
                score_low_hit++;
                setText(R.id.auto_low_goal_hit_score, score_low_hit);
                break;
            case R.id.auto_low_goal_hit_sub:
                score_low_hit--;
                setText(R.id.auto_low_goal_hit_score, score_low_hit);
                break;
            case R.id.auto_def_1_attempt_sub:
                score_auto_def_1--;
                setText(R.id.auto_def_1_attempt_score, score_auto_def_1);
        }
    }

    public void setText(int id, int score)
    {
        ((TextView)rootView.findViewById(id)).setText(score + "");
    }

    private void initButtons()
    {
        toggleButton_auto_boulder_start = (ToggleButton) rootView.findViewById(R.id.auto_toggle_boulder_start);

        toggleButton_auto_def_reached = (ToggleButton) rootView.findViewById(R.id.auto_toggle_reached_def);

        button_auto_high_goal_miss_add = (Button) rootView.findViewById(R.id.auto_high_goal_miss_add);
        button_auto_high_goal_miss_add.setOnClickListener(this);

        button_auto_high_goal_miss_sub = (Button) rootView.findViewById(R.id.auto_high_goal_miss_sub);
        button_auto_high_goal_miss_sub.setOnClickListener(this);

        button_auto_high_goal_hit_add = (Button) rootView.findViewById(R.id.auto_high_goal_hit_add);
        button_auto_high_goal_hit_add.setOnClickListener(this);

        button_auto_high_goal_hit_sub = (Button) rootView.findViewById(R.id.auto_high_goal_hit_sub);
        button_auto_high_goal_hit_sub.setOnClickListener(this);

        button_auto_low_goal_miss_add = (Button) rootView.findViewById(R.id.auto_low_goal_miss_add);
        button_auto_low_goal_miss_add.setOnClickListener(this);

        button_auto_low_goal_miss_sub = (Button) rootView.findViewById(R.id.auto_low_goal_miss_sub);
        button_auto_low_goal_miss_sub.setOnClickListener(this);

        button_auto_low_goal_hit_add = (Button) rootView.findViewById(R.id.auto_low_goal_hit_add);
        button_auto_low_goal_hit_add.setOnClickListener(this);

        button_auto_low_goal_hit_sub = (Button) rootView.findViewById(R.id.auto_low_goal_hit_sub);
        button_auto_low_goal_hit_sub.setOnClickListener(this);


    }
}
