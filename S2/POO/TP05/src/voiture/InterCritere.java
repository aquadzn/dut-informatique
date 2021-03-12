package voiture;

import java.util.ArrayList;

public class InterCritere implements Critere {
    private ArrayList<Critere> criteres;

    public InterCritere(ArrayList<Critere> criteres) {
        this.criteres = criteres;
    }

    public boolean estSatisfaitPar(Voiture v) {
        for (Critere c : this.criteres) {
            if (! c.estSatisfaitPar(v)) {
                return false;
            }
        }
        return true;
    }
}
