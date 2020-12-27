import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class JeuTest {

    @Test
    void calculVoisins() {
        int[][] aucunVoisin = new int[][] {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
        };
        int[][] unVoisin = new int[][] {
            {0, 0, 0},
            {0, 1, 1},
            {0, 0, 0},
        };
        int[][] deuxVoisins = new int[][] {
            {0, 0, 0},
            {1, 1, 1},
            {0, 0, 0},
        };
        int[][] troisVoisins = new int[][] {
            {0, 0, 0},
            {1, 0, 1},
            {0, 1, 0},
        };
        int[][] plusDeTroisVoisins = new int[][] {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1},
        };

        assertEquals(0, Jeu.calculVoisins(aucunVoisin, 1, 1));
        assertEquals(1, Jeu.calculVoisins(unVoisin, 1, 1));
        assertEquals(2, Jeu.calculVoisins(deuxVoisins, 1, 1));
        assertEquals(3, Jeu.calculVoisins(troisVoisins, 1, 1));
        assertTrue(Jeu.calculVoisins(plusDeTroisVoisins, 1, 1) > 3);
    }

    @Test
    void evolution() {
        int[][] vivante = new int[][] {
            {0, 1, 0},
            {1, 1, 0},
            {0, 0, 0},
        };
        int[][] vivanteAttendu = new int[][] {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 0},
        };

        int[][] pareil = new int[][] {
            {0, 0, 1},
            {0, 1, 0},
            {1, 0, 0},
        };
        int[][] pareilAttendu = new int[][] {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0},
        };

        int[][] morte = new int[][] {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0},
        };
        int[][] morteAttendu = new int[][] {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
        };

        int[][] oscillateur = new int[][] {
            {0, 0, 0},
            {1, 1, 1},
            {0, 0, 0},
        };
        int[][] oscillateurAttendu = new int[][] {
            {0, 1, 0},
            {0, 1, 0},
            {0, 1, 0},
        };

        int[][] bloc = new int[][] {
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0},
        };
        int[][] blocAttendu = new int[][] {
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0},
        };

        assertArrayEquals(vivanteAttendu, Jeu.evolution(vivante, 3, 3));
        assertArrayEquals(pareilAttendu, Jeu.evolution(pareil, 3, 3));
        assertArrayEquals(morteAttendu, Jeu.evolution(morte, 3, 3));
        assertArrayEquals(oscillateurAttendu, Jeu.evolution(oscillateur, 3, 3));
        assertArrayEquals(blocAttendu, Jeu.evolution(bloc, 4, 4));
    }

}