package lambdasBasic;
public class Produit {

    private int reference;
    private int prix;

    public Produit(int reference, int prix) {
        super();
        this.reference = reference;
        this.prix = prix;
    }

    public int getReference() {
        return reference;
    }

    public int getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Produit [reference=" + reference + ", prix=" + prix + "]";
    }

    public static void main(String[] args) {

        Produit p112et30 = new Produit(112, 30);
        Produit p150et15 = new Produit(150, 15);
        Produit p120et30 = new Produit(120, 30);
        Produit p112et40 = new Produit(112, 40);
        p120et30 = new Produit(120, 30);
    }
}
