import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ABRTest {

	private static ABRInt ABRVide;
	private static ABRInt ABRFeuille1, ABRFeuille2, ABRFeuille3;
	private static ABRInt ABRQcq;

	@Before
	public void setUp() throws Exception {
		ABRVide = new ABRInt();
		ABRFeuille1 = new ABRInt(5);
		ABRFeuille2 = new ABRInt(5);
		ABRFeuille3 = new ABRInt(5);
		ABRQcq = new ABRInt(new ABRInt(new ABRInt(), 6, new ABRInt(11)), 15,
				new ABRInt(new ABRInt(16), 18, new ABRInt(
						new ABRInt(new ABRInt(19), 19, new ABRInt()), 20, new ABRInt())));
	}

	@Test
	public void TestMin() {
		assertEquals("Min ABRFeuille", 5, (int) ABRFeuille1.min());
		assertEquals("Min ABRQcq", 6, (int) ABRQcq.min());
	}

	@Test(expected = Error.class)
	public void testMinABRVide() {
		ABRVide.min();
	}

	@Test
	public void TestMax() throws Exception {
		assertEquals("Max ABRFeuille", 5, (int) ABRFeuille1.max());
		assertEquals("Max ABRQcq", 20, (int) ABRQcq.max());
	}

	@Test(expected = Error.class)
	public void testMaxABRVide() throws Exception {
		ABRVide.max();
	}

	@Test
	public void testRechercheFausse() {
		assertFalse("Recherche ABRNull", ABRVide.recherche(7));
		assertFalse("Recherche fausse ABRFeuille", ABRFeuille1.recherche(7));
		assertFalse("Recherche fausse ABRQcq", ABRQcq.recherche(7));
	}

	@Test
	public void testRechercheVraie() {
		assertTrue("Recherche vraie ABRFeuille", ABRFeuille1.recherche(5));
		assertTrue("Recherche vraie ABRQcq", ABRQcq.recherche(6));
		assertTrue("Recherche vraie ABRQcq", ABRQcq.recherche(20));
		assertTrue("Recherche vraie ABRQcq", ABRQcq.recherche(16));
	}

	@Test
	public void testInsertionABRVide() {
		ABRVide.insertion(5);
		assertTrue("Insertion dans ABRNull", ABRVide.estIdentiqueA(ABRFeuille1));
	}

	@Test
	public void testInsertionABRFeuille() {
		ABRInt insereFeuille1 = new ABRInt(new ABRInt(3), 5, new ABRInt());
		ABRFeuille1.insertion(3);
		assertTrue("Insertion dans feuille à gauche",
				insereFeuille1.estIdentiqueA(ABRFeuille1));
		ABRInt insereFeuille2 = new ABRInt(new ABRInt(), 5, new ABRInt(8));
		ABRFeuille2.insertion(8);
		assertTrue("Insertion dans feuille à droite",
				insereFeuille2.estIdentiqueA(ABRFeuille2));
		ABRInt insereFeuille3 = new ABRInt(new ABRInt(5), 5, new ABRInt());
		ABRFeuille3.insertion(5);
		assertTrue("Insere déjà présent dans feuille",
				insereFeuille3.estIdentiqueA(ABRFeuille3));
	}

	@Test
	public void testInsertionABRQcq() {
		ABRInt insere1 = new ABRInt(
				new ABRInt(new ABRInt(), 6, new ABRInt(new ABRInt(8), 11, new ABRInt())),
				15, new ABRInt(new ABRInt(16), 18, new ABRInt(
						new ABRInt(new ABRInt(19), 19, new ABRInt()), 20, new ABRInt())));
		ABRQcq.insertion(8);
		assertTrue("Insere dans ABRQcq à gauche", insere1.estIdentiqueA(ABRQcq));
		ABRInt insere2 = new ABRInt(
				new ABRInt(new ABRInt(), 6, new ABRInt(new ABRInt(8), 11, new ABRInt())),
				15,
				new ABRInt(new ABRInt(16), 18,
						new ABRInt(new ABRInt(new ABRInt(19), 19, new ABRInt()), 20,
								new ABRInt(22))));
		insere1.insertion(22);
		assertTrue("Insere dans ABRQcq à droite", insere2.estIdentiqueA(insere1));
		ABRInt insere3 = new ABRInt(
				new ABRInt(new ABRInt(), 6, new ABRInt(new ABRInt(8), 11, new ABRInt())),
				15,
				new ABRInt(new ABRInt(16), 18,
						new ABRInt(
								new ABRInt(new ABRInt(new ABRInt(19), 19, new ABRInt()),
										19, new ABRInt()),
								20, new ABRInt(22))));
		insere2.insertion(19);
		assertTrue("Insere dans ABRQcq déjà présente", insere3.estIdentiqueA(insere2));
	}

	@Test
	public void testSuppressionABRVide() {
		ABRVide.supprime(5);
		assertEquals("Suppression ABRVide", ABRVide, ABRVide);
	}

	@Test
	public void testSuppressionABRFeuille() {
		ABRFeuille1.supprime(100);
		assertTrue("Suppression impossible ABRFeuille",
				ABRFeuille2.estIdentiqueA(ABRFeuille1));
		ABRFeuille1.supprime(5);
		assertTrue("Suppression effective ABRFeuille",
				ABRVide.estIdentiqueA(ABRFeuille1));
	}

	@Test
	public void testSuppressionABRQcq() {
		ABRQcq.supprime(100);
		assertTrue("Suppression impossible ABRQcq", ABRQcq.estIdentiqueA(ABRQcq));
		ABRInt suppression1 = new ABRInt(new ABRInt(new ABRInt(), 6, new ABRInt(11)), 15,
				new ABRInt(new ABRInt(16), 18,
						new ABRInt(new ABRInt(19), 20, new ABRInt())));
		ABRQcq.supprime(19);
		assertTrue("Suppression effective ABRQcq feuille",
				suppression1.estIdentiqueA(ABRQcq));

		ABRInt suppression2 = new ABRInt(new ABRInt(new ABRInt(), 6, new ABRInt(11)), 15,
				new ABRInt(new ABRInt(16), 18, new ABRInt(19)));
		ABRQcq.supprime(20);
		assertTrue("Suppression effective ABRQcq avec un fils gauche",
				suppression2.estIdentiqueA(ABRQcq));

		ABRInt suppression2bis = new ABRInt(new ABRInt(11), 15,
				new ABRInt(new ABRInt(16), 18, new ABRInt(
						new ABRInt(new ABRInt(19), 19, new ABRInt()), 20, new ABRInt())));
		// RàZ de ABRqcq
		ABRQcq = new ABRInt(new ABRInt(new ABRInt(), 6, new ABRInt(11)), 15,
				new ABRInt(new ABRInt(16), 18, new ABRInt(
						new ABRInt(new ABRInt(19), 19, new ABRInt()), 20, new ABRInt())));
		ABRQcq.supprime(6);
		System.out.println(suppression2bis);
		System.out.println(ABRQcq);
		assertTrue("Suppression effective ABRQcq avec un fils droit",
				suppression2bis.estIdentiqueA(ABRQcq));

		ABRInt suppression3 = new ABRInt(new ABRInt(6), 11,
				new ABRInt(new ABRInt(16), 18, new ABRInt(
						new ABRInt(new ABRInt(19), 19, new ABRInt()), 20, new ABRInt())));
		// RàZ de ABRqcq
		ABRQcq = new ABRInt(new ABRInt(new ABRInt(), 6, new ABRInt(11)), 15,
				new ABRInt(new ABRInt(16), 18, new ABRInt(
						new ABRInt(new ABRInt(19), 19, new ABRInt()), 20, new ABRInt())));
		ABRQcq.supprime(15);
		assertTrue("Suppression effective ABRQcq avec deux fils",
				suppression3.estIdentiqueA(ABRQcq));
	}
}
