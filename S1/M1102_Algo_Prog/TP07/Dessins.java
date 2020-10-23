/*
 * Dessins.java
 * Diverses méthodes statiques permettant de réaliser des dessins sur la console (en utilisant des print).
 */
public class Dessins {

	/**
	 * Affiche une ligne de caractères (sans retour à la ligne).
	 * 
	 * @param c
	 *            le caractère à afficher
	 * @param longueur
	 *            le nombre d'affichages du caractère (longueur >=0)
	 */
	public static void afficherEnLigne(char c, int longueur) {
		if (longueur < 0) {
			System.out.println("ERREUR! afficherEnLigne : longueur négative ("
					+ longueur + ")");
		} else {
			for (int colonne = 1; colonne <= longueur; colonne++) {
				System.out.print(c);
			}
		}
	}

	/**
	 * Affiche une ligne de caractères avec retour à la ligne.
	 * 
	 * @param c
	 *            le caractère à afficher
	 * @param longueur
	 *            le nombre d'affichages du caractère (longueur >=0).
	 */
	public static void afficherEnLigneln(char c, int longueur) {
		afficherEnLigne(c, longueur);
		System.out.println();
	}

	/**
	 * Affiche un rectangle composé avec le caractère '*'
	 * 
	 * @param largeur
	 *            largeur du rectangle (largeur >=0)
	 * @param hauteur
	 *            hauteur du rectangle (hauteur >=0)
	 */
	public static void afficherRectangle(int largeur, int hauteur) {

		if (hauteur < 0 || largeur < 0) {
			System.out.println("ERREUR! afficherRectangle : valeur négative ("
					+ largeur + "," + hauteur + ")");
		} else {
			for (int ligne = 1; ligne <= hauteur; ligne++) {
				afficherEnLigneln('*', largeur);
			}
		}
	}

	/**
	 * Affiche un rectangle composé avec le caractère '*'
	 * 
	 * @param largeur
	 *            largeur du rectangle (largeur >=0)
	*/
	public static void afficherCarré(int coté) {
			afficherRectangle(coté, coté);
	}
	
	
	/**
	 * Affiche un triangle rectangle d'étoiles dont le sommet est calé en haut à
	 * gauche.
	 * 
	 * @param hauteur
	 *            la hauteur du triangle (hauteur >=0)
	 */
	public static void afficherTriangleRectangleGauche(int hauteur) {
		if (hauteur < 0) {
			System.out
					.println("ERREUR! afficherTriangleRectangleGauche : hauteur négative ("
							+ hauteur + ")");
		} else {
			for (int ligne = 1; ligne <= hauteur; ligne++) {
				afficherEnLigneln('*', ligne);
			}
		}
	}

	/**
	 * Affiche un triangle rectangle d'étoiles dont le sommet est calé en haut à
	 * droite.
	 * 
	 * @param hauteur
	 *            la hauteur du triangle (hauteur >=0)
	 */
	public static void afficherTriangleRectangleDroit(int hauteur) {
		if (hauteur < 0) {
			System.out
					.println("ERREUR! afficherTriangleRectangleDroit : hauteur négative ("
							+ hauteur + ")");
		} else {
			for (int ligne = 1; ligne <= hauteur; ligne++) {
				afficherEnLigne(' ', hauteur - ligne);
				afficherEnLigneln('*', ligne);
			}
		}
	}

	/**
	 * Affiche un triangle isocèle d'étoiles (sommet en haut). (Autrement dit,
	 * il s'agit d'une pyramide.)
	 * 
	 * @param hauteur
	 *            la hauteur du triangle (hauteur >=0)
	 */
	public static void afficherTriangleIsocèle(int hauteur) {
		if (hauteur < 0) {
			System.out
					.println("ERREUR! afficherTriangleIsocèle : hauteur négative ("
							+ hauteur + ")");
		} else {
			for (int ligne = 1; ligne <= hauteur; ligne++) {
				afficherEnLigne(' ', hauteur - ligne);
				afficherEnLigneln('*', (2 * ligne - 1));
			}
		}
	}

	/**
	 * Affiche un triangle isocèle d'étoiles (base en haut). (Autrement dit, il
	 * s'agit d'une pyramide inversée.)
	 * 
	 * @param hauteur
	 *            la hauteur du triangle (hauteur >=0)
	 */
	public static void afficherTriangleIsocèleInversé(int hauteur) {
		if (hauteur < 0) {
			System.out
					.println("ERREUR! afficherTriangleIsocèleInversé : hauteur négative ("
							+ hauteur + ")");
		} else {
			for (int ligne = hauteur; ligne >= 1; ligne--) {
				afficherEnLigne(' ', hauteur - ligne);
				afficherEnLigneln('*', (2 * ligne - 1));
			}
		}
	}

	/**
	 * Affiche l'un en dessous de l'autre un triangle isocèle d'étoiles puis un
	 * triangle isocèle d'étoiles inversé.
	 * 
	 * @param demiHauteur
	 *            la hauteur de chacun des triangles (hauteur >=0)
	 */
	public static void afficherTriangleIsocèleEtTriangleIsocèleInversé(
			int demiHauteur) {
		afficherTriangleIsocèle(demiHauteur);
		afficherTriangleIsocèleInversé(demiHauteur);
	}

