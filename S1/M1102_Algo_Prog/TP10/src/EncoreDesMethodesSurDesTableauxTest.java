import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EncoreDesMethodesSurDesTableauxTest {

// MOYENNE	
	
	@Test
	public final void testMoyenne() {
		
		double[] tabLong1 = {2.7};
		assertEquals (2.7, EncoreDesMethodesSurDesTableaux.moyenne(tabLong1),0.0, "cas tableau de longueur 1");
		
		double[] tabMoyen = {12.5 , 3.7 ,  -23.5 , 0.0 , 24.3};
		assertEquals (3.4, EncoreDesMethodesSurDesTableaux.moyenne(tabMoyen),0.0, "cas moyen");
	}
	


// PLUS_GRAND	
	
	@Test
	public final void testPlusGrand() {

		double[] maxEnPremier = {22.4,-3.9,-7,13,-22,18.6};
		assertEquals (22.4, EncoreDesMethodesSurDesTableaux.plusGrand(maxEnPremier),0.0, "cas tableau longueur > 0, maxi en premier");

		double[] maxEnDernier = {12.4,-3.9,-7,13,-22,18.6};
		assertEquals (18.6, EncoreDesMethodesSurDesTableaux.plusGrand(maxEnDernier),0.0, "cas tableau longueur > 0, maxi en dernier");

		double[] maxAuMilieuEtMax0 = {-22.4,-3.9,-7,0.0,-22,-18.6};
		assertEquals (0.0, EncoreDesMethodesSurDesTableaux.plusGrand(maxAuMilieuEtMax0),0.0, "cas tableau longueur > 0, maxi au milieu");

		double[] maxNégatif = {-5555555.5, -2222222.2, -3333333.9, -7777777.7};
		assertEquals (-2222222.2, EncoreDesMethodesSurDesTableaux.plusGrand(maxNégatif),0.0, "cas tableau longueur > 0, maxi négatif");

	}


// EGAUX

	@Test
	public final void testEgaux() {
		int[] tabLongZero = {};
		int[] tabLongZero_bis = {};
		int[] tabLong5_A = {2,4,6,8,10};
		int[] tabLong5_Abis = {2,4,6,8,10};
		int[] tabLong5_B = {3, -5, 0, -1, 2};
		int[] tabLong5_C = {2, 4, -6, 8, 10};
		int[] tabLong3 = {1,2,3};

		assertTrue(EncoreDesMethodesSurDesTableaux.égaux(tabLongZero,tabLongZero_bis), "cas long=0 long=0");

		assertTrue(EncoreDesMethodesSurDesTableaux.égaux(tabLong5_A,tabLong5_Abis), "cas moyen");

		assertTrue(EncoreDesMethodesSurDesTableaux.égaux(tabLong5_A,tabLong5_A), "même tableau");

		assertFalse(EncoreDesMethodesSurDesTableaux.égaux(tabLong5_A, tabLongZero), "cas long!=0 long=0");

		assertFalse(EncoreDesMethodesSurDesTableaux.égaux(tabLongZero, tabLong5_A), "cas long=0 long!=0");

		assertFalse(EncoreDesMethodesSurDesTableaux.égaux(tabLong3, tabLong5_A), "cas longueurs différentes");

		assertFalse(EncoreDesMethodesSurDesTableaux.égaux(tabLong5_A, tabLong5_B), "cas même longueurs mais différents (1)");

		assertFalse(EncoreDesMethodesSurDesTableaux.égaux(tabLong5_A, tabLong5_C), "cas même longueurs mais différents (2)");

	}

// SOMME

	@Test
	public final void testSommeMêmeLongueur() {

		int[] tabLongZero = {};
		int[] tabLongZero_bis = {};
		int[] tabResultatLongZero = {};
		assertArrayEquals(tabResultatLongZero, EncoreDesMethodesSurDesTableaux.sommeMêmeLongueur(tabLongZero,tabLongZero_bis), "cas long0 long0");


		int[] tabLong5_A = {2, 4, 6, 8, 10};
		int[] tabLong5_B = {3, -5, 0, -1, 2};
		int[] tabResultatTestCasMoyen_long5 = {5,-1, 6, 7, 12};
		assertArrayEquals(tabResultatTestCasMoyen_long5, EncoreDesMethodesSurDesTableaux.sommeMêmeLongueur(tabLong5_A,tabLong5_B), "cas moyen");
	}
	
	@Test
	public final void testSomme() {

		int[] tabLongZero = {};
		int[] tabLongZero_bis = {};
		int[] tabResultatLongZero = {};
		assertArrayEquals(tabResultatLongZero, EncoreDesMethodesSurDesTableaux.somme(tabLongZero,tabLongZero_bis), "cas long0 long0");

		
		int[] tabLong5_A = {2, 4, 6, 8, 10};
		int[] tabLong5_B = {3, -5, 0, -1, 2};
		int[] tabResultatTestCasMoyen_long5 = {5,-1, 6, 7, 12};
		assertArrayEquals(tabResultatTestCasMoyen_long5, EncoreDesMethodesSurDesTableaux.somme(tabLong5_A,tabLong5_B), "cas moyen");

		int[] tabLong5 = {2, 4, 6, 8, 10};
		int[] tabLong3 = {1,2,3};
		int[] tabResultatCasLongueursDifférentes = {3,6,9,8,10};
		assertArrayEquals(tabResultatCasLongueursDifférentes,EncoreDesMethodesSurDesTableaux.somme(tabLong5, tabLong3), "cas A plus long que B");
		assertArrayEquals(tabResultatCasLongueursDifférentes,EncoreDesMethodesSurDesTableaux.somme(tabLong3, tabLong5), "cas B plus long que A");
		
		assertArrayEquals(tabLong5,EncoreDesMethodesSurDesTableaux.somme(tabLongZero, tabLong5), "cas A vide");
		assertArrayEquals(tabLong3,EncoreDesMethodesSurDesTableaux.somme(tabLong3, tabLongZero), "cas B vide");

		
	}


// POSITIFS

		@Test
		public final void testPositifs() {
			int[] tabLongZero = {};
			int[] tabResultatLongZero = {};

			int[] tabSansPositifs = {-2, -4, -6, -8, -10};

			int[] tabQueDesPositifs = {3, 5, 0, 1, 6};
			int[] tabResultatQueDesPositifs = {3, 5, 0, 1, 6};
			
			int[] tabCasMoyen1 = {0, -5, 6, -1, 0};
			int[] tabResultatCasMoyen1 = {0, 6, 0};

			int[] tabCasMoyen2 = {-3, 5, 0, -7, 1, -6};
			int[] tabResultatCasMoyen2 = {5, 0, 1};

					
			assertArrayEquals(tabResultatLongZero, EncoreDesMethodesSurDesTableaux.positifs(tabLongZero), "cas longueur zéro");
			
			assertArrayEquals(tabResultatLongZero, EncoreDesMethodesSurDesTableaux.positifs(tabSansPositifs), "cas sans positifs");

			assertArrayEquals(tabResultatQueDesPositifs, EncoreDesMethodesSurDesTableaux.positifs(tabQueDesPositifs), "cas que des positifs");
			
			assertArrayEquals(tabResultatCasMoyen1, EncoreDesMethodesSurDesTableaux.positifs(tabCasMoyen1), "cas moyen 1");

			assertArrayEquals(tabResultatCasMoyen2, EncoreDesMethodesSurDesTableaux.positifs(tabCasMoyen2), "cas moyen 2");
		
		}

	
}
