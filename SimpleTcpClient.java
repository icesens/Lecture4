import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SimpleTcpClient {
    public static void main(String[] args) throws IOException {

       Socket connection1 = new Socket("127.0.0.1", 1);

        for(int i = 0; i<500; i++) {
            new Socket("127.0.0.1", 1);
        }
         InputStream Stream = connection1.getInputStream();
         Stream.read();
    }
}
