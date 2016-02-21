package falconrobotics.scoutingprogram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

/**
 * Created by Francisco Martinez on 2/7/2016.
 */
public class Tab_Fragment_S extends Fragment implements Dialog_Helper.NoticeDialogListener{

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 4;
    private DialogFragment dialogFragment = new DialogFragment();
    private static Spinner teamNumSpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View x =  inflater.inflate(R.layout.tab_layout_g,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs_g);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager_g);
        teamNumSpinner = (Spinner)x.findViewById(R.id.pre_match_spinner_team_number);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        dialogFragment = new Dialog_Helper(R.layout.prompt_layout_s);
        dialogFragment.show(Tab_Fragment_S.this.getFragmentManager(), "Pre-Match");

        return x;
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */
        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new Fragment_S_Auto();
                case 1 : return new Fragment_S_Tele_Off();
                case 2 : return new Fragment_S_Tele_Def();
                case 3 : return new Fragment_S_Post();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0:
                    return "Auto";
                case 1 :
                    return "Tele - Offensive";
                case 2:
                    return "Tele - Defensive";
                case 3 :
                    return "Post-Match";
            }
            return null;
        }
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
    }
}
