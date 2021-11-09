package telecommande;

public class Main {

    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        Telecommande telecommande = new Telecommande(4);
        telecommande.assignerBouton(0, new Allumer(lamp));
        telecommande.assignerBouton(1, new Eteindre(lamp));
        telecommande.assignerBouton(2, new Allumer(radio));
        telecommande.assignerBouton(3, new MonterVolume(radio));
    }
}
