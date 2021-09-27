public class Boucle implements Strategie {

    private Coup coupCourant;

    public Boucle() {
        this.coupCourant = Coup.pierre;
    }

    @Override
    public Coup choisirCoup() {
        switch (coupCourant) {
            case pierre:
                return Coup.papier;
            case papier:
                return Coup.ciseaux;
            default:
                return Coup.pierre;
        }
    }
}
