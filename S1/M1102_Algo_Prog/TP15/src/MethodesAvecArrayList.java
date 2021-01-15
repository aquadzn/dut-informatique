import java.util.ArrayList;

public class MethodesAvecArrayList {

    public static int nbElementsCommencantPar(ArrayList<String> strings, char c) {
        int nbElements = 0;
        for (String string : strings) {
            if (string.length() > 0 && string.charAt(0) == c) {
                nbElements++;
            }
        }
        return nbElements;
    }

    public static boolean contientGontrand(ArrayList<String> strings) {
        return strings.contains("Gontrand");
    }

    public static void supprimerElementsSeTerminantPar(ArrayList<String> strings, char c) {
//        for (String str : new ArrayList<String>(strings)) {
//            if (str.charAt(str.length() - 1) == c) {
//                strings.remove(str);
//            }
//        }
        strings.removeIf(str -> str.charAt(str.length() - 1) == c);
    }

    public static ArrayList<Integer> positifs(int[] tab) {
        ArrayList<Integer> valeursPositives = new ArrayList<>();
        for (int i : tab) {
            if (i >= 0) {
                valeursPositives.add(i);
            }
        }
        return valeursPositives;
    }
    
    public static void mettreEnMajuscules(ArrayList<String> strings) {
        if (strings.size() > 0) {
            strings.replaceAll(String::toUpperCase);
        }
    }

    public static void insererTrie(ArrayList<String> strings, String elementAjoute) {

        int gauche = 0;
        int droite = strings.size();
        int milieu;

        while (gauche < droite) {
            milieu = (gauche + droite) / 2;

            if (elementAjoute.compareTo(strings.get(milieu)) < 0) {
                droite = milieu;
            }
            else {
                gauche = milieu + 1;
            }
        }

        strings.add(gauche, elementAjoute);
    }

}

















