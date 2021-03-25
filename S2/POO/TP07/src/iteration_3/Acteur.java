package iteration_3;

import java.util.Random;

public abstract class Acteur {
    private static Random r = new Random();
    private int x;
    private int y;
    private int dx;
    private int dy;
    private static int compteur = 0;
    private final String id;
    private int pv;

    private Environnement env;

    protected Acteur(int pv, Environnement env) {
        this.id = "acteur_" + String.valueOf(++compteur);
        this.pv = pv;
        this.env = env;
        this.x = r.nextInt(this.env.getLargeur());
        this.y = r.nextInt(this.env.getHauteur());
    }

    protected Acteur(int x, int y, int pv, Environnement env) {
        this.id = "acteur_" + String.valueOf(++compteur);
        this.pv = pv;
        this.x = x;
        this.y = y;
        this.env = env;
    }

    protected String getId() {
        return this.id;
    }

    protected int getPv() {
        return this.pv;
    }

    protected int getX() {
        return this.x;
    }

    protected int getY() {
        return this.y;
    }

    protected Environnement getEnv() {
        return this.env;
    }

    protected void setDx(int dx) {
        this.dx = dx;
    }

    protected void setDy(int dy) {
        this.dy = dy;
    }

    protected boolean estVivant() {
        return this.pv > 0;
    }

    protected void decrementerPv(int nombre) {
        this.pv -= nombre;
    }

    protected void incrementerPv(int nombre) {
        this.pv += nombre;
    }

    protected void meurt() {
        this.pv = 0;
    }

    protected void seDeplace() {
        
    }

    abstract protected void agit();

    public String toString() {
        return this.id +  " [" + this.x + "," + this.y + "] : " + this.pv + " pv";
    }
}
