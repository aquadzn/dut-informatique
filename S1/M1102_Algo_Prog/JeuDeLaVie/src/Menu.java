import java.util.Scanner;


public class Menu {

    /**
     * Lance le menu en affichant les différents scénarios possibles.
     */
    public static void lancer() {
        Scanner saisie = new Scanner(System.in);
        nettoyerConsole();

        System.out.print("Bienvenue dans ");
        System.out.print(Main.ANSI_BOLD + Main.ANSI_UNDERLINE + "Le jeu de la vie" + Main.ANSI_RESET);
        System.out.println("\n\nPar défaut, les tableaux sont de taille 20x60, 20% des cellules sont vivantes et le jeu se déroule sur 500 niveaux.");
        System.out.println("\nVous pouvez créer un tableau aléatoire avec les scénarios");
        System.out.println(Main.ANSI_BOLD + "\t[1] Aléatoire" + Main.ANSI_RESET);
        System.out.println(Main.ANSI_BOLD + "\t[2] Personnalisé" + Main.ANSI_RESET);
        System.out.println("ou utiliser les scénarios pré-définis");
        System.out.println(Main.ANSI_BOLD + "\t[3] Canon" + Main.ANSI_RESET + " ");
        System.out.println(Main.ANSI_BOLD + "\t[4] Planeur" + Main.ANSI_RESET + " ");
        System.out.println(Main.ANSI_BOLD + "\t[5] Vaisseau" + Main.ANSI_RESET + " ");
        System.out.println("\nPour quittez le jeu, appuyez sur CTRL-C");
        System.out.print("Choisissez un scénario ou appuyez sur entrée\n>>> ");

        String choixScenario = saisie.nextLine();

        nettoyerConsole();

        switch (choixScenario) {
            case "2":
                System.out.print("\nLongueur fenêtre\n>>> ");
                Main.LONGUEUR = saisie.nextInt();
                System.out.print("Hauteur fenêtre\n>>> ");
                Main.HAUTEUR = saisie.nextInt();
                System.out.print("Probabilité cellules vivantes (0.1...0.9)\n>>> ");
                Main.ALEATOIRE = saisie.nextDouble();
                System.out.print("Nombre de niveaux\n>>> ");
                Main.NIVEAUX = saisie.nextInt();

                if (!verifierValeurs(Main.LONGUEUR, Main.HAUTEUR, Main.ALEATOIRE, Main.NIVEAUX)) {
                    int[][] tab = Jeu.initialisation();
                    Jeu.demarrer("Personnalisé", tab, 300);
                }
                break;
            case "3":
                Main.LONGUEUR = 60;
                Main.HAUTEUR = 20;

                Jeu.demarrer("Canon", creerCanon(), 1000);
                break;
            case "4":
                Main.LONGUEUR = 60;
                Main.HAUTEUR = 20;

                Jeu.demarrer("Planeur", creerPlaneur(), 200);
                break;
            case "5":
                Main.LONGUEUR = 60;
                Main.HAUTEUR = 5;

                Jeu.demarrer("Vaisseau", creerVaisseau(), 250);
                break;
            default:
                int[][] tab = Jeu.initialisation();

                Jeu.demarrer("Aléatoire", tab, Main.NIVEAUX);
                break;
        }
        saisie.close();
    }

    /**
     * Nettoie la console.
     * Ne fonctionne pas sur les terminaux ne supportant pas ANSI.
     * https://stackoverflow.com/a/32295974
     */
    public static void nettoyerConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println();
    }

    /**
     * Vérifie que les valeurs optionnels entrées sont correctes.
     *
     * @param longueur longueur du jeu dans le terminal
     * @param hauteur hauteur du jeu dans le terminal
     * @param aleatoire valeur aléatoire pour remplir le tableau
     * @return faux si pas d'erreur vrai si erreur
     */
    public static boolean verifierValeurs(int longueur, int hauteur, double aleatoire, int niveau) {
        boolean erreur = false;

        if (longueur < 4 || hauteur < 4) {
            erreur = true;
            System.out.println("Les dimensions doivent avoir une valeur de 4x4 au minimum");
        }

        if (aleatoire <= 0. || aleatoire >= 1.) {
            erreur = true;
            System.out.println("La valeur aléatoire doit être comprise entre 0.0 et 1.0 exclus");
        }

        if (niveau < 1) {
            erreur = true;
            System.out.println("Il doit au moins y avoir un niveau");
        }

        return erreur;
    }

    /**
     * Crée le scénario du planeur.
     * @return tableau 2D
     */
    public static int[][] creerPlaneur() {
        int[][] planeur = new int[20][60];
        planeur[1][3] = 1;
        planeur[2][1] = 1;
        planeur[2][3] = 1;
        planeur[3][2] = 1;
        planeur[3][3] = 1;

        return planeur;
    }

    /**
     * Crée le scénario du vaisseau.
     * @return tableau 2D
     */
    public static int[][] creerVaisseau() {
        int[][] vaisseau = new int[5][60];
        vaisseau[1][1] = 1;
        vaisseau[1][2] = 1;
        vaisseau[1][3] = 1;
        vaisseau[1][4] = 1;
        vaisseau[2][0] = 1;
        vaisseau[2][4] = 1;
        vaisseau[3][4] = 1;
        vaisseau[4][0] = 1;
        vaisseau[4][3] = 1;

        return vaisseau;
    }

    /**
     * Crée le scénario du canon.
     * @return tableau 2D
     */
    public static int[][] creerCanon() {
        return new int[][] {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
    }

}
