package jeu;

public class Lancement {

    public static void main(String[] args) {
        Archer a = new Archer("archer");
        Magicien m = new Magicien("magicien");

        try {
            a.attaquer(m);
            a.crier();

            m.perdreArme();

            m.attaquer(a);
            m.crier();

            a.attaquer(m);
            a.crier();
            m.attaquer(a);
            m.crier();

            a.attaquer(m);
            a.crier();
            m.attaquer(a);
            m.crier();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
