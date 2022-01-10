import java.util.*;
import java.util.stream.Collectors;

public class Promo {

    private SortedSet<Etudiant> etudiants;

    public Promo() {
	this.etudiants = new TreeSet<>();
    }

    public void ajouter(Etudiant e) {
	etudiants.add(e);
    }

    public double moyennePromo() {
    	double moyenne = 0;
    	for (Etudiant etudiant : etudiants) {
			Iterator<Note> etudiantIterator = etudiant.iterator();
    		while (etudiantIterator.hasNext()) {
    			moyenne += etudiantIterator.next().getVal();
			}
		}

    	return moyenne / etudiants.size();
    }

	public double moyennePromoBis() {
		double moyenne = 0;
		for (Etudiant etudiant : etudiants) {
			for (Note note : etudiant) {
				moyenne += note.getVal();
			}
		}

		return moyenne / etudiants.size();
	}
}
