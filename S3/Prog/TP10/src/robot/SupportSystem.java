package robot;

import java.util.Collection;

public class SupportSystem {
    private final InputReader inputReader;
    private final Responder responder;

    public SupportSystem(InputReader inputReader, Responder responder) {
        this.inputReader = inputReader;
        this.responder = responder;
    }

    public void start() {
        printWelcome();

        Collection<String> strings;
        strings = this.inputReader.getInput();
        while (! strings.contains("bye")) {
            System.out.println(this.responder.generateResponse(strings));
            strings.clear();
            strings = this.inputReader.getInput();
        }

        printGoodbye();
    }

    public void printWelcome() {
        System.out.println("Bienvenue dans le systeme d’assistance technique DodgySoft.");
        System.out.println("Veuillez nous indiquer votre probleme.");
        System.out.println("Nous vous aiderons a le resoudre.");
        System.out.println("Tapez 'bye' pour quitter le système.");
    }

    public void printGoodbye() {
        System.out.println("Merci pour votre visite. Bye...");
    }
}
