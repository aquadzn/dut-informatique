public class Chantilly extends DessertAvecSupplement {

    private Dessert dessert;

    public Chantilly(Dessert dessert) {
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
