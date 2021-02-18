package banque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompteTestVirerEtEstADecouvert {

    // client qui servira pour tous les tests (on peut utiliser le même client car il n'est jamais modifié).
    private Client clientJames = new Client("James", "140 rue de la N. France");


    // tests de estADecouvert

    @Test
    public final void testDecouvertFaux() throws CompteException {
        Compte c = new Compte(1, clientJames, 0, 10000);
        Assertions.assertFalse(c.estADécouvert());
    }

    @Test
    public final void testDecouvertVrai() throws CompteException {
        Compte c = new Compte(1, clientJames, 0, 10000);
        c.débiter(1);
        Assertions.assertTrue(c.estADécouvert());
    }

    @Test
    public final void testDecouvertFaux2() throws CompteException {
        Compte c = new Compte(1, clientJames, 0, 10000);
        c.débiter(100);
        c.créditer(200);
        Assertions.assertFalse(c.estADécouvert());
    }


    // juste un test pour virer

    @Test
    public final void testVirer() throws CompteException {
        Compte c1 = new Compte(1, clientJames, 12000, 10000);
        Compte c2 = new Compte(2, clientJames, 12000, 10000);
        c1.virer(c2, 1000);
        Assertions.assertEquals(11000, c1.getSolde());
        Assertions.assertEquals(13000, c2.getSolde());
    }

}