package armee;

public class Brancardier extends Porteur {

    public Brancardier(String nom, int poids) {
        super(nom, poids, 60);
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
}
