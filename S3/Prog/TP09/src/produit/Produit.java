package produit;

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
        return "produit.Produit [reference=" + reference + ", prix=" + prix + "]";
    }

}