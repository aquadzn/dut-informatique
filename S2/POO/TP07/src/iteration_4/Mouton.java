package iteration_4;

public class Mouton extends Acteur {

    private static double pctReproduction = 0.06;

    public Mouton(Environnement env) {
        super(40, 5, env);
    }

    public Mouton(int x, int y, Environnement env) {
        super(x, y, 40, 5, env);
    }

    public void setPctReproduction(double d) {
        pctReproduction = d;
    }

    public void agit() {
        if (this.getEnv().getNbTours() % 2 != 0) {
            this.seDeplace();
        }

        if (Math.random() < pctReproduction) {
            System.out.println("\tUn bébé mouton nait");
            Environnement e = this.getEnv();
            e.ajouter(new Mouton(this.getX(), this.getY(), e));
        }

        this.decrementerPv(1);
    }
}
