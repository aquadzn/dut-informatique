/*
 * validationSemestre.java
 *
 */
import java.util.Scanner;


public class quelleSaison {

	public static void main(String[] args) {

        Scanner saisie = new Scanner(System.in);

        System.out.print("Entrez un jour (1-31) -> ");
        int jour = saisie.nextInt();
    	System.out.print("Entrez un mois (1-12) -> " + jour + "/");
	    int mois = saisie.nextInt();

        saisie.close();

        System.out.println("Vous avez entré: " + jour + "/" + mois);

        // Cas incorrecte
        if (mois < 1 || mois > 12 || jour < 1 || jour > 31) {
            System.out.println("Erreur, le jour, le mois ou l'année est incorrecte.");
        }

        else {
	        if (((mois == 4 || mois == 6 || mois == 9 || mois == 11) && jour > 30)
	        	|| ((mois == 1 || mois == 3 || mois == 5 || mois == 8 || mois == 10 || mois == 12) && jour > 31)
	            || (mois == 2 && jour > 29)
	        	) {
	        	System.out.println("Erreur, le jour est incorrecte.");
	            }
	        else {
	        	if (((mois >= 3 && jour >= 20) && (mois > 3 && mois < 6)) || ((mois <= 6 && jour < 21) && (mois > 3 && mois < 6)))) {
	        		System.out.println("Printemps!");
	        	}

	        	else if (((mois >= 6 && jour >= 21) && (mois > 6 && mois < 9)) || ((mois <= 9 && jour < 22) && (mois > 6 && mois < 9)))) {
	        		System.out.println("Eté!");
	        	}

	        	else if (((mois >= 9 && jour >= 22) && (mois > 9 && mois < 12)) || ((mois <= 12 && jour < 21) && (mois > 9 && mois < 12)))) {
	        		System.out.println("Automne!");
	        	}
	        	else {
	        		System.out.println("Hiver!");
	        	}
	        }
        }
    }
}