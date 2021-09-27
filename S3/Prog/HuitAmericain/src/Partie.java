import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Partie {
    private int nbToursMax;
    private static int tourActuel;
    private Joueur j1;
    private Joueur j2;
    private Paquet paquet;
    private Stack<Carte> pioche;
    private Stack<Carte> pli;

    private Scanner sc;

    public Partie(Joueur j1, Joueur j2, int nbToursMax) {
        this.nbToursMax = nbToursMax;
        this.sc = new Scanner(System.in);

        this.j1 = j1;
        this.j2 = j2;

        this.paquet = new Paquet();
        this.paquet.melanger();
        this.pioche = this.paquet.distribuer(j1, j2);
        this.pli = new Stack<>();
    }

    public void commencer() {
        this.pli.push(this.pioche.pop());

        for(tourActuel = 0; tourActuel < nbToursMax; tourActuel++) {
            if (this.pioche.empty()) {
                break;
            }

            unTour();
        }
    }

    public void unTour() {

    }

    public void resoudreTour() {
        if (tourActuel % 2 == 0) {
            this.j1.jouer();
            Carte carteJoueeJ1 = this.j1.getCarteJouee();

            if (carteJoueeJ1.equals(this.pli.peek())) {
                this.j1.deposerCarte(carteJoueeJ1.getCouleur(), carteJoueeJ1.getValeur());
            }
            else if (carteJoueeJ1.getValeur() == 8) {
                carteJoueeJ1.setCouleur("couleur");
            }
            else if (carteJoueeJ1.getValeur() == 11) {
                for(int i = 0; i < 4; i++) {
                    this.j2.prendreCarte(this.pioche.pop());
                }
            }
            else if (carteJoueeJ1.getValeur() == 1) {
                System.out.println("changement sens du jeu");
            }
            else if (carteJoueeJ1.getValeur() == 2) {
                for(int i = 0; i < 2; i++) {
                    this.j2.prendreCarte(this.pioche.pop());
                }
            }
            else {
//                piocherCarte()
            }
        }
        else {
            this.j2.jouer();
            Carte carteJoueeJ2 = this.j2.getCarteJouee();

            if (carteJoueeJ2.equals(this.pli.peek())) {
                this.j1.deposerCarte(carteJoueeJ2.getCouleur(), carteJoueeJ2.getValeur());
            }
            else if (carteJoueeJ2.getValeur() == 8) {
                carteJoueeJ2.setCouleur("couleur");
            }
            else if (carteJoueeJ2.getValeur() == 11) {
                for(int i = 0; i < 4; i++) {
                    this.j2.prendreCarte(this.pioche.pop());
                }
            }
            else if (carteJoueeJ2.getValeur() == 1) {
                System.out.println("changement sens du jeu");
            }
            else if (carteJoueeJ2.getValeur() == 2) {
                for(int i = 0; i < 2; i++) {
                    this.j2.prendreCarte(this.pioche.pop());
                }
            }
            else {
//                piocherCarte()
            }
        }
    }
}
