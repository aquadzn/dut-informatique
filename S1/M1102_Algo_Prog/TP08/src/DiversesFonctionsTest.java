import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiversesFonctionsTest {

    @Test
    final void testValAbs() {
        assertEquals(4, DiversesFonctions.valAbs(4), "cas positif");

        assertEquals(4, DiversesFonctions.valAbs(-4), "cas négatif");

        assertEquals(0, DiversesFonctions.valAbs(0), "cas nul");
    }

    @Test
    final void testEstNul() {
        assertTrue(DiversesFonctions.estNul(0), "cas nul");

        assertFalse(DiversesFonctions.estNul(-6), "cas négatif");

        assertFalse(DiversesFonctions.estNul(3), "cas positif");
    }

    @Test
    final void testAleatoirePairEntre0et100inclus() {
        int alea;

        /*  Remarquons que ce jeu de tests est loin d'être parfait :
         *  Il vérifie que des valeurs hors domaine ne sont pas générées,
         *  mais ne vérifie pas que toutes les valeurs de l'interval [0,100] sont atteintes
         *  et encore moins que la probabilité est uniforme. !
         */
        for (int i=1 ; i <= 150 ; i++){
            alea = DiversesFonctions.aleatoirePairEntre0et100inclus();
            assertTrue(alea >= 0 && alea <= 100 && alea%2 == 0);
        }
    }

    @Test
    final void testSigne() {
        assertEquals(1, DiversesFonctions.signe(4), "Cas positif");

        assertEquals(-1, DiversesFonctions.signe(-2), "Cas négatif");

        assertEquals(0, DiversesFonctions.signe(0), "Cas nul");
    }

    @Test
    final void testEstPair() {
        assertTrue(DiversesFonctions.estPair(2));

        assertFalse(DiversesFonctions.estPair(1));

        assertTrue(DiversesFonctions.estPair(0));
    }

    @Test
    final void testMax() {
        assertEquals(3, DiversesFonctions.max(1, 2, 3), "Cas positif");

        assertEquals(-1, DiversesFonctions.max(-3, -2, -1), "Cas négatif");

        assertEquals(0, DiversesFonctions.max(0, 0, 0), "Cas nul");
    }

    @Test
    final void testAuMoinsUnCaractere() {
        assertTrue(DiversesFonctions.auMoinsUnCaractere("BONJOUR"));

        assertFalse(DiversesFonctions.auMoinsUnCaractere(""));
    }

    @Test
    final void testNombreBinaire() {
        assertTrue(DiversesFonctions.nombreBinaire("0110"));

        assertTrue(DiversesFonctions.nombreBinaire("0"));

        assertFalse(DiversesFonctions.nombreBinaire(""));

        assertFalse(DiversesFonctions.nombreBinaire("AB01"));
    }

    @Test
    final void testValeurEntierPositif() {
        assertEquals(8, DiversesFonctions.valeurEntierPositif("8"), "Cas positif");

        assertEquals(-1, DiversesFonctions.valeurEntierPositif("9999999999"), "Cas négatif");

        assertEquals(-1, DiversesFonctions.valeurEntierPositif("-5"), "Cas négatif");
    }

    @Test
    final void testValeurNombreBinaire() {
        assertEquals(6, DiversesFonctions.valeurNombreBinaire("0110"), "Cas positif");

        assertEquals(1073741823, DiversesFonctions.valeurNombreBinaire("111111111111111111111111111111"), "Cas max");

        assertEquals(-1, DiversesFonctions.valeurNombreBinaire("1111111111111111111111111111111"), "Cas négatif");

        assertEquals(-1, DiversesFonctions.valeurNombreBinaire(""), "Cas négatif");

        assertEquals(-1, DiversesFonctions.valeurNombreBinaire("01AB"), "Cas négatif");
    }

    @Test
    final void testPGCD() {
        assertEquals(3, DiversesFonctions.pgcd(21, 15), "Cas positif");

        assertEquals(3, DiversesFonctions.pgcd(-21, -15), "Cas positif");

        assertEquals(0, DiversesFonctions.pgcd(0, 0), "Cas nul");
    }
}
