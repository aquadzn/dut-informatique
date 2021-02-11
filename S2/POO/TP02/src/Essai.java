public class Essai {
    public static void main(String[] args) {
        Client jean = new Client("Jean", "Paris");
        System.out.println(jean.getNom() + jean.getAdresse());
        jean.setAdresse("Lyon");
        System.out.println(jean.getNom() + jean.getAdresse());

        Compte compteJean = new Compte(jean, 1234);
        System.out.println(compteJean.getTitulaireNom());
        System.out.println(compteJean.getNumeroCompte());
        System.out.println(compteJean.getBalance());

        Client paul = new Client("Paul", "Marseille");
        Compte comptePaul = new Compte(paul, 5678);
        comptePaul.crediterSolde(200);
        comptePaul.debiterSolde(50);
        System.out.println(comptePaul.getBalance());

        Client john = new Client("John", "Bordeaux");
        Compte compteJohn = new Compte(john, 9101112);

        // Banque

        Banque LCM = new Banque("Le Crédit Montreuillois");
        LCM.addClient(jean);
        LCM.addClient(paul);
        LCM.addClient(john);
        LCM.addCompte(compteJean);
        LCM.addCompte(comptePaul);
        LCM.addCompte(compteJohn);

        LCM.getNbClients();
        LCM.getNbComptes();

        LCM.afficherClients();
        LCM.afficherComptes();

        LCM.afficherCompte(1234);

        LCM.setClientAdresse("John", "Nantes");

        LCM.crediterCompte(9101112, 50);
        LCM.debiterCompte(5678, 300);

        LCM.afficherComptesDecouvert();
    }
}
