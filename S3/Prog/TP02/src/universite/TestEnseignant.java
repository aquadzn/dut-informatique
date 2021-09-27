package universite;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestEnseignant {

    @Test
    public final void testEnseignant() {
        MaitreConf maitreConf = new MaitreConf("A");
        ProfAgrege profAgrege = new ProfAgrege("B");
        Exterieur exterieur = new Exterieur("C");

        try {
            maitreConf.ajouterHeures(190);
            profAgrege.ajouterHeures(380);
            exterieur.ajouterHeures(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(true, maitreConf.calculerHeuresComplementaires() == 0);
        Assertions.assertEquals(true, profAgrege.calculerHeuresComplementaires() == 0);
        Assertions.assertEquals(false, exterieur.calculerHeuresComplementaires() == 3);

        try {
            maitreConf.ajouterHeures(4);
            profAgrege.ajouterHeures(5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(false, maitreConf.calculerHeuresComplementaires() == 2);
        Assertions.assertEquals(false, profAgrege.calculerHeuresComplementaires() == 1);

    }
}
