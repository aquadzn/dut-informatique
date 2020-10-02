import java.util.Scanner;


public class circonferenceAire {

    public static void main(String[] args) {

        Scanner saisie = new Scanner(System.in);

        System.out.println("Circonférence et aire de cercles");

        double rayon;

        do {
            System.out.print("rayon (négatif pour terminer): -> ");
            rayon = saisie.nextDouble();
            System.out.println("circonférence: " + 2 * Math.PI * rayon + " ; " + "aire: " + Math.pow(rayon, 2) * Math.PI);
        }
        while (rayon >= 0);

        saisie.close();

        System.out.println("Au revoir !");
    }
}
