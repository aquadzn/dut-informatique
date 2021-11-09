package sport.strategy;

import sport.Personne;

public class InscriptionStretchingSenior implements Inscription {
    @Override
    public boolean inscriptionPossible(Personne p) {
        return p.getAge() > 60;
    }
}
