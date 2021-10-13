public class Chocolat extends DessertAvecSupplement {

    private Dessert dessert;

    public Chocolat(Dessert dessert) {
        super(dessert);
    }

    @Override
    public double prix() {
        return 0.5 + super.getDessert().prix();
    }

    @Override
    public String nom() {
        return super.getDessert().nom() + " avec chocolat";
    }
}
