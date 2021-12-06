import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    static final String RED = "\u001B[31m";
    static final String RESET = "\u001B[0m";

    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        BufferedReader input = null;
        PrintWriter output = null;

        try {
            input = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
            );
            output = new PrintWriter(clientSocket.getOutputStream(), true);

            String response = input.readLine();
            if (! response.equals("HELLO")) {
                // PAS DE CONNEXION
                System.exit(1);
            }
            System.out.println(RED + "[SERVEUR] - " + response + RESET);

            String msg;
            while ((msg = input.readLine()) != null) {
                output.println(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
                if (input != null) {
                    input.close();
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}