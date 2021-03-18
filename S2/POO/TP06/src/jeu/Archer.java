package jeu;

public class Archer extends Guerrier {

    public Archer(String nom) {
        super(nom, 30, 10, 20, new Arme("arc"));
    }

    public void crier() {
        System.out.println(this.getKills() + " guerriers tués!");
    }
}
