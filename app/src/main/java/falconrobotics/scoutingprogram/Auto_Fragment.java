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
public class Auto_Fragment extends Fragment implements View.OnClickListener{
    View rootView;
    private int low_goal = 0;
    private int high_goal = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.auto_layout,null);

        ToggleButton boulder_start = (ToggleButton)rootView.findViewById(R.id.toggle_boulder_start);
        boulder_start.setOnClickListener(this);

        ToggleButton def_reached = (ToggleButton)rootView.findViewById(R.id.toggle_reached_def);
        def_reached.setOnClickListener(this);

        Button high_goal_sub = (Button)rootView.findViewById(R.id.high_goal_auto_sub);
        high_goal_sub.setOnClickListener(this);

        Button high_goal_add = (Button)rootView.findViewById(R.id.high_goal_auto_add);
        high_goal_add.setOnClickListener(this);

        Button low_goal_sub = (Button)rootView.findViewById(R.id.low_goal_auto_sub);
        low_goal_sub.setOnClickListener(this);

        Button low_goal_add = (Button)rootView.findViewById(R.id.low_goal_auto_add);
        low_goal_add.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.low_goal_auto_sub:
                low_goal--;
                ((TextView)rootView.findViewById(R.id.low_goal_auto_score)).setText(low_goal + "");
                break;
            case R.id.low_goal_auto_add:
                low_goal++;
                ((TextView)rootView.findViewById(R.id.low_goal_auto_score)).setText(low_goal + "");
                break;
            case R.id.high_goal_auto_sub:
                high_goal--;
                ((TextView)rootView.findViewById(R.id.high_goal_auto_score)).setText(high_goal + "");
                break;
            case R.id.high_goal_auto_add:
                high_goal++;
                ((TextView)rootView.findViewById(R.id.high_goal_auto_score)).setText(high_goal + "");
                break;
        }
    }
}
