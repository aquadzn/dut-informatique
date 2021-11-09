package sport.strategy;

import sport.Personne;
import sport.Sexe;

public class InscriptionGymPrenatale implements Inscription {

    @Override
    public boolean inscriptionPossible(Personne p) {
        return p.getSexe() == Sexe.Femme;
    }
}
