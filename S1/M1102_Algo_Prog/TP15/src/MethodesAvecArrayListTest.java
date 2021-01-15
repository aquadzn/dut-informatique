import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MethodesAvecArrayListTest {

    @Test
    public final void testNbElementsCommencantPar() {

        assertEquals(0, MethodesAvecArrayList.nbElementsCommencantPar(new ArrayList<>(), 'a'), "liste de longueur 0");

        ArrayList<String> casMoyen = new ArrayList<>();
        casMoyen.add("Anatole"); casMoyen.add("Roberta"); casMoyen.add("Astrid"); casMoyen.add("Caliméro"); casMoyen.add("Angie");
        assertEquals(3, MethodesAvecArrayList.nbElementsCommencantPar(casMoyen, 'A'), "cas moyen");

        ArrayList<String> casAvecStringLong0 = new ArrayList<>();
        casAvecStringLong0.add("Anatole"); casAvecStringLong0.add(""); casAvecStringLong0.add("Roberta"); casAvecStringLong0.add("Angie");
        assertEquals(1, MethodesAvecArrayList.nbElementsCommencantPar(casAvecStringLong0, 'R'), "liste avec un String de longueur 0");
    }


    @Test
    public final void testContientGontrand() {

        assertFalse(MethodesAvecArrayList.contientGontrand(new ArrayList<>()), "liste vide");

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

        ArrayList<String> listeVide = new ArrayList<>();
        MethodesAvecArrayList.supprimerElementsSeTerminantPar(listeVide, 'a');
        assertEquals(new ArrayList<String>(), listeVide, "liste vide");

        ArrayList<String> long1 = new ArrayList<>();
        long1.add("Joséphine");
        MethodesAvecArrayList.supprimerElementsSeTerminantPar(long1, 'e');
        assertEquals(new ArrayList<String>(), long1, "liste long1");

        ArrayList<String> longSup = new ArrayList<>();
        longSup.add("Marcel");longSup.add("Joséphine");longSup.add("Guillaume");longSup.add("Alice");longSup.add("Anna");
        ArrayList<String> longSupResult = new ArrayList<>();
        longSupResult.add("Marcel");longSupResult.add("Anna");
        MethodesAvecArrayList.supprimerElementsSeTerminantPar(longSup, 'e');
        assertEquals(longSupResult, longSup, "liste avec plusieurs à supprimer qui se suivent ");
    }


    @Test
    public final void testPositifs() {

        int[] tabLongZero = new int[0];
        ArrayList<Integer> arrayListLongZeroResultat = new ArrayList<>();
        assertEquals(MethodesAvecArrayList.positifs(tabLongZero), arrayListLongZeroResultat, "cas tableau longueur zéro");

        int[] tabSansPositifs = {-6,-2,-7,-44};
        ArrayList<Integer> arrayListLongZeroResultat2 = new ArrayList<>();
        assertEquals(MethodesAvecArrayList.positifs(tabSansPositifs), arrayListLongZeroResultat2, "cas tableau longueur zéro");

        int[] tab = {-6,2,-7,55,-44};
        ArrayList<Integer> arrayListResultat = new ArrayList<>();
        arrayListResultat.add(2);arrayListResultat.add(55);
        assertEquals(MethodesAvecArrayList.positifs(tab), arrayListResultat, "cas tableau longueur zéro");
    }


    @Test
    public final void testMetEnMajuscules() {

        ArrayList<String> listeVide = new ArrayList<>();
        MethodesAvecArrayList.mettreEnMajuscules(listeVide);
        assertEquals(new ArrayList<String>(), listeVide, "liste vide");

        ArrayList<String> long1 = new ArrayList<>();
        long1.add("caliMeRo");
        ArrayList<String> long1Result = new ArrayList<>();
        long1Result.add("CALIMERO");
        MethodesAvecArrayList.mettreEnMajuscules(long1);
        assertEquals(long1Result, long1, "liste long1");

        ArrayList<String> longSup = new ArrayList<>();
        longSup.add("Marcel");longSup.add("aLicE");longSup.add("Anna");
        ArrayList<String> longSupResult = new ArrayList<>();
        longSupResult.add("MARCEL");longSupResult.add("ALICE");longSupResult.add("ANNA");
        MethodesAvecArrayList.mettreEnMajuscules(longSup);
        assertEquals(longSupResult, longSup, "liste long > 1");
    }

    @Test
    public final void testInsererTrie() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Alan");
        strings.add("Michel");
        strings.add("Paul");
        strings.add("William");

        ArrayList<String> stringsResults = new ArrayList<>();
        stringsResults.add("Alan");
        stringsResults.add("Michel");
        stringsResults.add("Paul");
        stringsResults.add("Thomas");
        stringsResults.add("William");

        MethodesAvecArrayList.insererTrie(strings, "Thomas");
        assertEquals(stringsResults, strings);
    }

}