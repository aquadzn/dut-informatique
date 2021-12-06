import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTCP {
    static final String RED = "\u001B[31m";
    static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader input;
        PrintWriter output;

        try {
            socket = new Socket("localhost", 32546);

            input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            output = new PrintWriter(socket.getOutputStream(), true);

            String response = input.readLine();
            if (! response.equals("HELLO")) {
                // PAS DE CONNEXION
                System.exit(1);
            }
            System.out.println(RED + "[SERVEUR] - " + response + RESET);

            Scanner sc = new Scanner(System.in);
            String msg;

            do {
                System.out.print("[CLIENT] - ");
                msg = sc.nextLine();

                // envoi au server
                output.println(msg);
                output.flush();

                // recupere la reponse du server
                response = input.readLine();
                System.out.println(RED + "[SERVEUR] - " + response + RESET);
            } while (! msg.equalsIgnoreCase("EXIT"));

            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
