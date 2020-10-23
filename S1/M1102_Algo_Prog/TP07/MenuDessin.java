import java.util.Scanner;


public class MenuDessin {

	public static void menu() {

		int choix, largeur, hauteur;
		Scanner saisie = new Scanner(System.in);

		do {
			System.out.println("1. Afficher un rectangle");
			System.out.println("2. Afficher un carré");
			System.out.println("3. Afficher un triangle rectangle droit");
			System.out.println("4. Afficher un triangle rectangle gauche");
			System.out.println("5. Quitter");

			System.out.print("--> ");
			choix = saisie.nextInt();
		}
		while (choix < 1 || choix > 5);

		switch(choix) {
			case 1:
				System.out.print("Largeur: ");
				largeur = saisie.nextInt();
				System.out.print("Hauteur: ");
				hauteur = saisie.nextInt();

				Dessins.afficherRectangle(largeur, hauteur);
				break;

			case 2:
				System.out.print("Hauteur: ");
				hauteur = saisie.nextInt();

				Dessins.afficherCarré(hauteur);
				break;

			case 3:
				System.out.print("Hauteur: ");
				hauteur = saisie.nextInt();

				Dessins.afficherTriangleRectangleDroit(hauteur);
				break;

			case 4:
				System.out.print("Hauteur: ");
				hauteur = saisie.nextInt();

				Dessins.afficherTriangleRectangleGauche(hauteur);
				break;

			default:
				System.out.println("Au revoir!");
				break;
		}
	}
}