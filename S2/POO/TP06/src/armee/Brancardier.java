package armee;

public class Brancardier extends Soldat {

    public Brancardier(String nom, int poids, int charge) {
        super(nom, poids, 60, charge);
    }

    public double vitesseMax() {
        int charge = this.getCharge();
        int poids = this.getPoids();

        if (charge == 0) {
            return super.vitesseMax();
        }
        else if (charge < poids / 3) {
            return 0.8 * super.vitesseMax();

        }
        else if (charge >= poids / 3 && charge <= poids / 2) {
            return 0.7 * super.vitesseMax();
        }
        else {
            return 4.;
        }
    }

    public void charger(int poidsCharge) {
        setCharge(this.getCharge() + poidsCharge);
    }

    public void decharger(int poidsCharge) {
        setCharge(this.getCharge() - poidsCharge);
    }
}
