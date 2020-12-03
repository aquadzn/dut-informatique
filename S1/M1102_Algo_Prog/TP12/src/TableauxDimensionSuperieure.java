public class TableauxDimensionSuperieure {

    public static int nbTrueDim2(boolean[][] tab) {
        int vrais = 0;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j]) {
                    vrais++;
                }
            }
        }
        return vrais;
    }

    public static int nbTrueDim4(boolean[][][][] tab) {
        int vrais = 0;
        for (int a = 0; a < tab.length; a++) {
            for (int b = 0; b < tab[a].length; b++) {
                for (int c = 0; c < tab[a][b].length; c++) {
                    for (int d = 0; d < tab[a][b][c].length; d++) {
                        if (tab[a][b][c][d]) {
                            vrais++;
                        }
                    }
                }
            }
        }
        return vrais;
    }

    public static boolean estPresentDim2(int[][] tab, int val) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] == val) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean estPresentDim4(int[][][][] tab, int val) {
        for (int a = 0; a < tab.length; a++) {
            for (int b = 0; b < tab[a].length; b++) {
                for (int c = 0; c < tab[a][b].length; c++) {
                    for (int d = 0; d < tab[a][b][c].length; d++) {
                        if (tab[a][b][c][d] == val) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void mettreLesNégatifsaZeroDim2(int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] < 0) {
                    tab[i][j] = 0;
                }
            }
        }
    }

    public static void mettreLesNégatifsaZeroDim4(int[][][][] tab) {
        for (int a = 0; a < tab.length; a++) {
            for (int b = 0; b < tab[a].length; b++) {
                for (int c = 0; c < tab[a][b].length; c++) {
                    for (int d = 0; d < tab[a][b][c].length; d++) {
                        if (tab[a][b][c][d] < 0) {
                            tab[a][b][c][d] = 0;
                        }
                    }
                }
            }
        }
    }

    public static int[] sommesLignes(int[][] tab) {
        int res[] = new int[tab.length];

        for (int i = 0; i < tab.length; i++) {
            int somme = 0;
            for (int j = 0; j < tab[i].length; j++) {
                somme += tab[i][j];
            }
            res[i] = somme;
        }
        return res;
    }

    public static int[] sommeZero(int[][] tab) {
        int res[] = new int[tab.length];

        for (int i = 0; i < tab.length; i++) {
            int somme = 0;
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] == 0) {
                    somme++;
                }
            }
            res[i] = somme;
        }
        return res;
    }

    public static boolean[] estPresentZero(int[][] tab) {
        boolean res[] = new boolean[tab.length];

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] == 0) {
                    res[i] = true;
                }
            }
        }
        return res;
    }


}
