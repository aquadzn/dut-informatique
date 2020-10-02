import java.util.Scanner;


public class aireCercle {

    final static double PI = 3.14;

    public static void main(String[] args) {

        Scanner saisie = new Scanner(System.in);

        System.out.print("Entrez la valeur r du rayon du cercle: ");
        double rayonCercle = Double.parseDouble(saisie.nextLine());

        double circonferenceCercle = 2 * PI * rayonCercle;
        double aireCercle = PI * rayonCercle * rayonCercle;

        System.out.println("Circonférence du cercle: " + circonferenceCercle);
        System.out.println("Aire du cercle: " + aireCercle);

    }
}
