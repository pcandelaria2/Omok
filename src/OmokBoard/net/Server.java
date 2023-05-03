package OmokBoard.net;

import java.net.*;
import java.io.*;

public class Server {
    private ServerSocket server;
    private Socket socket;

    public Server(int port) {

        try {
            server = new ServerSocket(8000);
            while(true){
                System.out.println("Waiting to connect");
                socket = server.accept();
                System.out.println("Connected");
                new NetworkAdapter(socket).receiveMessages();

                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public int getSocketLocalPort() {
        return socket.getLocalPort();
    }

    public String getServer() {
        return String.valueOf(server.getInetAddress());
    }
}

