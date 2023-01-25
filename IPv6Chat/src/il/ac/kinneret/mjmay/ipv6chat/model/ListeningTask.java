package il.ac.kinneret.mjmay.ipv6chat.model;

import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class ListeningTask  extends Task<Void> {
    private final ServerSocket socket;

    public ListeningTask(ServerSocket socket) {

        this.socket = socket;
    }

    @Override
    protected Void call() throws Exception {


        /// Sample code:
        // updateMessage(
        //     String.format("%02d:%02d:%02d (from %s): %s", Calendar.getInstance().get(Calendar.HOUR),
        //                   Calendar.getInstance().get(Calendar.MINUTE),
        //                   Calendar.getInstance().get(Calendar.SECOND), clientAddress, line + "\n"));
        //              }
        while (!isCancelled()) {
            Socket clientSocket = socket.accept();
            String clientAddress=clientSocket.getInetAddress().getHostAddress();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String line = in.readLine();
            while((line!=null)){
            // update the message property of the task to send the message back to the GUI thread
            updateMessage(
                    String.format("%02d:%02d:%02d (from %s): %s", Calendar.getInstance().get(Calendar.HOUR),
                            Calendar.getInstance().get(Calendar.MINUTE),
                            Calendar.getInstance().get(Calendar.SECOND), clientAddress, line + "\n"));
            line=null;
        }
        }
        return null;
    }
}

