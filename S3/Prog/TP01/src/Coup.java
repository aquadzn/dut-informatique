import java.util.Scanner;

public class Coup {

    private String nom;

    public Coup(String nom) throws PasCoup {
        this.nom = nom;

        if (! (nom.equals("pierre") || nom.equals("papier") || nom.equals("ciseaux"))) {
            throw new PasCoup("pas bon");
        }
    }

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        return ((Coup) obj).getNom().equals(this.nom);
    }

    public boolean bat(Coup coup) {
        boolean estBattu = false;

        switch (nom) {
            case "pierre":
                estBattu = coup.getNom().equals("ciseaux");
                break;
            case "papier":
                estBattu = coup.getNom().equals("pierre");
                break;
            default:
                estBattu = coup.getNom().equals("papier");
                break;
        }

        return estBattu;
    }

    public static Coup saisirCoup(Scanner sc) throws PasCoup {
        while (true) {
            try {
                return new Coup(sc.nextLine());
            }
            catch (PasCoup e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
