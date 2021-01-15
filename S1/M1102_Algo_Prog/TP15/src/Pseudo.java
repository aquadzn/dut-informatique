import java.util.Scanner;
import java.util.ArrayList;

public class Pseudo {

    public static void main(String[] args) {
        Scanner saisie = new Scanner(System.in);

        String affichage = "------------------- Menu --------------------\n" +
            "1. Ajouter un pseudo.\n" +
            "2. Supprimer un pseudo.\n" +
            "3. Compter le nombre de pseudos.\n" +
            "4. Afficher la liste des pseudos.\n" +
            "5. Compter le nombre de pseudos contenant 'a'.\n" +
            "6. Afficher les pseudos commencant par 'a'.\n" +
            "7. Supprimer les pseudos contenant 007.\n" +
            "8. Afficher la longueur des pseudos.\n" +
            "9. Quitter.";

        int choix;
        ArrayList<String> pseudos = new ArrayList<>();

        do {
            System.out.println(affichage);
            System.out.println("Votre choix:");
            System.out.print(">>> ");
            choix = saisie.nextInt();
            saisie.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Entrez un pseudo (2-20 charactères) : ");
                    String pseudoAjoute = saisie.nextLine();
                    ajouterPseudo(pseudos, pseudoAjoute);
                    break;
                case 2:
                    System.out.print("Entrez un pseudo à supprimer : ");
                    String pseudoSupprime = saisie.nextLine();
                    supprimerPseudo(pseudos, pseudoSupprime);
                    break;
                case 3:
                    afficherNombrePseudos(pseudos);
                    break;
                case 4:
                    afficherListePseudos(pseudos);
                    break;

                case 5:
                    afficherNombrePseudosContenantA(pseudos);
                    break;

                case 6:
                    afficherPseudosCommencantParA(pseudos);
                    break;

                case 7:
                    supprimerPseudo007(pseudos);
                    break;

                case 8:
                    afficherLongueurPseudos(pseudos);
                    break;

                case 9:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Option non valide.");
                    break;
            }
        } while (choix != 9);

    }

    public static void ajouterPseudo(ArrayList<String> listePseudos, String pseudo) {
        if (pseudo.length() > 2 && pseudo.length() < 20) {
            if ( ! listePseudos.contains(pseudo) ) {
                listePseudos.add(pseudo);
                System.out.println("Pseudo ajouté");
            }
            else {
                System.out.println("Pseudo déjà présent");
            }
        }
        else {
            System.out.println("Trop petit / trop grand.");
        }
    }

    public static void supprimerPseudo(ArrayList<String> listePseudos, String pseudo) {
        if (listePseudos.contains(pseudo)) {
            listePseudos.remove(pseudo);
            System.out.println("Pseudo supprimé");
        }
        else {
            System.out.println("Le pseudo pas dans la liste.");
        }
    }

    public static void afficherNombrePseudos(ArrayList<String> listePseudos) {
        System.out.println("Nombre de pseudos: " + listePseudos.size());
    }

    public static void afficherListePseudos(ArrayList<String> listePseudos) {
        for (String pseudo : listePseudos) {
            System.out.println(pseudo);
        }
    }

    public static void afficherNombrePseudosContenantA(ArrayList<String> listePseudos) {
        int somme = 0;
        for (String pseudo : listePseudos) {
            if (pseudo.contains("a")) {
                somme++;
            }
        }
        System.out.println("Pseudo contenant la lettre 'a' : " + somme);
    }

    public static void afficherPseudosCommencantParA(ArrayList<String> listePseudos) {
        for (String pseudo : listePseudos) {
            if (pseudo.charAt(0) == 'a') {
                System.out.println(pseudo);
            }
        }
    }

    public static void supprimerPseudo007(ArrayList<String> listePseudos) {
        listePseudos.removeIf(pseudo -> pseudo.contains("007"));
    }

    public static void afficherLongueurPseudos(ArrayList<String> listePseudos) {
        for (String pseudo : listePseudos) {
            System.out.println("Longeur de " + pseudo + " : " + pseudo.length());
        }
    }
}
