package armee;

public class Porteur extends Soldat {

    private final int chargeMax;
    private int charge;

    public Porteur(String nom, int poids, int chargeMax) {
        super(nom, poids);
        this.chargeMax = chargeMax;
        this.charge = 0;
    }

    public int getCharge() {
        return this.charge;
    }

    public String toString() {
        String str = super.toString();

        if (this.chargeMax == 60) {
            str += "Charge: " + this.charge + " kg\nType: brancardier\n";
        }
        if (this.chargeMax == 150) {
            str += "Charge: " + this.charge + " kg\nType: cavalier\n";
        }

        return str;
    }

    public void charger(int poidsCharge) {
        this.charge += poidsCharge;
    }

    public void decharger(int poidsCharge) {
        this.charge -= poidsCharge;
    }
}
