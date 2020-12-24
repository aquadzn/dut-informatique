import java.util.Scanner;


public class Jeu {

    // Code ANSI pour la couleur dans le terminal
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    /**
     * Lance le jeu.
     */
    public static void lancer() {

        Scanner saisie = new Scanner(System.in);
        int[][] tab = new int[Main.HAUTEUR][Main.LONGUEUR];
        int niveau = 0;

        nettoyerConsole();
        remplirTableau(tab, Main.ALEATOIRE);

        afficherTableau(tab, niveau);

        afficherParametres();
        String choix = saisie.nextLine();

        while (!choix.equals("y")) {

            remplirTableau(tab, Main.ALEATOIRE);

            nettoyerConsole();
            afficherTableau(tab, niveau);

            afficherParametres();
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

    /**
     * Affiche les paramètres du jeu utilisés
     * et demande la validation pour lancer le jeu.
     */
    public static void afficherParametres() {
        System.out.println("Paramètres: " + Main.LONGUEUR + "x" + Main.HAUTEUR + ", " + (Main.ALEATOIRE * 100) + "% de vivants");
        System.out.print("Valider votre choix avec 'y' : --> ");
    }

    /**
     * Compte le nombre de voisins dans un tableau
     * pour une ligne et une colonne donnée.
     * Retourne un entier.
     * 
     * @param tab tableau 2D à parcourir
     * @param ligne ligne à parcourir
     * @param colonne colonne à parcourir
     * @return nombre de voisins trouvés
     */
    public static int calculVoisins(int[][] tab, int ligne, int colonne) {
        int voisins = 0;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (tab[ligne + x][colonne + y] == 1) {
                    voisins += 1;
                }
            }
        }

        if (tab[ligne][colonne] == 1) {
            voisins -= 1;
        }

        return voisins;
    }

    /**
     * Complète une évolution pour un tableau d'entier donné
     * en calculant pour chaque élément du tableau ses voisins
     * puis en appliquant les règles du jeu pour cet élément.
     * Retourne un nouveau tableau d'entier après évolution.
     * 
     * @param tab tableau 2D à parcourir
     * @return tableau 2D après évolution
     */
    public static int[][] evolution(int[][] tab) {
        
        int[][] nouveau_tab = new int[Main.HAUTEUR][Main.LONGUEUR];

        for (int ligne = 1; ligne < Main.HAUTEUR - 1; ligne++) {
            for (int colonne = 1; colonne < Main.LONGUEUR - 1; colonne++) {
                int voisins = calculVoisins(tab, ligne, colonne);

                // Règles du jeu
                // =============
                // Cellule vivante
                if (tab[ligne][colonne] == 1) {
                    // Si <2 voisins ou >3 voisins Alors morte sinon pareil
                    nouveau_tab[ligne][colonne] = (voisins < 2 || voisins > 3) ? 0 : tab[ligne][colonne];
                }
                // Cellule morte
                else {
                    // Si exactement trois voisins Alors vivante sinon pareil
                    nouveau_tab[ligne][colonne] = (voisins == 3) ? 1 : tab[ligne][colonne];
                }

            }
        }

        return nouveau_tab;
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
     * Rempli un tableau 2D donnée de façon aléatoire
     * avec des 0 et des 1 selon une probabilité donnée.
     * 
     * @param tab tableau 2D à parcourir
     * @param valeur probabilité utilisée pour 1
     */
    public static void remplirTableau(int[][] tab, double valeur) {
        for (int ligne = 0 ; ligne < tab.length ; ligne++) {
            for (int colonne = 0 ; colonne < tab[ligne].length ; colonne++){
                if (Math.random() < valeur) {
                    tab[ligne][colonne] = 1;
                }
                else {
                    tab[ligne][colonne] = 0;
                }
            }
        }
    }

    /**
     * Affiche un le jeu, le niveau actuel ainsi que la population
     * à partir d'un tableau 2D et d'un niveau donnés.
     * Remplace les 0 et les 1 par des symboles ASCII colorés.
     * 
     * @param tab tableau 2D à parcourir
     * @param niveau niveau actuel
     */
    public static void afficherTableau(int[][] tab, int niveau) {
        int population = 0;
        for (int ligne = 0 ; ligne < Main.HAUTEUR ; ligne++) {
            for (int colonne = 0 ; colonne < Main.LONGUEUR ; colonne++){
                switch (tab[ligne][colonne]) {
                    case 0:
                        System.out.print(ANSI_WHITE_BACKGROUND + Main.MORT + ANSI_RESET);
                        break;
                    case 1:
                        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + Main.VIVANT + ANSI_RESET);
                        break;
                }
                if (tab[ligne][colonne] == 1) {
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
