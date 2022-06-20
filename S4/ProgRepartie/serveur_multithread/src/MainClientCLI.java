import java.util.Scanner;

public class MainClientCLI {
    public static void main(String[] args) {
        Client client = new Client("files/downloaded/");
        client.connect("127.0.0.1", 5555);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez 1 ou 2 pour upload ou download un fichier: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        String file = "";

        if (code == 1) {
            System.out.print("Chemin vers le fichier à upload: ");
            file = scanner.nextLine();
        } else if (code == 2) {
            System.out.print("Choisir un fichier à télécharger parmi ceux du serveur: ");
            file = scanner.nextLine();
        }

        Query q = new Query(code, file);
        client.sendQueryToServer(q);
    }
}
