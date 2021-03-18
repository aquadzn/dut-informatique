package jeu;

public class Arme {

    final private String nom;
    private int pointsAttaque;

    public Arme(String nom) {
        this.nom = nom;

        switch (nom) {
            case "hache":
                this.pointsAttaque = 10;
                break;
            case "arc":
                this.pointsAttaque = 5;
                break;
            case "baguette":
                this.pointsAttaque = 20;
                break;
            default:
                this.pointsAttaque = 0;
                break;
        }
    }

    public int getPointsAttaque() {
        return this.pointsAttaque;
    }
}
