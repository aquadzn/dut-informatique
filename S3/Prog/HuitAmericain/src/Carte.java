public class Carte {

    private String couleur;
    private int valeur;
    private boolean estSpeciale;

    public Carte(String couleur, int valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
        this.estSpeciale = false;

        if (valeur == 0 || valeur == 1 || valeur == 2 || valeur == 8 || valeur == 11) {
            estSpeciale = true;
        }
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getValeur() {
        return valeur;
    }

    public boolean isEstSpeciale() {
        return estSpeciale;
    }

    @Override
    public String toString() {
        return couleur + " " + valeur;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        Carte c = (Carte) obj;
        return c.getCouleur().equals(this.couleur) || c.getValeur() == this.valeur;
    }
}
