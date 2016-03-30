//package falconrobotics.scoutingprogram;
//
//import java.io.Serializable;
//
///**
// * This is fundamentally based off a Java chat client / server example found on the net at http://www.dreamincode.net/forums/topic/259777-a-simple-chat-program-with-clientserver-gui-optional/
// * <p/>
// * The purpose is to build a framework for making our own sync protocol in the Falcon Robotics scouting app and server.  Instead of blindly sending & receiving all data we want to make a very
// * simple protocol that allows the client to drive the sync action.  The server can still bail at any time for any reason if it needs to.
// * <p/>
// * This class defines the different type of messages that will be exchanged between the Clients and the Server.
// * When talking from a Java Client to a Java Server a lot easier to pass Java objects, no
// * need to count bytes or to wait for a line feed at the end of the frame
// */
//public class ChatMessage implements Serializable {
//
//    protected static final long serialVersionUID = 1112122200L;
//
//    // The different types of message sent by the Client
//    // WHOISIN to receive the list of the users connected
//    // MESSAGE an ordinary message
//    // LOGOUT to disconnect from the Server
//    static final int WHOISIN = 0, MESSAGE = 1, LOGOUT = 2;
//
//    private int type;
//
//    private String message;
//
//    /**
//     * Constructor
//     *
//     * @param type    - The type of message the client wants to send (WHOISIN, MESSAGE or LOGOUT)
//     * @param message - The actual message to send
//     */
//    ChatMessage(int type, String message) {
//        this.type = type;
//        this.message = message;
//    }
//
//    // Typical getters to access class private data
//
//    int getType() {
//        return type;
//    }
//
//    String getMessage() {
//        return message;
//    }
//}
