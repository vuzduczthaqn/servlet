package winT.Container;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class SimpWebContainer {
    private final int port;

    public SimpWebContainer(int port) {
        this.port = port;
    }

    private void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket socket = serverSocket.accept();
            Thread socketHandle = new SocketHandle(socket);
            socketHandle.start();
        }
    }

    public static void main(String[] args) throws IOException {
        SimpWebContainer simp = new SimpWebContainer(8888);
        simp.start();

    }
}
