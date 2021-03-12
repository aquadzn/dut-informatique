package courrier;

import java.util.ArrayList;

public class Essai {
    public static void main(String[] args) {

        Lettre l1 = new Lettre("jean");
        Lettre l2 = new Lettre("pierre");

        Colis c1 = new Colis("thomas", "paul", 1300);

        ArrayList<Courrier> boite = new ArrayList<Courrier>();
        boite.add(l1);
        boite.add(l2);
        boite.add(c1);

        for (Courrier c : boite) {
            System.out.println(c.toString());
        }

    }
}
