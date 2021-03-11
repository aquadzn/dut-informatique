public class Lettre implements Courrier {

    private final String destinataire;

    public Lettre(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public String toString() {
        return "Lettre pour " + getDestinataire() + " cout du courrier : " + coutAffranchissement();
    }

    public double coutAffranchissement() {
        return 0.5;
    }

    public boolean estCorrect() {
        return (destinataire != null);
    }
}
