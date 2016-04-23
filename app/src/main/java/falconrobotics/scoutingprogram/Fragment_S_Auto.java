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
 * Created on 2/11/2016.
 */
public class Fragment_S_Auto extends Fragment implements View.OnClickListener{
    View rootView;
    private static int
            auto_lowMiss = 0,
            auto_lowHit = 0,
            auto_highMiss = 0,
            auto_highHit = 0,
            auto_def1Miss = 0,
            auto_def1Hit = 0,
            auto_def2Miss = 0,
            auto_def2Hit = 0,
            auto_def3Miss = 0,
            auto_def3Hit = 0,
            auto_def4Miss = 0,
            auto_def4Hit = 0,
            auto_def5Miss = 0,
            auto_def5Hit = 0;

    private Button
            auto_high_miss_add,
            auto_high_miss_sub,
            auto_high_hit_add,
            auto_high_hit_sub,
            auto_low_miss_add,
            auto_low_miss_sub,
            auto_low_hit_add,
            auto_low_hit_sub,
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

    private static Helper helper;

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_s_auto, null);
        helper = new Helper();

        init();

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.matchCreate_auto_auto_high_goal_miss_add:
                auto_highMiss++;
                setText(R.id.matchCreate_auto_auto_high_goal_miss_score, auto_highMiss);
                break;
            case R.id.matchCreate_auto_auto_high_goal_miss_sub:
                auto_highMiss--;
                setText(R.id.matchCreate_auto_auto_high_goal_miss_score, auto_highMiss);
                break;
            case R.id.matchCreate_auto_auto_high_goal_hit_add:
                auto_highHit++;
                setText(R.id.matchCreate_auto_auto_high_goal_hit_score, auto_highHit);
                break;
            case R.id.matchCreate_auto_auto_high_goal_hit_sub:
                auto_highHit--;
                setText(R.id.matchCreate_auto_auto_high_goal_hit_score, auto_highHit);
                break;
            case R.id.matchCreate_auto_auto_low_goal_miss_add:
                auto_lowMiss++;
                setText(R.id.matchCreate_auto_auto_low_goal_miss_score, auto_lowMiss);
                break;
            case R.id.matchCreate_auto_auto_low_goal_miss_sub:
                auto_lowMiss--;
                setText(R.id.matchCreate_auto_auto_low_goal_miss_score, auto_lowMiss);
                break;
            case R.id.matchCreate_auto_auto_low_goal_hit_add:
                auto_lowHit++;
                setText(R.id.matchCreate_auto_auto_low_goal_hit_score, auto_lowHit);
                break;
            case R.id.matchCreate_auto_auto_low_goal_hit_sub:
                auto_lowHit--;
                setText(R.id.matchCreate_auto_auto_low_goal_hit_score, auto_lowHit);
                break;
            case R.id.matchCreate_auto_autodef1_attempt_add:
                auto_def1Miss++;
                setText( R.id.matchCreate_auto_autodef1_attempt_score, auto_def1Miss);
                break;
            case R.id.matchCreate_auto_autodef1_attempt_sub:
                auto_def1Miss--;
                setText(R.id.matchCreate_auto_autodef1_attempt_score, auto_def1Miss);
                break;
            case R.id.matchCreate_auto_autodef1_cross_add:
                auto_def1Hit++;
                setText(R.id.matchCreate_auto_autodef1_cross_score, auto_def1Hit);
                break;
            case R.id.matchCreate_auto_autodef1_cross_sub:
                auto_def1Hit--;
                setText(R.id.matchCreate_auto_autodef1_cross_score, auto_def1Hit);
                break;
            case R.id.matchCreate_auto_autodef2_attempt_add:
                auto_def2Miss++;
                setText( R.id.matchCreate_auto_autodef2_attempt_score, auto_def2Miss);
                break;
            case R.id.matchCreate_auto_autodef2_attempt_sub:
                auto_def2Miss--;
                setText(R.id.matchCreate_auto_autodef2_attempt_score, auto_def2Miss);
                break;
            case R.id.matchCreate_auto_autodef2_cross_add:
                auto_def2Hit++;
                setText(R.id.matchCreate_auto_autodef2_cross_score, auto_def2Hit);
                break;
            case R.id.matchCreate_auto_autodef2_cross_sub:
                auto_def2Hit--;
                setText(R.id.matchCreate_auto_autodef2_cross_score, auto_def2Hit);
                break;
            case R.id.matchCreate_auto_autodef3_attempt_add:
                auto_def3Miss++;
                setText( R.id.matchCreate_auto_autodef3_attempt_score, auto_def3Miss);
                break;
            case R.id.matchCreate_auto_autodef3_attempt_sub:
                auto_def3Miss--;
                setText(R.id.matchCreate_auto_autodef3_attempt_score, auto_def3Miss);
                break;
            case R.id.matchCreate_auto_autodef3_cross_add:
                auto_def3Hit++;
                setText(R.id.matchCreate_auto_autodef3_cross_score, auto_def3Hit);
                break;
            case R.id.matchCreate_auto_autodef3_cross_sub:
                auto_def3Hit--;
                setText(R.id.matchCreate_auto_autodef3_cross_score, auto_def3Hit);
                break;
            case R.id.matchCreate_auto_autodef4_attempt_add:
                auto_def4Miss++;
                setText( R.id.matchCreate_auto_autodef4_attempt_score, auto_def4Miss);
                break;
            case R.id.matchCreate_auto_autodef4_attempt_sub:
                auto_def4Miss--;
                setText(R.id.matchCreate_auto_autodef4_attempt_score, auto_def4Miss);
                break;
            case R.id.matchCreate_auto_autodef4_cross_add:
                auto_def4Hit++;
                setText(R.id.matchCreate_auto_autodef4_cross_score, auto_def4Hit);
                break;
            case R.id.matchCreate_auto_autodef4_cross_sub:
                auto_def4Hit--;
                setText(R.id.matchCreate_auto_autodef4_cross_score, auto_def4Hit);
                break;
            case R.id.matchCreate_auto_autodef5_attempt_add:
                auto_def5Miss++;
                setText( R.id.matchCreate_auto_autodef5_attempt_score, auto_def5Miss);
                break;
            case R.id.matchCreate_auto_autodef5_attempt_sub:
                auto_def5Miss--;
                setText(R.id.matchCreate_auto_autodef5_attempt_score, auto_def5Miss);
                break;
            case R.id.matchCreate_auto_autodef5_cross_add:
                auto_def5Hit++;
                setText(R.id.matchCreate_auto_autodef5_cross_score, auto_def5Hit);
                break;
            case R.id.matchCreate_auto_autodef5_cross_sub:
                auto_def5Hit--;
                setText(R.id.matchCreate_auto_autodef5_cross_score, auto_def5Hit);
                break;
        }
    }

    private void setText(int id, int score) {
        ((TextView) rootView.findViewById(id)).setText(score + "");
    }

    public static void assignPre()
    {
        Model_Match model_match = helper.match_readTeam(Tab_Fragment_S.getMatchNum(), Tab_Fragment_S.getTeamNum());

        auto_lowMiss = model_match.getAutoLowMiss();
        auto_lowHit = model_match.getAutoLowHit();
        auto_highMiss = model_match.getAutoHighMiss();
        auto_highHit = model_match.getAutoHighHit();
        auto_def1Miss = model_match.getAutoDef1Miss();
        auto_def1Hit = model_match.getAutoDef1Hit();
        auto_def2Miss = model_match.getAutoDef2Miss();
        auto_def2Hit = model_match.getAutoDef2Hit();
        auto_def3Miss = model_match.getAutoDef3Miss();
        auto_def3Hit = model_match.getAutoDef3Hit();
        auto_def4Miss = model_match.getAutoDef4Miss();
        auto_def4Hit = model_match.getAutoDef4Hit();
        auto_def5Miss = model_match.getAutoDef5Miss();
        auto_def5Hit = model_match.getAutoDef5Hit();
    }

    public static void assignDefault()
    {
        auto_lowMiss  = 0;
        auto_lowHit  = 0;
        auto_highMiss  = 0;
        auto_highHit  = 0;
        auto_def1Miss  = 0;
        auto_def1Hit  = 0;
        auto_def2Miss  = 0;
        auto_def2Hit  = 0;
        auto_def3Miss  = 0;
        auto_def3Hit  = 0;
        auto_def4Miss  = 0;
        auto_def4Hit  = 0;
        auto_def5Miss  = 0;
        auto_def5Hit  = 0;
    }

    private void init() {
        auto_low_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_auto_low_goal_miss_sub);
        auto_low_miss_sub.setOnClickListener(this);

        auto_low_miss_add = (Button) rootView.findViewById(R.id.matchCreate_auto_auto_low_goal_miss_add);
        auto_low_miss_add.setOnClickListener(this);

        auto_low_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_auto_low_goal_hit_sub);
        auto_low_hit_sub.setOnClickListener(this);

        auto_low_hit_add = (Button) rootView.findViewById(R.id.matchCreate_auto_auto_low_goal_hit_add);
        auto_low_hit_add.setOnClickListener(this);

        auto_high_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_auto_high_goal_miss_sub);
        auto_high_miss_sub.setOnClickListener(this);

        auto_high_miss_add = (Button) rootView.findViewById(R.id.matchCreate_auto_auto_high_goal_miss_add);
        auto_high_miss_add.setOnClickListener(this);

        auto_high_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_auto_high_goal_hit_sub);
        auto_high_hit_sub.setOnClickListener(this);

        auto_high_hit_add = (Button) rootView.findViewById(R.id.matchCreate_auto_auto_high_goal_hit_add);
        auto_high_hit_add.setOnClickListener(this);

        auto_def1_miss_add = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef1_attempt_add);
        auto_def1_miss_add.setOnClickListener(this);

        auto_def1_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef1_attempt_sub);
        auto_def1_miss_sub.setOnClickListener(this);

        auto_def1_hit_add = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef1_cross_add);
        auto_def1_hit_add.setOnClickListener(this);

        auto_def1_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef1_cross_sub);
        auto_def1_hit_sub.setOnClickListener(this);

        auto_def2_miss_add = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef2_attempt_add);
        auto_def2_miss_add.setOnClickListener(this);

        auto_def2_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef2_attempt_sub);
        auto_def2_miss_sub.setOnClickListener(this);

        auto_def2_hit_add = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef2_cross_add);
        auto_def2_hit_add.setOnClickListener(this);

        auto_def2_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef2_cross_sub);
        auto_def2_hit_sub.setOnClickListener(this);

        auto_def3_miss_add = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef3_attempt_add);
        auto_def3_miss_add.setOnClickListener(this);

        auto_def3_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef3_attempt_sub);
        auto_def3_miss_sub.setOnClickListener(this);

        auto_def3_hit_add = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef3_cross_add);
        auto_def3_hit_add.setOnClickListener(this);

        auto_def3_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef3_cross_sub);
        auto_def3_hit_sub.setOnClickListener(this);

        auto_def4_miss_add = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef4_attempt_add);
        auto_def4_miss_add.setOnClickListener(this);

        auto_def4_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef4_attempt_sub);
        auto_def4_miss_sub.setOnClickListener(this);

        auto_def4_hit_add = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef4_cross_add);
        auto_def4_hit_add.setOnClickListener(this);

        auto_def4_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef4_cross_sub);
        auto_def4_hit_sub.setOnClickListener(this);

        auto_def5_miss_add = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef5_attempt_add);
        auto_def5_miss_add.setOnClickListener(this);

        auto_def5_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef5_attempt_sub);
        auto_def5_miss_sub.setOnClickListener(this);

        auto_def5_hit_add = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef5_cross_add);
        auto_def5_hit_add.setOnClickListener(this);

        auto_def5_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_autodef5_cross_sub);
        auto_def5_hit_sub.setOnClickListener(this);

        assignDefault();
    }

    public void update(Model_Match model)
    {
//        model.set
    }

}