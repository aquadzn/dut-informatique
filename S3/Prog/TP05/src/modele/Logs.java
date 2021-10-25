package modele;

import CinemaExceptions.ErreurSalle;
import CinemaExceptions.ErreurSeanceEnCours;
import CinemaExceptions.NombrePlacesErreur;
import modele.requete.Requete;

import java.util.Stack;

public class Logs {
    private Stack<Requete> requetes;
    private Stack<Requete> annulees;

    public Logs() {
        this.requetes = new Stack<>();
        this.annulees = new Stack<>();
    }

    public void annulerDerniereRequete() throws ErreurSeanceEnCours, ErreurSalle {
        if (! this.requetes.empty()) {
            Requete r = this.requetes.pop();
            r.annuler();
            this.annulees.push(r);
        }
    }

    public void enregistrer(Requete r) throws ErreurSalle, NombrePlacesErreur, ErreurSeanceEnCours {
        r.executer();
        this.requetes.push(r);
    }

    public void retablir() throws ErreurSalle, NombrePlacesErreur, ErreurSeanceEnCours {
        if (! this.annulees.empty()) {
            this.annulees.pop().executer();
        }
    }
}
