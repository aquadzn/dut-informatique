package telecommande;

public abstract class Action {
    private Device device;

    public Action(Device device) {
        this.device = device;
    }

    public Device getDevice() {
        return device;
    }

    abstract void effectuer();
}
