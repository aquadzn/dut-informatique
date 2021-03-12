package voiture;

public class CritereKm implements Critere {
    private int km;

    public CritereKm(int km) {
        this.km = km;
    }

    public boolean estSatisfaitPar(Voiture v) {
        return (v.getKm() > this.km);
    }
}
