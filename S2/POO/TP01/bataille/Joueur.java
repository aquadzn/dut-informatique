import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 
 * La classe Joueur modélise les joueurs du jeu de bataille. 
 * 
 * Un joueur possède un nom et un paquet de cartes (ArrayList).
 * Le premier élément du ArrayList (indice 0) correspond au dessus du paquet de cartes.
 * Le dernier élément (indice size()-1 ) correspond au dessous du paquet de cartes.
 *  
 * Responsabilités détaillées de la classe Joueur :
 * - créer le joueur avec un paquet de cartes vide.
 * - créer le joueur avec un paquet de cartes déjà existant.
 * - dire quel est le nom du joueur
 * - ramasser une carte, c'est à dire ajouter la carte au dessous du paquet du joueur.
 * - poser une carte, c'est à dire retourner la carte au dessus du paquet et l'enlever du paquet.
 * - dire si le joueur a encore des cartes
 * - donner une représentation affichable du joueur et de ses cartes.
 */
public class Joueur {

	private String nom;
	private ArrayList<Carte> cartes;
	
	/*
	 * Construit un joueur dont la main et vide.
	 */
	public Joueur (String nom) {
		this.nom = nom;
		this.cartes = new ArrayList<Carte>();
	}
	
	/*
	 * Construit un joueur qui a pour main le paquet de cartes reçu en paramètre.
	 */
	public Joueur (String nom, ArrayList<Carte> cartes) {
		this.nom = nom;
		this.cartes = cartes;
	}

	public String getNom () {
		return this.nom;
	}

	public int getNbCartes() {
		return this.cartes.size();
	}

	public void ramasserUneCarte(Carte c) {
		this.cartes.add(c);
	}

	public Carte poserUneCarte(){
		if (!this.resteCarte()) throw new Error ("pas de carte");
		return this.cartes.remove(0);
	}

	public boolean resteCarte () {
		return ! this.cartes.isEmpty();
	}

	public Carte tricher1() {
		Carte carteMax = this.cartes.get(0);
		for (int i = 0; i < this.cartes.size() - 1; i++) {
			if (this.cartes.get(i + 1).supérieureA(carteMax)) {
				carteMax= this.cartes.get(i + 1);
			}
		}
		this.cartes.remove(carteMax);
		return carteMax;
	}

	public Carte tricher2(Carte carteAdverse) {
		Carte carteMinPlusGrand = this.cartes.get(0);
		// Carte cartePlusFaible = this.cartes.get(0);

		for (int i = 0; i < this.cartes.size() - 1; i++) {
			if (this.cartes.get(i + 1).supérieureA(carteAdverse) && ! this.cartes.get(i + 1).supérieureA(carteMinPlusGrand)) {
				carteMinPlusGrand = this.cartes.get(i + 1);
			}

			// if (cartePlusFaible.supérieureA(this.cartes.get(i + 1))) {
			// cartePlusFaible = this.cartes.get(i + 1);
			// }
		}
		// if (carteAdverse.supérieureA(carteMinPlusGrand)) {
		// 	return cartePlusFaible;
		// }
		return carteMinPlusGrand;
	}

	public String toString() {
		return this.nom + " : " + this.cartes.toString();
	}
	

}
