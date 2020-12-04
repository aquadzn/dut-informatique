public class Matrices {

    public static void main(String[] args) {

        int[][] matA = new int[][] {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] matB = new int[][] {
            {7, 8, 9},
            {10, 11, 12}
        };

        int[][] matC = new int[][] {
            {1, 2},
            {3, 4},
            {5, 6},
        };

        afficherMatrice(matA, true);

        int[][] matA_t = transposee(matA);

        System.out.println("\nTransposée");
        afficherMatrice(matA_t, true);

        int[][] matAB = addition(matA, matB);

        System.out.println("\nAddition");
        afficherMatrice(matAB, false);

        int[][] matAxC = multiplication(matA, matC);

        System.out.println("\nMultiplication");
        afficherMatrice(matAxC, true);
    }

    public static void afficherMatrice(int[][] mat, boolean dim) {
        if (dim) {
            System.out.println("Matrice de taille\nx: " + mat[0].length + "\ny: " + mat.length + "\n");
        }
        for (int ligne = 0 ; ligne < mat.length ; ligne++) {
            for (int colonneonne = 0 ; colonneonne < mat[ligne].length ; colonneonne++){
                System.out.print(mat[ligne][colonneonne] + "\t");
            }
            System.out.println();
        }
    }


    public static int[][] transposee(int[][] mat) {
        // Les dimensions de la transposée sont le contraire de la matrice d'entrée
        int[][] transpose = new int[mat[0].length][mat.length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                transpose[j][i] = mat[i][j];
            }
        }

        return transpose;
    }

    public static int[][] addition(int[][] matA, int[][] matB) {
        int[][] res = new int[matA.length][matA[0].length];

        for (int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matA[i].length; j++) {
                res[i][j] = matA[i][j] + matB[i][j];
            }
        }

        return res;
    }

    public static int[][] multiplication(int[][] matA, int[][] matB) {
        /*
         * Matrice A de taille a x b
         * Matrice B de taille c x d
         * (ordre x - y)
         * ---------------------------
         * Matrice res de taille b x c
         */

        int[][] res = new int[matA.length][matB[0].length];

        for (int ligne = 0; ligne < res.length; ligne++) {
            for (int colonne = 0; colonne < res[ligne].length; colonne++) {
                for (int i = 0; i < matB.length; i++) {
                    res[ligne][colonne] += matA[ligne][i] * matB[i][colonne];
                }

            }
        }

        return res;
    }
}
