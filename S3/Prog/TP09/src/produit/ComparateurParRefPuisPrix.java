package produit;

import produit.Produit;

import java.util.Comparator;

public class ComparateurParRefPuisPrix implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Produit p1 = (Produit) o1;
        Produit p2 = (Produit) o2;

        if (p1.getReference() == p2.getReference()) {
            return p1.getPrix() - p2.getPrix();
        }
        else {
            return p1.getReference() - p2.getReference();
        }
    }
}
