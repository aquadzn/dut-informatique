package armee;

import java.util.ArrayList;

public class Troupe {

    private final ArrayList<Soldat> soldats;

    public Troupe() {
        this.soldats = new ArrayList<>();
    }

    public void ajouterSoldat(Soldat s) {
        this.soldats.add(s);
    }

    public void enleverSoldat(Soldat s) {
        this.soldats.remove(s);
    }

    public double vitesseTroupe() {
        double min = this.soldats.get(0).vitesseMax();
        for (Soldat s : this.soldats) {
            if (s.vitesseMax() < min) {
                min = s.vitesseMax();
            }
        }
        return min;
    }
}
