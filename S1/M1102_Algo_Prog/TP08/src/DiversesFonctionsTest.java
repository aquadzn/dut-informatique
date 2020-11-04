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
    final void testCarreNombre() {
        assertEquals(16, DiversesFonctions.carreEntier(4), "Cas positif");

        assertEquals(4, DiversesFonctions.carreEntier(-2), "Cas négatif");

        assertEquals(0, DiversesFonctions.carreEntier(0), "Cas nul");
    }

}
