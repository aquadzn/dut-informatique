package iteration_2;

public class Mouton extends Acteur {
    public Mouton(Environnement env) {
        super(40, env);
    }

    public Mouton(int x, int y, Environnement env) {
        super(x, y, 40, env);
    }

    public void agit() {
        this.decrementerPv(1);
    }
}
