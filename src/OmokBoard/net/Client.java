package OmokBoard.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket;
    String host;
    int port;
    public Client() throws IOException {
        try {
            socket = new Socket("opuntia.cs.utep.edu",8000);
            //socket = new Socket("localhost",8000);
            host = String.valueOf(socket.getInetAddress());
            port = socket.getLocalPort();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //we do stuff here for the game
        close();
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public void close(){
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
