/**
 * Classe générique (comme la classe Arbre): le contenu des noeuds est de type quelconque E à condition qu'il permette
 * les comparaisons
 */
public class ABR<E extends Comparable<E>> extends Arbre<E> {

	/**
	 * Contructeur avec un contenu et deux sous-ABR
	 */
	public ABR(ABR<E> g, E c, ABR<E> d) {
		super(g, c, d);
	}

	/**
	 * Constructeur d'ABR vide
	 */
	public ABR() {
		this(null, null, null);
	}

	/**
	 * Constructeur d'ABR feuille
	 */
	public ABR(E c) {
		this(new ABR<>(), c, new ABR<>());
	}

	/**
	 * Retourne le contenu minimum de l'ABR courant s'il est non vide. Lance une erreur sinon.
	 */
	public E min() {
		if (this.estVide()) {
			throw new Error();
		}
		else {
			if (filsG.estVide()) {
				return this.contenu;
			}
			else {
				return ((ABR<E>) filsG).min();
			}
		}
	}

	/**
	 * Retourne le contenu maximum de l'ABR courant s'il est non vide. Lance une erreur sinon.
	 */
	public E max() {
		if (this.estVide()) {
			throw new Error();
		}
		else {
			if (filsD.estVide()) {
				return this.contenu;
			}
			else {
				return ((ABR<E>) filsD).max();
			}
		}
	}

	/**
	 * Retourne vrai si val est dans l'ABR courant
	 */
	public boolean recherche(E val) {
		if (val.compareTo(this.contenu) <= 0) {
			if (! filsG.estVide()) {
				if (val.compareTo(filsG.contenu) == 0) {
					return true;
				}
			}
			((ABR<E>) filsG).recherche(val);
		}
		else {
			if (! filsD.estVide()) {
				if (val.compareTo(filsD.contenu) == 0) {
					return true;
				}
			}
			((ABR<E>) filsD).recherche(val);
		}

		return false;
	}

	/**
	 * Insère val dans l'ABR courant
	 */
	public void insertion(E val) {
		//TODO
	}

	/**
	 * Supprime le contenu val de l'ABR courant s'il est présent
	 */
	public void supprime(E val) {
		//TODO
	}

	/**
	 * Supprime le contenu de la racine de l'ABR courant
	 */
	private void supprimeRacine() {
		//TODO
	}
}
