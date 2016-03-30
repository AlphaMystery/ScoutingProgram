package falconrobotics.scoutingprogram;

import android.bluetooth.BluetoothSocket;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MessageManager extends Thread {


    private static final String TAG = "MessageListener thread";
    private BluetoothSocket btConnectedSocket;
    private InputStream inStream;
    private OutputStream outStream;
    //    private Activity parent;
    private boolean run = true;

    public MessageManager(BluetoothSocket btConnectedSocket) throws IOException {
        this.btConnectedSocket = btConnectedSocket;
//        this.parent = parent;
        inStream = btConnectedSocket.getInputStream();
        outStream = btConnectedSocket.getOutputStream();
    }

    // this method will listen continuously to messages received through the BT socket until you call cancel
    public void run() {
        byte[] buffer = new byte[1024];
        int bytes;

        while (run) {
            try {
                bytes = inStream.read(buffer);

            } catch (IOException ex) {
                Log.e(TAG, "error while reading from bt socket");

            }

//            parent.doStuffWithTheMessage(buffer); // pay attention: its in bytes. u need to convert it to a string

        }
    }

    /* Call this from the main activity to send data to the remote device */
    public void write(byte[] bytes) throws IOException {
        outStream.write(bytes);
    }

    /* Call this from the main activity to shutdown the connection */
    public void cancel() {
        run = false;
        try {
            btConnectedSocket.close();
        } catch (IOException e) {
        }

    }
}
