package falconrobotics.scoutingprogram;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

/**
 * Created on 2/7/2016.
 */
public class Tab_Fragment_S extends Fragment {

    private static TabLayout tabLayout;
    private static ViewPager viewPager;
    private static int int_items = 3;
    private static View rootView;

    private static EditText teamNumInput, matchNumInput;
    private static Spinner matchLevelInput;

    private Model_Match model;

    private Helper helper;



    private static int teamNum, matchNum;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        helper = new Helper();
    /*
    Checks if there's a schedule available
     */
//        if(Interface_Spinners.Matches.size() < 1){
//            Toast.makeText(MainActivity.context, "Woops! No schedule found! Please sync with main device or pull the data from FIRST.", Toast.LENGTH_LONG).show();
//
//            Fragment fragment = new Fragment_Sync();
//
//            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.replace(R.id.containerView, fragment);
//            fragmentTransaction.addToBackStack(null);
//            fragmentTransaction.commit();
//        }else
        {

            rootView = inflater.inflate(R.layout.tab_layout_g, null);
            tabLayout = (TabLayout) rootView.findViewById(R.id.tabs_g);
            viewPager = (ViewPager) rootView.findViewById(R.id.viewpager_g);

            viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

            tabLayout.post(new Runnable() {
                @Override
                public void run() {
                    tabLayout.setupWithViewPager(viewPager);
                }
            });


            LayoutInflater li = LayoutInflater.from(rootView.getContext());
            View promptsView = li.inflate(R.layout.prompt_layout_s, null);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(rootView.getContext());
            alertDialogBuilder.setView(promptsView);

            teamNumInput = (EditText) promptsView.findViewById(R.id.prematch_teamNum);
            matchNumInput = (EditText) promptsView.findViewById(R.id.prematch_matchNum);
            matchLevelInput = (Spinner) promptsView.findViewById(R.id.prematch_level);
            matchLevelInput.setAdapter(new ArrayAdapter<>(
                    rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.MatchLevel)));

//            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//                @Override
//                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                }
//
//                @Override
//                public void onPageSelected(int position) {
//                    update();
//                }
//
//                @Override
//                public void onPageScrollStateChanged(int state) {
//
//                }
//            });

            viewPager.setOffscreenPageLimit(2);

            // set dialog message
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("SUBMIT",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    if(teamNumInput.getText().toString().matches("") || matchNumInput.getText().toString().matches(""))
                                    {
                                        if(teamNumInput.getText().toString().matches(""))Toast.makeText(MainActivity.context, "Woops! Please enter a valid team number!", Toast.LENGTH_LONG).show();
                                        else Toast.makeText(MainActivity.context, "Woops! Please enter a valid match number!", Toast.LENGTH_LONG).show();

                                        Fragment fragment = new Tab_Fragment_S();

                                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                        fragmentTransaction.replace(R.id.containerView, fragment);
                                        fragmentTransaction.addToBackStack(null);
                                        fragmentTransaction.commit();
                                    }
                                    else
                                    {
                                        teamNum = Integer.parseInt(teamNumInput.getText().toString());
                                        matchNum = Integer.parseInt(matchNumInput.getText().toString() + (matchLevelInput.getSelectedItem().equals(0) ? 1000 : 2000));

                                        if(helper.matchDataCheck(Integer.parseInt(teamNumInput.getText().toString()), Integer.parseInt(matchNumInput.getText().toString() + (matchLevelInput.getSelectedItem().equals(0) ? 1000 : 2000)))){
                                            Fragment_S_Auto.assignPre();
                                            Fragment_S_Tele.assignPre();
                                            Fragment_S_Post.assignPre();
                                        }
                                    }
// else{
//                                    Toast.makeText(MainActivity.context, "Woops! Please enter a number on the roster!", Toast.LENGTH_LONG).show();
//
//                                    Fragment fragment = new Tab_Fragment_S();
//
//                                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                                    fragmentTransaction.replace(R.id.containerView, fragment);
//                                    fragmentTransaction.addToBackStack(null);
//                                    fragmentTransaction.commit();
//                                }


                                }
                            })
                    .setNegativeButton("CANCEL",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Fragment fragment = new Fragment_Sync();

                                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                    fragmentTransaction.replace(R.id.containerView, fragment);
                                    fragmentTransaction.addToBackStack(null);
                                    fragmentTransaction.commit();
                                }
                            });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            // show it
            alertDialog.show();


            return rootView;}
//        return null;
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment_S_Auto();
                case 1:
                    return new Fragment_S_Tele();
                case 2:
                    return new Fragment_S_Post();
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

            switch (position) {
                case 0:
                    return "Auto";
                case 1:
                    return "Tele";
                case 2:
                    return "Post";
            }
            return null;
        }
    }

    public static int getTeamNum() {
        return teamNum;
    }

    public static int getMatchNum() {
        return matchNum;
    }

    private void update()
    {
//        Fragment_S_Auto auto = new Fragment_S_Auto();
//
//        model = auto.update(model);
//        update(model);
//        update(model);
//
//        helper.match_update(MainActivity.insertOrReplace, model);
    }
}
