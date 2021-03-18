package jeu;

public class Nain extends Guerrier {

    public Nain(String nom) {
        super(nom, 50, 20, 30, new Arme("hache"));
    }

    public void crier() {
        System.out.println(this.getKills() + " guerriers tués!");
    }
}
