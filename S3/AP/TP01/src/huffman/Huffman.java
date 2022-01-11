package huffman;

import java.util.*;

public class Huffman {

    private TreeSet<ArbreCodage> arbres;
    private ArbreCodage arbre;
    private Map<Character, Integer> frequences;


    public Huffman() {
        this.arbres = new TreeSet<>();
        this.frequences = new HashMap<>();
    }

    public SortedSet<ArbreCodage> getArbres() {
        return arbres;
    }

    public ArbreCodage getArbre() {
        return arbre;
    }

    public Map<Character, Integer> litTexte(String texte) {
        for (char c : texte.toCharArray()) {
            frequences.put(c, frequences.getOrDefault(c, 0) + 1);
        }

        return frequences;
    }

    public void construireArbre() {
        // Arbre feuille
        frequences.forEach((k, v) -> arbres.add(new ArbreCodage(k, v)));

        // Arbre Huffman
        int i = 0;

        while (arbres.isEmpty()) {
            System.out.println(i++);
            ArbreCodage a1 = arbres.pollFirst();
            ArbreCodage a2 = arbreIterator.next();

            ArbreCodage nouvelArbre = new ArbreCodage(a1, a2);
            arbres.add(nouvelArbre);
        }
    }

    public void afficheTableCodage() {

    }
}
