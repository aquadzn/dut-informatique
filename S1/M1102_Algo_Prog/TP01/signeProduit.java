import java.util.Scanner;


public class signeProduit {

    public static void main(String[] args) {

        Scanner saisie = new Scanner(System.in);

        double valeurA, valeurB;

        System.out.print("Entrez une valeur A: ");
        valeurA = Double.parseDouble(saisie.nextLine());
        System.out.print("Entrez une valeur B: ");
        valeurB = Double.parseDouble(saisie.nextLine());

        if ((valeurA > 0 && valeurB > 0) || (valeurA < 0 && valeurB < 0)) {
            System.out.println("Le signe du produit est positif");
        }
        else if ((valeurA > 0 && valeurB < 0) || (valeurA < 0 && valeurB > 0)) {
            System.out.println("Le signe du produit est négatif");
        }
        else {
            System.out.println("Produit de 0");
        }
    }
}
