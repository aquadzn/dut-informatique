package jeu;

import jeu.armes.Hache;

public class Nain extends Guerrier {

    public Nain(String nom) {
        super(nom, 50, 20, 30, new Hache());
    }

    public void crier() {
        System.out.println(this.toString() + " CRIE " + this.getKills() + " guerriers tués!");
    }
}
