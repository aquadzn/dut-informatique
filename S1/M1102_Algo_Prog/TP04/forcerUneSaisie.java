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
        while ((a < 0 || b < 0 || c < 0) || (a > b  || b > c));        

        // d.
        // int c1, c2, c3;

        // do {
        //     System.out.println("Entez 3 entiers positifs ou nuls tels que (c1 < c2 < c3) ou (c1 > c2 > c3) : -> ");
        //     System.out.print("c1: ");
        //     c1 = saisie.nextInt();
        //     System.out.print("c2: ");
        //     c2 = saisie.nextInt();
        //     System.out.print("c3: ");
        //     c3 = saisie.nextInt();
        // }
        // while ((c1 < 0 || c2 < 0 || c3 < 0) || ((c1 < c2 < c3) || (c1 > c2 > c3)));        



        saisie.close();

        // Résultats
        System.out.println();
        System.out.println("Pair: " + pair);
        System.out.println("nonNul: " + nonNul);
        System.out.println("a-b-c: " + a + "-" + b + "-" + c);
    }
}
