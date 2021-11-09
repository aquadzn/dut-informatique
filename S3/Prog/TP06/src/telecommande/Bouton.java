package telecommande;

public class Bouton {

    private int numero;
    private Action action;

    public Bouton(int numero) {
        this.numero = numero;
        this.action = null;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getNumero() {
        return numero;
    }

    public void appuyer() {
        this.action.effectuer();
    }
}
