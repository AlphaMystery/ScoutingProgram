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
 * Created by Install on 2/11/2016.
 */
public class Auto_Fragment extends Fragment implements View.OnClickListener {
    View rootView;
    private int low_miss = 0;
    private int low_hit = 0;
    private int high_miss = 0;
    private int high_hit = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.auto_layout, null);

        ToggleButton auto_boulder_start = (ToggleButton) rootView.findViewById(R.id.auto_toggle_boulder_start);
//        auto_boulder_start.setOnClickListener(this);

        ToggleButton auto_def_reached = (ToggleButton) rootView.findViewById(R.id.auto_toggle_reached_def);
//        auto_def_reached.setOnClickListener(this);

        Button auto_high_goal_miss_add = (Button) rootView.findViewById(R.id.auto_high_goal_miss_add);
        auto_high_goal_miss_add.setOnClickListener(this);

        Button auto_high_goal_miss_sub = (Button) rootView.findViewById(R.id.auto_high_goal_miss_sub);
        auto_high_goal_miss_sub.setOnClickListener(this);

        Button auto_high_goal_hit_add = (Button) rootView.findViewById(R.id.auto_high_goal_hit_add);
        auto_high_goal_hit_add.setOnClickListener(this);

        Button auto_high_goal_hit_sub = (Button) rootView.findViewById(R.id.auto_high_goal_hit_sub);
        auto_high_goal_hit_sub.setOnClickListener(this);

        Button auto_low_goal_miss_add = (Button) rootView.findViewById(R.id.auto_low_goal_miss_add);
        auto_low_goal_miss_add.setOnClickListener(this);

        Button auto_low_goal_miss_sub = (Button) rootView.findViewById(R.id.auto_low_goal_miss_sub);
        auto_low_goal_miss_sub.setOnClickListener(this);

        Button auto_low_goal_hit_add = (Button) rootView.findViewById(R.id.auto_low_goal_hit_add);
        auto_low_goal_hit_add.setOnClickListener(this);

        Button auto_low_goal_hit_sub = (Button) rootView.findViewById(R.id.auto_low_goal_hit_sub);
        auto_low_goal_hit_sub.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.auto_high_goal_miss_add:
                high_miss++;
                ((TextView) rootView.findViewById(R.id.auto_high_goal_miss_score)).setText(high_miss + "");
                break;
            case R.id.auto_high_goal_miss_sub:
                high_miss--;
                ((TextView) rootView.findViewById(R.id.auto_high_goal_miss_score)).setText(high_miss + "");
                break;
            case R.id.auto_high_goal_hit_add:
                high_hit++;
                ((TextView) rootView.findViewById(R.id.auto_high_goal_hit_score)).setText(high_hit + "");
                break;
            case R.id.auto_high_goal_hit_sub:
                high_hit--;
                ((TextView) rootView.findViewById(R.id.auto_high_goal_hit_score)).setText(high_hit + "");
                break;
            case R.id.auto_low_goal_miss_add:
                low_miss++;
                ((TextView) rootView.findViewById(R.id.auto_low_goal_miss_score)).setText(low_miss + "");
                break;
            case R.id.auto_low_goal_miss_sub:
                low_miss--;
                ((TextView) rootView.findViewById(R.id.auto_low_goal_miss_score)).setText(low_miss + "");
                break;
            case R.id.auto_low_goal_hit_add:
                low_hit++;
                ((TextView) rootView.findViewById(R.id.auto_low_goal_hit_score)).setText(low_hit + "");
                break;
            case R.id.auto_low_goal_hit_sub:
                low_hit--;
                ((TextView) rootView.findViewById(R.id.auto_low_goal_hit_score)).setText(low_hit + "");
                break;
        }
    }
}
