import java.util.Scanner;


public class Jeu {

    /**
     * Initialise le tableau à utiliser avec les différents paramètres
     * avant de démarrer le jeu.
     *
     * @return tableau 2D initialisé
     */
    public static int[][] initialisation() {
        Scanner saisie = new Scanner(System.in);
        int[][] tab = new int[Main.HAUTEUR][Main.LONGUEUR];

        Menu.nettoyerConsole();
        remplirTableau(tab, Main.ALEATOIRE);

        afficherTableau("Aléatoire", tab, 0);

        afficherParametres();
        String choix = saisie.nextLine();

        while (!choix.equals("y")) {

            remplirTableau(tab, Main.ALEATOIRE);

            Menu.nettoyerConsole();
            afficherTableau("Aléatoire", tab, 0);

            afficherParametres();
            choix = saisie.nextLine();
        }
        saisie.close();
        Menu.nettoyerConsole();

        return tab;
    }

    /**
     * Démarre le jeu avec un scénario, un tableau et le niveau max à atteindre.
     *
     * @param scenario scénario aléatoire, personnalisé ou prédéfini
     * @param tab tableau 2D à utiliser
     * @param niveauMax nombre de niveaux avant d'arrêter le jeu
     */
    public static void demarrer(String scenario, int[][] tab, int niveauMax) {
        afficherTableau(scenario, tab, 0);

        for (int niveau = 0; niveau < niveauMax; niveau++) {

            // équivalent de time.sleep() en Python
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tab = evolution(tab, Main.HAUTEUR, Main.LONGUEUR);
            niveau++;

            Menu.nettoyerConsole();
            afficherTableau(scenario, tab, niveau);

        }
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

        // On vérifie en partant de la cellule centrale
        // si elle a des cellules voisines vivantes en
        // tenant compte des bordures avec une exception
        // qui ne fait rien (bad practice mais ça marche)
        //
        // 0 0 0
        // 0 1 0
        // 0 0 0

        // Haut gauche
        try{
            if(tab[ligne - 1][colonne - 1] == 1){
                voisins++;}
        }
        catch(ArrayIndexOutOfBoundsException ignored) {
        }

        // Haut milieu
        try {
            if (tab[ligne - 1][colonne] == 1){
                voisins++;}
        }
        catch(ArrayIndexOutOfBoundsException ignored) {
        }

        // Haut droite
        try {
            if (tab[ligne - 1][colonne + 1] == 1){
                voisins++;}
        }
        catch(ArrayIndexOutOfBoundsException ignored) {
        }

        // Milieu gauche
        try {
            if (tab[ligne][colonne - 1] == 1){
                voisins++;}
        }
        catch(ArrayIndexOutOfBoundsException ignored) {
        }

        // Milieu droite
        try {
            if (tab[ligne][colonne + 1] == 1){
                voisins++;}
        }
        catch(ArrayIndexOutOfBoundsException ignored) {
        }

        // Bas gauche
        try {
            if (tab[ligne + 1][colonne - 1] == 1){
                voisins++;}
        }
        catch(ArrayIndexOutOfBoundsException ignored) {
        }

        // Bas milieu
        try {
            if (tab[ligne + 1][colonne] == 1){
                voisins++;}
        }
        catch(ArrayIndexOutOfBoundsException ignored) {
        }

        // Bas droite
        try {
            if (tab[ligne + 1][colonne + 1] == 1){
                voisins++;
            }
        }
        catch(ArrayIndexOutOfBoundsException ignored) {
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
     * @param hauteur hauteur du tableau
     * @param longueur longueur du tableau
     * @return tableau 2D après évolution
     */
    public static int[][] evolution(int[][] tab, int hauteur, int longueur) {

        int[][] nouveau_tab = new int[hauteur][longueur];

        for (int ligne = 0; ligne < hauteur; ligne++) {
            for (int colonne = 0; colonne < longueur; colonne++) {

                int voisins = calculVoisins(tab, ligne, colonne);

                // Règles du jeu
                // =============
                // Cellule vivante
                if (tab[ligne][colonne] == 1 && (voisins < 2 || voisins > 3)) {
                    nouveau_tab[ligne][colonne] = 0;
                }
                // Cellule morte
                else if (tab[ligne][colonne] == 0 && voisins == 3) {
                    nouveau_tab[ligne][colonne] = 1;
                }
                // Autre
                else {
                    nouveau_tab[ligne][colonne] = tab[ligne][colonne];
                }

            }
        }

        return nouveau_tab;
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
     * Affiche les paramètres du jeu utilisés
     * et demande la validation pour démarrer le jeu.
     */
    public static void afficherParametres() {
        System.out.println("Paramètres: " + Main.LONGUEUR + "x" + Main.HAUTEUR + ", " + (Main.ALEATOIRE * 100) + "% de vivants");
        System.out.print("Valider votre choix avec 'y' : --> ");
    }

    /**
     * Affiche un le jeu, le scénario choisi, le niveau actuel
     * ainsi que la population.
     * Remplace les 0 et les 1 par des symboles ASCII colorés.
     *
     * @param scenario scénario utilisé
     * @param tab tableau 2D à parcourir
     * @param niveau niveau actuel
     */
    public static void afficherTableau(String scenario, int[][] tab, int niveau) {
        int population = 0;
        for (int ligne = 0 ; ligne < Main.HAUTEUR ; ligne++) {
            for (int colonne = 0 ; colonne < Main.LONGUEUR ; colonne++){
                switch (tab[ligne][colonne]) {
                    case 0:
                        System.out.print(
                            Main.ANSI_WHITE_BACKGROUND + Main.MORT + Main.ANSI_RESET
                        );
                        break;
                    case 1:
                        System.out.print(
                            Main.ANSI_WHITE_BACKGROUND + Main.ANSI_BLACK + Main.VIVANT + Main.ANSI_RESET
                        );
                        break;
                }
                if (tab[ligne][colonne] == 1) {
                    population++;
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Scénario: " + scenario);
        System.out.println("Evolution niveau: " + niveau);
        System.out.println("Population: " + population);
        System.out.println();
    }

}
