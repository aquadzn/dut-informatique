public class MainServer {
    public static void main(String[] args) {
        int port = 5555;
        FileServer fileServer = new FileServer(port, "files/uploaded/");
        System.out.println("* démarrage du serveur sur le port " + port);
        fileServer.start();
    }
}
