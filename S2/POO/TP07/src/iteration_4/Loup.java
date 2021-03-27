package iteration_4;

public class Loup extends Acteur {

    private static double pctReproduction = 0.03;

    public Loup(Environnement env) {
        super(80, 10, env);
    }

    public Loup(int x, int y, Environnement env) {
        super(x, y, 80, 10, env);
    }

    public void agit() {
        Acteur a = captureMouton();
        if (a == null) {
            this.decrementerPv(2);
        }
        else {
            a.meurt();
        }

        this.seDeplace();

        if (Math.random() < pctReproduction) {
            System.out.println("\tUn bébé loup nait");
            Environnement e = this.getEnv();
            e.ajouter(new Loup(this.getX() + 1, this.getY() + 1, e));
        }

        this.decrementerPv(1);
    }

    private Acteur captureMouton() {
        for(Acteur m : this.getEnv().getActeurs()){
            if(m instanceof Mouton && m.estVivant() ){
                if((this.getY()-5<= m.getY() && m.getY()<=this.getY()+5) &&
                        (this.getX()-5<= m.getX() && m.getX()<=this.getX()+5)
                ){
                    return m;
                }
            }
        }
        return null;
    }
}
