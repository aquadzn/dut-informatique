import java.util.Random;

public class Aleatoire implements Strategie {

    @Override
    public Coup choisirCoup() {
        return Coup.values()[new Random().nextInt(Coup.values().length)];
    }
}
