package falconrobotics.scoutingprogram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by
 *          Francisco Martinez
 *          >> <<
 *
 *          on 2/7/2016.
 * DESCRIPTION: This fragment displayes bluetooth layout and will enable the user to
 *              communicate to the centralized bluetooth running on the computer
 *              and sync the files between phones.
 */
public class Fragment_Bluetooth extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_bluetooth,null);
    }
}
