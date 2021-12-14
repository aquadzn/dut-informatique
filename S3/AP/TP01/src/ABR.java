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
		if (estVide()) {
			return false;
		}
		else {
			if (val.compareTo(contenu) == 0) {
				return true;
			}
			else if (val.compareTo(contenu) > 0) {
				return ((ABR<E>) filsD).recherche(val);
			}
			else {
				return ((ABR<E>) filsG).recherche(val);
			}
		}
	}

	/**
	 * Insère val dans l'ABR courant
	 */
	public void insertion(E val) {
		if (estVide()) {
			this.contenu = val;
			this.filsG = new ABR<>();
			this.filsD = new ABR<>();
		}
/*
		else if (estFeuille()) {
			if (val.compareTo(contenu) <= 0) {
				this.filsG = new ABR<>(val);
			}
			else {
				this.filsD = new ABR<>(val);
			}
		}
*/
		else {
			if (val.compareTo(contenu) <= 0) {
				((ABR<E>) filsG).insertion(val);
			}
			else {
				((ABR<E>) filsD).insertion(val);
			}
		}
	}

	/**
	 * Supprime le contenu val de l'ABR courant s'il est présent
	 */
	public void supprime(E val) {
		if (! estVide()) {
			if (recherche(val)) {
				if (val.compareTo(contenu) == 0) {
					supprimeRacine();
				}
				else if (val.compareTo(contenu) > 0) {
					((ABR<E>) filsD).supprime(val);
				}
				else {
					((ABR<E>) filsG).supprime(val);
				}
			}
		}
	}

	/**
	 * Supprime le contenu de la racine de l'ABR courant
	 */
	private void supprimeRacine() {
		if (estFeuille()) {
			contenu = null;
			filsG = null;
			filsD = null;
		}
		else if (!filsG.estVide() && filsD.estVide()) {
			contenu = filsG.contenu;
			filsD = filsG.filsD;
			filsG = filsG.filsG;
		}
		else if (filsG.estVide() && !filsD.estVide()) {
			contenu = filsD.contenu;
			filsG = filsD.filsG;
			filsD = filsD.filsD;
		}
		else {
			E max = ((ABR<E>) filsG).max();
			supprime(max);
			contenu = max;
		}
	}
}
