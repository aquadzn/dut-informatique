package jeu;

public class Lancement {

    public static void main(String[] args) {
        Archer a = new Archer("archer");
        Magicien m = new Magicien("magicien");

        System.out.println(a.getPointsVie());
        System.out.println(m.getPointsVie());

        a.attaquer(m);
        a.crier();
        System.out.println(m.getPointsVie());

        m.perdreArme();

        m.attaquer(a);
        m.crier();
        System.out.println(a.getPointsVie());
    }
}
