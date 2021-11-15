package courrier;

public class Urgent extends CourrierContrainte {

    public Urgent(Courrier courrier) {
        super(courrier.getDestinataire(), courrier);
    }

    @Override
    public double coutAffranchissement() {
        return getCourrier().coutAffranchissement() * 2;
    }
}
