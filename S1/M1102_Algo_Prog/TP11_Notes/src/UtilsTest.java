import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UtilsTest {
    @Test
    public final void antizeroTest() {
        double[] notesTest = {1.01, 5., 0., 17.5, 0.99};
        double[] notesTestAttendues = {1.01, 5., 1., 17.5, 1.};
        Utils.antizero(notesTest);

        assertArrayEquals(notesTestAttendues, notesTest);
    }

    @Test
    public final void corrigerMoyenneTest() {
        double[] notesTest1 = {5., 9.9, 13.5};
        double moyenneReelle1 = Utils.retournerMoyenne(notesTest1);
        double moyenneAttendue1 = 13.;
        assertTrue(moyenneReelle1 < moyenneAttendue1);

        Utils.corrigerMoyenne(notesTest1, moyenneAttendue1);
        double nouvelleMoyenne1 = Utils.retournerMoyenne(notesTest1);
        assertTrue(nouvelleMoyenne1 >= moyenneAttendue1 - 0.1 && nouvelleMoyenne1 < moyenneAttendue1 );

        double[] notesTest2 = {10., 11., 12.};
        double moyenneReelle2 = Utils.retournerMoyenne(notesTest2);
        double moyenneAttendue2 = 11.;
        assertFalse(moyenneReelle2 < moyenneAttendue2);

    }
}
