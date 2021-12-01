import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Module m11 = new Module("M11", Niveau.S1);
        Module m12 = new Module("M12", Niveau.S1);
        Module m21 = new Module("M21", Niveau.S2);
        Etudiant e1 = new Etudiant("eleve A", Arrays.asList(
            new Note(m11, 10),
            new Note(m12, 8),
            new Note(m21, 12)
        ));

        System.out.println(e1.auMoinsUneNoteSous7());
        System.out.println(e1.aLaMoyennePartout());
        System.out.println(e1.aLaMoyenneS1());
        System.out.println(e1.moyenne());

        System.out.println(e1.lesModulesObtenus());
        System.out.println(e1.meilleureNote());
        System.out.println(e1.notesParNiveau());

        Etudiant e2 = new Etudiant("eleve B", Arrays.asList(
            new Note(m11, 15),
            new Note(m12, 7),
            new Note(m21, 12)
        ));
        Etudiant e3 = new Etudiant("eleve C", Arrays.asList(
            new Note(m11, 18),
            new Note(m12, 15),
            new Note(m21, 12)
        ));
        Etudiant e4 = new Etudiant("eleve D", Arrays.asList(
            new Note(m11, 5),
            new Note(m12, 20),
            new Note(m21, 12)
        ));

        Promo promo = new Promo(2021);
        promo.ajouterEtudiant(e1);
        promo.ajouterEtudiant(e2);
        promo.ajouterEtudiant(e3);
        promo.ajouterEtudiant(e4);

        System.out.println(promo.moyennesEtudiants(Niveau.S1));
        System.out.println(promo.nomMajorS1());
    }
}
