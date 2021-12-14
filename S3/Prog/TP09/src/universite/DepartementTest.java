package universite;

import static org.junit.Assert.*;

    import java.util.ArrayList;
    import java.util.Collection;
    import java.util.Set;
    import java.util.SortedSet;

    import org.junit.Before;
    import org.junit.Test;

public class DepartementTest {
    private Enseignant x, y, z, t;
    private Cours c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14;
    private Departement info;

    @Before
    public void setUp() throws Exception {
        x = new Prag("Homps");
        y = new MdC("Simonot");
        z = new Vacataire("Aquil");
        t = new Vacataire("Picton");
        x.ajouterHeure(200);
        y.ajouterHeure(100);
        z.ajouterHeure(56);
        t.ajouterHeure(40);

        c1 = new Cours("M212", x, Niveau.L1);
        c5 = new Cours("M213", x, Niveau.L1);
        c6 = new Cours("M214", z, Niveau.L1);
        c2 = new Cours("M212", y, Niveau.L3);
        c7 = new Cours("M216", z, Niveau.L3);
        c3 = new Cours("M310", y, Niveau.L2);
        c4 = new Cours("M213", x, Niveau.L2);
        c9 = new Cours("M214", y, Niveau.L2);
        c8 = new Cours("M215", y, Niveau.L2);
        c10 = new Cours("M215", x, Niveau.M1);
        c11 = new Cours("M212", z, Niveau.M1);
        c12 = new Cours("M211", x, Niveau.M1);
        c13 = new Cours("M213", y, Niveau.M2);
        c14 = new Cours("M212", z, Niveau.M2);

        info = new Departement();
        info.ajouter(x);
        info.ajouter(y);
        info.ajouter(z);

        info.ajouter(c1);
        info.ajouter(c2);
        info.ajouter(c3);
        info.ajouter(c4);
        info.ajouter(c5);
        info.ajouter(c6);
        info.ajouter(c7);
        info.ajouter(c8);
        info.ajouter(c9);
        info.ajouter(c10);
        info.ajouter(c11);
        info.ajouter(c12);
        info.ajouter(c13);
        info.ajouter(c14);
    }


    @Test
    public void testlesIntitulesDeCours() {
        System.out.println("le departement " + info);
        Collection<String> res = info.lesIntitulesDeCours();
        System.out.println("le resultat lesIntitulesDeCours" + res);
        assertEquals(7, res.size());
        assertTrue(res.contains("M211"));
        assertTrue(res.contains("M212"));
        assertTrue(res.contains("M213"));
        assertTrue(res.contains("M214"));
        assertTrue(res.contains("M215"));
        assertTrue(res.contains("M216"));
        assertTrue(res.contains("M310"));
    }

    @Test
    public void testlesIntitulesDeCoursTrie() {
        System.out.println("le departement " + info);
        Collection<String> res = info.lesIntitulesDeCoursTrie();
        System.out.println("le resultat lesIntitulesDeCoursTrie" + res);
        assertEquals(7, res.size());
        String[] tab1 = new String[7];
        String[] tab = res.toArray(tab1);
        assertEquals("M211", tab[0]);
        assertEquals("M212", tab[1]);
        assertEquals("M213", tab[2]);
        assertEquals("M214", tab[3]);
        assertEquals("M215", tab[4]);
        assertEquals("M216", tab[5]);
        assertEquals("M310", tab[6]);
    }

    @Test
    public void testlesResponsablesL2NomPuisIdentifiant() throws Exception {
        Enseignant nouveauHomps = new MdC("Homps");
        info.ajouter(nouveauHomps);
        info.ajouter(new Cours("A123", nouveauHomps, Niveau.L2));
        Collection<Enseignant> res = info.lesResponsablesL2NomPuisIdentifiant();
        System.out.println("le departement " + info);
        System.out.println("le resultat lesResponsablesL2NomPuisIdentifiant" + res);
        Enseignant[] tabAttendu = { x, nouveauHomps, y };
        Enseignant[] tab1 = new Enseignant[3];
        Enseignant[] tab = res.toArray(tab1);
        assertArrayEquals(tabAttendu, tab);
    }

    @Test
    public void testNbreResponsable() {
        assertEquals(3, info.nbreResponsable());
    }

    @Test
    public void testenseignantsSansHeuresCompTrieHeuresFaitesPuisNom() throws Exception {
        Enseignant nouveauSimonot = new MdC("Simonot");
        info.ajouter(nouveauSimonot);
        nouveauSimonot.ajouterHeure(100);
        Collection<Enseignant> res = info.enseignantsSansHeuresCompTrieHeuresFaitesPuisNom();
        System.out.println("le departement " + info);
        System.out.println("le resultat enseignantsSansHeuresCompTrieHeuresFaitesPuisNom" + res);
        Enseignant[] tabAttendu = { y, nouveauSimonot, x };
        Enseignant[] tab1 = new Enseignant[3];
        Enseignant[] tab = res.toArray(tab1);
        assertArrayEquals(tabAttendu, tab);
    }
}