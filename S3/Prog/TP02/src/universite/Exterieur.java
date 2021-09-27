package universite;

public class Exterieur extends Enseignant {

    public Exterieur(String nom) {
        super(nom);
    }

    @Override
    public int nombreHeuresComplementaires() {
        return this.getHeuresTravaillees();
    }
}
