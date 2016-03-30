//package falconrobotics.scoutingprogram;
//
//import android.bluetooth.BluetoothAdapter;
//import android.widget.ArrayAdapter;
//import android.widget.Toast;
//
///**
// * Created by Rodrigo on 3/11/2016.
// */
//
//
//
//public class BlueClient
//{
//
//    // Name of the connected device
//    private String mConnectedDeviceName = null;
//    // Array adapter for the conversation thread
//    private ArrayAdapter<String> mConversationArrayAdapter;
//    // String buffer for outgoing messages
//    private StringBuffer mOutStringBuffer;
//    // Local Bluetooth adapter
//    private BluetoothAdapter mBluetoothAdapter = null;
//    // Member object for the chat services
//    private BlueClient mChatService = null;
//
//    private static final String TAG = "BluetoothChat";
//    private static final boolean D = true;
//
//    // Message types sent from the BluetoothChatService Handler
//    public static final int MESSAGE_STATE_CHANGE = 1;
//    public static final int MESSAGE_READ = 2;
//    public static final int MESSAGE_WRITE = 3;
//    public static final int MESSAGE_DEVICE_NAME = 4;
//    public static final int MESSAGE_TOAST = 5;
//
//    // Key names received from the BluetoothChatService Handler
//    public static final String DEVICE_NAME = "device_name";
//    public static final String TOAST = "toast";
//
//    // Intent request codes
//    private static final int REQUEST_CONNECT_DEVICE_SECURE = 1;
//    private static final int REQUEST_CONNECT_DEVICE_INSECURE = 2;
//    private static final int REQUEST_ENABLE_BT = 3;
//
//
//    /**
//     * Sends a message.
//     * @param message  A string of text to send.
//     */
//    private void sendMessage(String message) {
//        // Check that we're actually connected before trying anything
//
//
//        // Check that there's actually something to send
//        if (message.length() > 0) {
//            // Get the message bytes and tell the BluetoothChatService to write
//            byte[] send = message.getBytes();
//            mChatService.write(send);
//
//            // Reset out string buffer to zero and clear the edit text field
//            mOutStringBuffer.setLength(0);
//            mOutEditText.setText(mOutStringBuffer);
//        }
//    }
//}
