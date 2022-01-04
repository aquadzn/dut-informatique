
/**
 * Classe générique (comme les classes Arbre et ABR): le contenu des noeuds est de type quelconque E à condition qu'il
 * permette les comparaisons
 */
public class AVL<E extends Comparable<E>> extends ABR<E> implements Cloneable {

	public AVL(AVL<E> g, E c, AVL<E> d) {
		super(g, c, d);
	}

	public AVL(E c) {
		this(new AVL<>(), c, new AVL<>());
	}

	public AVL() {
		this(null, null, null);
	}

	/**
	 * Effectue une rotation gauche autour de la racine de l'AVL courant si cela est possible
	 */
	public void rotationGauche() {
		//TODO
	}

	/**
	 * Effectue une rotation droite autour de la racine de l'AVL courant si cela est possible
	 */
	public void rotationDroite() {
		if (!estVide()) {
			filsD = this;
			contenu = filsG.contenu;
			filsD.filsG = filsG.filsD;
			filsG = filsG.filsG;
		}
	}

	/**
	 * Equilibre l'AVL courant avec une (double) rotation suite à une opération d'insertion ou de suppression de valeur
	 */
	public void equilibrage() {
		//TODO
	}

	/**
	 * Insère val dans l'AVL courant et équilibre
	 */
	public void insertion(E val) {
		//TODO

	}

	/**
	 * Supprime val de l'AVL courant et équilibre
	 */
	public void supprime(E val) {
		//TODO
	}

	/**
	 * Supprime le contenu de la racine de l'AVL courant
	 */
	public void supprimeRacine() {
		//TODO
	}

}
