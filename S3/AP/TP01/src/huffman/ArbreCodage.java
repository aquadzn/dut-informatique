package huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArbreCodage extends Arbre<Character> implements Comparable<ArbreCodage> {

    private int poids;

    /**
     * constructeur pour les noeuds : le contenu n'a pas d'importance,
     *  on met donc  (char) 0. En revanche le poids est la sommes des poids
     *  des sous arbres
     */
    public ArbreCodage(ArbreCodage filsG, ArbreCodage filsD) {
        super(filsG, (char) 0, filsD);
        this.poids = filsG.getPoids() + filsD.getPoids();
    }

    /**
     * constructeur pour les feuilles : ici le contenu( caractere) et le poids
     * (frequence) sont importants
     */
    public ArbreCodage(Character c, int poids) {
        super(c);
        this.poids = poids;
    }

    /**
     * construit la map des codages des caracteres par un parcours de l'arbre
     *
     * @param caracteres
     *            l'ensemble des caractères
     *                */
    public Map<Character, String> codage(Set<Character> caracteres) {
        Map<Character, String> codes = new HashMap<>();
        for (Character c : caracteres) {
            String code = codageParCar(c);
            codes.put(c, code);
        }
        return codes;
    }

    /**
     * retourne le code de Huffman du caractère car a
     */
    private String codageParCar(Character car) {
        return null;
        // ToDO
    }

    /**
     * Relation d'ordre sur les arbres par comparaison de leur poids.
     */
    @Override
    public int compareTo(ArbreCodage o) {
        int n=this.poids - o.poids;
        if(n !=0) return n;
        else return 1;
    }

    public int getPoids() {
        return poids;
    }
}