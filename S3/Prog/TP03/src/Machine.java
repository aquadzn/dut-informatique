import java.util.ArrayList;

public class Machine extends Joueur {

    private Strategie strategie;
    private int tour = 0;
    private ArrayList<Strategie> strategies = new ArrayList<>();

    public Machine() {
        super("IA");
        this.tour = 0;
        this.strategies.add(new Basique(Coup.pierre));
        this.strategies.add(new Boucle());
        this.strategies.add(new Aleatoire());
        this.strategie = this.strategies.get(0);
    }

    public void changerStrategie(Strategie s) {
        this.strategie = s;
    }

    @Override
    public void choisirCoup() {
        setCoupCourant(strategie.choisirCoup());
        tour++;
    }
}
