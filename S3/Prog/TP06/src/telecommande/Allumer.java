package telecommande;

public class Allumer extends Action {
    public Allumer(Device device) {
        super(device);
    }

    @Override
    void effectuer() {
        getDevice().on();
    }
}
