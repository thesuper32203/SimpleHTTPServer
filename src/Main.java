import java.awt.desktop.SystemEventListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {
        final ServerSocket  sever = new ServerSocket(8080);

        System.out.println("Listening for connection on port 8080");
        while(true){
        final Socket client = sever.accept(); // blocking method blocks until a client connects to the server
            // 1. Read HTTP request from the client socket
            // 2. Prepare an HTTP response
            // 3. Send HTTP response to the client
            // 4. Close the socket
            InputStreamReader isr
                    = new InputStreamReader(client.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();
            try {
            while(!line.isEmpty()){

                    System.out.println(line);
                    line = reader.readLine();

            }
            } catch (NullPointerException e) {
                System.out.println("Read all lines");
            }


        }



    }
}