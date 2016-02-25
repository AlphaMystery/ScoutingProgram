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
 * Created by Francisco Martinez on 2/11/2016.
 * DESCRIPTION: Displays scouting auto layout and stores user input data for retrieval.
 */
public class Fragment_S_Auto extends Fragment implements View.OnClickListener{
    View rootView;
    private int
            low_miss = 0,
            low_hit = 0,
            high_miss = 0,
            high_hit = 0;
    private Button
            auto_high_goal_miss_add,
            auto_high_goal_miss_sub,
            auto_high_goal_hit_add,
            auto_high_goal_hit_sub,
            auto_low_goal_miss_add,
            auto_low_goal_miss_sub,
            auto_low_goal_hit_add,
            auto_low_goal_hit_sub;
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
        }
    }

    public void setText(int id, int score)
    {
        ((TextView)rootView.findViewById(id)).setText(score + "");
    }

    private void initButtons()
    {
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
    }
}
