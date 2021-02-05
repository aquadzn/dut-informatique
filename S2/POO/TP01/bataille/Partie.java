import java.util.ArrayList;

/*
 * La classe Partie fait fonctionner le jeu de bataille (elle contient la boucle principale du jeu). 
 * Une partie oppose deux joueurs qui vont exécuter des tours de jeu jusqu'à ce que l'un d'eux gagne.
 * 
 * Une Partie concerne deux Joueur. 
 * 
 * Responsabilités détaillées de la classe Partie :
 * - créer une nouvelle partie opposant deux Joueur
 * - faire jouer la partie (jouer des tours de jeu jusquà ce qu'un joueur gagne).  
 * - dire qui est le gagnant ou bien si la partie est terminée
 * 
 */
public class Partie {

	private Joueur joueur1, joueur2;
	
	public Partie (String nomJ1, String nomJ2) {

		// créer deux paquets de cartes contenant une distribution d'un jeu de 32 cartes
		ArrayList<Carte> paquet1, paquet2; 
		paquet1 = new ArrayList<>();
		paquet2 = new ArrayList<>();
		FabriqueDeJeuxDe32Cartes.créerEtDistribuerJeu32(paquet1, paquet2);

		// créer les joueurs
		this.joueur1 = new Joueur(nomJ1, paquet1);
		this.joueur2 = new Joueur(nomJ2, paquet2);				
	}
	
	public void jouer () {
		System.out.println("Nous commençons une nouvelle et grandiose partie qui oppose :");
		System.out.println("Joueur 1 : " + this.joueur1.toString());
		System.out.println("Joueur 2 : " + this.joueur2.toString());
		System.out.println();
		
		int compteurDeTours = 0;
		
		// boucle principale du jeu		
		while (this.joueur1.resteCarte() && this.joueur2.resteCarte()) {
			compteurDeTours++;
			System.out.println("Tour n°" + compteurDeTours);
			System.out.println("===");
			this.faireUnTourDeJeu(compteurDeTours);
			System.out.println(this.joueur1.toString());
			System.out.println("Nombre cartes joueur 1: " + this.joueur1.getNbCartes());
			System.out.println(this.joueur2.toString());
			System.out.println("Nombre cartes joueur 2: " + this.joueur2.getNbCartes());
			System.out.println();
		}

		
		// affichage du résultat
		if (this.joueur1.resteCarte()) 
			System.out.println(this.joueur1.getNom() + " a gagné !");
		else 
			System.out.println(this.joueur2.getNom() + " a gagné !");
	}
	
	
	// EGALITEE DE BATAILLE PAS IMPLEMENTEE
	private void faireUnTourDeJeu(int tour) {
		Carte cartePoséeJoueur1, cartePoséeJoueur2;

		if (tour % 3 == 0) {
			// le joueur 1 triche tous les trois tours
			cartePoséeJoueur1 = this.joueur1.tricher1();
			System.out.println("Triche tour " + tour);
		}
		else {
			// chaque joueur pose une carte sur le tapis de jeu
			cartePoséeJoueur1 = this.joueur1.poserUneCarte();
		}
		System.out.println(this.joueur1.getNom() + " pose le " + cartePoséeJoueur1.toString());
		cartePoséeJoueur2 = this.joueur2.poserUneCarte();
		System.out.println(this.joueur2.getNom() + " pose le " + cartePoséeJoueur2.toString());
		
		// qui gagne le pli ?
		Joueur gagnantPli;

		// Supérieure
		if (cartePoséeJoueur1.compareTo(cartePoséeJoueur2) > 0) {
			gagnantPli = this.joueur1;
		}
		// Inférieure
		else if (cartePoséeJoueur1.compareTo(cartePoséeJoueur2) < 0) {
			gagnantPli = this.joueur2;
		}
		// Egalitée donc bataille
		else {

			// Joueur 1 moins de deux cartes
			if (this.joueur1.getNbCartes() < 2 && this.joueur2.getNbCartes() >= 2) {
				System.out.println(this.joueur1.getNom() + " n'a pas assez de cartes pour continuer");
				this.joueur1.viderCartes();
				return;
			}
			// Joueur 2 moins de deux cartes
			if (this.joueur2.getNbCartes() < 2 && this.joueur1.getNbCartes() >= 2) {
				System.out.println(this.joueur2.getNom() + " n'a pas assez de cartes pour continuer");
				this.joueur2.viderCartes();
				return;
			}

			System.out.println("\nBataille !!!");
			Carte batailleCartePosee1Joueur1 = this.joueur1.poserUneCarte();
			Carte batailleCartePosee1Joueur2 = this.joueur2.poserUneCarte();
			System.out.println("Les deux joueurs posent une carte face cachée");
			Carte batailleCartePosee2Joueur1 = this.joueur1.poserUneCarte();
			Carte batailleCartePosee2Joueur2 = this.joueur2.poserUneCarte();

			System.out.println(this.joueur1.getNom() + " bataille avec le " + batailleCartePosee2Joueur1.toString());
			System.out.println(this.joueur2.getNom() + " bataille avec le " + batailleCartePosee2Joueur2.toString());

			if (batailleCartePosee2Joueur1.supérieureA(batailleCartePosee2Joueur2)) {
				System.out.println(this.joueur1.getNom() + " remporte la bataille!\n");
				gagnantPli = this.joueur1;
			}
			else {
				System.out.println(this.joueur2.getNom() + " remporte la bataille!\n");
				gagnantPli = this.joueur2;
			}

			if (Math.random()<0.5) {
				gagnantPli.ramasserUneCarte(batailleCartePosee1Joueur1);
				gagnantPli.ramasserUneCarte(batailleCartePosee1Joueur2);
				gagnantPli.ramasserUneCarte(batailleCartePosee2Joueur1);
				gagnantPli.ramasserUneCarte(batailleCartePosee2Joueur2);
			}
			else {
				gagnantPli.ramasserUneCarte(batailleCartePosee1Joueur2);
				gagnantPli.ramasserUneCarte(batailleCartePosee1Joueur1);
				gagnantPli.ramasserUneCarte(batailleCartePosee2Joueur2);
				gagnantPli.ramasserUneCarte(batailleCartePosee2Joueur1);
			}
		}

		// le pli est battu puis ramassé par le gagnant
		if (Math.random()<0.5) {
			gagnantPli.ramasserUneCarte(cartePoséeJoueur1);
			gagnantPli.ramasserUneCarte(cartePoséeJoueur2);
		}
		else {
			gagnantPli.ramasserUneCarte(cartePoséeJoueur2);
			gagnantPli.ramasserUneCarte(cartePoséeJoueur1);
		}
	}
	
}
