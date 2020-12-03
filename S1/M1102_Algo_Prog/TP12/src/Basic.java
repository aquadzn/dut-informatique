public class Basic {

    public static void main(String[] args) {
        // déclaration, création et initialisation
        // d’un tableau à deux dimensions
        // qui représente une matrice
        // de hauteur 3 (la matrice comporte trois lignes)
        // de largeur 4 (la matrice comporte quatre colonnes)

//        char[][] tab3 = new char[4][7];
//        remplir(tab3, 'z');
//        afficherTableau(tab3);
        int[][] tab4 = new int[5][5];
        remplirTableauAvecDiagonale(tab4);
        afficherTableau(tab4);
    }

    public static void afficherTableau(int[][] t) {
        // boucle qui parcourt les lignes à afficher

        for (int ligne = 0 ; ligne < t.length ; ligne++) {
            // boucle qui, pour chaque ligne, parcourt les colonnes
            for (int colonne = 0 ; colonne < t[ligne].length ; colonne++){
                // affichage du contenu de la case située à la
                // ligne d’indice ligne et à la colonne d’indice colonne
                System.out.print(t[ligne][colonne] + "\t");
            }
            System.out.println();
        }
    }

    /*
     * Copie la valeur val dans toutes les cases du tableau.
     */
    public static void remplir (char[][] t , char val) {
        for (int i = 0; i < t.length; i++)
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = val;
            }
    }

    /*
     * Remplit le tableau à deux dimensions t avec
     * la valeur 1 sur la diagonale hautGauche-basDroit
     * et la valeur 0 partout ailleurs.
     * t doit être un tableau carré
     * (les deux dimensions doivent être de même longueur).
     */
    public static void remplirTableauAvecDiagonale (int[][] t) {
        for (int k = 0; k < t.length; k++) {
            t[k][k] = 1;
        }
    }



}
