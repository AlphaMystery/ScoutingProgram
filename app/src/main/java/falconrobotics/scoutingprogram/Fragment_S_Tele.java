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
public class Fragment_S_Tele extends Fragment implements View.OnClickListener {
    private View rootView;

    private static int
            lowMiss = 0,
            lowHit = 0,
            highMiss = 0,
            highHit = 0,
            lowBarMiss = 0,
            lowBarHit = 0,
            drawbridgeMiss = 0,
            drawbridgeHit = 0,
            sallyPortMiss = 0,
            sallyPortHit = 0;

    private Button
            high_miss_add,
            high_miss_sub,
            high_hit_add,
            high_hit_sub,
            low_miss_add,
            low_miss_sub,
            low_hit_add,
            low_hit_sub,
            lowBar_miss_sub,
            lowBar_hit_sub,
            drawbridge_miss_sub,
            drawbridge_hit_sub,
            sallyPort_miss_sub,
            sallyPort_hit_sub,
            lowBar_miss_add,
            lowBar_hit_add,
            drawbridge_miss_add,
            drawbridge_hit_add,
            sallyPort_miss_add,
            sallyPort_hit_add;

    private static Helper helper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_s_tele, null);
        helper = new Helper();

        init();

        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.matchCreate_tele_low_goal_miss_sub:
                lowMiss--;
                setText(R.id.matchCreate_tele_low_goal_miss_score, lowMiss);
                break;
            case R.id.matchCreate_tele_low_goal_miss_add:
                lowMiss++;
                setText(R.id.matchCreate_tele_low_goal_miss_score, lowMiss);
                break;
            case R.id.matchCreate_tele_low_goal_hit_sub:
                lowHit--;
                setText(R.id.matchCreate_tele_low_goal_hit_score, lowHit);
                break;
            case R.id.matchCreate_tele_low_goal_hit_add:
                lowHit++;
                setText(R.id.matchCreate_tele_low_goal_hit_score, lowHit);
                break;
            case R.id.matchCreate_tele_high_goal_miss_sub:
                highMiss--;
                setText(R.id.matchCreate_tele_high_goal_miss_score, highMiss);
                break;
            case R.id.matchCreate_tele_high_goal_miss_add:
                highMiss++;
                setText(R.id.matchCreate_tele_high_goal_miss_score, highMiss);
                break;
            case R.id.matchCreate_tele_high_goal_hit_sub:
                highHit--;
                setText(R.id.matchCreate_tele_high_goal_hit_score, highHit);
                break;
            case R.id.matchCreate_tele_high_goal_hit_add:
                highHit++;
                setText(R.id.matchCreate_tele_high_goal_hit_score, highHit);
                break;
            case R.id.matchCreate_lowbar_attempt_sub:
                lowBarMiss--;
                setText(R.id.matchCreate_lowbar_attempt_score, lowBarMiss);
                break;
            case R.id.matchCreate_lowbar_attempt_add:
                lowBarMiss++;
                setText(R.id.matchCreate_lowbar_attempt_score, lowBarMiss);
                break;
            case R.id.matchCreate_lowbar_cross_sub:
                lowBarHit--;
                setText(R.id.matchCreate_lowbar_cross_score, lowBarHit);
                break;
            case R.id.matchCreate_lowbar_cross_add:
                lowBarHit++;
                setText(R.id.matchCreate_lowbar_cross_score, lowBarHit);
                break;
            case R.id.matchCreate_drawbridge_attempt_sub:
                drawbridgeMiss--;
                setText(R.id.matchCreate_drawbridge_attempt_score, drawbridgeMiss);
                break;
            case R.id.matchCreate_drawbridge_attempt_add:
                drawbridgeMiss++;
                setText(R.id.matchCreate_drawbridge_attempt_score, drawbridgeMiss);
                break;
            case R.id.matchCreate_drawbridge_cross_sub:
                drawbridgeHit--;
                setText(R.id.matchCreate_drawbridge_cross_score, drawbridgeHit);
                break;
            case R.id.matchCreate_drawbridge_cross_add:
                drawbridgeHit++;
                setText(R.id.matchCreate_drawbridge_cross_score, drawbridgeHit);
                break;         
            case R.id.matchCreate_sallyport_attempt_sub:
                sallyPortMiss--;
                setText(R.id.matchCreate_sallyport_attempt_score, sallyPortMiss);
                break;
            case R.id.matchCreate_sallyport_attempt_add:
                sallyPortMiss++;
                setText(R.id.matchCreate_sallyport_attempt_score, sallyPortMiss);
                break;
            case R.id.matchCreate_sallyport_cross_sub:
                sallyPortHit--;
                setText(R.id.matchCreate_sallyport_cross_score, sallyPortHit);
                break;
            case R.id.matchCreate_sallyport_cross_add:
                sallyPortHit++;
                setText(R.id.matchCreate_sallyport_cross_score, sallyPortHit);
                break;
        }
    }

    public void setText(int id, int score) {
        ((TextView) rootView.findViewById(id)).setText(score + "");
    }

    public static void assignPre()
    {
        Model_Match model_match = helper.match_readTeam(Tab_Fragment_S.getMatchNum(), Tab_Fragment_S.getTeamNum());

        lowMiss = model_match.getTeleLowMiss();
        lowHit = model_match.getTeleLowHit();
        highMiss = model_match.getTeleHighMiss();
        highHit = model_match.getTeleHighHit();
        lowBarMiss = model_match.getTeleLowBarMiss();
        lowBarHit = model_match.getTeleLowBarHit();
        drawbridgeMiss = model_match.getTeleDrawbridgeMiss();
        drawbridgeHit = model_match.getTeleDrawbridgeHit();
        sallyPortMiss = model_match.getTeleSallyPortMiss();
        sallyPortHit = model_match.getTeleSallyPortHit();
    }

    public static void assignDefault()
    {
        lowMiss = 0;
        lowHit = 0;
        highMiss = 0;
        highHit = 0;
        lowBarMiss = 0;
        lowBarHit = 0;
        drawbridgeMiss = 0;
        drawbridgeHit = 0;
        sallyPortMiss = 0;
        sallyPortMiss = 0;
    }

    private void init() {
        low_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_low_goal_miss_sub);
        low_miss_sub.setOnClickListener(this);

        low_miss_add = (Button) rootView.findViewById(R.id.matchCreate_tele_low_goal_miss_add);
        low_miss_add.setOnClickListener(this);

        low_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_low_goal_hit_sub);
        low_hit_sub.setOnClickListener(this);

        low_hit_add = (Button) rootView.findViewById(R.id.matchCreate_tele_low_goal_hit_add);
        low_hit_add.setOnClickListener(this);

        high_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_high_goal_miss_sub);
        high_miss_sub.setOnClickListener(this);

        high_miss_add = (Button) rootView.findViewById(R.id.matchCreate_tele_high_goal_miss_add);
        high_miss_add.setOnClickListener(this);

        high_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_high_goal_hit_sub);
        high_hit_sub.setOnClickListener(this);

        high_hit_add = (Button) rootView.findViewById(R.id.matchCreate_tele_high_goal_hit_add);
        high_hit_add.setOnClickListener(this);

        lowBar_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_lowbar_attempt_sub);
        lowBar_miss_sub.setOnClickListener(this);

        lowBar_miss_add = (Button) rootView.findViewById(R.id.matchCreate_lowbar_attempt_add);
        lowBar_miss_add.setOnClickListener(this);

        lowBar_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_lowbar_cross_sub);
        lowBar_hit_sub.setOnClickListener(this);

        lowBar_hit_add = (Button) rootView.findViewById(R.id.matchCreate_lowbar_cross_add);
        lowBar_hit_add.setOnClickListener(this);

        drawbridge_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_drawbridge_attempt_sub);
        drawbridge_miss_sub.setOnClickListener(this);

        drawbridge_miss_add = (Button) rootView.findViewById(R.id.matchCreate_drawbridge_attempt_add);
        drawbridge_miss_add.setOnClickListener(this);

        drawbridge_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_drawbridge_cross_sub);
        drawbridge_hit_sub.setOnClickListener(this);

        drawbridge_hit_add = (Button) rootView.findViewById(R.id.matchCreate_drawbridge_cross_add);
        drawbridge_hit_add.setOnClickListener(this);

        sallyPort_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_sallyport_attempt_sub);
        sallyPort_miss_sub.setOnClickListener(this);

        sallyPort_miss_add = (Button) rootView.findViewById(R.id.matchCreate_sallyport_attempt_add);
        sallyPort_miss_add.setOnClickListener(this);

        sallyPort_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_sallyport_cross_sub);
        sallyPort_hit_sub.setOnClickListener(this);

        sallyPort_hit_add = (Button) rootView.findViewById(R.id.matchCreate_sallyport_cross_add);
        sallyPort_hit_add.setOnClickListener(this);

        assignDefault();
    }
}