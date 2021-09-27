package universite;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;

public class TestEtablissement {

    private Etablissement etablissement;
    private MaitreConf maitreConf;
    private ProfAgrege profAgrege;
    private Exterieur exterieur;

    @BeforeEach
    public void setUp() {
        maitreConf = new MaitreConf("A");
        profAgrege = new ProfAgrege("B");
        exterieur = new Exterieur("C");

        try {
            maitreConf.ajouterHeures(200);
            profAgrege.ajouterHeures(380);
            exterieur.ajouterHeures(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        etablissement = new Etablissement();
        etablissement.recruterEnseignant(maitreConf);
        etablissement.recruterEnseignant(profAgrege);
        etablissement.recruterEnseignant(exterieur);
    }

    @Test
    public final void testNoms() {
        Assertions.assertEquals(Arrays.asList("A", "B", "C"), etablissement.enseignantsNoms());

        Etablissement e2 = new Etablissement();
        ArrayList<String> empty = new ArrayList<>();
        Assertions.assertEquals(empty, e2.enseignantsNoms());
    }

    @Test
    public final void testZero() {
        Assertions.assertEquals(Arrays.asList(profAgrege), etablissement.enseignantsZeroHeuresComplementaires());
    }

    @Test
    public final void testNHeures() {
        Assertions.assertTrue(etablissement.enseignantsNHeuresComplementaires(6));
        Assertions.assertFalse(etablissement.enseignantsNHeuresComplementaires(10));
    }

    @Test
    public final void testPlusHeures() {
        Assertions.assertEquals(profAgrege.getNom(), etablissement.enseignantsPlusHeuresCours());

        etablissement.virerEnseignants();

        Assertions.assertNull(etablissement.enseignantsPlusHeuresCours());
    }
}
