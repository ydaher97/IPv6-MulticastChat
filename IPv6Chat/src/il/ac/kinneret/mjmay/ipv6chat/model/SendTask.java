package il.ac.kinneret.mjmay.ipv6chat.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SendTask {
    /**
     * Send a message to the desired IP address and port
     * @param otherIP The IP address to send to
     * @param otherPort The port to send to
     * @param message The message to send
     * @throws IOException Thrown if the connection to the other side failed
     */
    public static void sendMessage(String otherIP, int otherPort, String message) throws IOException {

        Socket socket = new Socket(otherIP, otherPort);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(message);
        socket.close();
    }
}