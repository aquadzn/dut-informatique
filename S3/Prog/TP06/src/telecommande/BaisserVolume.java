package telecommande;

public class BaisserVolume extends Action {
    private Radio radio;
    public BaisserVolume(Radio radio) {
        super(radio);
        this.radio = radio;
    }

    @Override
    void effectuer() {
        this.radio.decreaseSound();
    }
}
