import java.util.Scanner;


public class circonferenceAire {

    public static void main(String[] args) {

        Scanner saisie = new Scanner(System.in);

        System.out.println("Circonférence et aire de cercles");

        System.out.print("rayon: -> ");
        double rayon = saisie.nextDouble();

        while (rayon >= 0) {
            System.out.println("circonférence: " + 2 * 3.14 * rayon + " ; " + "aire: " + Math.pow(rayon, 2) * 3.14);
            System.out.print("rayon (négatif pour terminer): -> ");
            rayon = saisie.nextDouble();
        }

        saisie.close();

        System.out.println("Au revoir !");
    }
}
