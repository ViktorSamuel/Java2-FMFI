package sockets;

import java.io.*;
import java.net.Socket;

class SocketClient {
    // číslo portu na ktorom počúva Socket Server
    private static final int serverPortNumber = 9876;

    // meno alebo IP adresa počítača na ktorom beží Socket Server
    private static final String serverHostName = "localhost";

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        for (int i = 0; i < 5; i++) {
            try (
                    // nadviaž spojenie so serverom
                    Socket socket = new Socket(serverHostName, serverPortNumber);

                    // PrintWriter pre zapisovanie správ na server
                    OutputStream socketOutputStream = socket.getOutputStream();
                    PrintWriter out = new PrintWriter(socketOutputStream, true);

                    // BufferedReader pri čítanie správ zo servera
                    InputStream socketInputStream = socket.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(socketInputStream);
                    BufferedReader in = new BufferedReader(inputStreamReader)
            ) {
                System.out.println("Sending request to Socket Server");
                out.println(i == 4 ? "exit" : "msg-nr-" + i);

                String message = in.readLine();
                System.out.println("Received response: " + message);
            }
            Thread.sleep(1000);
        }
    }
}
