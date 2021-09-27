public class Main {

    public static void main(String[] args) {

        Paquet paquet = new Paquet();
        paquet.melanger();
        for(Carte c : paquet.getCartes()) {
            System.out.println(c.toString());
        }
    }
}
