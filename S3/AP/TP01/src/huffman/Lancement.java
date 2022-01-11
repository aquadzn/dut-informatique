package huffman;

public class Lancement {
    public static void main(String[] args) {
        Huffman huffman = new Huffman();

        System.out.println(huffman.litTexte("hello"));

        huffman.construireArbre();

        System.out.println(huffman.getArbres());
    }
}
