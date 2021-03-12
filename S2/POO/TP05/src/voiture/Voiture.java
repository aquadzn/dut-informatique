package voiture;

public class Voiture {

    private final String marque;
    private final String modele;
    private int km;
    private int prixJournee;

    public Voiture(String marque, String modele, int km, int prixJournee) {
        this.marque = marque;
        this.modele = modele;
        this.km = km;
        this.prixJournee = prixJournee;
    }

    public String toString() {
        return marque + " " + modele + " - " + km + " km - " + prixJournee + " euro / jour";
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public int getKm() {
        return km;
    }

    public int getPrixJournee() {
        return prixJournee;
    }

}
