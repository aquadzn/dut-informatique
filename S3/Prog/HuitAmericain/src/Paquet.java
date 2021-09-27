import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Paquet {

    private Stack<Carte> cartes;
    private static Random random = new Random();

    public Paquet() {
        this.cartes = new Stack<>();

        for (String c : new String[]{"piques", "carreaux", "coeurs", "trefles"}) {
            for (int i = 1; i <= 13; i++) {
                this.cartes.add(new Carte(c, i));
            }
        }
        this.cartes.add(new Carte("joker", 0));
        this.cartes.add(new Carte("joker", 0));
    }

    public Stack<Carte> getCartes() {
        return cartes;
    }

    public void melanger() {
        Collections.shuffle(this.cartes);
    }

    public Stack<Carte> distribuer(Joueur j1, Joueur j2) {
        for (int i = 0; i < 7; i++) {
            j1.prendreCarte(this.cartes.pop());
        }
        for (int i = 0; i < 7; i++) {
            j2.prendreCarte(this.cartes.pop());
        }

        // donner pioche
        return this.cartes;
    }

}