	/**
	 * Affiche un losange d'étoiles.
	 * 
	 * @param hauteur
	 *            la hauteur (totale) du losange (hauteur>=0 et hauteur impaire)
	 */
	public static void afficherLosange(int hauteur) {

		if (hauteur < 0) {
			System.out.println("ERREUR! afficherLosange : hauteur négative ("
					+ hauteur + ")");
		} else if (hauteur % 2 == 0) {
			System.out.println("ERREUR! afficherLosange : hauteur paire ("
					+ hauteur + ")");
		}

		else {

			int hauteurTriangle = (hauteur / 2) + 1;

			for (int ligne = 1; ligne <= hauteurTriangle; ligne++) {
				afficherEnLigne(' ', hauteurTriangle - ligne);
				afficherEnLigneln('*', (2 * ligne - 1));
			}
			for (int ligne = hauteurTriangle - 1; ligne >= 1; ligne--) {
				afficherEnLigne(' ', hauteurTriangle - ligne);
				afficherEnLigneln('*', (2 * ligne - 1));
			}
		}
	}

	/**
	 * Affiche un damier avec le caractère 'B' pour blanc et 'N' pour noir.
	 * 
	 * @param largeur
	 *            largeur du damier (largeur paire et >=0)
	 * @param hauteur
	 *            hauteur du damier (hauteur paire et >=0)
	 */
	public static void afficherDamier(int largeur, int hauteur) {

		if (hauteur < 0 || largeur < 0) {
			System.out.println("ERREUR! afficherRectangle : valeur négative ("
					+ largeur + "," + hauteur + ")");
		} else if (hauteur % 2 != 0 || largeur % 2 != 0) {
			System.out.println("ERREUR! afficherRectangle : valeur impaires ("
					+ largeur + "," + hauteur + ")");
		} else {
			for (int ligne = 1; ligne <= hauteur / 2; ligne++) {
				for (int colonne = 1; colonne <= largeur / 2; colonne++) {
					System.out.print("BN");
				}
				System.out.println();
				for (int colonne = 1; colonne <= largeur / 2; colonne++) {
					System.out.print("NB");
				}
				System.out.println();
			}
		}
	}

	/**
	 * Affiche avec des étoiles un rectangle creux.
	 * 
	 * @param largeur
	 *            largeur du rectangle (largeur >=0)
	 * @param hauteur
	 *            hauteur du rectangle (hauteur >=0)
	 */
	public static void afficherRectangleCreux(int largeur, int hauteur) {

		if (hauteur < 0 || largeur < 0) {
			System.out.println("ERREUR! afficherRectangle : valeur négative ("
					+ largeur + "," + hauteur + ")");
		} else {
			if (hauteur > 0 && largeur > 0) {
				afficherEnLigneln('*', largeur); // première ligne
				if (hauteur > 1) {
					for (int ligne = 2; ligne < hauteur; ligne++) {
						if (largeur > 1) {
							afficherEnLigne('*', 1);
							afficherEnLigne(' ', largeur - 2);
						}
						afficherEnLigneln('*', 1);
					}
					afficherEnLigneln('*', largeur); // dernière ligne
				}
			}
		}
	}

	/**
	 * Affiche une croix de 'x'.
	 * 
	 * @param hauteur
	 *            la hauteur (totale) de la croix (hauteur >=0 et hauteur
	 *            impaire)
	 */
	public static void afficherCroix(int hauteur) {

		if (hauteur < 0) {
			System.out.println("ERREUR! afficherCroix : hauteur négative ("
					+ hauteur + ")");
		} else if (hauteur % 2 == 0) {
			System.out.println("ERREUR! afficherCroix : hauteur paire ("
					+ hauteur + ")");
		}

		else {

			int hauteurDemiCroix = (hauteur / 2) + 1;

			for (int ligne = 1; ligne <= hauteurDemiCroix - 1; ligne++) {
				afficherEnLigne(' ', ligne - 1);
				afficherEnLigne('x', 1);
				afficherEnLigne(' ', 2 * (hauteurDemiCroix - ligne) - 1);
				afficherEnLigneln('x', 1);
			}
			afficherEnLigne(' ', hauteurDemiCroix - 1);
			afficherEnLigneln('x', 1);
			for (int ligne = hauteurDemiCroix - 1; ligne >= 1; ligne--) {
				afficherEnLigne(' ', ligne - 1);
				afficherEnLigne('x', 1);
				afficherEnLigne(' ', 2 * (hauteurDemiCroix - ligne) - 1);
				afficherEnLigneln('x', 1);
			}
		}
	}

	/**
	 * Affiche un triangle isocèle d'étoiles creux (sommet en haut). (Autrement
	 * dit, il s'agit d'une pyramide.)
	 * 
	 * @param hauteur
	 *            la hauteur du triangle (hauteur >=0)
	 */
	public static void afficherTriangleIsocèleCreux(int hauteur) {
		if (hauteur < 0) {
			System.out
					.println("ERREUR! afficherTriangleIsocèleCreux : hauteur négative ("
							+ hauteur + ")");
		} else {
			if (hauteur >= 2) {
				afficherEnLigne(' ', hauteur - 1);
				System.out.println('*');

				for (int ligne = 2; ligne <= hauteur-1; ligne++) {
					afficherEnLigne(' ', hauteur - ligne);
					System.out.print('*');
					afficherEnLigne(' ', (2 * (ligne - 1) - 1));
					System.out.println('*');
				}
			}
			if (hauteur >=1) {
				afficherEnLigne('*', (2 * hauteur - 1));
			}
		}
	}

}
