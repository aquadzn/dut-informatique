package voiture;

import java.util.ArrayList;

public class Agence {
    public ArrayList<Voiture> voitures;

    public Agence() {
        this.voitures = new ArrayList<>();
    }

    public void ajoute(Voiture v) {
        this.voitures.add(v);
    }

    public ArrayList<Voiture> selection(Critere c) {
        ArrayList<Voiture> selectionVoitures = new ArrayList<>();
        for (Voiture v : this.voitures) {
            if (c.estSatisfaitPar(v)) {
                selectionVoitures.add(v);
            }
        }
        return selectionVoitures;
    }
}
