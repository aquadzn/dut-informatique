import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRegistre {
	private Personne p1;
	private Personne p2;
	private Personne p3;
	private Personne p4;
	private EtatCivil etatCivilNormal;
	private EtatCivil etatCivilTousMorts;
	private EtatCivil etatCivilTousVivants;

	@BeforeEach
	void setUp() throws Exception {
		p1 = new Personne("AA", 1980);
		p2 = new Personne("BB", 1940);
		p3 = new Personne("CC", 2000);
		p4 = new Personne("DD", 1960);
		p2.meurt(1951);
		p3.meurt(2013);
		ArrayList<Personne> l = new ArrayList<Personne>();
		l.add(p1);
		l.add(p2);
		l.add(p3);
		l.add(p4);
		etatCivilNormal = new EtatCivil(l);	
		ArrayList<Personne> lMort = new ArrayList<Personne>();
		lMort.add(p2);
		lMort.add(p3);
		etatCivilTousMorts = new EtatCivil(lMort);
		ArrayList<Personne> lVivant = new ArrayList<Personne>();
		lVivant.add(p1);
		lVivant.add(p4);
		etatCivilTousVivants = new EtatCivil(lVivant);
	}
	
	@Test
	public void testnbreDeVivants() {
		System.out.println(etatCivilNormal);
		assertEquals(2, etatCivilNormal.nombreDeVivant());
	}

	@Test
	public void testnbreDeMortsApres1960() {
		assertEquals(1, etatCivilNormal.nombreDeMortApres1960());
	}

	@Test
	public void testnbreDeVivantsDe1960() {
		assertEquals(1, etatCivilNormal.nombreDeVivantDe1960());
	}

	@Test
	public void testTousMorts() {
		assertFalse(etatCivilNormal.tousMort());
		assertTrue(etatCivilTousMorts.tousMort());
		assertFalse(etatCivilTousVivants.tousMort());
	}

	@Test
	public void testAuMoinsUnVivant() {
		assertTrue(etatCivilNormal.auMoinsUnVivant());
		assertFalse(etatCivilTousMorts.auMoinsUnVivant());
		assertTrue(etatCivilTousVivants.auMoinsUnVivant());
	}

//	@Test
//	public void testTousVivant() {
//		assertFalse(etatCivilNormal.tousVivant());
//		assertFalse(etatCivilTousMorts.tousVivant());
//		assertTrue(etatCivilTousVivants.tousVivant());
//	}
//
//	@Test
//	public void testnbreDeMorts() {
//		assertEquals(2, etatCivilNormal.nombreDeMort());
//	}
//
	@Test
	public void testchercherVivant() throws AucunVivant {
		assertEquals(p1, etatCivilNormal.chercherPremierVivant());
	}

	@Test
	public void testchercherVivant2() throws AucunVivant {
		assertThrows(AucunVivant.class,()->etatCivilTousMorts.chercherPremierVivant());
	}

	@Test
	public void testchercherMort() throws AucunMort {
		assertEquals(p3, etatCivilNormal.chercherDernierMort());
	}

	@Test
	public void testchercherMort2() throws AucunMort {
		assertThrows(AucunMort.class,()->etatCivilTousVivants.chercherDernierMort());
	}
}
