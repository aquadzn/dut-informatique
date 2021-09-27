package universite;

public abstract class Titulaire extends Enseignant {

    private int heuresStatutaire;

    public Titulaire(String nom, int heuresStatutaire) {
        super(nom);
        this.heuresStatutaire = heuresStatutaire;
    }

    public int getHeuresStatutaire() {
        return heuresStatutaire;
    }

    @Override
    public int nombreHeuresComplementaires() {
        int h = this.getHeuresTravaillees() - this.getHeuresStatutaire();
        if (h <= 0) {
            return 0;
        }
        else {
            return h;
        }
    }
}
