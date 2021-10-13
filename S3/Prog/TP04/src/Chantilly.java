public class Chantilly extends DessertAvecSupplement {

    private Dessert dessert;

    public Chantilly(Dessert dessert) {
        super(dessert);
    }

    @Override
    public double prix() {
        return 0.8 + super.getDessert().prix();
    }

    @Override
    public String nom() {
        return super.getDessert().nom() + " avec chantilly";
    }
}
