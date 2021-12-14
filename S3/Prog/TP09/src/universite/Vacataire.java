package universite;

public class Vacataire extends Enseignant{

	public Vacataire(String nom) {
		super(nom);
	}

	public int getHeureSupp() {
		return this.getHeureEff();
	}

	public String toString() {
		return "[Exterieur] " + super.toString();
	}
	
	
}
