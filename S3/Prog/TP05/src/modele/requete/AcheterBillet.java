package modele.requete;

import CinemaExceptions.ErreurSalle;
import CinemaExceptions.ErreurSeanceEnCours;
import CinemaExceptions.NombrePlacesErreur;
import modele.Cinema;
import modele.Salle;

public class AcheterBillet extends Requete {
    private int nbBillets, numSalle;

    public AcheterBillet(Cinema cinema, int nbBillets, int numSalle) {
        super(cinema);
        this.nbBillets = nbBillets;
        this.numSalle = numSalle;
    }

    @Override
    public void executer() throws ErreurSalle, ErreurSeanceEnCours, NombrePlacesErreur {
        Salle s = getCinema().getSalle(numSalle);
        s.acheterSeanceEnCours(nbBillets);
    }

    @Override
    public void annuler() throws ErreurSalle {
        getCinema().getSalle(numSalle).setCapacite(getCinema().getSalle(numSalle).getCapacite() + nbBillets);
    }
}
