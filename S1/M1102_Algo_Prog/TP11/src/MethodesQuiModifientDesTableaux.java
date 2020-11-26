import java.util.Scanner;


public class MethodesQuiModifientDesTableaux {

	public static void raz(int[] t) {
		for (int i = 0; i < t.length; i++)
				t[i] = 0;
	}

	public static void valAbs(int[] t) {
		for (int i = 0; i < t.length; i++)
			t[i] = Math.abs(t[i]);
	}
	
	/*
	 * Remplit le tableau avec des valeurs aléatoires comprises entre min inclus et max inclus.
	 */
	public static void remplirTableauAvecValeursAléatoires(int[] t, int valMin, int valMax) {
		for (int i = 0 ; i < t.length ; i++) {
			t[i] = (int) (Math.random() * ((valMax - valMin) + 1)) + valMin;
		}
	}
	
	/*
	 * Crée un tableau et le remplit avec des valeurs aléatoires comprises entre min inclus et max inclus.
	 */
	public static int[] créerEtRemplirTableauAvecValeursAléatoires(int longueur, int valMin, int valMax) {
		int[] t = new int[longueur];
		remplirTableauAvecValeursAléatoires(t, valMin, valMax);
		return t;
	}

	
	public static void afficher(int[] t) {
		for (int i = 0; i < t.length; i++)
			System.out.print(t[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] tab = créerEtRemplirTableauAvecValeursAléatoires(5, -10, 10);
		afficher(tab);

		valAbs(tab);
		afficher(tab);

		raz(tab);
		afficher(tab);
	}
	
}
