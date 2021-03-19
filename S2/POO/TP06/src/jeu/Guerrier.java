package jeu;
import jeu.armes.Arme;

public abstract class Guerrier {

    final private String nom;
    private int pointsVie;
    private int pointsAttaque;
    private int pointsDefense;
    private Arme arme;
    private boolean estArme;
    private int kills;
    private int santeMax;

    protected Guerrier(String nom, int pV, int pA, int pD, Arme arme) {
        this.nom = nom;
        this.pointsVie = pV;
        this.pointsAttaque = pA;
        this.pointsDefense = pD;
        this.arme = arme;

        this.estArme = true;
        this.kills = 0;
        this.santeMax = pV;
    }

    private int getPointsVie() {
        return this.pointsVie;
    }

    private int getPointsDefense() {
        return this.pointsDefense;
    }

    protected int getKills() {
        return this.kills;
    }

    private void setPointsVie(int pointsVie) {
        this.pointsVie = pointsVie;
    }

    protected void perdreArme() {
        this.arme = null;
        this.estArme = false;
    }

    public String toString() {
        return this.nom + "[" + this.pointsVie + "/" + this.santeMax + " PV]";
    }

    protected void attaquer(Guerrier g) throws Exception {
        if (g.getPointsVie() == 0) {
            this.kills++;
            throw new Exception("Le guerrier attaqué n'a plus de PV");
        }

        int attaque = this.pointsAttaque - g.getPointsDefense();
        if (this.estArme) {
            attaque += this.arme.getPointsAttaque();
        }

        System.out.println(this.toString() + " INFLIGE -" + attaque + " PV à " + g.toString());
        g.setPointsVie(g.getPointsVie() - attaque);
    }

    protected abstract void crier();
}
