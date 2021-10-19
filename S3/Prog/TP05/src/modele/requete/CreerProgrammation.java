package modele.requete;

import CinemaExceptions.ErreurSalle;
import CinemaExceptions.ErreurSeanceEnCours;
import CinemaExceptions.NombrePlacesErreur;
import modele.Cinema;
import modele.Film;

import java.util.List;

public class CreerProgrammation extends Requete {

    private List<List<Film>> lesFilms;
    public CreerProgrammation(Cinema cinema, List<List<Film>> lesFilms) {
        super(cinema);
        this.lesFilms = lesFilms;
    }

    @Override
    public void executer() throws ErreurSalle, ErreurSeanceEnCours {
        for (int i = 0; i < getCinema().getNbSalles(); i++) {
            getCinema().getSalle(i).creerProgrammation(lesFilms.get(i));
        }
    }

    @Override
    public void annuler() {
        getCinema().getSalles().forEach(salle -> {
            salle.getSeances().clear();
        });
    }
}
