import java.util.Scanner;


public class Factorielle {

    public static void main(String[] args) {
        
        Scanner saisie = new Scanner(System.in);

        System.out.print("Entrez un entier positif ou nul: -> ");
        int nombre = saisie.nextInt();

        saisie.close();

        // 12 est le maximum pour un type int(32) 
        if (nombre >= 0 && nombre <= 12) {
            System.out.printf("La factorielle de %d (int) est %d\n", nombre, factInt(nombre));
        }
        // 20 est le maximum pour un type long(64)
        else if (nombre > 12 && nombre <= 20) {
            System.out.printf("La factorielle de %d (long) est %d\n", nombre, factLong((long) nombre));
        }
        // Cas factorielle trop grande
        else if (nombre > 20) {
            System.out.printf("Trop grand, je ne peux calculer la factorielle de %d\n", nombre);
        }
        // Cas entier négatif
        else {
            System.out.printf("La factorielle de %d est impossible!\nEntrez un entier positif ou nul.\n", nombre);
        }

    }

    public static int factInt(int n) {

        // Cas n == 0
        int resultat = 1;

        for (int i = 1; i <= n; i++) {
            resultat *= i;
        }

        return resultat;
    }

    public static long factLong(long n) {

        // Cas n == 0
        long resultat = 1;

        for (int i = 1; i <= n; i++) {
            resultat *= i;
        }

        return resultat;
    }
}
