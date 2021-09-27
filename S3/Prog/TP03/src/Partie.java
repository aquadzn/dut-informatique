import java.util.Scanner;

public class Partie {
    private int nbToursMax;
    private Joueur j1;
    private Joueur j2;
    private Scanner sc;

    public Partie(Joueur j1, Joueur j2, int nbToursMax) {
        this.nbToursMax = nbToursMax;
        this.j1 = j1;
        this.j2 = j2;
        this.sc = new Scanner(System.in);
    }

    public void go() {
        System.out.println(j1.toString() + " et " + j2.toString());
        for (int i = 0; i < nbToursMax; i++) {
            unTour();
        }
        System.out.println();

        if (j1.getScore() == j2.getScore()) {
            System.out.println("Match nul!");
        }
        else {
            if (j1.getScore() > j2.getScore()) {
                System.out.println("Victoire de " + j1.getNom());
            }
            else {
                System.out.println("Victoire de " + j2.getNom());
            }
        }
    }

    public void unTour() {
        j1.choisirCoup();
        j2.choisirCoup();

        System.out.println(
                j1.getNom() + " joue " + j1.getCoupCourant().name() +
                        " et " + j2.getNom() + " joue " + j2.getCoupCourant().name()
        );

        resoudreTour();
        System.out.println(j1.toString() + " et " + j2.toString());

    }

    public void resoudreTour() {
        Coup coupJ1 = j1.getCoupCourant();
        Coup coupJ2 = j2.getCoupCourant();

        if (coupJ1.equals(coupJ2)) {
            j1.marquePoint(1);
            j2.marquePoint(1);
        } else {
            if (coupJ1.bat(coupJ2)) {
                j1.marquePoint(2);
            }
            else {
                j2.marquePoint(2);
            }
        }
    }
}
