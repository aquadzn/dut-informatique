package modele.requete;

import CinemaExceptions.ErreurSalle;
import CinemaExceptions.ErreurSeanceEnCours;
import CinemaExceptions.NombrePlacesErreur;
import modele.Cinema;
import modele.Salle;

public class ClotureSeance extends Requete {

    private int numSalle;

    public ClotureSeance(Cinema cinema, int numSalle) {
        super(cinema);
        this.numSalle = numSalle;
    }

    @Override
    public void executer() throws ErreurSalle, ErreurSeanceEnCours {
        getCinema().getSalle(numSalle).finirSeance();
    }

    @Override
    public void annuler() throws ErreurSalle, ErreurSeanceEnCours {
        Salle s = getCinema().getSalle(numSalle);
        if (s.pasDeseanceEnCours()) {
            s.setSeanceEnCours(s.getNbSeance() - 1);
        }
        else {
            s.setSeanceEnCours(s.getIndiceSeanceEnCours() - 1);
        }
    }
}
