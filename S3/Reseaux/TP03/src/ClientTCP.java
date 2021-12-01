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
        Scanner sc = new Scanner(System.in);

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

            String msg;
            do {
                System.out.print("[CLIENT] - ");
                msg = sc.nextLine();
                // envoi au server
                output.println(msg);
                // recupere la reponse du server
                response = input.readLine();
                System.out.println(RED + "[SERVEUR] - " + response + RESET);
            } while (! msg.equals("EXIT"));

            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
