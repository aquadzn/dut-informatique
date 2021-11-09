package telecommande;

public class Lamp implements Device {

    @Override
    public void on() {
        System.out.println("Lampe allumée");
    }

    @Override
    public void off() {
        System.out.println("Lampe éteinte");
    }

}
