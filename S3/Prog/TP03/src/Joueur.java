public abstract class Joueur {

    private String nom;
    private int score;
    private Coup coupCourant;

    public Joueur(String nom) {
        this.nom = nom;
        this.score = 0;
    }

    public Coup getCoupCourant() {
        return coupCourant;
    }

    public void setCoupCourant(Coup coupCourant) {
        this.coupCourant = coupCourant;
    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return nom + " score: " + score;
    }

    public void marquePoint(int point) {
        setScore(getScore() + point);
    }

    public abstract void choisirCoup();
}
