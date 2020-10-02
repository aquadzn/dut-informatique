/*
 * tableMultiplication.java
 */
import java.util.Scanner;


public class tableMultiplication {

    public static void main(String[] args) {
        
        Scanner saisie = new Scanner(System.in);

        System.out.print("Veuillez saisir un entier entre 0 et 9 inclus: -> ");
        int nombre = saisie.nextInt();

        while (nombre < 0 || nombre > 9) {
            System.out.print("L'entier " + nombre + " est incorrecte. Réessayez: -> ");
            nombre = saisie.nextInt();
        }

        saisie.close();

        for (int i = 0; i <= 10; i++) {
            // System.out.printf("%d fois %d = %d\n", i, nombre, (i * nombre));
            System.out.println(i + " fois " + nombre + " = " + (i * nombre));
        }
    }
}