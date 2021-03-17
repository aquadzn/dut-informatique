package armee;

public class Lancement {

    public static void main(String[] args) {

        Soldat ss = new Soldat("Tom", 75, 0, 0);
        Brancardier b = new Brancardier("Paul", 91, 45);
        Cavalier c = new Cavalier("Jean", 101, 110);

        c.decharger(90);
        c.charger(100);

        System.out.println(ss.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());

        Troupe t = new Troupe();
        t.ajouterSoldat(ss);
        t.ajouterSoldat(b);
        t.ajouterSoldat(c);

        System.out.println("Vitesse max troupe: " + t.vitesseTroupe() + " km/h");
    }
}
