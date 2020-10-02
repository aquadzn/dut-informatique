/*
 * tarifsBus.java
 * Affiche le prix d'un billet pour un âge donné
 *
 */
import java.util.Scanner;


public class tarifsBus {

    public static void main(String[] args) {

        Scanner saisie = new Scanner(System.in);

        System.out.print("Quel âge avez-vous ? -> ");
        int age = saisie.nextInt();
        System.out.print("Habitez vous Montreuil ? (Non 0 - Oui 1) -> ");
        int local = saisie.nextInt();

        saisie.close();

        if (local == 0) {

            if (age < 0 || age > 122) {
                System.out.println("Erreur d'âge");
            }

            else if (age <= 3) {
                System.out.println("0 euro(s) 25 centime(s) pour une bébé non montreuillois");
            }
        
            else if (age < 20 || age >= 65 ) {
                System.out.println("0 euro(s) 80 centime(s) pour un jeune ou une personne âgée non montreuillois(e)");
            }

            else {
                System.out.println("1 euro(s) 20 centime(s) pour un adulte non montreuillis");
            }

        }

        else {

            if (age < 0 || age > 122) {
                System.out.println("Erreur d'âge");
            }

            else if (age <= 3) {
                int euro = ((int) Math.round((double) Math.round(0.25 * 0.7)));
                int centime = ((int) Math.round((0.25 * 0.7) * 100));

                System.out.println(euro + " euro(s) " + centime + "centime(s) pour un bébé montreuillois");
            }
        
            else if (age < 20 || age >= 65 ) {
                int euro = ((int) Math.round((double) Math.round(0.8 * 0.7))) - 1;
                int centime = ((int) Math.round((0.8 * 0.7) * 100));

                System.out.println(euro + " euro(s) " + centime + "centime(s) pour un jeune ou une personne âgée montreuillois(e)");
            }

            else {
                int euro = ((int) Math.round((double) Math.round(1.2 * 0.7))) - 1;
                int centime = ((int) Math.round((1.2 * 0.7) * 100));

                System.out.println(euro + " euro(s) " + centime + "centime(s) pour un adulte montreuillois");
            
            }
        }

    }
}
