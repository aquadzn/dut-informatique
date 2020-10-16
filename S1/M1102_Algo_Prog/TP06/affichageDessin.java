public class affichageDessin {

	public static void main(String[] args) {

		System.out.println();
		afficherRectangle(8, 4);

		System.out.println();
		afficherCarre(4);

		System.out.println();		
		afficherTriangleRectangleGauche(4);

		System.out.println();		
		afficherTriangleRectangleDroit(4);

		System.out.println();		
		afficherTriangleIsocele(4);

		System.out.println();
		// afficherDamier(8, 4);
		// afficherRectangleCreux(8, 4);

	}

	public static void afficherRectangle(int largeur, int hauteur) {

		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void afficherCarre(int cote) {

		for (int i = 0; i < cote; i++) {
			for (int j = 0; j < cote; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public static void afficherTriangleRectangleGauche(int hauteur) {

		for (int i = 0; i <= hauteur; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public static void afficherTriangleRectangleDroit(int hauteur) {

		for (int i = 0; i <= hauteur; i++) {
			for (int j = hauteur; j > 0; j--) {
				if (i < j)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}

	}

	public static void afficherTriangleIsocele(int hauteur) {

        for (int i = 1, j = 0; i <= hauteur; i++, j = 0) {
            for (int espace = 1; espace <= hauteur - i; espace++) {
                System.out.print(" ");
            }

			for (; j != (2 * i) - 1; j++) {
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
		//
	}

	public static void afficherRectangleCreux(int largeur, int hauteur) {
		System.out.println();

		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				if (i == 0 || i == hauteur -1) {
					for (int k = 0; k < largeur; k++) {
						System.out.print("*");
					}
				}
				else {
					System.out.print("*");
					for (int k = 1; k < largeur - 1; k++) {
						System.out.print(" ");
					}
					System.out.print("*");
				}
			}

			System.out.println();
		}
	}

}