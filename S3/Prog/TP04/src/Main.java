public class Main {
    public static void main(String[] args) {
        DessertSimple a = new Crepe();
        Dessert b = new Chocolat(a);
        Dessert c = new Chantilly(b);

        System.out.println(a.nom() + " " + a.prix());
        System.out.println(b.nom() + " " + b.prix());
        System.out.println(c.nom() + " " + c.prix());
    }
}
