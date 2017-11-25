

import java.io.*;
import java.net.Socket;

public class ClientSocketTask implements Runnable{
    /**
     * Created by PR on 07.11.2017. */
    private Socket connection;  //Create Socket
    /**
     * define the transport address (network address IP + Port number) */
    private int port = 1234; // initialize port number
    private String ip = "localhost"; // localhost ip address = 127.0.0.1
    /**
     * String variable to store the client request */
    public String clientRequest = "";
    public ClientSocketTask(String _clientRequest) {
        clientRequest = _clientRequest;
    }
    @Override
    public void run()  {
        try {
            /***
             *  Connect with server */
            connection = new Socket(ip, port); //Create a Client Socket for "localhost" address and port
            System.out.println("Connected! sending: ´" + clientRequest + "´ to server...\nINFO:" + connection);
            /***
             *  Setting up output stream */
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream())); //Create a Request Buffer
            wr.write(clientRequest); //write "Request" in the outputStream
            wr.write("\n");
            wr.flush(); //Send written content to server
            /***
             *  Setting up input stream */
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream())); //Create a Reply Buffer
            String requestString = rd.readLine(); //Read Server Reply
            System.out.println("Server replied: " + requestString); //Print the Server reply
            /***
             /* Close streams*/
            rd.close(); //close Request Buffer
            wr.close(); //close Reply Buffer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
