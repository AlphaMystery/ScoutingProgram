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
 * Created on 2/11/2016.
 */
public class Fragment_S_Auto extends Fragment implements View.OnClickListener{
    View rootView;

    private Button
            auto_high_miss_add,
            auto_high_miss_sub,
            auto_high_hit_add,
            auto_high_hit_sub,
            auto_low_miss_add,
            auto_low_miss_sub,
            auto_low_hit_add,
            auto_low_hit_sub,
            auto_lowbar_miss_sub,
            auto_lowbar_miss_add,
            auto_lowbar_hit_sub,
            auto_lowbar_hit_add,
            auto_c_miss_sub,
            auto_c_miss_add,
            auto_c_hit_sub,
            auto_c_hit_add;

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_s_auto, container, false);

        init();

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.matchCreate_auto_high_miss_add:
                Match_Model_Save.autoHighMiss++;
                setText(R.id.matchCreate_auto_high_miss_score, Match_Model_Save.autoHighMiss);
                break;
            case R.id.matchCreate_auto_high_miss_sub:
                Match_Model_Save.autoHighMiss--;
                setText(R.id.matchCreate_auto_high_miss_score, Match_Model_Save.autoHighMiss);
                break;
            case R.id.matchCreate_auto_high_hit_add:
                Match_Model_Save.autoHighHit++;
                setText(R.id.matchCreate_auto_high_hit_score, Match_Model_Save.autoHighHit);
                break;
            case R.id.matchCreate_auto_high_hit_sub:
                Match_Model_Save.autoHighHit--;
                setText(R.id.matchCreate_auto_high_hit_score, Match_Model_Save.autoHighHit);
                break;
            case R.id.matchCreate_auto_low_miss_add:
                Match_Model_Save.autoLowMiss++;
                setText(R.id.matchCreate_auto_low_miss_score, Match_Model_Save.autoLowMiss);
                break;
            case R.id.matchCreate_auto_low_miss_sub:
                Match_Model_Save.autoLowMiss--;
                setText(R.id.matchCreate_auto_low_miss_score, Match_Model_Save.autoLowMiss);
                break;
            case R.id.matchCreate_auto_low_hit_add:
                Match_Model_Save.autoLowHit++;
                setText(R.id.matchCreate_auto_low_hit_score, Match_Model_Save.autoLowHit);
                break;
            case R.id.matchCreate_auto_low_hit_sub:
                Match_Model_Save.autoLowHit--;
                setText(R.id.matchCreate_auto_low_hit_score, Match_Model_Save.autoLowHit);
                break;
            case R.id.matchCreate_auto_lowbar_miss_add:
                Match_Model_Save.autoLowBarMiss++;
                setText(R.id.matchCreate_auto_lowbar_miss_score, Match_Model_Save.autoLowBarMiss);
                break;
            case R.id.matchCreate_auto_lowbar_miss_sub:
                Match_Model_Save.autoLowBarMiss--;
                setText(R.id.matchCreate_auto_lowbar_miss_score, Match_Model_Save.autoLowBarMiss);
                break;
            case R.id.matchCreate_auto_lowbar_hit_add:
                Match_Model_Save.autoLowBarHit++;
                setText(R.id.matchCreate_auto_lowbar_hit_score, Match_Model_Save.autoLowBarHit);
                break;
            case R.id.matchCreate_auto_lowbar_hit_sub:
                Match_Model_Save.autoLowBarHit--;
                setText(R.id.matchCreate_auto_lowbar_hit_score, Match_Model_Save.autoLowBarHit);
                break;
            case R.id.matchCreate_auto_c_miss_add:
                Match_Model_Save.autoCMiss++;
                setText(R.id.matchCreate_auto_c_miss_score, Match_Model_Save.autoCMiss);
                break;
            case R.id.matchCreate_auto_c_miss_sub:
                Match_Model_Save.autoCMiss--;
                setText(R.id.matchCreate_auto_c_miss_score, Match_Model_Save.autoCMiss);
                break;
            case R.id.matchCreate_auto_c_hit_add:
                Match_Model_Save.autoCHit++;
                setText(R.id.matchCreate_auto_c_hit_score, Match_Model_Save.autoCHit);
                break;
            case R.id.matchCreate_auto_c_hit_sub:
                Match_Model_Save.autoCHit--;
                setText(R.id.matchCreate_auto_c_hit_score, Match_Model_Save.autoCHit);
                break;
        }
    }

    private void setText(int id, int score) {
        ((TextView) rootView.findViewById(id)).setText(score + "");
    }

    private void init() {
        auto_low_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_low_miss_sub);
        auto_low_miss_sub.setOnClickListener(this);

        auto_low_miss_add = (Button) rootView.findViewById(R.id.matchCreate_auto_low_miss_add);
        auto_low_miss_add.setOnClickListener(this);

        auto_low_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_low_hit_sub);
        auto_low_hit_sub.setOnClickListener(this);

        auto_low_hit_add = (Button) rootView.findViewById(R.id.matchCreate_auto_low_hit_add);
        auto_low_hit_add.setOnClickListener(this);

        auto_high_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_high_miss_sub);
        auto_high_miss_sub.setOnClickListener(this);

        auto_high_miss_add = (Button) rootView.findViewById(R.id.matchCreate_auto_high_miss_add);
        auto_high_miss_add.setOnClickListener(this);

        auto_high_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_high_hit_sub);
        auto_high_hit_sub.setOnClickListener(this);

        auto_high_hit_add = (Button) rootView.findViewById(R.id.matchCreate_auto_high_hit_add);
        auto_high_hit_add.setOnClickListener(this);

        auto_lowbar_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_lowbar_miss_sub);
        auto_lowbar_miss_sub.setOnClickListener(this);

        auto_lowbar_miss_add = (Button) rootView.findViewById(R.id.matchCreate_auto_lowbar_miss_add);
        auto_lowbar_miss_add.setOnClickListener(this);

        auto_lowbar_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_lowbar_hit_sub);
        auto_lowbar_hit_sub.setOnClickListener(this);

        auto_lowbar_hit_add = (Button) rootView.findViewById(R.id.matchCreate_auto_lowbar_hit_add);
        auto_lowbar_hit_add.setOnClickListener(this);

        auto_c_miss_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_c_miss_sub);
        auto_c_miss_sub.setOnClickListener(this);

        auto_c_miss_add = (Button) rootView.findViewById(R.id.matchCreate_auto_c_miss_add);
        auto_c_miss_add.setOnClickListener(this);

        auto_c_hit_sub = (Button) rootView.findViewById(R.id.matchCreate_auto_c_hit_sub);
        auto_c_hit_sub.setOnClickListener(this);

        auto_c_hit_add = (Button) rootView.findViewById(R.id.matchCreate_auto_c_hit_add);
        auto_c_hit_add.setOnClickListener(this);
    }
}