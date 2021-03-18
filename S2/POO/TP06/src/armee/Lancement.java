package armee;

public class Lancement {

    public static void main(String[] args) {

        Soldat ss = new Soldat("Tom", 75);
        Brancardier b = new Brancardier("Paul", 91);
        Cavalier c = new Cavalier("Jean", 101);

        b.charger(45);
        c.charger(120);

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
