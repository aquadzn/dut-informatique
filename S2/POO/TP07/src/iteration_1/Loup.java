package iteration_1;

public class Loup extends Acteur {
    public Loup() {
        super(80);
    }

    public void agit() {
        this.decrementerPv(1);
    }
}
