package sport.template;

import sport.Personne;
import sport.Sexe;

public class GymPrenatale extends Activite {
    public GymPrenatale(int capacite) {
        super("Gym prénatale", capacite);
    }

    @Override
    boolean inscriptionPossible(Personne p) {
        return p.getSexe() == Sexe.Femme;
    }
}
