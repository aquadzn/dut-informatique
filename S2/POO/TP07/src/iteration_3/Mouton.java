package iteration_3;

public class Mouton extends Acteur {

    public Mouton(Environnement env) {
        super(40, 5, env);
    }

    public Mouton(int x, int y, Environnement env) {
        super(x, y, 40, 5, env);
    }

    public void agit() {
        if (this.getEnv().getNbTours() % 2 != 0) {
            this.seDeplace();
        }

        this.decrementerPv(1);
    }
}
