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
    private View rootView;
    private int high_goal_y = 0;
    private int high_goal_n = 0;
    private int low_goal_y = 0;
    private int low_goal_n = 0;
    private int boulder = 0;
    private int defence_push = 0;
    private int portcullis = 0;
    private int cheval_de_frise = 0;
    private int moat = 0;
    private int ramparts = 0;
    private int drawbridge = 0;
    private int sally_port = 0;
    private int rock_wall = 0;
    private int rough_terrain = 0;
    private int low_bar = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.scout_layout,null);

        //set up buttons
        {
            Button def_push_sub = (Button) rootView.findViewById(R.id.defensive_push_sub);
            def_push_sub.setOnClickListener(this);

            Button def_push_add = (Button) rootView.findViewById(R.id.defensive_push_add);
            def_push_add.setOnClickListener(this);

            Button passed_boulder_sub = (Button) rootView.findViewById(R.id.passed_boulder_sub);
            passed_boulder_sub.setOnClickListener(this);

            Button passed_boulder_add = (Button) rootView.findViewById(R.id.passed_boulder_add);
            passed_boulder_add.setOnClickListener(this);

            Button low_bar_sub = (Button) rootView.findViewById(R.id.low_bar_sub);
            low_bar_sub.setOnClickListener(this);

            Button low_bar_add = (Button) rootView.findViewById(R.id.low_bar_add);
            low_bar_add.setOnClickListener(this);

            Button rough_terrain_sub = (Button) rootView.findViewById(R.id.rough_terrain_sub);
            rough_terrain_sub.setOnClickListener(this);

            Button rough_terrain_add = (Button) rootView.findViewById(R.id.rough_terrain_add);
            rough_terrain_add.setOnClickListener(this);

            Button rock_wall_sub = (Button) rootView.findViewById(R.id.rock_wall_sub);
            rock_wall_sub.setOnClickListener(this);

            Button rock_wall_add = (Button) rootView.findViewById(R.id.rock_wall_add);
            rock_wall_add.setOnClickListener(this);

            Button sally_port_sub = (Button) rootView.findViewById(R.id.sally_port_sub);
            sally_port_sub.setOnClickListener(this);

            Button sally_port_add = (Button) rootView.findViewById(R.id.sally_port_add);
            sally_port_add.setOnClickListener(this);

            Button drawbridge_sub = (Button) rootView.findViewById(R.id.drawbridge_sub);
            drawbridge_sub.setOnClickListener(this);

            Button drawbridge_add = (Button) rootView.findViewById(R.id.drawbridge_add);
            drawbridge_add.setOnClickListener(this);

            Button ramparts_sub = (Button) rootView.findViewById(R.id.ramparts_sub);
            ramparts_sub.setOnClickListener(this);

            Button ramparts_add = (Button) rootView.findViewById(R.id.ramparts_add);
            ramparts_add.setOnClickListener(this);

            Button moat_sub = (Button) rootView.findViewById(R.id.moat_sub);
            moat_sub.setOnClickListener(this);

            Button moat_add = (Button) rootView.findViewById(R.id.moat_add);
            moat_add.setOnClickListener(this);

            Button cheval_de_frise_sub = (Button) rootView.findViewById(R.id.cheval_de_frise_sub);
            cheval_de_frise_sub.setOnClickListener(this);

            Button cheval_de_frise_add = (Button) rootView.findViewById(R.id.cheval_de_frise_add);
            cheval_de_frise_add.setOnClickListener(this);

            Button portcullis_sub = (Button) rootView.findViewById(R.id.portcullis_sub);
            portcullis_sub.setOnClickListener(this);

            Button portcullis_add = (Button) rootView.findViewById(R.id.portcullis_add);
            portcullis_add.setOnClickListener(this);

            Button high_goal_make_sub = (Button) rootView.findViewById(R.id.high_goal_make_sub);
            high_goal_make_sub.setOnClickListener(this);

            Button high_goal_make_add = (Button) rootView.findViewById(R.id.high_goal_make_add);
            high_goal_make_add.setOnClickListener(this);

            Button high_goal_miss_sub = (Button) rootView.findViewById(R.id.high_goal_miss_sub);
            high_goal_miss_sub.setOnClickListener(this);

            Button high_goal_miss_add = (Button) rootView.findViewById(R.id.high_goal_miss_add);
            high_goal_miss_add.setOnClickListener(this);

            Button low_goal_make_sub = (Button) rootView.findViewById(R.id.low_goal_make_sub);
            low_goal_make_sub.setOnClickListener(this);

            Button low_goal_make_add = (Button) rootView.findViewById(R.id.low_goal_make_add);
            low_goal_make_add.setOnClickListener(this);

            Button low_goal_miss_sub = (Button) rootView.findViewById(R.id.low_goal_miss_sub);
            low_goal_miss_sub.setOnClickListener(this);

            Button low_goal_miss_add = (Button) rootView.findViewById(R.id.low_goal_miss_add);
            low_goal_miss_add.setOnClickListener(this);
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
            case R.id.defensive_push_sub:
                defence_push--;
                ((TextView)rootView.findViewById(R.id.defensive_push_score)).setText(defence_push + "");
                break;
            case R.id.defensive_push_add:
                defence_push++;
                ((TextView)rootView.findViewById(R.id.defensive_push_score)).setText(defence_push + "");
                break;
            case R.id.passed_boulder_sub:
                boulder--;
                ((TextView)rootView.findViewById(R.id.passed_boulders_score)).setText(boulder + "");
                break;
            case R.id.passed_boulder_add:
                boulder++;
                ((TextView)rootView.findViewById(R.id.passed_boulders_score)).setText(boulder + "");
                break;
            case R.id.low_bar_sub:
                low_bar--;
                ((TextView)rootView.findViewById(R.id.low_bar_score)).setText(low_bar + "");
                break;
            case R.id.low_bar_add:
                low_bar++;
                ((TextView)rootView.findViewById(R.id.low_bar_score)).setText(low_bar + "");
                break;
            case R.id.rough_terrain_sub:
                rough_terrain--;
                ((TextView)rootView.findViewById(R.id.rough_terrain_score)).setText(rough_terrain + "");
                break;
            case R.id.rough_terrain_add:
                rough_terrain++;
                ((TextView)rootView.findViewById(R.id.rough_terrain_score)).setText(rough_terrain + "");
                break;
            case R.id.rock_wall_sub:
                rock_wall--;
                ((TextView)rootView.findViewById(R.id.rock_wall_score)).setText(rock_wall + "");
                break;
            case R.id.rock_wall_add:
                rock_wall++;
                ((TextView)rootView.findViewById(R.id.rock_wall_score)).setText(rock_wall + "");
                break;
            case R.id.sally_port_sub:
                sally_port--;
                ((TextView)rootView.findViewById(R.id.sally_port_score)).setText(sally_port + "");
                break;
            case R.id.sally_port_add:
                sally_port++;
                ((TextView)rootView.findViewById(R.id.sally_port_score)).setText(sally_port + "");
                break;
            case R.id.drawbridge_sub:
                drawbridge--;
                ((TextView)rootView.findViewById(R.id.drawbridge_score)).setText(drawbridge + "");
                break;
            case R.id.drawbridge_add:
                drawbridge++;
                ((TextView)rootView.findViewById(R.id.drawbridge_score)).setText(drawbridge + "");
                break;
            case R.id.ramparts_sub:
                ramparts--;
                ((TextView)rootView.findViewById(R.id.ramparts_score)).setText(ramparts + "");
                break;
            case R.id.ramparts_add:
                ramparts++;
                ((TextView)rootView.findViewById(R.id.ramparts_score)).setText(ramparts + "");
                break;
            case R.id.moat_sub:
                moat--;
                ((TextView)rootView.findViewById(R.id.moat_score)).setText(moat + "");
                break;
            case R.id.moat_add:
                moat++;
                ((TextView)rootView.findViewById(R.id.moat_score)).setText(moat + "");
                break;
            case R.id.cheval_de_frise_sub:
                cheval_de_frise--;
                ((TextView)rootView.findViewById(R.id.cheval_de_frise_score)).setText(cheval_de_frise + "");
                break;
            case R.id.cheval_de_frise_add:
                cheval_de_frise++;
                ((TextView)rootView.findViewById(R.id.cheval_de_frise_score)).setText(cheval_de_frise + "");
                break;
            case R.id.portcullis_sub:
                portcullis--;
                ((TextView)rootView.findViewById(R.id.portcullis_score)).setText(portcullis + "");
                break;
            case R.id.portcullis_add:
                portcullis++;
                ((TextView)rootView.findViewById(R.id.portcullis_score)).setText(portcullis + "");
                break;
            case R.id.high_goal_make_sub:
                high_goal_y--;
                ((TextView)rootView.findViewById(R.id.high_goal_make_score)).setText(high_goal_y + "");
                break;
            case R.id.high_goal_make_add:
                high_goal_y++;
                ((TextView)rootView.findViewById(R.id.high_goal_make_score)).setText(high_goal_y + "");
                break;
            case R.id.high_goal_miss_sub:
                high_goal_n--;
                ((TextView)rootView.findViewById(R.id.high_goal_miss_score)).setText(high_goal_n + "");
                break;
            case R.id.high_goal_miss_add:
                high_goal_n++;
                ((TextView)rootView.findViewById(R.id.high_goal_miss_score)).setText(high_goal_n + "");
                break;
            case R.id.low_goal_make_sub:
                low_goal_y--;
                ((TextView)rootView.findViewById(R.id.low_goal_make_score)).setText(low_goal_y + "");
                break;
            case R.id.low_goal_make_add:
                low_goal_y++;
                ((TextView)rootView.findViewById(R.id.low_goal_make_score)).setText(low_goal_y + "");
                break;
            case R.id.low_goal_miss_sub:
                low_goal_n--;
                ((TextView)rootView.findViewById(R.id.low_goal_miss_score)).setText(low_goal_n + "");
                break;
            case R.id.low_goal_miss_add:
                low_goal_n++;
                ((TextView)rootView.findViewById(R.id.low_goal_miss_score)).setText(low_goal_n + "");
                break;
        }
    }
}
