package modele.requete;

import CinemaExceptions.ErreurSalle;
import CinemaExceptions.ErreurSeanceEnCours;
import CinemaExceptions.NombrePlacesErreur;
import modele.Cinema;

public abstract class Requete {
    private Cinema cinema;

    public Requete(Cinema cinema) {
        this.cinema = cinema;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public abstract void executer() throws ErreurSalle, ErreurSeanceEnCours, NombrePlacesErreur;
    public abstract void annuler() throws ErreurSalle, ErreurSeanceEnCours;
}
