package calculatrice;

import java.util.Stack;

public class Calculatrice {

    private final Stack<Double> stack;

    public Calculatrice() {
        this.stack = new Stack<>();
    }

    // Effacer tous les éléments de la pile
    public void effacer() {
        this.stack.clear();
    }

    // Effacer n éléments de la pile
    public void effacer(int combienEffacer) {
        for (int i = 0; i < combienEffacer; i++) {
            this.stack.pop();
        }
    }

    public int nbValeurs() {
        return this.stack.size();
    }

    public double sommet() {
        return (this.stack.empty()) ? Double.NaN : this.stack.peek();
    }

    public void entrerValeur(double val) {
        this.stack.push(val);
    }

    public void additioner() {
        double d1 = this.stack.pop();
        double d2 = this.stack.pop();

        this.stack.push(d1 + d2);
    }

    public void soustraire() {
        double d1 = this.stack.pop();
        double d2 = this.stack.pop();

        // soustraction donc inverse
        this.stack.push(d2 - d1);
    }

    public void multiplier() {
        double d1 = this.stack.pop();
        double d2 = this.stack.pop();

        this.stack.push(d1 * d2);
    }

    public void diviser() throws ArithmeticException {
        double d1 = this.stack.pop();
        double d2 = this.stack.pop();

        if (d1 == 0) {
            this.stack.push(d2);
            this.stack.push(d1);
            throw new ArithmeticException("Division par zéro!");
        }
        else {
            this.stack.push(d2 / d1);
        }
    }

    public void negation() {
        double d = this.stack.pop();
        this.stack.push(-d);
    }

    public void puissance() {
        double d1 = this.stack.pop();
        double d2 = this.stack.pop();

        this.stack.push(Math.pow(d2, d1));
    }

    public void operationAvancee(String choix) {
        double d = this.stack.pop();
        switch (choix) {
            case "sin":
                this.stack.push(Math.sin(d));
                break;
            case "cos":
                this.stack.push(Math.cos(d));
                break;
            case "tan":
                this.stack.push(Math.tan(d));
                break;
            case "abs":
                this.stack.push(Math.abs(d));
                break;
            case "ln":
                this.stack.push(Math.log(d));
                break;
            case "ln10":
                this.stack.push(Math.log10(d));
                break;
            case "ln2":
                this.stack.push(Math.log(d) / Math.log(2));
                break;
            case "sqrt":
                this.stack.push(Math.sqrt(d));
                break;
        }
    }
}
