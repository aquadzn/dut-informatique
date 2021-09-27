package universite;

public abstract class Enseignant {

    private static int COMPTEUR = 0;
    private static int PRIX_HEURE = 40;

    private int id;
    private String nom;
    private int heuresTravaillees;

    public Enseignant(String nom) {
        this.id = ++COMPTEUR;
        this.nom = nom;
        this.heuresTravaillees = 0;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Enseignant " + nom + " a travaillé " + getHeuresTravaillees()
                + " heures dont " + nombreHeuresComplementaires() + " heures complémentaires ("
                + calculerHeuresComplementaires() + " euros)";
    }

    public int getHeuresTravaillees() {
        return heuresTravaillees;
    }

    public void ajouterHeures(int heuresTravaillees) throws Exception {
        if (heuresTravaillees < 1) {
            throw new Exception("Minimum 1h");
        }
        this.heuresTravaillees += heuresTravaillees;
    }

    public int calculerHeuresComplementaires() {
        return PRIX_HEURE * this.nombreHeuresComplementaires();
    }

    public abstract int nombreHeuresComplementaires();
}
