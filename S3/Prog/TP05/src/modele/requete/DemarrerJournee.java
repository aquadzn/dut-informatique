package modele.requete;

import CinemaExceptions.ErreurSalle;
import CinemaExceptions.ErreurSeanceEnCours;
import CinemaExceptions.NombrePlacesErreur;
import modele.Cinema;
import modele.Salle;

public class DemarrerJournee extends Requete {

    public DemarrerJournee(Cinema cinema) {
        super(cinema);
    }

    @Override
    public void executer() throws ErreurSeanceEnCours {
        if (getCinema().journeeFinie()) {
            for (int i = 0; i < getCinema().getNbSalles(); i++) {
                try {
                    Salle salle = getCinema().getSalle(i);
                    salle.demarrerSalle();

                } catch (ErreurSeanceEnCours | ErreurSalle e) {
                    System.out.println("erreur impossible dans DemarrerJournee");
                }
            }
        } else
            throw new ErreurSeanceEnCours("une des salles n'a pas termine sa journee");
    }

    @Override
    public void annuler() {
        getCinema().getSalles().forEach(salle -> {
            try {
                salle.setSeanceEnCours(-1);
                salle.getSeances().forEach(seance -> seance.setPlacesDisponible(salle.getCapacite()));
            } catch (ErreurSeanceEnCours erreurSeanceEnCours) {
                erreurSeanceEnCours.printStackTrace();
            }
        });
    }
}
