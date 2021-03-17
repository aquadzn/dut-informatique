package armee;

public class Soldat {
    private final String nom;
    private int poids;
    private final int chargeMax;
    private int charge;

    public Soldat(String nom, int poids, int chargeMax, int charge) {
        this.nom = nom;
        this.poids = poids;
        this.chargeMax = chargeMax;
        this.charge = charge;
    }

    public int getPoids() {
        return this.poids;
    }

    public int getCharge() {
        return this.charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public String toString() {
        String str = "Soldat " + this.nom + "\nPoids: " + this.poids + " kg\nVitesse max: "
                + this.vitesseMax() + " km/h\n";

        if (this.chargeMax == 60) {
            str += "Charge: " + this.charge + " kg\nType: brancardier\n";
        }
        if (this.chargeMax == 150) {
            str += "Charge: " + this.charge + " kg\nType: cavalier\n";
        }

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
