import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MethodesAvecArrayListTest {

    @Test
    public final void testNbElementsCommencantPar() {

        assertEquals(0, MethodesAvecArrayList.nbElementsCommencantPar(new ArrayList<String>(), 'a'), "liste de longueur 0");

        ArrayList<String> casMoyen = new ArrayList<String>();
        casMoyen.add("Anatole"); casMoyen.add("Roberta"); casMoyen.add("Astrid"); casMoyen.add("Caliméro"); casMoyen.add("Angie");
        assertEquals(3, MethodesAvecArrayList.nbElementsCommencantPar(casMoyen, 'A'), "cas moyen");

        ArrayList<String> casAvecStringLong0 = new ArrayList<String>();
        casAvecStringLong0.add("Anatole"); casAvecStringLong0.add(""); casAvecStringLong0.add("Roberta"); casAvecStringLong0.add("Angie");
        assertEquals(1, MethodesAvecArrayList.nbElementsCommencantPar(casAvecStringLong0, 'R'), "liste avec un String de longueur 0");
    }


    @Test
    public final void testContientGontrand() {

        assertFalse(MethodesAvecArrayList.contientGontrand(new ArrayList<String>()), "liste vide");

        ArrayList<String> listLong1sans = new ArrayList<>(); listLong1sans.add("Bébert");
        assertFalse(MethodesAvecArrayList.contientGontrand(listLong1sans), "liste long 1 sans Gontrand");

        ArrayList<String> listLong1avec = new ArrayList<>(); listLong1avec.add("Gontrand");
        assertTrue(MethodesAvecArrayList.contientGontrand(listLong1avec), "liste long 1 avec Gontrand");

        ArrayList<String> listLongNavecPosition1 = new ArrayList<>(); listLongNavecPosition1.add("Gontrand");listLongNavecPosition1.add("Marcel");listLongNavecPosition1.add("Olive");
        assertTrue(MethodesAvecArrayList.contientGontrand(listLongNavecPosition1), "liste long n avec Gontrand en position 1");

        ArrayList<String> listLongNavecLastPosition = new ArrayList<>(); listLongNavecLastPosition.add("Olive");listLongNavecLastPosition.add("Marcel");listLongNavecLastPosition.add("Gontrand");
        assertTrue(MethodesAvecArrayList.contientGontrand(listLongNavecLastPosition), "liste long n avec Gontrand en dernière position");

        ArrayList<String> listLongNcasMoyen = new ArrayList<>(); listLongNcasMoyen.add("Olive");listLongNcasMoyen.add("");listLongNcasMoyen.add("Gontrand");listLongNcasMoyen.add("Marcel");listLongNcasMoyen.add("Gudule");
        assertTrue(MethodesAvecArrayList.contientGontrand(listLongNcasMoyen), "liste long n avec Gontrand cas moyen");

        ArrayList<String> listLongNsans = new ArrayList<>(); listLongNsans.add("Olive");listLongNsans.add("Marcel");listLongNsans.add("Bilbo");
        assertFalse(MethodesAvecArrayList.contientGontrand(listLongNsans), "liste long n sans Gontrand");
    }


    @Test
    public final void testSupprimeElementsSeTerminantPar() {

        ArrayList<String> listeVide = new ArrayList<String>();
        MethodesAvecArrayList.supprimerElementsSeTerminantPar(listeVide, 'a');
        assertTrue(listeVide.equals(new ArrayList<String>()), "liste vide");

        ArrayList<String> long1 = new ArrayList<String>();
        long1.add("Joséphine");
        MethodesAvecArrayList.supprimerElementsSeTerminantPar(long1, 'e');
        assertTrue(long1.equals(new ArrayList<String>()), "liste long1");

        ArrayList<String> longSup = new ArrayList<String>();
        longSup.add("Marcel");longSup.add("Joséphine");longSup.add("Guillaume");longSup.add("Alice");longSup.add("Anna");
        ArrayList<String> longSupResult = new ArrayList<String>();
        longSupResult.add("Marcel");longSupResult.add("Anna");
        MethodesAvecArrayList.supprimerElementsSeTerminantPar(longSup, 'e');
        assertTrue(longSup.equals(longSupResult), "liste avec plusieurs à supprimer qui se suivent ");
    }


    @Test
    public final void testPositifs() {

        int[] tabLongZero = new int[0];
        ArrayList<Integer> arrayListLongZeroResultat = new ArrayList<>();
        assertTrue(arrayListLongZeroResultat.equals(MethodesAvecArrayList.positifs(tabLongZero)), "cas tableau longueur zéro");

        int[] tabSansPositifs = {-6,-2,-7,-44};
        ArrayList<Integer> arrayListLongZeroResultat2 = new ArrayList<>();
        assertTrue(arrayListLongZeroResultat2.equals(MethodesAvecArrayList.positifs(tabSansPositifs)), "cas tableau longueur zéro");

        int[] tab = {-6,2,-7,55,-44};
        ArrayList<Integer> arrayListResultat = new ArrayList<>();
        arrayListResultat.add(2);arrayListResultat.add(55);
        assertTrue(arrayListResultat.equals(MethodesAvecArrayList.positifs(tab)), "cas tableau longueur zéro");
    }


    @Test
    public final void testMetEnMajuscules() {

        ArrayList<String> listeVide = new ArrayList<String>();
        MethodesAvecArrayList.mettreEnMajuscules(listeVide);
        assertTrue(listeVide.equals(new ArrayList<String>()), "liste vide");

        ArrayList<String> long1 = new ArrayList<String>();
        long1.add("caliMeRo");
        ArrayList<String> long1Result = new ArrayList<String>();
        long1Result.add("CALIMERO");
        MethodesAvecArrayList.mettreEnMajuscules(long1);
        assertTrue(long1.equals(long1Result), "liste long1");

        ArrayList<String> longSup = new ArrayList<String>();
        longSup.add("Marcel");longSup.add("aLicE");longSup.add("Anna");
        ArrayList<String> longSupResult = new ArrayList<String>();
        longSupResult.add("MARCEL");longSupResult.add("ALICE");longSupResult.add("ANNA");
        MethodesAvecArrayList.mettreEnMajuscules(longSup);;
        assertTrue(longSup.equals(longSupResult), "liste long > 1");
    }

}