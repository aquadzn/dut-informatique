import java.util.ArrayList;

public abstract class Joueur {

    private String nom;
    private Carte carteJouee;
    private ArrayList<Carte> cartes;

    public Joueur(String nom) {
        this.nom = nom;
        this.cartes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public Carte getCarteJouee() {
        return carteJouee;
    }

    public void setCarteJouee(Carte carteJouee) {
        this.carteJouee = carteJouee;
    }

    public void prendreCarte(Carte c) {
        this.cartes.add(c);
    }

    public Carte deposerCarte(String couleur, int valeur) {
        for (Carte c : this.cartes) {
            if (c.getCouleur().equals(couleur) && c.getValeur() == valeur) {
                this.cartes.remove(c);
                return c;
            }
        }
        return null;
    }

    public abstract void jouer();
}
