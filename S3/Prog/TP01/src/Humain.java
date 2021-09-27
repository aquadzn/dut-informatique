import java.util.Scanner;

public class Humain extends Joueur {

    private Scanner sc;

    public Humain(String nom) {
        super(nom);
        this.sc = new Scanner(System.in);
    }

    @Override
    public void choisirCoup() throws PasCoup {
        System.out.println("Coup (pierre - papier - ciseaux) ? : ");
        setCoupCourant(Coup.saisirCoup(sc));
    }
}
