import java.util.Scanner;

import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TestShiFUMI {
    private Coup cis;
    private Coup pap;
    private Coup pie;
    private Joueur j1;
    private Joueur j2;
    Partie p;
    private int ancien1;
    private int ancien2;

    @Before
    public void setUp() throws Exception {
	cis = new Coup("ciseaux");
	pap = new Coup("papier");
	pie = new Coup("pierre");
	j1 = new Humain("Arthur");
	j2 = new Machine();
	j1.setScore(4);
	j2.setScore(4);
	ancien1 = j1.getScore();
	ancien2 = j2.getScore();
	p = new Partie(j1, j2, 3);

    }

    @Test
    public void resoudreTourEgalite() {

	j2.setCoupCourant(cis);
	j1.setCoupCourant(cis);
	p.resoudreTour();
	assertEquals(j1.getScore(), ancien1 + 1);
	assertEquals(j2.getScore(), ancien2 + 1);
    }

    @Test
    public void resoudreTour1() {
	j1.setCoupCourant(cis);
	j2.setCoupCourant(pap);
	p.resoudreTour();

	assertTrue(j1.getScore() == ancien1 + 2);
	assertTrue(j2.getScore() == ancien2);
    }

    @Test
    public void resoudreTour2() {
	j1.setCoupCourant(pap);
	j2.setCoupCourant(cis);
	p.resoudreTour();
	assertTrue(j2.getScore() == ancien2 + 2);
	assertTrue(j1.getScore() == ancien1);
    }

}
