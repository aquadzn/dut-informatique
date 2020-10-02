import java.util.Scanner;


public class MultipleDeDeuxTroisCinq {

    public static void main(String[] args) {
    
        Scanner saisie = new Scanner(System.in);

        System.out.print("Entrez un nombre entier: ");
        int nombreInput = Integer.parseInt(saisie.nextLine());
    
        if (nombreInput % 2 == 0) {
            System.out.println("Le nombre " + nombreInput + " est pair");
        }
        else {
            System.out.println("Le nombre " + nombreInput + " n'est pas pair");
        }

        if (nombreInput % 3 == 0) {
            System.out.println("C'est aussi un multiple de 3");
        }
        else {
            System.out.println("Ce n'est pas un multiple de 3");
        }

        if (nombreInput % 5 == 0) {
            System.out.println("C'est aussi un multiple de 5");
        }
        else {
            System.out.println("Ce n'est pas un multiple de 5");
        }
    }
}
