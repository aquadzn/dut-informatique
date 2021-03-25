package iteration_1;

public class Mouton extends Acteur {
    public Mouton() {
        super(40);
    }

    public void agit() {
        this.decrementerPv(1);
    }
}
