

import java.io.*;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    /**
     * Created by PR on 07.11.2017.*/
    public static void main(String args[]) throws UnknownHostException, IOException {
        Scanner scanner = new Scanner(System.in); // Create scanner to allow keyboard input
        while(true) {
            System.out.print("INFO: Enter ´q´ to stop session\n");
            System.out.print("Enter message request to the server :   \n");
            String input = scanner.nextLine(); // Waiting for keyboard input
            if ("q".equals(input)) {
                System.out.println("Exit!"); // if keyboard input equal to ´q´ close client process
                break;
            }
            ClientSocketTask clientThread = new ClientSocketTask(input); // create a new socket task
            clientThread.run(); //Run Task
        }
    }
}
