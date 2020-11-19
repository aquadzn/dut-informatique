public class EncoreDesMethodesSurDesTableaux {

//    public static void main(String args) {
//        double[] tabLongZéro = new double[0]; // création d’un tableau de longueur zéro
//        System.out.println(moyenne(tabLongZéro));
//    }

    public static double moyenne(double[] tab) {
        double sum = 0;
        for(double i : tab) {
            sum += i;
        }
        return sum / tab.length;
    }

    public static double plusGrand(double[] tab) {
        double max = tab[0];
        for (double i : tab) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static boolean égaux(int[] tabA, int[] tabB) {
        if (tabA.length != tabB.length) {
            return false;
        }

        for(int i = 0; i < tabA.length; i++) {
            if (tabA[i] != tabB[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] sommeMêmeLongueur(int[] tabA, int[] tabB) {
        int length = tabA.length;
        if (length != tabB.length) {
            return new int[] {-1};
        }

        int[] tabRes = new int[length];
        for (int i = 0; i < length; i++) {
            tabRes[i] = (tabA[i] + tabB[i]);
        }
        return tabRes;
    }

 /*   public static int[] somme(int[] tabA, int[] tabB) {
        int lengthA = tabA.length;
        int lengthB = tabB.length;
        if (lengthA != lengthB) {
            return new int[] {-1};
        }

        int[] tabRes = new int[length];
        for (int i = 0; i < length; i++) {
            tabRes[i] = (tabA[i] + tabB[i]);
        }
        return tabRes;
    }*/

    public static int[] positifs(int[] tab) {
        int zeros = 0;
        for (int i : tab) {
            if (i < 0) {
                zeros++;
            }
        }

        int[] tabRes = new int[tab.length - zeros];
        for (int j = 0; j < tab.length; j++) {
            if (tab[j] >= 0) {
                tabRes[j] = tab[j];
            }
        }

        return tabRes;
    }

}
