import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class MenuTest {

    @Test
    void verifierValeurs() {
        int longueurBonne = 60;
        int hauteurBonne = 20;
        double aleatoireBon = 0.2;
        int niveauBon = 10;
        int longueurMauvaise = 3;
        int hauteurMauvaise = 0;
        double aleatoireMauvais = 0.0;
        int niveauMauvais = 0;

        assertFalse(Menu.verifierValeurs(longueurBonne, hauteurBonne, aleatoireBon, niveauBon));
        assertTrue(Menu.verifierValeurs(longueurBonne, hauteurBonne, aleatoireBon, niveauMauvais));
        assertTrue(Menu.verifierValeurs(longueurBonne, hauteurBonne, aleatoireMauvais, niveauBon));
        assertTrue(Menu.verifierValeurs(longueurBonne, hauteurBonne, aleatoireMauvais, niveauMauvais));
        assertTrue(Menu.verifierValeurs(longueurBonne, hauteurMauvaise, aleatoireBon, niveauBon));
        assertTrue(Menu.verifierValeurs(longueurBonne, hauteurMauvaise, aleatoireBon, niveauMauvais));
        assertTrue(Menu.verifierValeurs(longueurBonne, hauteurMauvaise, aleatoireMauvais, niveauBon));
        assertTrue(Menu.verifierValeurs(longueurBonne, hauteurMauvaise, aleatoireMauvais, niveauMauvais));

        assertTrue(Menu.verifierValeurs(longueurMauvaise, hauteurMauvaise, aleatoireMauvais, niveauBon));
        assertTrue(Menu.verifierValeurs(longueurMauvaise, hauteurMauvaise, aleatoireMauvais, niveauMauvais));
        assertTrue(Menu.verifierValeurs(longueurMauvaise, hauteurMauvaise, aleatoireBon, niveauBon));
        assertTrue(Menu.verifierValeurs(longueurMauvaise, hauteurMauvaise, aleatoireBon, niveauMauvais));
        assertTrue(Menu.verifierValeurs(longueurMauvaise, hauteurBonne, aleatoireMauvais, niveauBon));
        assertTrue(Menu.verifierValeurs(longueurMauvaise, hauteurBonne, aleatoireMauvais, niveauMauvais));
        assertTrue(Menu.verifierValeurs(longueurMauvaise, hauteurBonne, aleatoireBon, niveauBon));
        assertTrue(Menu.verifierValeurs(longueurMauvaise, hauteurBonne, aleatoireBon, niveauMauvais));

    }
}