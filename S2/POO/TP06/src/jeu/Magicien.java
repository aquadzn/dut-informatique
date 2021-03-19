package jeu;

import jeu.armes.Baguette;

public class Magicien extends Guerrier {

    public Magicien(String nom) {
        super(nom, 40, 30, 10, new Baguette());
    }

    public void crier() {
        System.out.println(this.toString() + " CRIE " + "flamme d'udun !");
    }
}
