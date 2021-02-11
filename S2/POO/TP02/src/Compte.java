public class Compte {

    private Client titulaire;
    private int numeroCompte;
    private long solde;

    // et si plusieurs comptes sont crées au même moment?
    private static int compteur = 0;

    public Compte(Client titulaire) {
        this.titulaire = titulaire;
        this.numeroCompte = ++compteur;
        this.solde = 0;
    }

    public String getTitulaireNom() {
        return this.titulaire.getNom();
    }

    public int getNumeroCompte() {
        return this.numeroCompte;
    }

    public long getSolde() {
        return this.solde;
    }

    public void afficherSolde() {
        int euros = (int) Math.floorDiv(this.solde, 100);
        int centimes = Math.abs((int) (this.solde % 100));
        System.out.println("Solde actuel: " + euros + "." + centimes + " euros");
    }

    public void crediterSolde(long montant) {
        this.solde += montant;
    }

    public void debiterSolde(long montant) {
        this.solde -= montant;
    }
}
