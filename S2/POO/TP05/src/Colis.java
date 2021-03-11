public class Colis implements Courrier {
    private String destinataire;
    private String expediteur;
    private double poids;

    public Colis(String destinataire, String expediteur, double poids) {
        this.destinataire = destinataire;
        this.expediteur = expediteur;
        this.poids = poids;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public String toString() {
        return "colis de " + poids + " g pour " + getDestinataire() + " cout du courrier : " + coutAffranchissement();
    }

    public double coutAffranchissement() {
        return (double) (int) (this.poids / 500 + 1);
    }

    public boolean estCorrect() {
        return (destinataire != null && expediteur != null);
    }
}
