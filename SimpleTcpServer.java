import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleTcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1);
        while(true) {
            Socket connection = server.accept();
        }
    }
}
