package armee;

public class Cavalier extends Porteur {

    public Cavalier(String nom, int poids) {
        super(nom, poids, 150);
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
}
