import java.util.Scanner;


public class avantageCommercial {

    final static double REDUCTION = 0.95;
    final static int SEUIL = 100;

    public static void main(String[] args) {
    
        Scanner saisie = new Scanner(System.in);
        
        double montantAchat;

        System.out.print("Entrez montant de l'achat: ");
        montantAchat = Double.parseDouble(saisie.nextLine());

        if (montantAchat > 100) {
            double montantFinal = 100 + ((montantAchat - 100) * REDUCTION);
            System.out.println("Prix final après réduction de 5% sur l'excédent de 100: " + montantFinal);
        }
        else if (montantAchat <= 0) {
            System.out.println("Ce montant n'est pas correct!");
        }
        else {
            System.out.println("Prix final: " + montantAchat);
        }

    }
}
