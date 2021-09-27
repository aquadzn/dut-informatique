import java.util.Scanner;

public enum Coup {
    pierre,
    papier,
    ciseaux;

    Coup() {
    }

    public boolean bat(Coup c) {
        boolean estBattu = false;

        if (this.compareTo(c) == 1 || this.compareTo(c) == -2) {
            estBattu = true;
        }

        return estBattu;

    }

    public static Coup saisirCoup(Scanner sc) {
        while (true) {
            try {
                return Coup.valueOf(sc.nextLine().toLowerCase());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

}
