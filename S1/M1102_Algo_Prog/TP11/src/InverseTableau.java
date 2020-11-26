
public class InverseTableau {

	/*
	 * Retourne un tableau contenant les éléments de tab mais dans l'ordre inverse.
	 */
	public static int[] créeTableauInversé(int[] tab) {
		int longueur = tab.length;
		int[] tabInversé = new int[longueur];

		for (int i = 0, j = longueur -1; i < longueur; i++, j--) {
			tabInversé[i] = tab[j];
		}
		return tabInversé;
	}

	/*
	 * Inverse l'ordre des éléments de tab.
	 */
	public static void inverseTableau(int[] tab) {
		int pivot;
		int longueur = tab.length;
		for (int i=0 ; i < longueur / 2 ; i++) {
			pivot = tab[i];
			tab[i] = tab[longueur - i - 1];
			tab[longueur - i - 1] = pivot;
		}
	}


}
