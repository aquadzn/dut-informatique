package jeu;

import jeu.armes.Arc;

public class Archer extends Guerrier {

    public Archer(String nom) {
        super(nom, 30, 10, 20, new Arc());
    }

    public void crier() {
        System.out.println(this.toString() + " CRIE " + this.getKills() + " guerriers tués!");
    }
}
