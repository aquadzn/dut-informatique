public class Machine extends Joueur {

    private int i;

    public Machine() {
        super("IA");
        this.i = 0;
    }
    @Override
    public void choisirCoup() throws PasCoup {
        switch (i) {
            case 0:
                setCoupCourant(new Coup("pierre"));
                i++;
                break;
            case 1:
                setCoupCourant(new Coup("papier"));
                i++;
                break;
            default:
                setCoupCourant(new Coup("ciseaux"));
                i = 0;
                break;
        }
    }
}
