package messagerie;

public class Main {
    public static void main(String[] args) throws ServeurException {
        Serveur.demarrer();
        if (! Serveur.getStatus()) {
            System.exit(1);
        }

        Client jean = new Client("jean");
        Client paul = new Client("paul");
        Client thomas = new Client("thomas");

        jean.connexionServeur();
        paul.connexionServeur();
        thomas.connexionServeur();
        System.out.println("Connectés: " + Serveur.getNbConnectes());

        jean.envoyerMessage(new String[]{"paul", "thomas"}, "Salut, ca va ?");
        paul.envoyerMessage("jean", "Bonjour, oui et toi ?");
        jean.envoyerMessage("paul", "Bien merci.");
        paul.envoyerMessage("jean", "Que puis-je faire pour toi ?");

        // Salut, ca va ? pour Paul
        jean.supprimerMessage(1);

        jean.consulterMessagesEnvoyes();
        jean.consulterMessagesRecus();
        jean.consulterConversationParPseudo("paul");

        paul.consulterMessagesRecus();
        paul.consulterConversationParPseudo("jean");

        thomas.consulterMessagesRecus();

        System.out.println();
        jean.deconnexionServeur();
        paul.deconnexionServeur();
        thomas.deconnexionServeur();

        System.out.println("Connectés: " + Serveur.getNbConnectes());
        Serveur.eteindre();
    }
}
