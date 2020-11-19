import java.util.Scanner;


public class Menu {

    public static void run() {
        Scanner saisie = new Scanner(System.in);
        System.out.println("-------- Système de gestion de notes --------");
        int etudiants;

        do {
            System.out.println("Entrez le nombre d'étudiants");
            System.out.print(">>> ");
            etudiants = saisie.nextInt();
        } while (etudiants <= 0);

        double[] notes = new double[etudiants];

        for (int i = 0; i < etudiants; i++) {
            System.out.println("Note étudiant " + (i + 1));
            System.out.print(">>> ");
            notes[i] = saisie.nextDouble();
        }

        String affichage = "------------------- Menu --------------------\n" +
                "1. Afficher le nombre d'étudiants.\n" +
                "2. Afficher toutes les notes.\n" +
                "3. Afficher la moyenne de la promotion.\n" +
                "4. Afficher si toutes les notes sont supérieures à un seuil.\n" +
                "5. Quitter.";

        int choix;
        do {
            System.out.println(affichage);
            System.out.println("Votre choix:");
            System.out.print(">>> ");
            choix = saisie.nextInt();

            switch (choix) {
                case 1:
                    Utils.nombreEtudiants(etudiants);
                    break;
                case 2:
                    Utils.listeNotes(notes);
                    break;
                case 3:
                    Utils.moyenneNotes(notes);
                    break;
                case 4:
                    System.out.print("Seuil de validation: ");
                    double seuil = saisie.nextDouble();
                    Utils.seuilNotes(notes, seuil);
                    break;
                case 5:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Option non valide.");
                    break;
            }
        } while (choix != 5);

        saisie.close();
    }

}
