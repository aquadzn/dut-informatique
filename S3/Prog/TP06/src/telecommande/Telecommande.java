package telecommande;

import java.util.ArrayList;

public class Telecommande {
    private int nbBoutons;
    private ArrayList<Bouton> boutons;

    public Telecommande(int nbBoutons) {
        this.nbBoutons = nbBoutons;
        this.boutons = new ArrayList<>();

        for(int i = 0; i < nbBoutons; i++) {
            this.boutons.add(new Bouton(i));
        }
    }

    public ArrayList<Bouton> getTelecommande() {
        return this.boutons;
    }

    public void assignerBouton(int i, Action action) {
        this.boutons.get(i).setAction(action);
    }

    public void presserBouton(int i) {
        this.boutons.get(i).appuyer();
    }
}
