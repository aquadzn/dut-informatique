package vue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import modele.Cinema;
import modele.Film;

import modele.Logs;
import modele.Salle;
import CinemaExceptions.ErreurSalle;
import CinemaExceptions.ErreurSeanceEnCours;

import CinemaExceptions.NombrePlacesErreur;
import CinemaExceptions.SaisieEntierException;
import modele.requete.*;

public class VueCinema {
    private Cinema leCinema;
    private Logs logs;

    public VueCinema(Cinema bib) {
	this.leCinema = bib;
	this.logs = new Logs();
    }

    public int menuEtSaisie() {
	int rep = 0;
	try {
	    System.out.println("1:	creer la programmation");
	    System.out.println("2:	demarrer la journee ");
	    System.out.println("3:	cloturer la seance courante d'une salle ");
		System.out.println("4:	acheter des billets");
		System.out.println("5:	préacheter billets");
	    System.out.println("6:	afficher le cinema");
		System.out.println("7:	annuler dernier choix");
		System.out.println("8:	retablir derniere annulation");
		System.out.println("9:	quitter");
	    System.out.println("Entrez votre choix: ");
	    rep = UtilSaisie.lireEntierPositifInferieurA(10);
	} catch (SaisieEntierException e) {
	    System.out.println(e.getMessage());
	    menuEtSaisie();
	}
	return rep;
    }

    public void go() throws ErreurSeanceEnCours, ErreurSalle, NombrePlacesErreur {

	boolean encore = true;
	while (encore) {
	    int choix = menuEtSaisie();
	    switch (choix) {
	    case (1): {
		faireProgrammation();
		break;
	    }
	    case (2): {
		demarrerJournee();
		break;
	    }
	    case (3): {
		cloturer();
		break;
	    }
	    case (4): {
		acheter();
		break;
	    }
	    case (5): {
		preacheter();
		break;
	    }
		case (6): {
			System.out.println(leCinema);
			break;
		}
		case (7): {
		this.logs.annulerDerniereRequete();
		break;
		}
		case (8): {
			this.logs.retablir();
			break;
		}
	    case (9): {
		System.out.println("au revoir");
		encore = false;
		break;
	    }
	    }
	}

    }

    private void preacheter() {
		int numSalle = UtilSaisie
				.lireEntierPositifEnBoucle("entrer un numero de salle ");
		System.out.println(numSalle);
		int numSeance = UtilSaisie
				.lireEntierPositifEnBoucle("entrer un numéro de seance ");
		System.out.println(numSeance);
		int nbBillets = UtilSaisie
				.lireEntierPositifEnBoucle("entrer un nombre de billets ");
		System.out.println(nbBillets);

		try {
			this.logs.enregistrer(new PreAcheter(this.leCinema, nbBillets, numSalle, numSeance));
		} catch (ErreurSalle | NombrePlacesErreur | ErreurSeanceEnCours e) {
			System.out.println(e.getMessage());
		}
	}

    private void acheter() {
	int numSalle = UtilSaisie
		.lireEntierPositifEnBoucle("entrer un numero de salle");
	System.out.println(numSalle);
	int nbBillets = UtilSaisie
		.lireEntierPositifEnBoucle("entrer un nombre de billets  ");
	System.out.println(nbBillets);
	try {
		this.logs.enregistrer(new AcheterBillet(this.leCinema, nbBillets, numSalle));
	    System.out.println("achat effectue ");
	} catch (ErreurSalle e) {
	    System.out.println(e.getMessage());
	    acheter();
	} catch (NombrePlacesErreur e) {
	    System.out.println("erreur dans le nombre de places");
	    System.out.println(e.getMessage());
	    acheter();
	} catch (ErreurSeanceEnCours e) {
	    System.out.println("probleme ");
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    System.out.println(
		    "il ne devrait pas y avoir d'erreur de ce type ...");
	}
    }

    private void cloturer() {
	int numSalle = UtilSaisie
		.lireEntierPositifEnBoucle("entrer un numero de salle");
	System.out.println(numSalle);
	try {
		this.logs.enregistrer(new ClotureSeance(this.leCinema, numSalle));
	    System.out.println("la seance a bien etet cloturee");
	} catch (ErreurSalle e) {
	    System.out.println(e.getMessage());
	    cloturer();
	} catch (ErreurSeanceEnCours e) {
	    System.out.println(e.getMessage());
	    // ici on choisit de remonter au menu
	} catch (Exception e) {
	    System.out.println(
		    "il ne devrait pas y avoir d'erreur de ce type ...");
	}
    }

    private void demarrerJournee() {
	try {
	    this.logs.enregistrer(new DemarrerJournee(this.leCinema));
	    System.out.println("journee demarree");
	} catch (ErreurSeanceEnCours e) {
	    System.out.println(e.getMessage());
	} catch (Exception e) {
	    System.out.println(
		    "il ne devrait pas y avoir d'erreur de ce type ...");
	}

    }

    private void faireProgrammation() {
	if (leCinema.journeeFinie()) {
	    List<List<Film>> lesFilms = Stream.iterate(0, n -> n + 1)
		    .limit(leCinema.getNbSalles())
		    .map(UtilSaisie::saisirFilmDeSalle)
		    .collect(Collectors.toList());
	    try {
			this.logs.enregistrer(new CreerProgrammation(this.leCinema, lesFilms));
	    } catch (ErreurSeanceEnCours e) {
		System.out.println("erreur impossible dans faireProgrammation");
	    } catch (Exception e) {
		System.out.println(
			"il ne devrait pas y avoir d'erreur de ce type ...");
		e.printStackTrace();
	    }
	    System.out.println("programmation terminee");
	}

	else
	    System.out.println("les seances ne sont pas toutes terminees");
    }
}
