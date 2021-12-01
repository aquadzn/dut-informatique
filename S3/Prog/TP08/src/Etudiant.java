import java.util.*;
import java.util.stream.Collectors;

public class Etudiant {
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

    public List<Note> getNotes() {
        return notes;
    }

    @Override
    public String toString() {
	return "Etudiant [nom=" + nom + ", notes=" + notes + "]";
    }

    public int getNumeroEtudiant() {
	return numeroEtudiant;
    }

    public boolean auMoinsUneNoteSous7() {
        return this.notes.stream()
            .anyMatch(note -> note.getVal() < 7);
    }

    public boolean aLaMoyennePartout() {
        return this.notes.stream()
            .allMatch(note -> note.getVal() >= 10);
    }

    public boolean aLaMoyenneS1() {
        return this.notes.stream()
            .filter(note -> note.getModule().getNiveau() == Niveau.S1)
            .allMatch(note -> note.getVal() >= 10);
    }

    public int moyenne() {
        return this.notes.stream()
            .map(Note::getVal)
            .reduce(0, Integer::sum)
            / this.notes.size();
    }

    public int moyenne(Niveau niveau) {
        return this.notes.stream()
            .filter(note -> note.getModule().getNiveau() == niveau)
            .map(Note::getVal)
            .reduce(0, Integer::sum)
            / this.notes.size();
    }

    public Collection<Module> lesModulesObtenus() {
        return this.notes.stream()
            .filter(note -> note.getVal() >= 10)
            .map(Note::getModule)
            .collect(Collectors.toList());
    }

    public int meilleureNote() {
        return this.notes.stream()
            .map(Note::getVal)
            .max(Integer::compareTo)
            .get();
    }

    public Map<Niveau, List<Note>> notesParNiveau() {
        return this.notes.stream()
            .collect(Collectors.groupingBy(
                note -> note.getModule().getNiveau()
            ));
    }
}
