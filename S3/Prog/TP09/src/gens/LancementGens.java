package gens;

import java.util.SortedSet;
import java.util.TreeSet;

public class LancementGens {
    public static void main(String[] args) {
        Gens g1 = new Gens("lulu", 18);
        Gens g2 = new Gens("toto", 17);
        Gens g3 = new Gens("lulu", 20);
        Gens g4 = new Gens("bibi", 25);

        SortedSet<Gens> gens = new TreeSet<>(((o1, o2) -> {

            if (((Gens) o1).getNom().equals(((Gens) o2).getNom())) {
                return ((Gens) o1).getAge() - ((Gens) o2).getAge();
            }
            else {
                return ((Gens) o1).getNom().compareTo(((Gens) o2).getNom());
            }
        }));

        gens.add(g1);
        gens.add(g2);
        gens.add(g3);
        gens.add(g4);

        System.out.println(gens);
    }
}
