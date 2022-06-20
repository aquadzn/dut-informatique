import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) throws IOException {
        int port = 5555;
        System.out.println("* démarrage du serveur sur le port " + port);

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            Thread fileThread = new Thread(new FileServer(clientSocket, "files/uploaded/"));
            fileThread.start();
        }

    }
}
