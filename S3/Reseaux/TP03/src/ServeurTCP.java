import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServeurTCP {
    public static void main(String[] args) throws IOException {
        ArrayList<Socket> clients = new ArrayList<>();
        ServerSocket serverSocket = new ServerSocket(32546);
        System.out.println("Démarrage du serveur sur le port 32546");

        Socket client;
        while (true) {
            try {
                client = serverSocket.accept();
                System.out.println("Nouveau client " + client);

                BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter output = new PrintWriter(client.getOutputStream(), true);

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        output.println("HELLO");
                        while (true) {
                            String msg = input.readLine();

                            if (msg.equals("EXIT")) {
                                output.println("Arrêt ...");
                                break;
                            }
                            output.println(msg);
                        }
                    }
                });

                clients.add(client);
                thread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
