package falconrobotics.scoutingprogram;
/*
mast rob
 */
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created on 2/7/2016.
 */
public class Fragment_Sync extends Fragment {
    private TextView switchStatus;
    private Switch mySwitch;
    private View rootView;
    private Button mButton;
    static final String ACTION = "Bluetooth socket is connected";
    private static final String TAG2 = "MessageListener thread";
    private final String TAG = "Server";
    private BluetoothAdapter btAdapter;
    private String socketString = "a random string";
    private BluetoothServerSocket btServerSocket;
    private BluetoothSocket btConnectedSocket;
    private boolean connected;
    private InputStream inStream;
    private OutputStream outStream;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//         rootView =  inflater.inflate(R.layout.layout_sync,container,false);

        rootView =  inflater.inflate(R.layout.layout_sync, null);

//        switchStatus = (TextView) rootView.findViewById(R.id.SeverSwitch);
//        mySwitch = (Switch) rootView.findViewById(R.id.SeverSwitch);
//        mButton = (Button) rootView.findViewById(R.id.buttonSyncPit);
//        mySwitch.setOnClickListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
//                if(isChecked)
//                {
//                    Server server = new Server();
//                    server.setPriority(Thread.MAX_PRIORITY);
//                    Log.d("Server", "Server Has Started");
//                    server.start();
//                }
//
//            }
//
////        });
//        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if(isChecked)
//                {
//                    Server server = new Server();
//                    server.setPriority(Thread.MAX_PRIORITY);
//                    Log.d("Server", "Server Has Started");
//                    server.start();
//                    switchStatus.setText("Server ON");
//                }
//                else
//                {
//                    switchStatus.setText("Server OFF");
//                }
//            }
//        });
//
//        mButton.setOnClickListener(new Button.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                if (mySwitch.isChecked()) {
//
//
//                } else {
//                    btAdapter = BluetoothAdapter.getDefaultAdapter();
//                    try {
//                        btServerSocket = btAdapter.listenUsingRfcommWithServiceRecord(socketString, MainActivity.BT_UUID);
//                        btConnectedSocket = btServerSocket.accept();
//
//                        outStream = btConnectedSocket.getOutputStream();
//                        inStream = btConnectedSocket.getInputStream();
////                        ArrayList<String> foundUpdates = SyncPitData.findPitRecords("2016", "SCMBSrv1",
////                                );
////                        outStream.write();
//                    } catch (IOException e) {
//                        Log.e("Exception", e.toString());
//                    }
//                }
//            }
//        });


        Button delete = (Button) rootView.findViewById(R.id.sync_delete_ALL);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper helper = new Helper();

                helper.doRestart(getActivity().getApplicationContext());
//                helper.resetData(new File(Helper.mainDirPath), true);
            }
        });

        return rootView;
    }
}
