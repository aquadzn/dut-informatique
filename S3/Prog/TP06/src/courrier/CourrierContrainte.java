package courrier;

public abstract class CourrierContrainte extends Courrier {

    private Courrier courrier;
    public CourrierContrainte(String destinataire, Courrier courrier) {
        super(destinataire);
        this.courrier = courrier;
    }

    public Courrier getCourrier() {
        return courrier;
    }
}
