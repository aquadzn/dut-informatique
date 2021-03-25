package iteration_1;

public abstract class Acteur {
    private static int compteur = 0;
    private final String id;
    private int pv;

    protected Acteur(int pv) {
        this.id = "acteur_" + String.valueOf(++compteur);
        this.pv = pv;
    }

    public String getId() {
        return this.id;
    }

    public int getPv() {
        return this.pv;
    }

    protected boolean estVivant() {
        return this.pv > 0;
    }

    protected void decrementerPv(int nombre) {
        this.pv -= nombre;
    }

    protected void incrementerPv(int nombre) {
        this.pv += nombre;
    }

    protected void meurt() {
        this.pv = 0;
    }

    abstract protected void agit();

    public String toString() {
        return this.id + " : " + this.pv + " pv";
    }
}
