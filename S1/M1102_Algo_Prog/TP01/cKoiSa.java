/*
 * cKoiSa.java
 * Le programme demande d'entrer une valeur décimale
 * Si la valeur entrée est supérieure ou égale à 0, on affiche cette valeur
 * Si la valeur entrée est inférieure à 0, on affiche son opposé
 */
import java.util.Scanner;


public class cKoiSa {

    public static void main(String[] args) {

        double valeurInput;
        double valeurOutput = 15397462.648967;

        Scanner saisie = new Scanner(System.in);

        System.out.print("Entrez un nombre décimal: ");

        valeurInput = Double.parseDouble(saisie.nextLine());		
        
        if (valeurInput >= 0) {
            valeurOutput = valeurInput;
        }
        if (valeurInput < 0) {
            valeurOutput = -valeurInput;
        }

        System.out.println("Le résultat est: " + valeurOutput);}}

