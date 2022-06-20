public class MainClient {
    public static void main(String[] args) {
        Client client = new Client("files/downloaded/");
        client.connect("127.0.0.1", 5555);

//        Query q = new Query(1, "files/downloaded/projet.pdf");
//        client.sendQueryToServer(q);

        Query q = new Query(2, "terraform.png");
        client.sendQueryToServer(q);

    }
}
