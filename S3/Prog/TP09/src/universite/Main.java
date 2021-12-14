package universite;

public class Main {

	public static void main(String[] args) throws ExceptHeure {
		Enseignant t1 = new Prag("Mehdi");
		Enseignant m1 = new MdC("David");
		Enseignant e1 = new Vacataire("Omar");
		Etablissement e=new Etablissement("IUT Montreuil");
//		t1.ajouterHeure(40);
//		m1.ajouterHeure(40);
//		e1.ajouterHeure(40);
//		
//		System.out.println(t1.getNom() + " (id " + t1.getId() + ") : " + t1.getHeureEff() + " Heures effectuées et " + t1.getHeureSupp() + " Heures supp");
//		System.out.println(m1.getNom() + " (id " + m1.getId() + ") : " + m1.getHeureEff() + " Heures effectuées et " + m1.getHeureSupp() + " Heures supp");
//		System.out.println(e1.getNom() + " (id " + e1.getId() + ") : " + e1.getHeureEff() + " Heures effectuées et " + e1.getHeureSupp() + " Heures supp");
//		
//		t1.ajouterHeure(400);
//		m1.ajouterHeure(400);
//		e1.ajouterHeure(400);
//		
//		System.out.println(t1.getNom() + " (id " + t1.getId() + ") : " + t1.getHeureEff() + " Heures effectuées et " + t1.getHeureSupp() + " Heures supp");
//		System.out.println(m1.getNom() + " (id " + m1.getId() + ") : " + m1.getHeureEff() + " Heures effectuées et " + m1.getHeureSupp() + " Heures supp");
//		System.out.println(e1.getNom() + " (id " + e1.getId() + ") : " + e1.getHeureEff() + " Heures effectuées et " + e1.getHeureSupp() + " Heures supp");
		e.ajouterEnseignant(t1);
		e.ajouterEnseignant(m1);
		e.ajouterEnseignant(e1);
		e.majHeures();
		e.totalDu();
		System.out.println(e.toString());
	}

}
