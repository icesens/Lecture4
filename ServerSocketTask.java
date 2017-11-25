

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Socket;

public class ServerSocketTask implements Runnable{
    /**
     * Created by PR on 07.11.2017. */
    private Socket connection;  // Create Socket
    public ServerSocketTask(Socket s) {
        this.connection = s;
    }
    @Override
    public void run() {
        try {
            /***
             *  Setting up input stream */
            BufferedReader clientRequest = new BufferedReader(new InputStreamReader(connection.getInputStream())); //Create a Request Buffer
            String requestString = clientRequest.readLine(); //Read Client request, Convert it to String
            System.out.println("Client sent : " + requestString); //Print the client request
            try {
                Thread.sleep(requestString.length()*1000); // delay the thread. Time delay = size of request string in seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /***
             *  Setting up output stream */
            DataOutputStream serverReply = new DataOutputStream(connection.getOutputStream()); //Create a Reply Buffer
            serverReply.writeBytes("Reply : " + requestString); //write "Reply" in the outputStream
            serverReply.writeBytes("\n");
            serverReply.flush(); //Send written content to client
            /***
             /* Close streams*/
            serverReply.close(); //close Request Buffer
            clientRequest.close(); //close Reply Buffer

        } catch (IOException e) {
            e.printStackTrace();
        } }
}
