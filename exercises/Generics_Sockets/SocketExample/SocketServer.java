package sockets;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

class SocketServer {
    // číslo portu na ktorom počúva Socket Server
    private static final int port = 9876;

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        // vytvor SocketServer objekt, ktorý bude akceptovať nové spojenia
        ServerSocket serverSocket = new ServerSocket(port);

        String message;
        do {
            System.out.println("Waiting for client request");

            try (
                    // čakaj na spojenie a potom preň vytvor socket
                    Socket socket = serverSocket.accept();

                    // stream pre čítanie zo socketu
                    InputStream socketInputStream = socket.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(socketInputStream);
                    BufferedReader in = new BufferedReader(inputStreamReader);

                    // stream pre zapisovanie do socketu
                    OutputStream socketOutputStream = socket.getOutputStream();
                    PrintWriter out = new PrintWriter(socketOutputStream, true);
            ) {
                message = in.readLine();
                System.out.println("Received message: " + message);

                out.println("Echo: " + message);
            }

            // ukonči server keď prijímeš exit
        } while (!message.equalsIgnoreCase("exit"));

        System.out.println("Shutting down Socket Server!");

        serverSocket.close();
    }
}
