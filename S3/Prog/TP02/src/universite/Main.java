package universite;

public class Main {

    public static void main(String[] args) {
        MaitreConf maitreConf = new MaitreConf("A");
        ProfAgrege profAgrege = new ProfAgrege("B");
        Exterieur exterieur = new Exterieur("C");

        try {
            maitreConf.ajouterHeures(200);
            profAgrege.ajouterHeures(380);
            exterieur.ajouterHeures(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Etablissement etablissement = new Etablissement();
        etablissement.recruterEnseignant(maitreConf);
        etablissement.recruterEnseignant(profAgrege);
        etablissement.recruterEnseignant(exterieur);

        System.out.println(etablissement.totalHeuresComplementaires());

        etablissement.majHeuresComplementaires();

        System.out.println(etablissement.totalHeuresComplementaires());
    }
}
