public class Main {

    public static void main(String[] args) throws PasCoup {

        Partie partie = new Partie(new Humain("William"), new Machine(), 5);
        partie.go();

    }
}
