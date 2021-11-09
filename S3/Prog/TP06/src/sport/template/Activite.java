package sport.template;

import sport.Personne;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Activite {

    private String nom;
    private int capacite;
    private Collection<Personne> inscrits;

    public Activite(String nom, int capacite) {
	this.nom = nom;
	this.capacite = capacite;
	this.inscrits = new ArrayList<>();
    }

    public Collection<Personne> getInscrits() {
        return inscrits;
    }

    public void inscrire(Personne p) {
        if (inscriptionPossible(p)) {
            if (this.inscrits.size() + 1 >= capacite)  {
                this.inscrits.add(p);
            }
        }
    }

    abstract boolean inscriptionPossible(Personne p);

}
