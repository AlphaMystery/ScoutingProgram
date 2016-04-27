package falconrobotics.scoutingprogram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
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

    private Button
            lowBar_miss_add,
            lowBar_miss_sub,
            lowBar_hit_add,
            lowBar_hit_sub,
            c_miss_add,
            c_miss_sub,
            c_hit_add,
            c_hit_sub,
            s1_miss_add,
            s1_miss_sub,
            s1_hit_add,
            s1_hit_sub,
            s2_miss_add,
            s2_miss_sub,
            s2_hit_add,
            s2_hit_sub,
            s3_miss_add,
            s3_miss_sub,
            s3_hit_add,
            s3_hit_sub,
            s4_miss_add,
            s4_miss_sub,
            s4_hit_add,
            s4_hit_sub,
            s5_miss_add,
            s5_miss_sub,
            s5_hit_add,
            s5_hit_sub,
            s6_miss_add,
            s6_miss_sub,
            s6_hit_add,
            s6_hit_sub;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_s_tele, container, false);

        init();

        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.matchCreate_tele_lowbar_miss_sub:
                Match_Model_Save.teleLowBarMiss--;
                setText(R.id.matchCreate_tele_lowbar_miss_score, Match_Model_Save.teleLowBarMiss);
                break;
            case R.id.matchCreate_tele_lowbar_miss_add:
                Match_Model_Save.teleLowBarMiss++;
                setText(R.id.matchCreate_tele_lowbar_miss_score, Match_Model_Save.teleLowBarMiss);
                break;
            case R.id.matchCreate_tele_lowbar_hit_sub:
                Match_Model_Save.teleLowBarHit--;
                setText(R.id.matchCreate_tele_lowbar_hit_score, Match_Model_Save.teleLowBarHit);
                break;
            case R.id.matchCreate_tele_lowbar_hit_add:
                Match_Model_Save.teleLowBarHit++;
                setText(R.id.matchCreate_tele_lowbar_hit_score, Match_Model_Save.teleLowBarHit);
                break;
            case R.id.matchCreate_tele_c_miss_sub:
                Match_Model_Save.teleCMiss--;
                setText(R.id.matchCreate_tele_c_miss_score, Match_Model_Save.teleCMiss);
                break;
            case R.id.matchCreate_tele_c_miss_add:
                Match_Model_Save.teleCMiss++;
                setText(R.id.matchCreate_tele_c_miss_score, Match_Model_Save.teleCMiss);
                break;
            case R.id.matchCreate_tele_c_hit_sub:
                Match_Model_Save.teleCHit--;
                setText(R.id.matchCreate_tele_c_hit_score, Match_Model_Save.teleCHit);
                break;
            case R.id.matchCreate_tele_c_hit_add:
                Match_Model_Save.teleCHit++;
                setText(R.id.matchCreate_tele_c_hit_score, Match_Model_Save.teleCHit);
                break;
            case R.id.matchCreate_tele_sector1_miss_sub:
                Match_Model_Save.teleSector1Miss--;
                setText(R.id.matchCreate_tele_sector1_miss_score, Match_Model_Save.teleSector1Miss);
                break;
            case R.id.matchCreate_tele_sector1_miss_add:
                Match_Model_Save.teleSector1Miss++;
                setText(R.id.matchCreate_tele_sector1_miss_score, Match_Model_Save.teleSector1Miss);
                break;
            case R.id.matchCreate_tele_sector1_hit_sub:
                Match_Model_Save.teleSector1Hit--;
                setText(R.id.matchCreate_tele_sector1_hit_score, Match_Model_Save.teleSector1Hit);
                break;
            case R.id.matchCreate_tele_sector1_hit_add:
                Match_Model_Save.teleSector1Hit++;
                setText(R.id.matchCreate_tele_sector1_hit_score, Match_Model_Save.teleSector1Hit);
                break;
            case R.id.matchCreate_tele_sector2_miss_sub:
                Match_Model_Save.teleSector2Miss--;
                setText(R.id.matchCreate_tele_sector2_miss_score, Match_Model_Save.teleSector2Miss);
                break;
            case R.id.matchCreate_tele_sector2_miss_add:
                Match_Model_Save.teleSector2Miss++;
                setText(R.id.matchCreate_tele_sector2_miss_score, Match_Model_Save.teleSector2Miss);
                break;
            case R.id.matchCreate_tele_sector2_hit_sub:
                Match_Model_Save.teleSector2Hit--;
                setText(R.id.matchCreate_tele_sector2_hit_score, Match_Model_Save.teleSector2Hit);
                break;
            case R.id.matchCreate_tele_sector2_hit_add:
                Match_Model_Save.teleSector2Hit++;
                setText(R.id.matchCreate_tele_sector2_hit_score, Match_Model_Save.teleSector2Hit);
                break;
            case R.id.matchCreate_tele_sector3_miss_sub:
                Match_Model_Save.teleSector3Miss--;
                setText(R.id.matchCreate_tele_sector3_miss_score, Match_Model_Save.teleSector3Miss);
                break;
            case R.id.matchCreate_tele_sector3_miss_add:
                Match_Model_Save.teleSector3Miss++;
                setText(R.id.matchCreate_tele_sector3_miss_score, Match_Model_Save.teleSector3Miss);
                break;
            case R.id.matchCreate_tele_sector3_hit_sub:
                Match_Model_Save.teleSector3Hit--;
                setText(R.id.matchCreate_tele_sector3_hit_score, Match_Model_Save.teleSector3Hit);
                break;
            case R.id.matchCreate_tele_sector3_hit_add:
                Match_Model_Save.teleSector3Hit++;
                setText(R.id.matchCreate_tele_sector3_hit_score, Match_Model_Save.teleSector3Hit);
                break;
            case R.id.matchCreate_tele_sector4_miss_sub:
                Match_Model_Save.teleSector4Miss--;
                setText(R.id.matchCreate_tele_sector4_miss_score, Match_Model_Save.teleSector4Miss);
                break;
            case R.id.matchCreate_tele_sector4_miss_add:
                Match_Model_Save.teleSector4Miss++;
                setText(R.id.matchCreate_tele_sector4_miss_score, Match_Model_Save.teleSector4Miss);
                break;
            case R.id.matchCreate_tele_sector4_hit_sub:
                Match_Model_Save.teleSector4Hit--;
                setText(R.id.matchCreate_tele_sector4_hit_score, Match_Model_Save.teleSector4Hit);
                break;
            case R.id.matchCreate_tele_sector4_hit_add:
                Match_Model_Save.teleSector4Hit++;
                setText(R.id.matchCreate_tele_sector4_hit_score, Match_Model_Save.teleSector4Hit);
                break;
            case R.id.matchCreate_tele_sector5_miss_sub:
                Match_Model_Save.teleSector5Miss--;
                setText(R.id.matchCreate_tele_sector5_miss_score, Match_Model_Save.teleSector5Miss);
                break;
            case R.id.matchCreate_tele_sector5_miss_add:
                Match_Model_Save.teleSector5Miss++;
                setText(R.id.matchCreate_tele_sector5_miss_score, Match_Model_Save.teleSector5Miss);
                break;
            case R.id.matchCreate_tele_sector5_hit_sub:
                Match_Model_Save.teleSector5Hit--;
                setText(R.id.matchCreate_tele_sector5_hit_score, Match_Model_Save.teleSector5Hit);
                break;
            case R.id.matchCreate_tele_sector5_hit_add:
                Match_Model_Save.teleSector5Hit++;
                setText(R.id.matchCreate_tele_sector5_hit_score, Match_Model_Save.teleSector5Hit);
                break;
            case R.id.matchCreate_tele_sector6_miss_sub:
                Match_Model_Save.teleSector6Miss--;
                setText(R.id.matchCreate_tele_sector6_miss_score, Match_Model_Save.teleSector6Miss);
                break;
            case R.id.matchCreate_tele_sector6_miss_add:
                Match_Model_Save.teleSector6Miss++;
                setText(R.id.matchCreate_tele_sector6_miss_score, Match_Model_Save.teleSector6Miss);
                break;
            case R.id.matchCreate_tele_sector6_hit_sub:
                Match_Model_Save.teleSector6Hit--;
                setText(R.id.matchCreate_tele_sector6_hit_score, Match_Model_Save.teleSector6Hit);
                break;
            case R.id.matchCreate_tele_sector6_hit_add:
                Match_Model_Save.teleSector6Hit++;
                setText(R.id.matchCreate_tele_sector6_hit_score, Match_Model_Save.teleSector6Hit);
                break;
        }
    }

    public void setText(int id, int score) {
        ((TextView) rootView.findViewById(id)).setText(score + "");
    }

    private void init() {
        lowBar_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_lowbar_miss_sub);
        lowBar_miss_sub.setOnClickListener(this);

        lowBar_miss_add = (Button) rootView.findViewById(R.id.matchCreate_tele_lowbar_miss_add);
        lowBar_miss_add.setOnClickListener(this);

        lowBar_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_lowbar_hit_sub);
        lowBar_hit_sub.setOnClickListener(this);

        lowBar_hit_add = (Button) rootView.findViewById(R.id.matchCreate_tele_lowbar_hit_add);
        lowBar_hit_add.setOnClickListener(this);

        c_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_c_miss_sub);
        c_miss_sub.setOnClickListener(this);

        c_miss_add = (Button) rootView.findViewById(R.id.matchCreate_tele_c_miss_add);
        c_miss_add.setOnClickListener(this);

        c_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_c_hit_sub);
        c_hit_sub.setOnClickListener(this);

        c_hit_add = (Button) rootView.findViewById(R.id.matchCreate_tele_c_hit_add);
        c_hit_add.setOnClickListener(this);
        
        s1_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_sector1_miss_sub);
        s1_miss_sub.setOnClickListener(this);

        s1_miss_add = (Button) rootView.findViewById(R.id.matchCreate_tele_sector1_miss_add);
        s1_miss_add.setOnClickListener(this);

        s1_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_sector1_hit_sub);
        s1_hit_sub.setOnClickListener(this);

        s1_hit_add = (Button) rootView.findViewById(R.id.matchCreate_tele_sector1_hit_add);
        s1_hit_add.setOnClickListener(this);

        s2_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_sector2_miss_sub);
        s2_miss_sub.setOnClickListener(this);

        s2_miss_add = (Button) rootView.findViewById(R.id.matchCreate_tele_sector2_miss_add);
        s2_miss_add.setOnClickListener(this);

        s2_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_sector2_hit_sub);
        s2_hit_sub.setOnClickListener(this);

        s2_hit_add = (Button) rootView.findViewById(R.id.matchCreate_tele_sector2_hit_add);
        s2_hit_add.setOnClickListener(this);

        s3_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_sector3_miss_sub);
        s3_miss_sub.setOnClickListener(this);

        s3_miss_add = (Button) rootView.findViewById(R.id.matchCreate_tele_sector3_miss_add);
        s3_miss_add.setOnClickListener(this);

        s3_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_sector3_hit_sub);
        s3_hit_sub.setOnClickListener(this);

        s3_hit_add = (Button) rootView.findViewById(R.id.matchCreate_tele_sector3_hit_add);
        s3_hit_add.setOnClickListener(this);

        s4_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_sector4_miss_sub);
        s4_miss_sub.setOnClickListener(this);

        s4_miss_add = (Button) rootView.findViewById(R.id.matchCreate_tele_sector4_miss_add);
        s4_miss_add.setOnClickListener(this);

        s4_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_sector4_hit_sub);
        s4_hit_sub.setOnClickListener(this);

        s4_hit_add = (Button) rootView.findViewById(R.id.matchCreate_tele_sector4_hit_add);
        s4_hit_add.setOnClickListener(this);

        s5_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_sector5_miss_sub);
        s5_miss_sub.setOnClickListener(this);

        s5_miss_add = (Button) rootView.findViewById(R.id.matchCreate_tele_sector5_miss_add);
        s5_miss_add.setOnClickListener(this);

        s5_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_sector5_hit_sub);
        s5_hit_sub.setOnClickListener(this);

        s5_hit_add = (Button) rootView.findViewById(R.id.matchCreate_tele_sector5_hit_add);
        s5_hit_add.setOnClickListener(this);

        s6_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_sector6_miss_sub);
        s6_miss_sub.setOnClickListener(this);

        s6_miss_add = (Button) rootView.findViewById(R.id.matchCreate_tele_sector6_miss_add);
        s6_miss_add.setOnClickListener(this);

        s6_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_tele_sector6_hit_sub);
        s6_hit_sub.setOnClickListener(this);

        s6_hit_add = (Button) rootView.findViewById(R.id.matchCreate_tele_sector6_hit_add);
        s6_hit_add.setOnClickListener(this);
    }
}