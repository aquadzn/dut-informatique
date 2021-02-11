import java.util.ArrayList;

public class Banque {

    private String nom;
    private ArrayList<Client> clients;
    private ArrayList<Compte> comptes;

    public Banque(String nom) {
        this.nom = nom;
        this.clients = new ArrayList<Client>();
        this.comptes = new ArrayList<Compte>();
    }

    public String getNom() {
        return this.nom;
    }

    public int getNbComptes() {
        return this.comptes.size();
    }

    public int getNbClients() {
        return this.clients.size();
    }

    public void setClientAdresse(String nom, String nouvelleAdresse) {
        for(Client c : this.clients) {
            if (c.getNom().equals(nom)) {
                c.setAdresse(nouvelleAdresse);
                break;
            }
        }
        System.out.println();
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void addCompte(Compte compte) {
        this.comptes.add(compte);
    }

    public void crediterCompte(int numeroCompte, double montant) {
        for(Compte c : this.comptes) {
            if (c.getNumeroCompte() == numeroCompte) {
                c.crediterSolde(montant);
                System.out.println("Solde actuel compte " + c.getNumeroCompte() + ": " + c.getBalance());
                break;
            }
        }
        System.out.println();
    }

    public void debiterCompte(int numeroCompte, double montant) {
        for(Compte c : this.comptes) {
            if (c.getNumeroCompte() == numeroCompte) {
                c.debiterSolde(montant);
                System.out.println("Solde actuel compte " + c.getNumeroCompte() + ": " + c.getBalance());
                break;
            }
        }
        System.out.println();
    }

    public void afficherClients() {
        for (Client client: this.clients) {
            System.out.print(client.getNom() + " - ");
        }
        System.out.println();
    }

    public void afficherComptes() {
        for (Compte compte: this.comptes) {
            System.out.print(compte.getTitulaireNom() + ":" + compte.getNumeroCompte() + " - ");
        }
        System.out.println();
    }

    public void afficherCompte(int numeroCompte) {
        for(Compte c : this.comptes) {
            if (c.getNumeroCompte() == numeroCompte) {
                System.out.println(c.getTitulaireNom());
                System.out.println(c.getNumeroCompte());
                System.out.println(c.getBalance());
                break;
            }
        }
        System.out.println();
    }
}
