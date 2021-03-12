package voiture;

import java.util.ArrayList;

public class Lancement {
    public static void main(String[] args) {
        Agence agence = new Agence();
        agence.ajoute(new Voiture("Citroen", "DS", 50000, 50));
        agence.ajoute(new Voiture("Ford", "Focus", 20000, 30));
        agence.ajoute(new Voiture("Peugeot", "308", 10000, 35));

        Critere cPrix = new CriterePrix(40);
        ArrayList<Voiture> voituresCritere = agence.selection(cPrix);
        System.out.println("Critère prix:");
        if (voituresCritere.isEmpty()) {
            System.out.println("Rien trouvé");
        }
        else {
            for (Voiture v : voituresCritere) {
                System.out.println(v.toString());
            }
        }
        voituresCritere.clear();

        ArrayList<Critere> criteres = new ArrayList<>();
        Critere cMarque = new CritereMarque("Ford");
        criteres.add(cPrix);
        criteres.add(cMarque);

        voituresCritere = agence.selection(new InterCritere(criteres));
        System.out.println("Inter critère:");
        if (voituresCritere.isEmpty()) {
            System.out.println("Rien trouvé");
        }
        else {
            for (Voiture v : voituresCritere) {
                System.out.println(v.toString());
            }
        }
        voituresCritere.clear();
    }
}
