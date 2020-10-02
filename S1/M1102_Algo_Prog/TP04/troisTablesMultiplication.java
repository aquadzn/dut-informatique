/*
 * troisTablesMultiplication.java
 */
import java.util.Scanner;


public class troisTablesMultiplication {

    public static void main(String[] args) {
        
        Scanner saisie = new Scanner(System.in);

        System.out.print("Veuillez saisir un entier entre 2 et 9 inclus: -> ");
        int nombre = saisie.nextInt();

        while (nombre < 2 || nombre > 9) {
            System.out.print("L'entier " + nombre + " est incorrecte. Réessayez: -> ");
            nombre = saisie.nextInt();
        }

        saisie.close();

        System.out.printf("\n\tpar %d\tpar %d\tpar %d\n", (nombre -1), nombre, (nombre + 1));

        for (int i = 0; i <= 10; i++) {
            System.out.printf("%d\t%d\t%d\t%d\n", i, i * (nombre - 1), (i * nombre), i * (nombre + 1));
        }
    }
}
