public class Main {

    // Paramètres du jeu
    public static int LONGUEUR = 60;
    public static int HAUTEUR = 20;
    public static double ALEATOIRE = 0.2;
    public static int NIVEAUX = 500;

    // Constantes
    public static final char MORT = '_';
    public static final char VIVANT = '#';
    // Code ANSI pour la couleur dans le terminal
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BOLD = "\u001b[1m";
    public static final String ANSI_UNDERLINE = "\u001b[4m";

    /**
     * Programme principal du jeu de la vie.
     */
    public static void main(String[] args) {
        Menu.lancer();
    }

}
