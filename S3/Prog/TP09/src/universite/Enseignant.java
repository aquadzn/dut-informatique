package universite;

public abstract class Enseignant {

	private String nom;
	private int id;
	private int heureEff;
	private static int compteur=0;
	
	public Enseignant(String nom) {
		this.nom=nom;
		this.id=compteur;
		this.heureEff=0;
		compteur++;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public int getHeureEff() {
		return heureEff;
	}

	public void setHeureEff(int heureEff) {
		this.heureEff = heureEff;
	}
	
	public abstract int getHeureSupp();
	
	public void ajouterHeure(int heure) throws ExceptHeure{
		if(heure<0) throw new ExceptHeure();
		heureEff+=heure;
	}
	
	public int sommeHeureSupp() {
		return getHeureSupp()*40;
	}
	
	public String toString() {
		return this.getNom() +  "(id " + this.getId() + ") : " + this.getHeureEff() + " Heures effectuées et " + this.getHeureSupp() + " Heures supp";
	}
}
