package voiture;

import java.util.Scanner;

public class VueAgence {
    private Agence agence;
    private Scanner saisie = new Scanner(System.in);

    public VueAgence(Agence agence) {
        this.agence = agence;
    }

    public void selection() {
        menu();
    }

    public void menu() {
        int choix;
        int choixVoiture;
        do {
            System.out.println("Veuillez choisir votre critère:");
            System.out.println("\t1. par prix");
            System.out.println("\t2. par marque");
            System.out.println("\t3. par km(s)");
            System.out.print("Votre choix: ");
            choix = saisie.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Voici les prix des voitures:");
                    for (int i = 0; i < this.agence.voitures.size(); i++) {
                        System.out.println("\t\t" + i + ": " + this.agence.voitures.get(i).getPrixJournee());
                    }
                    System.out.print("Votre choix: ");
                    choixVoiture = saisie.nextInt();
                    break;
                case 2:
                    System.out.println("Voici les marques des voitures:");
                    for (int i = 0; i < this.agence.voitures.size(); i++) {
                        System.out.println("\t\t" + i + ": " + this.agence.voitures.get(i).getMarque());
                    }
                    System.out.print("Votre choix: ");
                    choixVoiture = saisie.nextInt();
                    CritereMarque cMarque = new CritereMarque(this.agence.voitures.get(choixVoiture).getMarque());
                    System.out.println("Nous vous proposons:");
                    for (Voiture v : this.agence.selection(cMarque)) {
                        System.out.println(v.toString());
                    }
                    break;
                case 3:
                    System.out.println("Voici les km des voitures:");
                    for (int i = 0; i < this.agence.voitures.size(); i++) {
                        System.out.println("\t\t" + i + ": " + this.agence.voitures.get(i).getKm());
                    }
                    System.out.print("Votre choix: ");
                    choixVoiture = saisie.nextInt();
                    CritereKm cKm = new CritereKm(this.agence.voitures.get(choixVoiture).getKm());
                    System.out.println("Nous vous proposons:");
                    for (Voiture v : this.agence.selection(cKm)) {
                        System.out.println(v.toString());
                    }
                    break;
                default:
                    System.out.println("Mauvais choix");
                    break;
            }
        } while (choix < 1 || choix > 3);
    }
}
