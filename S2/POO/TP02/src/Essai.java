public class Essai {
    public static void main(String[] args) {
        Client jean = new Client("Jean", "Paris");
        System.out.println(jean.getNom() + jean.getAdresse());
        jean.setAdresse("Lyon");
        System.out.println(jean.getNom() + jean.getAdresse());

        Compte compteJean = new Compte(jean);
        System.out.println(compteJean.getTitulaireNom());
        System.out.println(compteJean.getNumeroCompte());
        compteJean.afficherSolde();

        Client paul = new Client("Paul", "Marseille");
        Compte comptePaul = new Compte(paul);
        comptePaul.crediterSolde(25185); // 251.85
        comptePaul.debiterSolde(5033); // 50.33
        comptePaul.afficherSolde();

        Client john = new Client("John", "Bordeaux");
        Compte compteJohn = new Compte(john);

        System.out.println(compteJean.getNumeroCompte());
        System.out.println(comptePaul.getNumeroCompte());
        System.out.println(compteJohn.getNumeroCompte());

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

        LCM.afficherCompte(1);

        LCM.setClientAdresse("John", "Nantes");

        LCM.debiterCompte(1, 50057);
        LCM.crediterCompte(2, 5000);
        LCM.afficherCompte(2);
        LCM.crediterCompte(3, 45767);
        LCM.debiterCompte(3, 30050);
        LCM.afficherCompte(3);

        LCM.afficherComptesDecouvert();
    }
}
