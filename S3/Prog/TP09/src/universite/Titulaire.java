package universite;

public abstract class Titulaire extends Enseignant{
	
	private int heureContrat;

	public Titulaire(String nom, int heureContrat) {
		super(nom);
		this.heureContrat=heureContrat;
	}

	public int getHeureSupp() {
		int heureSupp = this.getHeureEff()-heureContrat;
		if(heureSupp<=0) {
			return 0;
		}
		return heureSupp;
	}

}
