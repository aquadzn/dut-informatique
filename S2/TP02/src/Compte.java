public class Compte {

    private Client titulaire;
    private int numeroCompte;
    private double solde;

    public Compte(Client titulaire, int numeroCompte) {
        this.titulaire = titulaire;
        this.numeroCompte = numeroCompte;
        this.solde= 0;
    }

    public String getTitulaireNom() {
        return this.titulaire.getNom();
    }

    public int getNumeroCompte() {
        return this.numeroCompte;
    }

    public double getBalance() {
        return this.solde;
    }

    public void crediterSolde(double montant) {
        this.solde += montant;
        System.out.println("Solde actuel: " + this.solde);
    }

    public void debiterSolde(double montant) {
        this.solde -= montant;
        System.out.println("Solde actuel: " + this.solde);
    }
}
