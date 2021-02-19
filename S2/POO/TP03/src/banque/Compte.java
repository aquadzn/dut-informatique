package banque;

/**
 *  banque.Compte.java
 *  banque.Compte en banque.
 *  Cette version n'a pas de limite de découvert... (Un client peut donc débiter de l'argent autant qu'il le veut !!)
 *  D'autre part, toutes les méthodes ne sont pas sécurisées pour assurer la cohérence de leur comportement par rapport à leur spécification.
 *  
 *  Cette classe permet de gérer des sommes au centime d'euro près jusqu'à (2^63-1) centimes d'euros = 92 233 720 368 547 758,07 euros (soit plus de 92 billiards d'euros).
 *
 *  Un compte est reponsable de : 
 *  - donner son numéro, son solde
 *  - créditer ou débiter un montant
 *  - fournir une représenation affichable de son état
 */
public class Compte {

	private int numéro;
	private Client titulaire;
	private long solde; // Le solde est géré en centièmes d'euros. Par exemple 1234 signifie 12 euros 34 centimes.
	private int decouvertMax;
	
	public Compte(int numéro, Client client, long solde, int decouvertMax) throws CompteException {
		this.numéro = numéro;
		this.titulaire = client;
		this.solde = solde;
		this.decouvertMax = decouvertMax;

		if (this.numéro < 1) {
			throw new CompteException("Numéro de compte nul ou négatif");
		}
		if (this.decouvertMax < 0) {
			throw new CompteException("decouvertMax < 0");
		}
		if (this.solde < -(this.decouvertMax)) {
			throw new CompteException("Solde < decouvertMax");
		}
	}

	public Compte(int numéro, Client client, int decouvertMax) throws CompteException {
		this(numéro, client, 0, decouvertMax);

		if (this.decouvertMax < 0) {
			throw new CompteException("decouvertMax < 0");
		}
	}

	public long getSolde () {
		return this.solde;
	}

	public int getNuméro() {
		return this.numéro;
	}

	public void setDecouvertMax(int decouvertMax) throws CompteException {
		if (this.decouvertMax < 0) {
			throw new CompteException("decouvertMax < 0");
		}
		else {
			this.decouvertMax = decouvertMax;
		}
	}
	
	// Attention : cette version ne vérifie pas le signe du montant crédité ni le dépassement de la capacité de gestion du type long.
	public void créditer(long montant) throws CompteException {
		if (montant <= 0) {
			throw new CompteException("Montant négatif");
		}
		else if (this.solde >= Long.MAX_VALUE) {
			throw new CompteException("Solde maximal atteint, impossible de créditer");
		}
		else {
			this.solde += montant;
		}
	}

	// Attention : cette version ne vérifie pas le signe du montant débité.
	// Exception decouvertMax
	public void débiter(long montant) throws CompteException {
		if (montant > this.solde + this.decouvertMax) {
			throw new CompteException("Montant trop élevé");
		}
		else if (montant <= 0) {
			throw new CompteException("Montant négatif");
		}
		else {
			this.solde -= montant;
		}
	}

	public boolean estADécouvert() {
		return this.solde < 0;
	}

	public void virer(Compte destinataire, long montant) throws CompteException {
		débiter(montant);
		destinataire.créditer(montant);
	}

	@Override  
	public String toString() {
    	String affichageSolde;
    	if (this.solde >= 0)
    		affichageSolde =  this.solde/100 + " euros " + this.solde%100 + " centimes";
    	else 
    		affichageSolde =  "- " + (-this.solde/100) + " euros " + (-this.solde%100) + " centimes";
    		
        return "banque.Compte numéro : " + this.numéro
        		+ " ; titulaire : " + this.titulaire.getNom()
                + " ; solde : " + affichageSolde;
	}
}
