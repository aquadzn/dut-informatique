package messagerie;

public class Message {

    private final int idMessage;
    private final String auteur;
    private final String destinataire;
    private final String texte;

    private static int compteur = 0;

    public Message(String auteur, String destinataire, String texte) {
        this.idMessage = ++compteur;
        this.destinataire = destinataire;
        this.auteur = auteur;
        this.texte = texte;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public String toString() {
        return "[" + this.idMessage + "] - [" + this.auteur + "] - [" + this.destinataire + "] - " + this.texte;
    }
}
