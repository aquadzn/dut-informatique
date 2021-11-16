import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Departement {

    private ArrayList<Enseignant> enseignants;
    private ArrayList<Cours> lesCours;

    public Departement() {
        enseignants = new ArrayList<Enseignant>();
        lesCours = new ArrayList<Cours>();
    }

    public void ajouter(Enseignant e) {
        enseignants.add(e);
    }

    public Enseignant getEnseignant(int i) {
        return enseignants.get(i);
    }

    @Override
    public String toString() {
        return "Departement [enseignants=" + enseignants + "\n lesCours= \n"
                + lesCours + "]";
    }

    public void ajouter(Cours c)  {
        boolean dejaLa=false;
        for (Cours leCours : lesCours) {
            if (leCours.equals(c)) {
                dejaLa=true;
            }
        }
        if(!dejaLa)
            lesCours.add(c);
    }

    public ArrayList<Cours> lesCoursDeMaster() {
        ArrayList<Cours> cours = new ArrayList<>();
        for(Cours c : this.lesCours) {
            if (c.getNiveau() == Niveau.M1 || c.getNiveau() == Niveau.M2) {
                cours.add(c);
            }
        }
        return cours;
//        return lesCours.stream()
//                .filter(cours -> cours.getNiveau() == Niveau.M1 || cours.getNiveau() == Niveau.M2)
//                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Cours> lesCoursM212() {
        ArrayList<Cours> cours = new ArrayList<>();
        for(Cours c : this.lesCours) {
            if (c.getIntitule().equals("M212")) {
                cours.add(c);
            }
        }
        return cours;
//        return lesCours.stream()
//                .filter(cours -> cours.getIntitule().equals("M212"))
//                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Cours> selectionnerCours(Predicate<Cours> condition) {
//        ArrayList<Cours> cours = new ArrayList<>();
//        for(Cours c : this.lesCours) {
//            if (condition.test(c)) {
//                cours.add(c);
//            }
//        }
//        return cours;
        return lesCours.stream()
                .filter(condition::test)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
