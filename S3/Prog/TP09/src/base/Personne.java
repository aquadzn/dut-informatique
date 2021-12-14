package base;

public class Personne {
    private static int compteur = 0;
    private final int identifiant;
    private String nom, prenom;
    private Adresse adresse;

    public Personne(String nom, String prenom, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        identifiant = compteur;
        compteur++;
    }

    @Override
    public String toString() {
        return identifiant + "," + nom + "," + prenom + "," + adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne personne = (Personne) o;

        return identifiant == personne.identifiant;

    }

    @Override
    public int hashCode() {
        return identifiant;
    }
}