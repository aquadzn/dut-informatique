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

}
