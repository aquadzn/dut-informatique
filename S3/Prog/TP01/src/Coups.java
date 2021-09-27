import java.util.Scanner;

public enum Coups {
    pierre,
    papier,
    ciseaux;

    Coups() {
    }

    public boolean bat(Coups c) {
        boolean estBattu = false;
        switch (this.name()) {
            case "pierre":
                if (c.ordinal() == 2) {
                    estBattu = true;
                }
                break;
            case "papier":
                if (c.ordinal() == 0) {
                    estBattu = true;
                }
                break;
            default:
                if (c.ordinal() == 1) {
                    estBattu = true;
                }
                break;
        }

        return estBattu;

    }

    public static Coups saisirCoup(Scanner sc) {
        while (true) {
            try {
                return Coups.valueOf(sc.nextLine().toLowerCase());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

}
