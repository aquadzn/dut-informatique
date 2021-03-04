package messagerie;

import java.util.ArrayList;

public class Client {

    private final int idClient;
    private final String pseudo;
    private boolean estConnecte;
    private final ArrayList<Message> messages;

    private static int compteur = 0;

    public Client(String pseudo) throws ServeurException {
        this.idClient = ++compteur;
        this.pseudo = pseudo;
        this.estConnecte = false;
        this.messages = new ArrayList<>();

        Serveur.ajoutClient(this);
    }

    public void setEstConnecte(boolean status) {
        this.estConnecte = status;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getPseudo() {
        return pseudo;
    }

    public boolean getEstConnecte() {
        return estConnecte;
    }

    public void connexionServeur() throws ServeurException {
        Serveur.connexionClient(this);
    }

    public void deconnexionServeur() throws ServeurException {
        Serveur.deconnexionClient(this);
    }

    public void envoyerMessage(String destinataire, String texte) {
        Message msg = new Message(this.pseudo, destinataire, texte);
        this.messages.add(msg);
        Serveur.envoiMessage(msg);
    }

    public void envoyerMessage(String[] destinataires, String texte) {
        for (String d : destinataires) {
            Message msg = new Message(this.pseudo, d, texte);
            this.messages.add(msg);
            Serveur.envoiMessage(msg);
        }
    }

    public void recevoirMessage(Message msg) {
        this.messages.add(msg);
    }

    public void supprimerMessage(int idMessage) {
        for (Message m : this.messages) {
            if (m.getIdMessage() == idMessage) {
                this.messages.remove(m);
                System.out.println("Message " + idMessage + " supprimé.");
                return;
            }
        }
        System.out.println("ID de message inexistant.");
    }

    public void consulterMessagesRecus() {
        System.out.println("\nO-------------------------------------------");
        System.out.println(this.pseudo + " - Message reçus");
        System.out.println("ID - AUTEUR - DESTINATAIRE - CONTENU");
        System.out.println("----------------------");
        for (Message m : this.messages) {
            if (m.getDestinataire().equals(this.pseudo)) {
                System.out.println(m.toString());
            }
        }
        System.out.println("-------------------------------------------O");
    }

    public void consulterMessagesEnvoyes() {
        System.out.println("\nO-------------------------------------------");
        System.out.println(this.pseudo + " - Message envoyés");
        System.out.println("ID - AUTEUR - DESTINATAIRE - CONTENU");
        System.out.println("----------------------");
        for (Message m : this.messages) {
            if (m.getAuteur().equals(this.pseudo)) {
                System.out.println(m.toString());
            }
        }
        System.out.println("-------------------------------------------O");
    }

    public void consulterConversationParPseudo(String pseudo) {
        System.out.println("\nO-------------------------------------------");
        System.out.println(this.pseudo + " - Conversation avec " + pseudo);
        System.out.println("ID - AUTEUR - DESTINATAIRE - CONTENU");
        System.out.println("----------------------");
        for (Message m : this.messages) {
            if (m.getAuteur().equals(this.pseudo) && m.getDestinataire().equals(pseudo) || m.getAuteur().equals(pseudo) && m.getDestinataire().equals(this.pseudo)) {
                System.out.println(m.toString());
            }
        }
        System.out.println("-------------------------------------------O");
    }

}
