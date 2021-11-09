package sport.template;

import sport.Personne;

public class StretchingSenior extends Activite {
    public StretchingSenior(int capacite) {
        super("Stretching senior", capacite);
    }

    @Override
    boolean inscriptionPossible(Personne p) {
        return p.getAge() > 60;
    }
}
