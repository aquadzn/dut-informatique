package banque;

public class Essai {

    public static void main(String[] args) throws CompteException {
        Client antoine = new Client ("Antoine", "222 rue de la Paix");
        Compte compteAntoine = new Compte(123, antoine, 10000);
        compteAntoine.créditer(3456);
        System.out.println(compteAntoine);

        Client jean = new Client ("Jean", "1 Rue de la Paix");
        Compte compteJean = new Compte(321, jean, 10000);

        compteAntoine.débiter(10000000);


        compteAntoine.virer(compteJean, 1456);
        System.out.println(compteAntoine);
        System.out.println(compteJean);

/*        Banque banque = new Banque ("Le Crédit Montreuillois");
        banque.ajouterClient("Bébert", "Nantes");
        banque.ajouterClient("Ludivine", "Chamonix");
        banque.créerCompte("Bébert", 10000);
        banque.créerCompte("Ludivine", 10000);
        banque.créerCompte("Ludivine", 10000);
        System.out.println(banque.listerCLients());
        System.out.println(banque.listerComptes());
        banque.créditer(2, 10000);
        System.out.println(banque.étatCompte(2));
        banque.débiter(1, 20000);
        System.out.println(banque.étatCompte(1));
        banque.modifierAdresseClient("Bébert", "Marseille");
        System.out.println(banque.listerCLients());
        System.out.println(banque.comptesADécouvert());*/





    }

}
