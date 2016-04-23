//package falconrobotics.scoutingprogram;
//
//import android.bluetooth.BluetoothAdapter;
//import android.bluetooth.BluetoothServerSocket;
//import android.bluetooth.BluetoothSocket;
//import android.content.Intent;
//import android.util.Log;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import falconrobotics.scoutingprogram.SyncPitData.*;
//
//public class Server extends Thread {
//
//
//    /*package-protected*/
//    static final String ACTION = "Bluetooth socket is connected";
//    private static final String TAG2 = "MessageListener thread";
//    private final String TAG = "Server";
//    private BluetoothAdapter btAdapter;
//    private String socketString = "a random string";
//    private BluetoothServerSocket btServerSocket;
//    private BluetoothSocket btConnectedSocket;
//    private boolean connected;
//    private InputStream inStream;
//    private OutputStream outStream;
//
//    public Server()
//    {
//        connected = false;
//    }
//
//    @Override
//    public void run() {
//        btAdapter = BluetoothAdapter.getDefaultAdapter();
//
//        try {
//            Log.i(TAG, "getting socket from adapter");
//            btServerSocket = btAdapter.listenUsingRfcommWithServiceRecord(socketString, MainActivity.BT_UUID);
//            listen();
//
//        } catch (IOException ex) {
//            Log.e(TAG, "error while initializing");
//
//
//        }
//
//    }
//
//    private void listen() {
//        Log.i(TAG, "listening");
//        btConnectedSocket = null;
//        while (!connected) {
//            try {
//                btConnectedSocket = btServerSocket.accept();
//                inStream = btConnectedSocket.getInputStream();
//                outStream = btConnectedSocket.getOutputStream();
//
//                Log.v(TAG, "connected and listening");
//
//                byte[] buffer = new byte[1024];
//                int bytes;
//                Log.d(TAG2,"About to send msg");
//
//
//                while (true) {
//                    try {
//                        bytes = inStream.read(buffer);
//
//
//
//                    } catch (IOException ex) {
//                        Log.e(TAG, "error while reading from bt socket");
//
//                    }
//
//
//                    SyncPitData.updatePitRecord("2016", "SCMBSrv1", new String(buffer));
//                    Log.d(TAG2,"Message Sent");
//
//
//
//
//
////            parent.doStuffWithTheMessage(buffer); // pay attention: its in bytes. u need to convert it to a string
//
//                }
//            } catch (IOException ex) {
//                Log.e(TAG, "connection failed");
//                connectionFailed();
//
//            }
//            if (btConnectedSocket != null) {
//                broadcast();
//                closeServerSocket();
//            } else {
//                Log.i(TAG, "socket is null");
//                connectionFailed();
//            }
//        }
//
//    }
//
//    private void broadcast() {
//        try {
//
//            Intent intent = new Intent();
//            intent.setAction(ACTION);
////            parent.sendBroadcast(intent);
//            connected = true;
//        } catch (RuntimeException runTimeEx) {
//            Log.e("RunTimeException",runTimeEx.toString());
//
//        }
//
//        closeServerSocket();
//    }
//
//
//    private void connectionFailed() {
//
//    }
//
//    public void closeServerSocket() {
//        try {
//            btServerSocket.close();
//        } catch (IOException ex) {
//            Log.e(TAG + ":cancel", "error while closing server socket");
//        }
//    }
//}