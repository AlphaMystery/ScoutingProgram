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

    private Helper helper;

    private Model_Match model;

    private static int teamNum, matchNum;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        helper = new Helper();


        rootView = inflater.inflate(R.layout.tab_layout_g, container, false);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs_g);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager_g);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        dialog(container);

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return rootView;
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

    private void dialog(ViewGroup container)
    {

        LayoutInflater li = LayoutInflater.from(rootView.getContext());
        View promptsView = li.inflate(R.layout.prompt_layout_s, container, false);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(rootView.getContext());
        alertDialogBuilder.setView(promptsView);

        teamNumInput = (EditText) promptsView.findViewById(R.id.prematch_teamNum);
        matchNumInput = (EditText) promptsView.findViewById(R.id.prematch_matchNum);
        matchLevelInput = (Spinner) promptsView.findViewById(R.id.prematch_level);
        matchLevelInput.setAdapter(new ArrayAdapter<>(
                rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(Interface_Spinners.MatchLevel)));

        viewPager.setOffscreenPageLimit(2);

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("SUBMIT",
                        new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {
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
                                    matchNum = Integer.parseInt(matchNumInput.getText().toString()) + (matchLevelInput.getSelectedItem().equals(1) ? 1000 : 2000);

                                    if(!helper.matchDataCheck(teamNum, matchNum)){
                                        Model_Match model_match = helper.match_readTeam(matchNum,teamNum);

                                        Match_Model_Save._id = model_match.get_id();
                                        Match_Model_Save.teamNum = model_match.getTeamNum();
                                        Match_Model_Save.autoLowMiss = model_match.getAutoLowMiss();
                                        Match_Model_Save.autoLowHit = model_match.getAutoLowHit();
                                        Match_Model_Save.autoHighMiss = model_match.getAutoHighMiss();
                                        Match_Model_Save.autoHighHit = model_match.getAutoHighHit();
                                        Match_Model_Save.autoLowBarMiss = model_match.getAutoLowBarMiss();
                                        Match_Model_Save.autoLowBarHit = model_match.getAutoLowBarHit();
                                        Match_Model_Save.autoCMiss = model_match.getAutoCMiss();
                                        Match_Model_Save.autoCHit = model_match.getAutoCHit();
                                        Match_Model_Save.teleSector1Miss = model_match.getTeleSector1Miss();
                                        Match_Model_Save.teleSector1Hit = model_match.getTeleSector1Hit();
                                        Match_Model_Save.teleSector2Miss = model_match.getTeleSector2Miss();
                                        Match_Model_Save.teleSector2Hit = model_match.getTeleSector2Hit();
                                        Match_Model_Save.teleSector3Miss = model_match.getTeleSector3Miss();
                                        Match_Model_Save.teleSector3Hit = model_match.getTeleSector3Hit();
                                        Match_Model_Save.teleSector4Miss = model_match.getTeleSector4Miss();
                                        Match_Model_Save.teleSector4Hit = model_match.getTeleSector4Hit();
                                        Match_Model_Save.teleSector5Miss = model_match.getTeleSector5Miss();
                                        Match_Model_Save.teleSector5Hit = model_match.getTeleSector5Hit();
                                        Match_Model_Save.teleSector6Miss = model_match.getTeleSector6Miss();
                                        Match_Model_Save.teleSector6Hit = model_match.getTeleSector6Hit();
                                        Match_Model_Save.postClimb = model_match.getPostClimb();
                                        Match_Model_Save.postComments = model_match.getPostComments();
                                    }
                                }
                            }
                        })
                .setNegativeButton("CANCEL",
                        new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                Fragment fragment = new Fragment_Sync();

                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.containerView, fragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                        });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
