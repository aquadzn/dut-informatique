package armee;

public class Cavalier extends Soldat {

    public Cavalier(String nom, int poids, int charge) {
        super(nom, poids, 150, charge);
    }

    public double vitesseMax() {
        int charge = this.getCharge();

        if (charge == 0) {
            return 15.;
        }
        else if (charge < 50) {
            return 13.;
        }
        else if (charge <= 100) {
            return 10.;
        }
        else {
            return 8.;
        }
    }

    public void charger(int poidsCharge) {
        setCharge(this.getCharge() + poidsCharge);
    }

    public void decharger(int poidsCharge) {
        setCharge(this.getCharge() - poidsCharge);
    }
}
