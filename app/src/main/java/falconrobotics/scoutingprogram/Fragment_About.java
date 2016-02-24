package falconrobotics.scoutingprogram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;

/**
 * Created by Francisco Martinez on 2/11/2016.
 * DESCRIPTION: This fragment intentionally left blank.
 */
public class Fragment_About extends Fragment{
    private static View rootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_about, null);
        return rootView;
    }

    private void setup()
    {
    }
}
