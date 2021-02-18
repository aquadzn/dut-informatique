package banque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompteTest {

    private final Client clientJohn = new Client("John", "140 rue de la N. France");
    private final Client clientDoe = new Client("Doe", "1 Rue de la Paix");

    @Test
    public final void testVirer() throws CompteException {
        Compte compteJohn = new Compte(1, clientJohn, 10000, 10000);
        Compte compteDoe = new Compte(2, clientDoe, 1000, 10000);
        compteJohn.virer(compteDoe, 5000);
        Assertions.assertEquals(5000, compteJohn.getSolde());
        Assertions.assertEquals(6000, compteDoe.getSolde());
    }

    // Tests de débiter
    @Test
    public final void testDebiter() throws CompteException {
        Compte compteJohn = new Compte(1, clientJohn, 10000, 10000);
        compteJohn.débiter(1000);
        Assertions.assertEquals(9000, compteJohn.getSolde());
    }

    @Test
    public final void testDebiter2() throws CompteException {
        Compte compteJohn = new Compte(1, clientJohn, 10000, 10000);
        compteJohn.débiter(15000);
        Assertions.assertEquals(-5000, compteJohn.getSolde());
    }

    @Test
    public final void testDebiterMontantNégatif() throws CompteException {
        Compte compteJohn = new Compte(1, clientJohn, 10000, 10000);
        Assertions.assertThrows(CompteException.class, () -> compteJohn.débiter(-2));
    }

    @Test
    public final void testDebiterDepassementDecouvert() throws CompteException {
        Compte compteJohn = new Compte(1, clientJohn, 0, 1000);
        Assertions.assertThrows(CompteException.class, () -> compteJohn.débiter(1001));
    }


    // Tests du constructeur
    @Test
    public final void testCreationNumeroInvalideNegatif() {
        Assertions.assertThrows(CompteException.class, () -> new Compte(-5, clientJohn, 0, 0));
    }

    // on considère que zéro n'est pas un numéro de compte valide
    @Test
    public final void testCreationNumeroInvalideZero() {
        Assertions.assertThrows(CompteException.class, () -> new Compte(0, clientJohn, 0, 0));
    }

    @Test
    public final void testCreationDecouvertNegatif() {
        Assertions.assertThrows(CompteException.class, () -> new Compte(1, clientJohn, 0, -6));
    }

    @Test
    public final void testCreationSoldeInsuffisant() {
        Assertions.assertThrows(CompteException.class, () -> new Compte(1, clientJohn, -20000, 10000));
    }

    // par contre le cas ci-dessous ne doit pas déclencher d'erreur
    @Test
    public final void testCreationCasLimite() throws CompteException {
        Compte c = new Compte(1, clientJohn, Long.MAX_VALUE, 10000);
        Assertions.assertEquals(Long.MAX_VALUE, c.getSolde());
    }

    // Tests de créditer
    @Test
    public final void testCrediter() throws CompteException {
        Compte c = new Compte(1, clientJohn, 12000, 10000);
        c.créditer(1000);
        Assertions.assertEquals(13000, c.getSolde());
    }

    @Test
    public final void testCrediterMontantNégatif() throws CompteException {
        Compte c = new Compte(1, clientJohn, 12000, 10000);
        Assertions.assertThrows(CompteException.class, () -> c.créditer(-2));
    }

	@Test
	public final void testCrediterDépassementIntMAXVALUE() throws CompteException {
		Compte c = new Compte(1, clientJohn, Long.MAX_VALUE, 10000);
		Assertions.assertThrows(CompteException.class, () -> c.créditer(1));
	}

}
