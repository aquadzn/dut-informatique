import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FonctionsSurTableauxTest {

	
	@Test
	public final void testNbOccurrences() {
		
		assertEquals (0, FonctionsSurTableaux.nbOccurrences(new int[0], 12), "cas tableau longueur 0");
		
		int[] tab12PasPresent = {2,3,-7,13,22,0};
		assertEquals (0, FonctionsSurTableaux.nbOccurrences(tab12PasPresent, 12), "cas tableau longueur > 0, val pas presente");
		
		// On prend bien garde de tester la prise en compte de la première case et de la dernière case du tableau.
		int[] tab12Present = {12,3,12,13,0,22,12};
		assertEquals (3, FonctionsSurTableaux.nbOccurrences(tab12Present, 12), "cas tableau longueur > 0, val presente");
		
	}

	@Test
	public final void testNbStrictementNegatifs() {
		
		assertEquals (0, FonctionsSurTableaux.nbStrictementNegatifs(new int[0]), "cas tableau longueur 0");
		
		int[] pasDeNegatifs = {2,3,7,13,22,0};
		assertEquals (0, FonctionsSurTableaux.nbStrictementNegatifs(pasDeNegatifs), "cas tableau longueur > 0, pas de negatifs");
		
		// On prend bien garde de tester la prise en compte de la première case et de la dernière case du tableau.
		int[] desNegatifst = {-12,3,12,-13,0,22,-12};
		assertEquals (3, FonctionsSurTableaux.nbStrictementNegatifs(desNegatifst), "cas tableau longueur > 0, plusieurs negatifs");
		
	}
	
	@Test
	public final void testSommeValeurs() {

		assertEquals (0, FonctionsSurTableaux.sommeValeurs(new int[0]), "cas tableau longueur 0");
				
		int[] tabMoyen = {12,3,12,-13,0,22};
		assertEquals (36, FonctionsSurTableaux.sommeValeurs(tabMoyen), "cas moyen");

	}

	@Test
	public final void testEstPresent() {
		
		assertFalse (FonctionsSurTableaux.estPresent(new int[0], 12), "cas tableau longueur 0");
		
		int[] tab12PasPresent = {2,3,-7,13,22,0};
		assertFalse (FonctionsSurTableaux.estPresent(tab12PasPresent, 12), "cas tableau longueur > 0, val pas presente");
		
		int[] tab12En1èrePosition = {12,3,-7,13,0,22};
		assertTrue (FonctionsSurTableaux.estPresent(tab12En1èrePosition, 12), "cas tableau longueur > 0, val en indice 0");
		
		int[] tab12EnDernièrePosition = {22,3,-7,13,0,12};
		assertTrue (FonctionsSurTableaux.estPresent(tab12EnDernièrePosition, 12), "cas tableau longueur > 0, val en dernier indice");

		int[] tab12EnPositionMoyenne = {22,3,-7,12,0,-12};
		assertTrue (FonctionsSurTableaux.estPresent(tab12EnPositionMoyenne, 12), "cas tableau longueur > 0, val en position moyenne");
		
	}	
	
	@Test
	public final void testTousPositifs() {
		
		assertTrue (FonctionsSurTableaux.tousPositifs(new int[0]), "cas tableau longueur 0");
		
		int[] tabMoyenFaux = {2,0,-7,13,22,0};
		assertFalse (FonctionsSurTableaux.tousPositifs(tabMoyenFaux), "cas tableau longueur > 0, faux");

		int[] tabMoyenVrai = {2,0,7,13,22,0};
		assertTrue (FonctionsSurTableaux.tousPositifs(tabMoyenVrai), "cas tableau longueur > 0, vrai");
		
		int[] tabNegEn1èrePosition = {-12,3,7,13,0,22};
		assertFalse (FonctionsSurTableaux.tousPositifs(tabNegEn1èrePosition), "cas tableau longueur > 0, negatif en indice 0");
		
		int[] tabNegEnDernièrePosition = {22,3,7,13,0,-12};
		assertFalse (FonctionsSurTableaux.tousPositifs(tabNegEnDernièrePosition), "cas tableau longueur > 0, val en dernier indice");
	
	}

	@Test
	public final void testIndicePremOccurrence() {

		assertEquals(-1, FonctionsSurTableaux.indicePremOccurrence(new int[0], 12), "cas tableau longueur 0");

		int[] tab12PasPresent = {2,3,-7,13,22,0};
		assertEquals (-1, FonctionsSurTableaux.indicePremOccurrence(tab12PasPresent, 12), "cas tableau longueur > 0, val pas presente");

		int[] tab12En1èrePosition = {12,3,-7,12,0,22};
		assertEquals (0, FonctionsSurTableaux.indicePremOccurrence(tab12En1èrePosition, 12), "cas tableau longueur > 0, val en indice 0");

		int[] tab12EnDernièrePosition = {22,3,-7,13,0,12};
		assertEquals (5, FonctionsSurTableaux.indicePremOccurrence(tab12EnDernièrePosition, 12), "cas tableau longueur > 0, val en dernier indice");

		int[] tab12EnPositionMoyenne = {22,3,-7,12,0,12, 12};
		assertEquals (3, FonctionsSurTableaux.indicePremOccurrence(tab12EnPositionMoyenne, 12), "cas tableau longueur > 0, val en position moyenne");

	}

	@Test
	public final void testIndiceDernOccurrence() {

		assertEquals(-1, FonctionsSurTableaux.indiceDernOccurrence(new int[0], 12), "cas tableau longueur 0");

		int[] tab12PasPresent = {2,3,-7,13,22,0};
		assertEquals (-1, FonctionsSurTableaux.indiceDernOccurrence(tab12PasPresent, 12), "cas tableau longueur > 0, val pas presente");

		int[] tab12En4ePosition = {12,3,-7,12,0,22};
		assertEquals (3, FonctionsSurTableaux.indiceDernOccurrence(tab12En4ePosition, 12), "cas tableau longueur > 0, val en dernier indice");

		int[] tab5En1erePosition = {5, 3, 1, 2, 4};
		assertEquals (0, FonctionsSurTableaux.indiceDernOccurrence(tab5En1erePosition, 5), "cas tableau longueur > 0, val en premier indice");

		int[] tab12EnPositionMoyenne = {22,12,-7,15, 12, 12,0,1};
		assertEquals (5, FonctionsSurTableaux.indiceDernOccurrence(tab12EnPositionMoyenne, 12), "cas tableau longueur > 0, val en position moyenne");

	}

	
	@Test
	public final void testPlusGrandPositif() {
		
		assertEquals (-1.0, FonctionsSurTableaux.plusGrandPositif(new double[0]), 0.0, "cas tableau longueur 0");
		
		double[] queNegatifs = {-2,-3,-7.7,-13,-22.3,-7};
		assertEquals (-1.0, FonctionsSurTableaux.plusGrandPositif(queNegatifs),0.0, "cas tableau longueur > 0, que des negatifs");
		
		double[] maxEnPremier = {22.4,-3.9,-7,13,-22,18.6};
		assertEquals (22.4, FonctionsSurTableaux.plusGrandPositif(maxEnPremier),0.0, "cas tableau longueur > 0, maximum en premier");

		double[] maxEnDernier = {12.4,-3.9,-7,13,-22,18.6};
		assertEquals (18.6, FonctionsSurTableaux.plusGrandPositif(maxEnDernier),0.0, "cas tableau longueur > 0, maximum en dernier");

		double[] maxAuMilieuEtMax0 = {-22.4,-3.9,-7,0.0,-22,-18.6};
		assertEquals (0.0, FonctionsSurTableaux.plusGrandPositif(maxAuMilieuEtMax0),0.0, "cas tableau longueur > 0, position moyenne, maximum = zero");
		
	}
	
}
