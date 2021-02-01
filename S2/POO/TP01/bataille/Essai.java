import java.util.ArrayList;

public class Essai {

    public static void main(String[] args) {
        Carte valetCarreau = new Carte(11, "carreau");
        Carte cinqTrefle = new Carte(5, "trèfle");

        System.out.println(valetCarreau.toString());
        System.out.println(cinqTrefle.toString());

        ArrayList<Carte> cartesTriees = FabriqueDeJeuxDe32Cartes.créerJeu32DansOrdre();
        ArrayList<Carte> cartesBattues = FabriqueDeJeuxDe32Cartes.créerJeu32Battu();

        for(Carte c : cartesTriees) {
            System.out.println(c.toString());
        }
        for (Carte c : cartesBattues) {
            System.out.println(c.toString());
        }

        if (cartesBattues.get(0) == cartesBattues.get(1)) {
            System.out.println("cartes égales");
        }
        else if (cartesBattues.get(0).supérieureA(cartesBattues.get(1))) {
            System.out.println("première > deuxième");
        }
        else {
            System.out.println("deuxième > première");
        }

        Joueur joueurZero = new Joueur("Jean");
        System.out.println(joueurZero.getNom());
        System.out.println(joueurZero.toString());

        joueurZero.ramasserUneCarte(valetCarreau);
        System.out.println(joueurZero.toString());
        joueurZero.ramasserUneCarte(cinqTrefle);
        System.out.println(joueurZero.toString());

        joueurZero.poserUneCarte();
        System.out.println(joueurZero.toString());

        carteRestante(joueurZero);
        joueurZero.poserUneCarte();
        carteRestante(joueurZero);


        ArrayList<Carte> paquetUn = new ArrayList<>();
        ArrayList<Carte> paquetDeux = new ArrayList<>();

        FabriqueDeJeuxDe32Cartes.créerEtDistribuerJeu32(paquetUn, paquetDeux);

        Joueur joueurUn = new Joueur("Azerty", paquetUn);
        Joueur joueurDeux = new Joueur("Qwerty", paquetDeux);

        System.out.println(joueurUn.toString());
        System.out.println(joueurDeux.toString());

    }

    private static void carteRestante(Joueur joueur) {

        if (joueur.resteCarte()) {
            System.out.println("au moins une carte restante");
        }
        else {
            System.out.println("pas de carte restante");
        }
    }


}
