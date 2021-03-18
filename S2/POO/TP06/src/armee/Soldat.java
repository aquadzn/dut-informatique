package armee;

public class Soldat {
    private final String nom;
    private int poids;


    public Soldat(String nom, int poids) {
        this.nom = nom;
        this.poids = poids;
    }

    public int getPoids() {
        return this.poids;
    }

    public String toString() {
        String str = "Soldat " + this.nom + "\nPoids: " + this.poids + " kg\nVitesse max: "
                + this.vitesseMax() + " km/h\n";

        return str;
    }

    public double vitesseMax() {
        if (this.poids < 85) {
            return 7;
        }
        else if (this.poids > 85 && this.poids <= 95) {
            return 6.6;
        }
        else {
            return 7;
        }
    }
}
