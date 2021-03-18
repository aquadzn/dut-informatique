package armee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCavalier {

    @Test
    final public void testVitesseMax() {
        Cavalier c = new Cavalier("Jean", 80);
        Assertions.assertEquals(15., c.vitesseMax(), "0kg");

        c.charger(25);
        Assertions.assertEquals(13., c.vitesseMax(), "25kg");

        c.charger(50);
        Assertions.assertEquals(10., c.vitesseMax(), "75kg");

        c.charger(50);
        Assertions.assertEquals(8, c.vitesseMax(), "125kg");
    }

}
