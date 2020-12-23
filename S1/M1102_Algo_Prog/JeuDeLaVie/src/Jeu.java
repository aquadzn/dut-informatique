import java.util.Scanner;


public class Jeu {

    public static void lancer() {

        Scanner saisie = new Scanner(System.in);
        char[][] tab = new char[Main.HAUTEUR][Main.LONGUEUR];
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
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tab = evolution(tab);
            niveau++;

            nettoyerConsole();
            afficherTableau(tab, niveau);

        }
    }


    public static char[][] evolution(char[][] tab) {

        char[][] nouveau_tab = new char[Main.HAUTEUR][Main.LONGUEUR];

        // Loop through every cell
        for (int l = 1; l < Main.HAUTEUR - 1; l++) {
            for (int m = 1; m < Main.LONGUEUR - 1; m++) {
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        if (tab[l + i][m + j] == Main.VIVANT) {
                            aliveNeighbours += 1;
                        }

                // The cell needs to be subtracted from
                // its neighbours as it was counted before
                if (tab[l][m] == Main.VIVANT) {
                    aliveNeighbours -= 1;
                }

                // Implementing the Rules of Life

                // Cell is lonely and dies
                if ((tab[l][m] == Main.VIVANT) && (aliveNeighbours < 2))
                    nouveau_tab[l][m] = Main.MORT;

                    // Cell dies due to over population
                else if ((tab[l][m] == Main.VIVANT) && (aliveNeighbours > 3))
                    nouveau_tab[l][m] = Main.MORT;

                    // A new cell is born
                else if ((tab[l][m] == Main.MORT) && (aliveNeighbours == 3))
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
    }


    public static void remplirTableau(char[][] tab, double valeur) {
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


    public static void afficherTableau(char[][] tab, int niveau) {
        int population = 0;
        for (int ligne = 0 ; ligne < Main.HAUTEUR ; ligne++) {
            for (int colonne = 0 ; colonne < Main.LONGUEUR ; colonne++){
                System.out.print(tab[ligne][colonne]);
                if (tab[ligne][colonne] == Main.VIVANT) {
                    population++;
                }
            }
            System.out.println();
        }
        System.out.println("Evolution niveau: " + niveau);
        System.out.println("Population: " + population);
    }

}
