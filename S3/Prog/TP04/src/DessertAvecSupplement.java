public abstract class DessertAvecSupplement extends Dessert {
    private Dessert dessert;

    public DessertAvecSupplement(Dessert dessert) {
        this.dessert = dessert;
    }

    public Dessert getDessert() {
        return dessert;
    }

}
