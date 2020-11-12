import java.util.Scanner;


public class FonctionsSurTableaux {
    public static int nbOccurrences(int[] tab, int val) {
        int occ = 0;
        for (int i : tab) {
            if (i == val) {
                occ++;
            }
        }
        return occ;
    }

    public static int nbStrictementNegatifs(int[] tab) {
        int neg = 0;
        for (int i : tab) {
            if (i < 0) {
                neg++;
            }
        }
        return neg;
    }

    public static int sommeValeurs(int[] tab) {
        int somme = 0;
        for (int i : tab) {
            somme += i;
        }
        return somme;
    }

    public static boolean estPresent(int[] tab, int val) {
        for (int i : tab) {
            if (i == val) {
                return true;
            }
        }
        return false;
    }

    public static boolean tousPositifs(int[] tab) {
        for (int i : tab) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

  /*  public static void main() {
        Scanner saisie = new Scanner(System.in);
        System.out.print();



        saisie.close();
    }*/

    public static int indicePremOccurrence(int[] tab, int val) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static int indiceDernOccurrence(int[] tab, int val) {
        for (int i = tab.length - 1; i >= 0; i--) {
            if (tab[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static int nbOccurrences(int[] tab, int min, int max) {
        if (min > max) {
            return -1;
        }
        else {
            int occ = 0;
            for (int i : tab) {
                if (i >= min && i <= max ) {
                    occ++;
                }
            }
            return occ;
        }
    }

    public static double plusGrandPositif(double[] tab) {
        if (tab.length == 0) {
            return -1;
        }

        boolean auMoinsUnPositif = false;
        for (double d : tab) {
            if (d >= 0) {
                auMoinsUnPositif = true;
                break;
            }
        }
        if (!auMoinsUnPositif) {
            return -1;
        }
        else {
            double max = tab[0];
            for (int i = 0; i < tab.length; i++) {
                if (tab[i] > max) {
                    max = tab[i];
                }
            }
            return max;
        }
    }

}
