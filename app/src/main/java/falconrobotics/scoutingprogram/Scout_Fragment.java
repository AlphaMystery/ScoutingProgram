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
public class Scout_Fragment extends Fragment implements View.OnClickListener{
    View rootView;
    int high_goal_y = 0;
    int high_goal_n = 0;
    int low_goal_y = 0;
    int low_goal_n = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.scout_layout,null);

        Button high_goal_make_add = (Button)rootView.findViewById(R.id.high_goal_make_add);
        high_goal_make_add.setOnClickListener(this);

        Button high_goal_make_sub = (Button)rootView.findViewById(R.id.high_goal_make_sub);
        high_goal_make_sub.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        String countString = "";
        switch (v.getId())
        {
            case R.id.high_goal_make_add:
                high_goal_y++;
                countString = high_goal_y + "";
                ((TextView)rootView.findViewById(R.id.high_goal_make_score)).setText(countString);
                break;
            case R.id.high_goal_make_sub:
                high_goal_y--;
                countString = high_goal_y + "";
                ((TextView)rootView.findViewById(R.id.high_goal_make_score)).setText(countString);
                break;
        }
    }
}
