package iteration_1;

import java.util.ArrayList;

public class Environnement {
    private final int hauteur;
    private final int largeur;
    private final ArrayList<Acteur> acteurs;

    public Environnement(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.acteurs = new ArrayList<>();
    }

    public void ajouter(Acteur a) {
        this.acteurs.add(a);
    }

    public void unTour() {
        for(int i = this.acteurs.size() - 1; i >= 0; i--) {
            System.out.println(this.acteurs.get(i).toString());
            this.acteurs.get(i).agit();

            if (! this.acteurs.get(i).estVivant()) {
                this.acteurs.get(i).meurt();
                this.acteurs.remove(i);
            }
        }
        System.out.println();
    }

}
