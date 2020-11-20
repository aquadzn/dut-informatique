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
        double res = sum / tab.length;
        return Double.isNaN(res) ? 0 : res;
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

    public static int[] somme(int[] tabA, int[] tabB) {
        int lengthA = tabA.length;
        int lengthB = tabB.length;

        int[] tabRes = new int[Math.max(lengthA, lengthB)];

        for (int i = 0; i < tabRes.length; i++) {
            if (tabA.length > i) {
                tabRes[i] += tabA[i];
            }
            if (tabB.length > i) {
                tabRes[i] += tabB[i];
            }
        }

        return tabRes;
    }

    public static int[] positifs(int[] tab) {
        int negatives = 0;
        for (int t : tab) {
            if (t <= -1) {
                negatives++;
            }
        }

        int[] tabRes = new int[tab.length  - negatives];
        int indexTabRes = 0;

        for (int i : tab) {
            if (i >= 0) {
                tabRes[indexTabRes] = i;
                indexTabRes++;
            }
        }

        return tabRes;
    }

}
