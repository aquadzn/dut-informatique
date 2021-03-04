package messagerie;

import java.util.ArrayList;

public class Serveur {

    private static boolean estDemarre = false;
    private static int nbConnectes = 0;
    private static final ArrayList<Client> utilisateurs = new ArrayList<>();

    public static boolean getStatus() {
        return estDemarre;
    }

    public static int getNbConnectes() {
        return nbConnectes;
    }

    public static void demarrer() {
        if (estDemarre) {
            System.out.println("Le serveur est déjà en ligne.");
        }
        else {
            estDemarre = true;
            System.out.println("Le serveur est en ligne.");
        }
    }

    public static void eteindre() {
        if (! estDemarre) {
            System.out.println("Le serveur est déjà hors-ligne.");
        }
        else {
            estDemarre = false;
            nbConnectes = 0;
            System.out.println("Le serveur est hors-ligne.");
        }
    }

    public static void ajoutClient(Client c) throws ServeurException {
        for (Client u : utilisateurs) {
            if (u.getPseudo().equals(c.getPseudo())) {
                throw new ServeurException(c.getPseudo() + " - Utilisateur existant.");
            }
        }
        utilisateurs.add(c);
    }

    public static void connexionClient(Client c) throws ServeurException {
        if (c.getEstConnecte()) {
            throw new ServeurException(c.getPseudo() + " - Utilisateur déjà connecté.");
        }
        else {
            nbConnectes++;
            c.setEstConnecte(true);
            System.out.println(c.getPseudo() + " s'est connecté.");
        }
    }

    public static void deconnexionClient(Client c) throws ServeurException {
        if (! c.getEstConnecte()) {
            throw new ServeurException(c.getPseudo() + " - Utilisateur déjà déconnecté.");
        }
        else {
            nbConnectes--;
            c.setEstConnecte(false);
            System.out.println(c.getPseudo() + " s'est déconnecté.");
        }
    }

    // On pourrait s'assurer que le message s'envoi seulement
    // si le destinataire existe mais sur la plupart des messageries
    // un message s'envoi qd même si le destinataire n'existe pas
    public static void envoiMessage(Message msg) {
        for (Client c : utilisateurs) {
            if (c.getPseudo().equals(msg.getDestinataire())) {
                c.recevoirMessage(msg);
            }
        }
    }
}
