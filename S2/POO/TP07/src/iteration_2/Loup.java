package iteration_2;

public class Loup extends Acteur {
    public Loup(Environnement env) {
        super(80, env);
    }

    public Loup(int x, int y, Environnement env) {
        super(x, y, 80, env);
    }

    public void agit() {
        Acteur a = captureMouton();
        if (a == null) {
            this.decrementerPv(2);
        }
        else {
            a.meurt();
            this.getEnv().getActeurs().remove(a);
        }

        this.decrementerPv(1);
    }

    private Acteur captureMouton() {
        for(Acteur a : this.getEnv().getActeurs()) {
            if (a instanceof Mouton && a.estVivant()) {
                int aX = a.getX();
                int aY = a.getY();
                int x = this.getX();
                int y = this.getY();

                if ((aX <= x + 5 && aX >= x - 5) && (aY <= y + 5 && aY >= y - 5)) {
                    return a;
                }
            }
        }
        return null;
    }
}
