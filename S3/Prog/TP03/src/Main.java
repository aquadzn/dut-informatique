import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Partie partie = new Partie(new Humain("William"), new Machine(), 10);
        partie.go();

    }
}
