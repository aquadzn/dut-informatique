package courrier;

public class Main {
    public static void main(String[] args) {
        Lettre lettre = new Lettre("paul");
        Colis colis = new Colis("pierre", 10000);

        System.out.println("Lettre: " + lettre.auxNormes() + " - " + lettre.coutAffranchissement());
        System.out.println("Colis: " + colis.auxNormes() + " - " + colis.coutAffranchissement());

        Urgent lettreUrgente = new Urgent(lettre);
        AccuseDeReception accuseDeReception = new AccuseDeReception(colis, "jean");

        System.out.println("Lettre urgente: " + lettreUrgente.auxNormes() + " - " + lettreUrgente.coutAffranchissement());
        System.out.println("Colis accusé: " + accuseDeReception.auxNormes() + " - " + accuseDeReception.coutAffranchissement());
    }
}
