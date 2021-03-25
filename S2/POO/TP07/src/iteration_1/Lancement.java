package iteration_1;

public class Lancement {
    public static void main(String[] args) {
        Environnement env = new Environnement(1000, 1000);
        env.ajouter(new Mouton());
        env.ajouter(new Mouton());
        env.ajouter(new Loup());
        env.ajouter(new Mouton());

        for (int i = 0; i < 50; i++) {
            env.unTour();
        }
    }
}
