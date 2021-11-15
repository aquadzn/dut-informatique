package courrier;

public class AccuseDeReception extends CourrierContrainte {

    private String expediteur;

    public AccuseDeReception(Courrier courrier, String expediteur) {
        super(courrier.getDestinataire(), courrier);
        this.expediteur = expediteur;
    }

    public String getExpediteur() {
        return expediteur;
    }

    @Override
    public boolean auxNormes() {
        return getCourrier().auxNormes() && this.expediteur != null;
    }

    @Override
    public double coutAffranchissement() {
        return getCourrier().coutAffranchissement();
    }
}
