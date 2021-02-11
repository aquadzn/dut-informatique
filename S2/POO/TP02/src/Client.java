public class Client {
    private String nom;
    private String adresse;

    public Client(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public String getNom() {
        return this.nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String nouvelleAdresse) {
        this.adresse = nouvelleAdresse;
    }
}
