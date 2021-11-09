package telecommande;

public class MonterVolume extends Action {
    private Radio radio;
    public MonterVolume(Radio radio) {
        super(radio);
        this.radio = radio;
    }

    @Override
    void effectuer() {
        this.radio.increaseSound();
    }
}
