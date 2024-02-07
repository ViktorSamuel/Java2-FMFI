package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class SocketProtocol {
    // Do you see the Strategy pattern here?
    private int patience = 5;
    public String processInput(String input) {
        if (patience-- >0) return input;
        else return "Bye.\n";
    }
}

class ServerThread extends Thread {
    private final Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                // stream pre čítanie zo socketu
                InputStream socketInputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(socketInputStream);
                BufferedReader in = new BufferedReader(inputStreamReader);

                // stream pre zapisovanie do socketu
                OutputStream socketOutputStream = socket.getOutputStream();
                PrintWriter out = new PrintWriter(socketOutputStream, true);

        ) {
            String inputLine, outputLine;
            SocketProtocol socketProtocol = new SocketProtocol();

            outputLine = socketProtocol.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = socketProtocol.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye.\n")) break;
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MultiServer {
    private final int port = 12345;
    public MultiServer() {}
    public void start() {
        System.out.println("Starting the server on a port " + this.port);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                new ServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on a port " + this.port);
        }
    }
}

public class Demo {
    public void show() {
        new MultiServer().start();
        // then start multiple netcats: `nc 127.0.0.1 12345` and try to type something
    }
}
