public class affichageDessin {

	public static void main(String[] args) {

		afficherRectangle(8, 4);
		afficherCarre(4);
		afficherTriangleRectangleGauche(4);
		afficherTriangleRectangleDroit(4);
		afficherTriangleIsocele(4);


		afficherDamier(8, 4);

	}

	public static void afficherRectangle(int largeur, int hauteur) {
		
		System.out.println();

		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();
	}

	public static void afficherCarre(int cote) {
		
		System.out.println();

		for (int i = 0; i < cote; i++) {
			for (int j = 0; j < cote; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();
	}

	public static void afficherTriangleRectangleGauche(int hauteur) {
		
		System.out.println();

		for (int i = 0; i <= hauteur; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();
	}

	public static void afficherTriangleRectangleDroit(int hauteur) {

		System.out.println();

		for (int i = 0; i <= hauteur; i++) {
			for (int j = hauteur; j > 0; j--) {
				if (i < j)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}


		System.out.println();
	}

	public static void afficherTriangleIsocele(int hauteur) {
		
		System.out.println();

		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < hauteur - 1; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void afficherTriangleIsoceleInverse(int hauteur) {
		//
	}

	public static void afficherTriangleIsoceleEtTriangleIsoceleInverse(int demiHauteur) {
		//
	}

	public static void afficherLosange(int hauteur) {
		//
	}

	public static void afficherDamier(int largeur, int hauteur) {

		System.out.println();

		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur / 2; j++) {
				System.out.print("B");
				System.out.print("N");
			}
			System.out.println();
		}

		System.out.println();
	}

}