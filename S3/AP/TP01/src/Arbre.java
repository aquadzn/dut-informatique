import java.util.LinkedList;
import java.util.Queue;

/**
 * Cette classe est dite générique car le contenu du noeud de l'arbre peut être de tout type
 */
public class Arbre<E> {

	protected E contenu; // contenu du noeud
	protected Arbre<E> filsG, filsD; // les sous-arbres

	/**
	 * Constructeur
	 * 
	 * @param g
	 *            sous-arbre gauche
	 * @param c
	 *            contenu du noeud
	 * @param d
	 *            sous-arbre droit
	 */
	public Arbre(Arbre<E> g, E c, Arbre<E> d) {
		this.filsG = g;
		this.contenu = c;
		this.filsD = d;
	}

	/**
	 * Constructeur d'arbre vide
	 */
	public Arbre() {
		this(null, null, null);
	}

	/**
	 * Constructeur de feuille càd un contenu et deux sous-arbres vides
	 */
	public Arbre(E contenu) {
		this(new Arbre<E>(), contenu, new Arbre<E>());
	}

	/**
	 * Teste si l'arbre courant est vide
	 */
	public boolean estVide() {
		return this.filsG == null && this.filsD == null && this.contenu == null;
	}

	/**
	 * Retourne la taille de l'arbre courant
	 */
	public int taille() {
		if (estVide()) {
			return 0;
		}
		return 1 + filsG.taille() + filsD.taille();
	}

	/**
	 * Retourne vrai si l'arbre courant est une feuille
	 */
	public boolean estFeuille() {
		return this.taille() == 1;
	}

	/**
	 * Retourne le nombre de feuilles de l'arbre courant
	 */
	public int nbFeuilles() {
		if (estVide()) {
			return 0;
		}
		if (estFeuille()) {
			return 1;
		}

		return filsG.nbFeuilles() + filsD.nbFeuilles();
	}

	/**
	 * Retourne la hauteur de l'arbre courant (0 si feuille)
	 */
	public int hauteur() {
		if (this.estVide()) {
			return -1;
		}
		if (this.estFeuille()) {
			return 0;
		}
		else {
			return 1 + Math.max(filsG.hauteur(), filsD.hauteur());
		}
	}

	/**
	 * Affiche les contenus de l'arbre courant en effectuant un parcours préfixe
	 */
	public void parcoursPrefixe() {
		if (! this.estVide()) {
			System.out.println(this.contenu);

			if (! this.filsG.estVide()) {
				this.filsG.parcoursPrefixe();
			}

			if (! this.filsD.estVide()) {
				this.filsD.parcoursPrefixe();
			}
		}
	}

	/**
	 * Affiche les contenus de l'arbre courant en effectuant un parcours infixe
	 */
	public void parcoursInfixe() {
		if (! this.estVide()) {
			if (! this.filsG.estVide()) {
				this.filsG.parcoursPrefixe();
			}

			System.out.println(this.contenu);

			if (! this.filsD.estVide()) {
				this.filsD.parcoursPrefixe();
			}
		}
	}

	/**
	 * Affiche les contenus de l'arbre courant en effectuant un parcours postfixe
	 */
	public void parcoursPostfixe() {
		if (! this.estVide()) {
			if (! this.filsG.estVide()) {
				this.filsG.parcoursPrefixe();
			}

			if (! this.filsD.estVide()) {
				this.filsD.parcoursPrefixe();
			}

			System.out.println(this.contenu);
		}
	}

	/**
	 * Affiche les contenus de l'arbre courant en effectuant un parcours en largeur
	 */
	public void parcoursLargeur() {
		Queue<Arbre> file = new LinkedList<>();
		file.add(this);

		while(! file.isEmpty()) {
			Arbre noeud = file.poll();
			System.out.println(noeud.contenu);

			if (! noeud.filsG.estVide()) {
				file.add(noeud.filsG);
			}
			if (! noeud.filsD.estVide()) {
				file.add(noeud.filsD);
			}
		}
	}

	/**************************
	 * Getters et utilitaires *
	 **************************/

	public Arbre<E> getFilsG() {
		return this.filsG;
	}

	public Arbre<E> getFilsD() {
		return this.filsD;
	}

	public E getContenu() {
		return this.contenu;
	}

	public boolean estIdentiqueA(Arbre<E> b) {
		if (this.estVide() && b.estVide())
			return true;
		if (!this.estVide() && !b.estVide() && this.contenu.equals(b.contenu))
			return this.filsG.estIdentiqueA(b.filsG) && this.filsD.estIdentiqueA(b.filsD);
		else
			return false;
	}

	@Override
	public String toString() {
		if (this.estVide())
			return "vide";
		return "[filsG=" + filsG + ", contenu=" + contenu + ", filsD=" + filsD + "]";
	}

}
