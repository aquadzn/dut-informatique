import java.util.ArrayList;

public class Banque {

    private String nom;
    private ArrayList<Client> clients;
    private ArrayList<Compte> comptes;

    public Banque(String nom) {
        this.nom = nom;
        this.clients = new ArrayList<>();
        this.comptes = new ArrayList<>();
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

    public void crediterCompte(int numeroCompte, long montant) {
        for(Compte c : this.comptes) {
            if (c.getNumeroCompte() == numeroCompte) {
                c.crediterSolde(montant);
                break;
            }
        }
        System.out.println();
    }

    public void debiterCompte(int numeroCompte, long montant) {
        for(Compte c : this.comptes) {
            if (c.getNumeroCompte() == numeroCompte) {
                c.debiterSolde(montant);
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
                c.afficherSolde();
                break;
            }
        }
    }

    public void afficherComptesDecouvert() {
        System.out.println("Comptes à découvert:");
        for (Compte c : this.comptes) {
            if (c.getSolde() < 0) {
                System.out.println(c.getNumeroCompte());
                c.afficherSolde();
            }
        }
    }
}
