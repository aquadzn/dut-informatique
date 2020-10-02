/*
 * triCroissant.java
 * Programme qui tri trois entiers rentrés par l'utilisateur
 * dans l'ordre croissant
 */
import java.util.Scanner;


public class triCroissant {
    public static void main(String[] args) {

        Scanner saisie = new Scanner(System.in);
        
        // On initialise un array contenant 3 int
        int[] array = new int[3];
        // On intialise valeur minimale, maximale et médiane
		int min, max, med;

        // On itère pour assigner chaque valeur dans l'array
        for (int i = 0; i < array.length; i++) {
            System.out.print("Entrez nombre " + (i + 1) + ": ");
            array[i] = saisie.nextInt();
        }

        if (array[0] > array[1]) {
            if (array[0] > array[2]) {
                max = array[0];
                if (array[1] > array[2]) {
                    med = array[1];
                    min = array[2];
                }
				else {
                    med = array[2];
                    min = array[1];
                }
            }
			else {
                med = array[0];
                max = array[2];
                min = array[1];
            }
        }
		else {
            if (array[1] > array[2]) {
                max = array[1];
                if (array[0] > array[2]) {
                    med = array[0];
                    min = array[2];
                }
				else {
                    med = array[2];
                    min = array[0];
                }
            }
			else {
                med = array[1];
                max = array[2];
                min = array[0];
            }
        }

        System.out.println("Tri croissant: " + min + "-" + med + "-" + max);
    }
}
