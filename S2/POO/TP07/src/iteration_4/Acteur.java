package iteration_4;

import java.util.Random;

public abstract class Acteur {
    private static final Random r = new Random();
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int vitesse;
    private static int compteur = 0;
    private final String id;
    private int pv;

    private Environnement env;

    protected Acteur(int pv, int vitesse, Environnement env) {
        String str = "";
        if (this instanceof Mouton) {
            str += "M";
        }
        if (this instanceof Loup) {
            str += "L";
        }
        this.id = str + String.format("%02d", ++compteur);
        this.pv = pv;
        this.vitesse = vitesse;
        this.env = env;
        this.x = r.nextInt(this.env.getLargeur());
        this.y = r.nextInt(this.env.getHauteur());
        this.dx = r.nextInt(2 - (-1)) + -1;
        this.dy = r.nextInt(2 - (-1)) + -1;
    }

    protected Acteur(int x, int y, int pv, int vitesse, Environnement env) {
        String str = "";
        if (this instanceof Mouton) {
            str += "M";
        }
        if (this instanceof Loup) {
            str += "L";
        }
        this.id = str + String.format("%02d", ++compteur);
        this.pv = pv;
        this.vitesse = vitesse;
        this.env = env;
        this.x = x;
        this.y = y;
        this.dx = r.nextInt(2 - (-1)) + -1;
        this.dy = r.nextInt(2 - (-1)) + -1;
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
        this.x += this.dx * vitesse;
        this.y += this.dy * vitesse;

        if (r.nextDouble() < 0.2) {
            this.dx = r.nextInt(2 - (-1)) + -1;
            this.dy = r.nextInt(2 - (-1)) + -1;
        }

        if (this.x >= this.env.getLargeur()) {
            this.x = this.env.getLargeur() - 1;
            this.dx = -1;
        }
        if (this.x < 0) {
            this.x = 0;
            this.dx = 1;
        }
        if (this.y >= this.env.getHauteur()) {
            this.y = this.env.getHauteur() - 1;
            this.dy = -1;
        }
        if (this.y < 0) {
            this.y = 0;
            this.dy = 1;
        }
    }

    abstract protected void agit();

    public String toString() {
        String str = this.id +  " [" + this.x + "," + this.y + "][";
        if (this.dx == -1) {
            str += "←,";
        }
        if (this.dx == 1) {
            str += "→,";
        }
        if (this.dx == 0) {
            str += "o,";
        }
        if (this.dx == -1) {
            str += "↑]";
        }
        if (this.dx == 1) {
            str += "↓]";
        }
        if (this.dx == 0) {
            str += "o]";
        }

        str += " : " + this.pv + " pv";
        return str;
    }
}
