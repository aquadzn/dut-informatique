package base;

public class Adresse {
    private int numeroRue;
    private String rue, ville, pays;

    public Adresse(int numeroRue, String rue, String ville, String pays) {
        super();
        this.numeroRue = numeroRue;
        this.rue = rue;
        this.ville = ville;
        this.pays = pays;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this.getClass() != obj.getClass()) {
//            return false;
//        }
//        base.Adresse adr = (base.Adresse) obj;
//        return adr.numeroRue == this.numeroRue &&
//            adr.rue.equals(this.rue) &&
//            adr.ville.equals(this.ville) &&
//            adr.pays.equals(this.pays);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adresse adresse = (Adresse) o;

        return pays != null ? pays.equals(adresse.pays) : adresse.pays == null;

    }

    @Override
    public int hashCode() {
        return pays != null ? pays.hashCode() : 0;
    }

    // @Override
    @Override
    public String toString() {
        return numeroRue + " " + rue + " , " + ville + " , " + pays + "\n";
    }

    public int getNumeroRue() {
        return numeroRue;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public String getPays() {
        return pays;
    }

}