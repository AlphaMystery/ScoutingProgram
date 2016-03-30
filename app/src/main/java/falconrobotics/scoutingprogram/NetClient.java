//package falconrobotics.scoutingprogram;
//
///**
// * Created by Rodrigo on 3/8/2016.
// */
//
//import android.util.Log;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class NetClient {
//
//    /**
//     * Maximum size of buffer
//     */
//    public static final int BUFFER_SIZE = 2048;
//    ObjectInputStream sInput;
//    ObjectOutputStream sOutput;
//    private Socket socket = null;
//    private PrintWriter out;
//    private BufferedReader in;
//    private String host;
//    private int port = 1545;
//
//
//    /**
//     * Constructor with Host, Port and MAC Address
//     *
//     * @param host
//     * @param //port
//     */
//    public NetClient(String host) {
//        this.host = host;
//    }
//
//    public void connectWithServer() {
//        try {
//            if (socket == null) {
//                this.socket = new Socket(host, port);
//                out = new PrintWriter(socket.getOutputStream());
//                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                this.sInput = new ObjectInputStream(this.socket.getInputStream());
//            }
//        } catch (IOException e) {
//            Log.e("Cant create con", e.toString());
//        }
//    }
//
//    public void disConnectWithServer() {
//        if (socket != null) {
//            if (socket.isConnected()) {
//                try {
//                    in.close();
//                    out.close();
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public void sendMessage(ChatMessage msg) {
//        try {
//            sOutput.writeObject(msg);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public String receiveDataFromServer() {
//        connectWithServer();
//        try {
//            String message = "";
//            int charsRead;
//            char[] buffer = new char[BUFFER_SIZE];
//
//            while ((charsRead = in.read(buffer)) != -1) {
//                message += new String(buffer).substring(0, charsRead);
//            }
//
//            disConnectWithServer(); // disconnect server
//            return message;
//        } catch (IOException e) {
//            return "Error receiving response:  " + e.getMessage();
//        }
//    }
//
//
//}
