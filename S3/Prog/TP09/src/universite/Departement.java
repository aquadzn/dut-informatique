package universite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Departement {

    private ArrayList<Enseignant> enseignants;
    private Set<Cours> lesCours;

    public Departement() {
    	enseignants = new ArrayList<Enseignant>();
    	lesCours = new HashSet<>();
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
		lesCours.add(c);
    }

    public Set<String> lesIntitulesDeCours() {
    	Set<String> strings = new HashSet<>();
    	for(Cours c : lesCours) {
    		strings.add(c.getIntitule());
		}
    	return strings;
	}

	public SortedSet<String> lesIntitulesDeCoursTrie() {
        SortedSet<String> strings = new TreeSet<String>(String::compareTo);
        for(Cours c: lesCours) {
            strings.add(c.getIntitule());
        }
        return strings;
    }

    public SortedSet<Enseignant> lesResponsablesL2NomPuisIdentifiant() {
        SortedSet<Enseignant> res = new TreeSet<Enseignant>(((Enseignant o1, Enseignant o2) -> {
            if (o1.getNom().equals(o2.getNom())) {
                return o1.getId() - o2.getId();
            }
            else {
                return o1.getNom().compareTo(o2.getNom());
            }
        }));

        for(Cours c : lesCours) {
            if (c.getNiveau() == Niveau.L2) {
                res.add(c.getResponsable());
            }
        }
        return res;
    }

    public int nbreResponsable() {
        Set<Enseignant> res = new HashSet<>();
        for(Cours c : lesCours) {
            res.add(c.getResponsable());
        }

        return res.size();
    }

    public SortedSet<Enseignant> enseignantsSansHeuresCompTrieHeuresFaitesPuisNom() {
        SortedSet<Enseignant> res = new TreeSet<Enseignant>(((Enseignant o1, Enseignant o2) -> {
            if (o1.getHeureEff() == o2.getHeureEff()) {
                int _r = o1.getNom().compareTo(o2.getNom());
                if (_r == 0) {
                    return o1.getId() - o2.getId();
                }
                return _r;
            }
            else {
                return o1.getHeureEff() - o2.getHeureEff();
            }
        }));

        for(Enseignant e : enseignants) {
            if (e.getHeureSupp() == 0) {
                res.add(e);
            }
        }
        return res;
    }
}
