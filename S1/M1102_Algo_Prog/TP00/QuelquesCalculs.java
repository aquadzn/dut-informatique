/* 
 * QuelquesCalculs.java
 * Ce programme permet d'essayer quelques opérations arithmétiques. 
 * Ce programme déclenche plusieurs erreurs de compilation, et contient plusieurs bugs...
 * A vous de le corriger.
 */

import java.util.Scanner;


class QuelquesCalculs {
	

	public static void main (String args[]) {


		Scanner saisie = new Scanner(System.in);
		// int nbDeJoueurs = Integer.parseInt(saisie.nextLine());
		// double diametreDuCercle = Double.parseDouble(saisie.nextLine());

		int a = 12, b = 5;

		System.out.print("x: ");
		double x = Double.parseDouble(saisie.nextLine());

		System.out.print("y: ");
		int y = Integer.parseInt(saisie.nextLine());
		
		saisie.close();
		
		// affichage des deux entiers et de leur somme
		System.out.println("a vaut " + a + ", b vaut " + b);
		System.out.println("a + b = " + (a + b));
		
		// affichage des deux réels et du résultat de leur division
		System.out.println("x vaut " + x + ", y vaut " + y);
		System.out.println("x / y = " + (x / y));

		// affichage des deux entiers et du résultat de leur
		// - soustraction
		// - multiplication
		// - division
		// - modulo
		System.out.println();
		System.out.println("a - b vaut: " + (a - b));
		System.out.println("a * b vaut: " + (a * b));
		System.out.println("a / b vaut: " + (a / b));
		System.out.println("a % b vaut: " + (a % b));
		
		
		System.out.println();  // c'est un saut de ligne
		if (x > 0) {
			System.out.println("x est positif");
		}

		System.out.println();
		if (x * y < 0) {
			System.out.print("Le produit de x par y est négatif ");
			System.out.println("donc soit x est négatif soit y est négatif.");
		}

		System.out.println();		
		if (a % 2  == 0) {
			System.out.println("a est pair");
		}
		else {
			System.out.println("a est impair"); 
		}

	}
}


