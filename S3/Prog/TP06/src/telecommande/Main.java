package telecommande;

public class Main {

    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        Telecommande telecommande = new Telecommande(4);
        telecommande.getTelecommande().get(0).setAction(new Allumer(lamp));
        telecommande.getTelecommande().get(1).setAction(new Eteindre(lamp));
        telecommande.getTelecommande().get(2).setAction(new Allumer(radio));
        telecommande.getTelecommande().get(3).setAction(new MonterVolume(radio));
    }
}
