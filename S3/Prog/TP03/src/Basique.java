public class Basique implements Strategie {

    private Coup coup;

    public Basique(Coup coup) {
        this.coup = coup;
    }

    @Override
    public Coup choisirCoup() {
        return this.coup;
    }
}
