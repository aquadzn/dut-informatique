package banque;

import java.util.Scanner;

public class Menu {

    private static final Banque banque = new Banque ("Le Crédit Montreuillois");

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        Scanner saisie = new Scanner(System.in);
        int choix;

        do {
            System.out.println("----------------------------------------------");
            System.out.println("1. Créer un client");
            System.out.println("2. Créer un compte à partir d'un nom de client");
            System.out.println("3. Modifier adresse client");
            System.out.println("4. Modifier découvert max compte");
            System.out.println("5. Lister clients");
            System.out.println("6. Lister comptes");
            System.out.println("7. Lister comptes à découvert");
            System.out.println("8. Afficher l'état d'un compte");
            System.out.println("9. Créditer un compte");
            System.out.println("10. Débiter un compte");
            System.out.println("11. Faire un virement compte à compte");
            System.out.println("12. Quitter");
            System.out.println("----------------------------------------------");
            System.out.print("--> ");
            choix = saisie.nextInt();
        }
        while (choix != 12);

        switch(choix) {
            case 1:
                System.out.print("Nom: ");
                String nom = saisie.nextLine();
                System.out.print("Adresse: ");
                String adresse = saisie.nextLine();
                banque.ajouterClient(nom, adresse);
                break;

            case 2:
                System.out.print("Nom du client: ");
                nom = saisie.nextLine();
                System.out.print("Découvert max: ");
                int decouvert = saisie.nextInt();
                banque.créerCompte(nom, decouvert);
                break;

            case 3:
                System.out.print("Nom du client: ");
                nom = saisie.nextLine();
                System.out.print("Nouvelle adresse: ");
                adresse = saisie.nextLine();
                banque.modifierAdresseClient(nom, adresse);
                break;

            case 4:
                System.out.print("Numéro de compte: ");
                int numero = saisie.nextInt();
                System.out.print("Nouveau découvert: ");
                decouvert = saisie.nextInt();
                banque.modifierDecouvertMax(numero, decouvert);
                break;

            case 5:
                banque.listerCLients();
                break;

            case 6:
                banque.listerComptes();
                break;

            case 7:
                banque.comptesADécouvert();
                break;

            case 8:
                System.out.print("Numéro de compte: ");
                numero = saisie.nextInt();
                System.out.println(banque.étatCompte(numero));
                break;

            case 9:
                System.out.print("Numéro de compte: ");
                numero = saisie.nextInt();
                System.out.print("Montant: ");
                long montant = saisie.nextLong();
                banque.créditer(numero, montant);
                break;

            case 10:
                System.out.print("Numéro de compte: ");
                numero = saisie.nextInt();
                System.out.print("Montant: ");
                montant = saisie.nextLong();
                banque.débiter(numero, montant);
                break;

            case 11:

                break;

            default:
                System.out.println("Mauvais choix!");
                break;
        }

        nettoyerConsole();
    }

    public static void nettoyerConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println();
    }
}
