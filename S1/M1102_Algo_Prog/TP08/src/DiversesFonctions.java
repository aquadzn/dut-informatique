public class DiversesFonctions {

    /*
     * Retourne la valeur absolue d'un int.
     */
    public static int valAbs(int x) {
        int valAbs;
        if (x<0) {
            valAbs = -x;
        }
        else {
            valAbs = x;
        }
        return valAbs;
    }

    /*
     * Retourne true si x est égal à zéro.
     */
    public static boolean estNul (int x) {
        return x == 0;
    }

    /*
     * Retourne un nombre aléatoire pair compris entre 0 et 100 inclus.
     */
    public static int aleatoirePairEntre0et100inclus() {
        return 2*(int)(Math.random()*51);
    }

    /*
     * Retourne le signe d'un nombre
     */
    public static int signe(int a) {
        if (a > 0) {
            return 1;
        }
        else if (a < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }

    /*
     * Retourne vrai si un nombre est pair
     */
    public static boolean estPair(int a) {
        return a % 2 == 0;
    }

    /*
     * Retourne la plus grande des valeurs a, b et c
     */
    public static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    /*
     * Retourne
     */
    public static boolean auMoinsUnCaractere(String s) {
        return s.length() > 0;
    }

    /*
     * Retourne
     */
    public static boolean nombreBinaire(String s) {
        int longueur = s.length();
        if (longueur < 1) {
            return false;
        }

        for(int i = 0; i < longueur; i++) {
            if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                return false;
            }
        }

        return true;
    }

    /*
     * Retourne
     */
    public static int valeurEntierPositif(String nombreEntierPositif) {
        return (nombreEntierPositif.length() > 9 || nombreEntierPositif.charAt(0) == '-') ? -1 : Integer.parseInt(nombreEntierPositif);
    }

    /*
     * Retourne
     */
    public static int valeurNombreBinaire(String nombreBinaireNonSigne) {
        if (nombreBinaireNonSigne.length() > 30 || nombreBinaire(nombreBinaireNonSigne) == false) {
            return -1;
        }
        else {
            return Integer.parseInt(nombreBinaireNonSigne, 2);
        }
    }

    /*
     * Retourne
     */
    public static int pgcd(int a, int b) {
        int abs_a = valAbs(a);
        int abs_b = valAbs(b);
        int reste = 0;

        while (abs_b != 0) {
            reste = abs_a % abs_b;
            abs_a = abs_b;
            abs_b = reste;
        }
        return abs_a;
    }

    /*
     * Retourne
     */
//    public static String ecritureEnBase2NonSigne(int a) {
//        return ;
//    }

    /*
     * Retourne
     */
//    public static String ecritureEnBase2Signe(int a) {
//        return ;
//    }



}
