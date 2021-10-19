package modele;

import modele.requete.Requete;

import java.util.Stack;

public class Logs {
    private Stack<Requete> requetes;

    public Logs() {
        this.requetes = new Stack<>();
    }

    public void annulerDerniereRequete() {
        this.requetes.pop();
    }

    public void enregistrer(Requete r) {
        r.executer();
        this.requetes.push(r);
    }
}
