package universite;

import java.util.ArrayList;
import java.util.Scanner;

public class Etablissement {

    private static Scanner sc = new Scanner(System.in);

    private ArrayList<Enseignant> enseignants;

    public Etablissement() {
        this.enseignants = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Enseignant e : this.enseignants) {
            s.append(e.toString()).append('\n');
        }

        return s.toString();
    }

    public void recruterEnseignant(Enseignant e) {
        this.enseignants.add(e);
    }

    public void virerEnseignants() {
        this.enseignants.clear();
    }

    public void majHeuresComplementaires() {
        for(Enseignant e : this.enseignants) {
            System.out.print("Changer note de " + e.getNom() + " : ");
            if (sc.nextLine().toLowerCase().equals("oui")) {
                String heure = "";
                do {
                    System.out.print("Combien d'heures en plus ? ");
                    heure = sc.nextLine();
                    try {
                        e.ajouterHeures(Integer.parseInt(heure));
                    } catch (Exception ex) {
                        System.out.print("Heure incorrecte. ");
                    }
                } while (Integer.parseInt(heure) < 1);
            }
        }
    }

    public int totalHeuresComplementaires() {
        return this.enseignants.stream()
                .mapToInt(Enseignant::nombreHeuresComplementaires)
                .sum();
    }

    public ArrayList<String> enseignantsNoms() {
        ArrayList<String> nomsEnseignants = new ArrayList<>();
        for(Enseignant e : this.enseignants) {
            nomsEnseignants.add(e.getNom());
        }

        return nomsEnseignants;
    }

    public ArrayList<Enseignant> enseignantsZeroHeuresComplementaires() {
        ArrayList<Enseignant> enseignantsZero = new ArrayList<>();
        for(Enseignant e : this.enseignants) {
            if (e.nombreHeuresComplementaires() == 0) {
                enseignantsZero.add(e);
            }
        }

        return enseignantsZero;
    }

    public boolean enseignantsNHeuresComplementaires(int n) {
        for(Enseignant e : this.enseignants) {
            if (e.nombreHeuresComplementaires() > n) {
                return true;
            }
        }

        return false;
    }

    public String enseignantsPlusHeuresCours() {
        if (this.enseignants.size() == 0) {
            return null;
        }

        Enseignant max = enseignants.get(0);
        for(Enseignant e : this.enseignants) {
            if (e.getHeuresTravaillees() > max.getHeuresTravaillees()) {
                max = e;
            }
        }

        return max.getNom();
    }
}
