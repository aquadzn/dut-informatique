/*
 * nombresPremiers.java
 * On cherche à savoir si un entier entrée est primaire ou non
 * Test de primalité
 *
 * Si nombreInput est divisible par un entier compris entre 2 et
 * nombreInput - 1 alors il n'est pas premier.
 * Si il n'est pas divisible, il est premier.
 */ 

import java.util.Scanner;


public class nombresPremiers {

    public static void main(String[] args) {
    
        Scanner saisie = new Scanner(System.in);

        System.out.print("Entrez un entier: ");
        int nombreInput = Integer.parseInt(saisie.nextLine());
        boolean estPremier = true;


        // Cas où l'entier serait 1, 0 ou négatif
        if (nombreInput <= 1) {
            estPremier = false; // le nombre n'est pas premier
        }

        // Test de primalité
        for(int i = 2; i < nombreInput; i++) {
            if (nombreInput % i == 0) {
            estPremier = false;
            }
        }

        // Résultat pour savoir si le nombre est premier
        if (estPremier) {
            System.out.println(nombreInput + " est premier");
        }
        else {
            System.out.println(nombreInput + " n'est pas premier");
        }

    }
}
