package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSimple {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);

        while (true) {
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String messageFromClient = in.readLine();
            System.out.println(clientSocket + " - " + messageFromClient);

            int choice = choiceFromClient(messageFromClient);
            while (choice != -1) {
                switch (choiceFromClient(messageFromClient)) {
                    case -1 -> clientSocket.close();
                    case 1 -> out.println("upload fichier");
                    case 2 -> out.println("download fichier");
                    default -> out.println("option inexistante");
                }

                messageFromClient = in.readLine();
                System.out.println(clientSocket + " - " + messageFromClient);
                choice = choiceFromClient(messageFromClient);
            }
        }
    }

    public int choiceFromClient(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSimple server = new ServerSimple();
        server.start(5555);
    }

}
