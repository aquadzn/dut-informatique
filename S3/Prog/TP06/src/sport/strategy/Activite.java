package sport.strategy;

import sport.Personne;

import java.util.ArrayList;
import java.util.Collection;

public class Activite {

    private String nom;
    private int capacite;
    private Collection<Personne> inscrits;
    private Inscription inscription;

    public Activite(String nom, int capacite, Inscription inscription) {
	this.nom = nom;
	this.capacite = capacite;
	this.inscrits = new ArrayList<>();
	this.inscription = inscription;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public Collection<Personne> getInscrits() {
        return inscrits;
    }

    public void inscrire(Personne p) {
        if (this.inscription.inscriptionPossible(p)) {
            if (this.inscrits.size() + 1 <= capacite) {
                this.inscrits.add(p);
            }
        }
    }

}
