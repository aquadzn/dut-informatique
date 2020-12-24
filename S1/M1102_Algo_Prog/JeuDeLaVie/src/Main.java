public class Main {

    // Paramètres du jeu
    public static int LONGUEUR = 60;
    public static int HAUTEUR = 20;
    public static double ALEATOIRE = 0.2;
    // Constantes
    public static final char MORT = '_';
    public static final char VIVANT = '#';

    /**
     * Programme principal du jeu de la vie.
     * 
     * @param args arguments CLI
     */
    public static void main(String[] args) {
        menu(args);
    }

    /**
     * Affiche le menu principal du jeu.
     * 
     * @param args paramètres optionnels du jeu
     */
    public static void menu(String args[]) {
        if (args.length == 0) {
            Jeu jeu = new Jeu();
            jeu.lancer();
        }
        else {
            if (args[0].equals("help")) {
                System.out.println("Main.class");
                System.out.println("==========");
                System.out.println("\nUtilisation");
                System.out.println("===========");
                System.out.println("\tjava Main");
                System.out.println("\tjava Main 80");
                System.out.println("\tjava Main 80 30");
                System.out.println("\tjava Main 80 0.3\n");
                System.out.println("Arguments optionnels");
                System.out.println("====================");
                System.out.println("\tLONGUEUR [int] : Longueur de la fenêtre de jeu");
                System.out.println("\tHauteur [int] : Hauteur de la fenêtre de jeu");
                System.out.println("\tALEATOIRE [double] : Valeur aléatoire cellules vivantes (0-1)\n");
            }
            else {
                switch (args.length) {
                    case 1:
                        LONGUEUR = Integer.parseInt(args[0]);
                        break;
                    case 2:
                        LONGUEUR = Integer.parseInt(args[0]);
                        HAUTEUR = Integer.parseInt(args[1]);
                        break;
                    case 3:
                        LONGUEUR = Integer.parseInt(args[0]);
                        HAUTEUR = Integer.parseInt(args[1]);
                        ALEATOIRE = Double.parseDouble(args[2]);   
                        break;
                    default:
                        break;
                }

                if (!verifierValeurs(LONGUEUR, HAUTEUR, ALEATOIRE)) {
                    Jeu jeu = new Jeu();
                    jeu.lancer();
                }
            }
        }
    }

    /**
     * Vérifie que les valeurs optionnels entrées sont correctes.
     * 
     * @param longueur longueur du jeu dans le terminal
     * @param hauteur hauteur du jeu dans le terminal
     * @param aleatoire valeur aléatoire pour remplir le tableau
     * @return faux si pas d'erreur vrai si erreur
     */
    public static boolean verifierValeurs(int longueur, int hauteur, double aleatoire) {
        boolean erreur = false;

        if (longueur < 4 || hauteur < 4) {
            erreur = true;
            System.out.println("Les dimensions doivent avoir une valeur de 4x4 au minimum");
        }

        if (aleatoire <= 0. || aleatoire >= 1.) {
            erreur = true;
            System.out.println("La valeur aléatoire doit être comprise entre 0.0 et 1.0 exclus");
        }

        return erreur;
    }

}
