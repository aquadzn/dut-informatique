/*
* William JACQUES
* B1
* 12 / 12 tests réussis
*/
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
     * c.
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
     * d.
     * Retourne vrai si un nombre est pair
     */
    public static boolean estPair(int a) {
        return a % 2 == 0;
    }

    /*
     * e.
     * Retourne la plus grande des valeurs a, b et c
     */
    public static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    /*
     * f.
     * Retourne vrai si s contient au moins un caractère (longueur >0)
     */
    public static boolean auMoinsUnCaractere(String s) {
        return s.length() > 0;
    }

    /*
     * g.
     * Retourne vrai si s contient un nombre écrit en base 2 (s est composée des caractères '0' et '1')
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
     * h.
     * Retourne la valeur d'un entier positif reçu en paramètre sous la forme d'un type String représentant
     * un nombre entier positif de 9 chiffres au maximum
     */
    public static int valeurEntierPositif(String nombreEntierPositif) {
        return (nombreEntierPositif.length() > 9 || nombreEntierPositif.charAt(0) == '-') ? -1 : Integer.parseInt(nombreEntierPositif);
    }

    /*
     * i.
     * Retourne la valeur d'un nombre reçu en paramètre sous la forme d'un type String représentant
     * un nombre binaire (entier non signé) de 30 bits au maximum.
     */
    public static int valeurNombreBinaire(String nombreBinaireNonSigne, boolean rapide) {
        if (nombreBinaireNonSigne.length() > 30 || !nombreBinaire(nombreBinaireNonSigne)) {
            return -1;
        }
        else {
            if (rapide) {
                // Méthode avec Integer.parseInt (plus rapide)
                return Integer.parseInt(nombreBinaireNonSigne, 2);
            }
            else {
                // Méthode hardcodé (plus lent)
                int resultat = 0;
                int longueur = nombreBinaireNonSigne.length();

                for(int i = 0; i < longueur; i++) {
                    if (nombreBinaireNonSigne.charAt(i) == '1') {
                        resultat += Math.pow(2, (longueur - i - 1));
                    }
                }

                return resultat;
            }
        }
    }

    /*
     * j.
     * Retourne le pgcd de la valeur absolue de a et de la valeur absolue de
     */
    public static int pgcd(int a, int b) {
        int abs_a = valAbs(a);
        int abs_b = valAbs(b);

        while (abs_b != 0) {
            int reste = abs_a % abs_b;
            abs_a = abs_b;
            abs_b = reste;
        }
        return abs_a;
    }

    /*
     * k.
     * Retourne l'écriture en base 2 de la valeur absolue de a
     */
    public static String ecritureEnBase2NonSigne(int a, boolean rapide) {
        if (a > 255 || a < 0) {
            return "Erreur, nombre trop grand ou négatif";
        }
        else if (a == 0) {
            return "0";
        }
        else {
            int abs_a = valAbs(a);

            if (rapide) {
                // Méthode optimisée
                return Integer.toBinaryString(abs_a);
            }
            else {
                // Méthode hardcodé (plus lente)
                StringBuilder resultat = new StringBuilder("        ");
                int longueur = resultat.length();

                for(int i = longueur - 1; abs_a != 0; i--) {
                    int reste = abs_a % 2;
                    abs_a /= 2;
                    resultat.setCharAt(i, (char) (reste + '0'));
                }

                // On convertir StringBuilder en String et on enlève tous les espaces blancs
                return resultat.toString().replaceAll("\\s", "");
            }
        }
    }

    /*
     * l.
     * Retourne l'écriture en base 2 sur 32 bits de l'entier signé a (complément à 2)
     */
//    public static String ecritureEnBase2Signe(int a) {
//        return ;
//    }



}
