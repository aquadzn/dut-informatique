package iteration_3;

import java.util.ArrayList;

public class Environnement {
    private final int hauteur;
    private final int largeur;
    private int nbTours;
    private final ArrayList<Acteur> acteurs;

    public Environnement(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.nbTours = 0;
        this.acteurs = new ArrayList<>();
    }

    public int getHauteur() {
        return this.hauteur;
    }

    public int getLargeur() {
        return this.largeur;
    }

    public int getNbTours() {
        return this.nbTours;
    }

    public ArrayList<Acteur> getActeurs() {
        return this.acteurs;
    }

    public void ajouter(Acteur a) {
        if (this.dansTerrain(a.getX(), a.getY())) {
            this.acteurs.add(a);
        }
        else {
            System.out.println("Acteur non ajouté, coordonnées en dehors du terrain");
        }
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
        this.nbTours++;
    }

    public boolean dansTerrain(int x, int y) {
        return ((x >= 0 || x <= this.largeur) && (y >= 0 || y <= this.hauteur));
    }

}
