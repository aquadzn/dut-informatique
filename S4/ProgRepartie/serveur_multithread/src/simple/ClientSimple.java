package simple;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientSimple {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ClientSimple client = new ClientSimple();
        client.startConnection("127.0.0.1", 5555);
        while (true) {
            String response = client.sendMessage(sc.nextLine());
            System.out.println(response);
        }
    }
}