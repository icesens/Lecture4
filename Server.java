

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    /**
     * Server wait for client message and reply
     * Created by PR on 07.11.2017.*/
    private static Socket connection;  // Create Socket
    private static ServerSocket serverSocket;   // Create a Server Socket
    public static void main(String[] args) throws IOException {
        int port = 1234; // initialize port number
        serverSocket = new ServerSocket(port);// Start a new server socket
        while (true) {
            /***
             *  Connection with client */
            System.out.println("wait for connections");
            connection = serverSocket.accept(); // Wait and create new connection if a client request arrives
            ServerSocketTask serverTask = new ServerSocketTask(connection); // create a new socket task
            serverTask.run(); // Run Task
            /***
             /* Close socket */
            connection.close(); // close Socket connection
        }
    }
}
