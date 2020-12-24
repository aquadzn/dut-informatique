import java.util.Scanner;


public class Jeu {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void lancer() {

        Scanner saisie = new Scanner(System.in);
        int[][] tab = new int[Main.HAUTEUR][Main.LONGUEUR];
        int niveau = 0;

        nettoyerConsole();
        remplirTableau(tab, 0.1);

        afficherTableau(tab, niveau);

        System.out.print("Valider votre choix avec 'y' : --> ");
        String choix = saisie.nextLine();

        while (!choix.equals("y")) {

            remplirTableau(tab, 0.1);

            nettoyerConsole();
            afficherTableau(tab, niveau);

            System.out.print("Valider votre choix avec 'y' : --> ");
            choix = saisie.nextLine();
        }

        saisie.close();

        while (true) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tab = evolution(tab);
            niveau++;

            nettoyerConsole();
            afficherTableau(tab, niveau);

        }
    }


    public static int calculVoisins(int[][] tab, int ligne, int colonne) {
        int voisins = 0;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (tab[ligne + x][colonne + y] == Main.VIVANT) {
                    voisins += 1;
                }
            }
        }

        if (tab[ligne][colonne] == Main.VIVANT) {
            voisins -= 1;
        }

        return voisins;
    }


    public static int[][] evolution(int[][] tab) {

        int[][] nouveau_tab = new int[Main.HAUTEUR][Main.LONGUEUR];

        // Loop through every cell
        for (int l = 1; l < Main.HAUTEUR - 1; l++) {
            for (int m = 1; m < Main.LONGUEUR - 1; m++) {
                int voisins = calculVoisins(tab, l, m);

                // Implementing the Rules of Life

                // Cell is lonely and dies
                if ((tab[l][m] == Main.VIVANT) && (voisins < 2))
                    nouveau_tab[l][m] = Main.MORT;

                    // Cell dies due to over population
                else if ((tab[l][m] == Main.VIVANT) && (voisins > 3))
                    nouveau_tab[l][m] = Main.MORT;

                    // A new cell is born
                else if ((tab[l][m] == Main.MORT) && (voisins == 3))
                    nouveau_tab[l][m] = Main.VIVANT;

                    // Remains the same
                else
                    nouveau_tab[l][m] = tab[l][m];
            }
        }

        return nouveau_tab;
    }


    public static void nettoyerConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println();
    }


    public static void remplirTableau(int[][] tab, double valeur) {
        for (int ligne = 0 ; ligne < tab.length ; ligne++) {
            for (int colonne = 0 ; colonne < tab[ligne].length ; colonne++){
                if (Math.random() < valeur) {
                    tab[ligne][colonne] = Main.VIVANT;
                }
                else {
                    tab[ligne][colonne] = Main.MORT;
                }
            }
        }
    }


    public static void afficherTableau(int[][] tab, int niveau) {
        int population = 0;
        for (int ligne = 0 ; ligne < Main.HAUTEUR ; ligne++) {
            for (int colonne = 0 ; colonne < Main.LONGUEUR ; colonne++){
                switch (tab[ligne][colonne]) {
                    case 0:
                        System.out.print(ANSI_WHITE_BACKGROUND + "⠀" + ANSI_RESET);
                        break;
                    case 1:
                        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "█" + ANSI_RESET);
                        break;
                }
                if (tab[ligne][colonne] == Main.VIVANT) {
                    population++;
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Evolution niveau: " + niveau);
        System.out.println("Population: " + population);
        System.out.println();
    }

}
