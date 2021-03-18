package jeu;

public class Magicien extends Guerrier {

    public Magicien(String nom) {
        super(nom, 40, 30, 10, new Arme("baguette"));
    }

    public void crier() {
        System.out.println("flamme d'udun !");
    }
}
