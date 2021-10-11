public class Chocolat extends DessertAvecSupplement {

    private Dessert dessert;

    public Chocolat(Dessert dessert) {
        super(dessert);
    }

    @Override
    public double prix() {
        return 0;
    }

    @Override
    public String nom() {
        return null;
    }
}
