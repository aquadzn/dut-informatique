import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Etudiant implements Iterable<Note>, Comparable {
    public static int compteur = 0;
    private int numeroEtudiant;
    private String nom;
    private List<Note> notes;

    public Etudiant(String nom, List<Note> notes) {
	this.nom = nom;
	this.notes = notes;
	this.numeroEtudiant = compteur;
	compteur++;
    }

    public String getNom() {
	return nom;
    }

    @Override
    public String toString() {
	return "Etudiant [nom=" + nom + ", notes=" + notes + "]";
    }

    public int getNumeroEtudiant() {
	return numeroEtudiant;
    }

    @Override
    public Iterator<Note> iterator() {
        return notes.iterator();
    }

    @Override
    public int compareTo(Object o) {
        Etudiant e2 = (Etudiant) o;
        if (this.getNom().equals(e2.getNom())) {
            return this.getNumeroEtudiant() - e2.getNumeroEtudiant();
        } else {
            return this.getNom().compareTo(e2.getNom());
        }
    }
}
