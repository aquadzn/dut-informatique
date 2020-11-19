public class Utils {

    public static void nombreEtudiants(int etudiants) {
        System.out.println("Il y a " + etudiants + " étudiants.");
    }

    public static void listeNotes(double[] notes) {
        for (int i = 0; i < notes.length; i++) {
            System.out.println("Note étudiant " + (i + 1) + ": " + notes[i]);
        }
    }

    public static void moyenneNotes(double[] notes) {
        double moyenne = 0;

        for (double note : notes) {
            moyenne += note;
        }
        System.out.println("Moyenne de la classe: " + (moyenne / notes.length));
    }

    public static void seuilNotes(double[] notes, double seuil) {
        boolean depasse = false;

        for (int i = 0; i < notes.length; i++) {
            if (notes[i] > seuil) {
                depasse = true;
                break;
            }
        }
        if (depasse) {
            System.out.println("Seuil dépassé");
        }
        else {
            System.out.println("OK. Seuil non dépassé.");
        }
    }
}
