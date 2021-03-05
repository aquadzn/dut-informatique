package calculatrice;

import java.util.Stack;

public class Calculatrice {

    private static Stack<Double> stack = new Stack<>();

    static void effacer() {
        stack.clear();
    }

    static double resultat() {
        return stack.peek();
    }

    static void entrerValeur(double val) {
        stack.push(val);
    }

    static void additioner() {
        double d1 = stack.pop();
        double d2 = stack.pop();

        stack.push(d1 + d2);
    }

    static void soustraire() {
        double d1 = stack.pop();
        double d2 = stack.pop();

        // soustraction donc inverse
        stack.push(d2 - d1);
    }

    static void multiplier() {
        double d1 = stack.pop();
        double d2 = stack.pop();

        stack.push(d1 * d2);
    }

    static void diviser() {
        double d1 = stack.pop();
        double d2 = stack.pop();

        stack.push(d1 / d2);
    }

    static void prendreNegation() {
        double d = stack.pop();
        stack.push(-d);
    }
}
