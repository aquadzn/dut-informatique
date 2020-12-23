public class Main {

    // Paramètres du jeu
    static final int HAUTEUR = 14;
    static final int LONGUEUR = 80;
    static final char VIVANT = '#';
    static final char MORT = '·';

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.lancer();
    }
}
