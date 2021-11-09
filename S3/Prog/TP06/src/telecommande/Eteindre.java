package telecommande;

public class Eteindre extends Action {
    public Eteindre(Device device) {
        super(device);
    }

    @Override
    void effectuer() {
        getDevice().off();
    }
}
