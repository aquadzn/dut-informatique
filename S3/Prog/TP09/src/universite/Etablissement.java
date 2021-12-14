package universite;
import java.util.ArrayList;
import java.util.Scanner;

public class Etablissement {

	Scanner sc = new Scanner(System.in);
	
	private ArrayList<Enseignant>enseignants;
	private String nom;
	
	public Etablissement(String nom) {
		this.enseignants=new ArrayList<>();
		this.nom=nom;
	}
	
	public void ajouterEnseignant(Enseignant e) {
		this.enseignants.add(e);
	}
	
	public void majHeures() {
		int heures=0;
		for (Enseignant e : enseignants) {
			do {
				System.out.print("Veuillez saisir les heures de l'enseignant " + e.getNom() + " : ");
				heures = Integer.parseInt(sc.nextLine());
				try {
					e.ajouterHeure(heures);
				} catch (ExceptHeure e1) {
					System.out.println("Veuillez saisir une heure positive");
				}
			}while(heures<0);
		}
	}
	
	public void totalDu() {
		int heures = 0;
		for (Enseignant e : enseignants) {
			heures+=e.getHeureSupp();
		}
		System.out.println("Nombre d'heures complementaires total dû : "+ heures+"h, le montant est donc de " + heures*40+ "€");
	}

	public String toString() {
		return "Etablissement " + nom + " enseignants=" + enseignants.toString();
	}
	
	
}
