public class Main {

    // Paramètres du jeu
    public static final int HAUTEUR = 20;
    public static final int LONGUEUR = 60;
//    public static final char VIVANT = '#';
//    public static final char MORT = '·';
    public static final int VIVANT = 1;
    public static final int MORT = 0;

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.lancer();
    }
}
