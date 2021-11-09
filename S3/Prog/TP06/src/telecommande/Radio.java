package telecommande;

public class Radio implements Device {

    @Override
    public void on() {
        System.out.println("Radio allumée");
    }

    @Override
    public void off() {
        System.out.println("Radio éteinte");
    }

    public void increaseSound() {
        System.out.println("Volume augmenté");
    }

    public void decreaseSound() {
        System.out.println("Volume baissé");
    }

}
