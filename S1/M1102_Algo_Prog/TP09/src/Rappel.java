import java.util.Scanner;

public class Rappel {
    public static void main(String[] args) {
        Scanner saisie = new Scanner(System.in);
        double[] notes;

        System.out.print("Nombre d'étudiants: ");
        notes = new double[saisie.nextInt()];

        for (int i = 0; i < notes.length; i++) {
            System.out.print("Note étudiant " + (i+1) + ": ");
            notes[i] = saisie.nextDouble();
        }

        double somme = 0;
        for (double n : notes) {
            somme += n;
        }

        saisie.close();
        System.out.println("Moyenne: " + (somme / notes.length));
    }
}
