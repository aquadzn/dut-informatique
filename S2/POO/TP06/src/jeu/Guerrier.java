package jeu;

public abstract class Guerrier {

    final private String nom;
    private int pointsVie;
    private int pointsAttaque;
    private int pointsDefense;
    private Arme arme;
    private boolean estArme;
    private int kills;

    public Guerrier(String nom, int pV, int pA, int pD, Arme arme) {
        this.nom = nom;
        this.pointsVie = pV;
        this.pointsAttaque = pA;
        this.pointsDefense = pD;
        this.arme = arme;
        this.estArme = true;
        this.kills = 0;
    }

    public int getPointsVie() {
        return this.pointsVie;
    }

    private int getPointsDefense() {
        return this.pointsDefense;
    }

    public int getKills() {
        return this.kills;
    }

    private void setPointsVie(int pointsVie) {
        this.pointsVie = pointsVie;
    }

    public void perdreArme() {
        this.arme = null;
        this.estArme = false;
    }

    public void attaquer(Guerrier g) {
        if (this.estArme) {
            g.setPointsVie(g.getPointsVie() - (this.pointsAttaque + this.arme.getPointsAttaque()) + g.getPointsDefense());
        }
        else {
            g.setPointsVie(g.getPointsVie() - this.pointsAttaque + g.getPointsDefense());
        }

        if (g.getPointsVie() == 0) {
            this.kills++;
        }
    }

    protected void crier() {

    }
}
