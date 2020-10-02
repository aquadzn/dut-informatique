/*
 * forcerUneSaisie.java
 * Entrée d'entiers
 */
import java.util.Scanner;

public class forcerUneSaisie {

    public static void main(String[] args) {

        Scanner saisie = new Scanner(System.in);

        // a.
        int pair;

        do {
            System.out.print("Entrez un entier pair compris entre 0 et 100 inclus: -> ");
            pair = saisie.nextInt();
        }
        while ((pair < 0 || pair > 100) && pair % 2 != 0);

        // b.
        int nonNul;

        do {
            System.out.print("Entrez un entier non nul, pair si positif ou impair si négatif : -> ");
            nonNul = saisie.nextInt();
        }
        while ((nonNul == 0 || nonNul > 0 && nonNul % 2 != 0) || (nonNul == 0 || nonNul < 0 && nonNul % 2 == 0));

        // c.
        int a, b, c;


        do {
            System.out.println("Entez 3 entiers positifs ou nuls tels que a < b < c : -> ");
            System.out.print("a: ");
            a = saisie.nextInt();
            System.out.print("b: ");
            b = saisie.nextInt();
            System.out.print("c: ");
            c = saisie.nextInt();
        }
        while ((a < 0 && b < 0 && c < 0) && (a > b && a > c && b < a && b > c && c < b && c < a));

        // d.
        


        // Résultats
        System.out.println("Pair: " + pair);
        System.out.println("nonNul: " + nonNul);
        System.out.println("a, b, c: " + a + b + c);

        saisie.close();
    }
}
