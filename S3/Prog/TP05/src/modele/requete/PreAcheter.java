package modele.requete;

import CinemaExceptions.ErreurSalle;
import CinemaExceptions.ErreurSeanceEnCours;
import CinemaExceptions.NombrePlacesErreur;
import modele.Cinema;
import modele.Salle;
import modele.Seance;

public class PreAcheter extends Requete {

    private int nbBillets, numSalle, numSeance;

    public PreAcheter(Cinema cinema, int nbBillets, int numSalle, int numSeance) {
        super(cinema);
        this.nbBillets = nbBillets;
        this.numSalle = numSalle;
        this.numSeance = numSeance;
    }

    @Override
    public void executer() throws ErreurSalle, ErreurSeanceEnCours, NombrePlacesErreur {
        Salle s = getCinema().getSalle(numSalle);
        s.preacheter(nbBillets, numSeance);
    }

    @Override
    public void annuler() throws ErreurSalle, ErreurSeanceEnCours {
        Seance s = getCinema().getSalle(numSalle).getSeance(numSeance);
        s.setPlacesDisponible(s.getNbPlacesDispo() + nbBillets);
    }
}
