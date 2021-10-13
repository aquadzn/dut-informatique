package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import CinemaExceptions.ErreurSalle;
import CinemaExceptions.ErreurSeanceEnCours;
import CinemaExceptions.NombrePlacesErreur;
import modele.Cinema;
import modele.Film;

public class TestDepart {
    private Cinema melies;

    @Before
    public void setUp() throws Exception {
	melies = new Cinema();
	try {
	    ArrayList<Integer> l = new ArrayList<>();
	    l.add(20);
	    l.add(10);
	    melies = new Cinema(l);
	    ArrayList<Film> filmsDeLaSalle0 = new ArrayList<>();
	    filmsDeLaSalle0.add(new Film("Les combattants"));
	    filmsDeLaSalle0.add(new Film("Lucy"));
	    filmsDeLaSalle0.add(new Film("Maintenant ou jamais"));
	    ArrayList<Film> filmsDeLaSalle1 = new ArrayList<>();
	    filmsDeLaSalle1.add(new Film("Delivre nous du mal"));
	    filmsDeLaSalle1.add(new Film("Les combattants"));
	    filmsDeLaSalle1.add(new Film("Hunger games"));
	    melies.getSalle(0).creerProgrammation(filmsDeLaSalle0);
	    melies.getSalle(1).creerProgrammation(filmsDeLaSalle1);
	    melies.getSalle(0).setSeanceEnCours(2);
	    melies.getSalle(0).getSeance(2).setPlacesDisponible(4);
	    // System.out.println(melies);

	} catch (Exception e) {
	    System.out.println("erreur d'initalisation");
	}
    }

    @Test
    public void testCloturer1() throws ErreurSalle, ErreurSeanceEnCours {
	melies.cloturerSeanceEnCours(0);
	assertEquals(-1, melies.getSalle(0).getIndiceSeanceEnCours());
    }

    @Test(expected = ErreurSeanceEnCours.class)
    public void testCloturer2() throws ErreurSalle, ErreurSeanceEnCours {
	melies.cloturerSeanceEnCours(1);
    }

    @Test(expected = ErreurSalle.class)
    public void testCloturer3() throws ErreurSalle, ErreurSeanceEnCours {
	melies.cloturerSeanceEnCours(4);
    }

    @Test
    public void testCloturer4() throws ErreurSalle, ErreurSeanceEnCours {
	melies.getSalle(0).setSeanceEnCours(0);
	melies.cloturerSeanceEnCours(0);
	assertEquals(1, melies.getSalle(0).getIndiceSeanceEnCours());
    }

    @Test
    public void testAcheter1()
	    throws ErreurSalle, NombrePlacesErreur, ErreurSeanceEnCours {
	melies.acheter(3, 0);
	assertEquals(1,
		melies.getSalle(0).getSeanceEnCours().getNbPlacesDispo());
    }

    @Test(expected = NombrePlacesErreur.class)
    // System.out.println(melies);
    public void testAcheter2()
	    throws ErreurSalle, NombrePlacesErreur, ErreurSeanceEnCours {
	melies.acheter(5, 0);
    }

    @Test(expected = ErreurSalle.class)
    // System.out.println(melies);
    public void testAcheter3()
	    throws ErreurSalle, NombrePlacesErreur, ErreurSeanceEnCours {
	melies.acheter(1, 8);
    }

    @Test(expected = ErreurSeanceEnCours.class)
    // System.out.println(melies);
    public void testAcheter4()
	    throws ErreurSalle, NombrePlacesErreur, ErreurSeanceEnCours {
	melies.acheter(1, 1);
    }

}
