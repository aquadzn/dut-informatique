// Pas fini
import java.util.Scanner;


public class cribleEratosthene {
    public static void main(String[] args) {
        Scanner saisie = new Scanner(System.in);

        System.out.print("Entrez un entier limite: ");
        int limite = saisie.nextInt();
        saisie.close();

        int[] listeEntiers = new int[limite - 1];
        int[] listePrime = {2, 3, 5, 7};

        for (int i = 2; i <= limite; i++) {
            listeEntiers[i - 2] = i;
        }

        afficherTab(listeEntiers);

        for (int p : listePrime) {
            for (int j = p; j <= listeEntiers.length; j += p) {
                listeEntiers[j - p] = 0;
            }
        }

        System.out.println("Après zéro");
        afficherTab(listeEntiers);
    }

    public static void afficherTab(int[] tab) {
        for (int i : tab) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
