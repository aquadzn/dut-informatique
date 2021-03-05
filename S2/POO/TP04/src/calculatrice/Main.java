package calculatrice;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // -(5 * 6 + (-7)) == 5
        Calculatrice.entrerValeur(5);
        Calculatrice.entrerValeur(6);
        Calculatrice.entrerValeur(-7);
        Calculatrice.additioner();
        Calculatrice.multiplier();
        Calculatrice.prendreNegation();
        System.out.println(Calculatrice.resultat());
    }

}
