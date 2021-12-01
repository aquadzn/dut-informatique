import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Promo {
    private ArrayList<Etudiant> etudiants;
    private int annee;

    public Promo(int annee) {
        this.annee = annee;
        this.etudiants = new ArrayList<>();
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    public int getAnnee() {
        return annee;
    }

    public void ajouterEtudiant(Etudiant e) {
        this.etudiants.add(e);
    }

    public Map<String, Integer> moyennesEtudiants() {
        return this.etudiants.stream()
            .collect(Collectors.toMap(
                Etudiant::getNom,
                Etudiant::moyenne
            ));
    }

    public Map<String, Integer> moyennesEtudiants(Niveau niveau) {
        return this.etudiants.stream()
            .collect(Collectors.toMap(
                Etudiant::getNom,
                e -> e.moyenne(niveau)
            ));
    }

    public String nomMajorS1() {
        return this.etudiants.stream()
            .max(Comparator.comparingInt(e -> e.moyenne(Niveau.S1)))
            .map(Etudiant::getNom)
            .get();

//        return this.etudiants.stream()
//            .reduce(e -> Math.max(e.moyenne(Niveau.S1), e.moyenne(Niveau.S1)))
//            .get().getNom()
//            ;
    }
}
