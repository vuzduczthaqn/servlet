package winT.Container;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class SocketHandle extends Thread{
    private Socket socket;
    public SocketHandle(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        BufferedReader in=null;
        PrintWriter out=null;
        try {
            in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = in.readLine();
            //readLine sẽ đọc theo con trỏ sau mỗi lần đọc con trỏ sẽ trỏ vào dòng kế tiếp

            while (!line.isEmpty()) {
                System.out.println(line);
                line = in.readLine();
            }

            out = new PrintWriter(socket.getOutputStream());
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type : text/html");
            out.println();
            out.println("<html><body> Current time : ");
            out.println(LocalDateTime.now());
            out.println("</body></html>");
            out.flush();
        }catch (Exception e) {

        }finally {
            try {
                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
