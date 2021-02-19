package banque;

import java.util.ArrayList;

/*
 * La banque gère ses clients et ses comptes...
 *  
 */
public class Banque {

	private String nomBanque;
	private ArrayList<Compte> comptes;
	private ArrayList<Client> clients;

	int numéroCompteMax; // Sert à générer des numéro de comptes uniques.
	
	public Banque (String nomBanque) {
		this.nomBanque = nomBanque;
		this.comptes = new ArrayList<>();
		this.clients = new ArrayList<>();
		this.numéroCompteMax = 0;
	}

	public String getNomBanque() {
		return this.nomBanque;
	}

	public void créerCompte (String nomClient, int decouvertMax) {
		Client client = this.trouverClient(nomClient);
		if (client == null) {
			return;
		}
		
		this.numéroCompteMax++;

		try {
			this.comptes.add(new Compte(this.numéroCompteMax, client, decouvertMax));
		}
		catch (CompteException e) {
			e.printStackTrace();
		}
	}
	

	public void ajouterClient (String nom, String adresse) {
		if (this.trouverClient(nom) != null)
			return;
		this.clients.add(new Client(nom, adresse));
	}
	
	public void modifierAdresseClient (String nom, String nouvelleAdresse) {
		Client client = this.trouverClient(nom);
		if (client == null)
			return;
		client.setAdresse(nouvelleAdresse);
	}

	public void modifierDecouvertMax(int numeroCompte, int nouveauDecouvertMax) {
		Compte compte = this.trouverCompte(numeroCompte);
		if (compte == null) {
			return;
		}

		try {
			compte.setDecouvertMax(nouveauDecouvertMax);
		} catch (CompteException e) {
			e.printStackTrace();
		}
	}
	
	public String listerComptes() {
		return this.comptes.toString();
	}
	
	public String listerCLients() {
		return this.clients.toString();
	}
	
	public int nbClients () {
		return this.clients.size();
	}
	
	public int nbComptes () {
		return this.comptes.size();
	}
			
	public String étatCompte(int numéro) {
		Compte c = this.trouverCompte(numéro);
		if (c == null)
			return ("Aucun compte ne correspond au numéro " + numéro);
		else
			return c.toString();
	}
	

	public void créditer (int numéroCompte, long montant) {
		Compte compteACréditer = this.trouverCompte(numéroCompte);

		if (compteACréditer == null)
			return;
		
		try {
			compteACréditer.créditer(montant);
		}
		catch (CompteException e) {
			e.printStackTrace();
		}
	}
	

	public void débiter (int numéroCompte, long montant) {
		Compte compteADébiter = this.trouverCompte(numéroCompte);

		if (compteADébiter == null)
			return;

		try {
			compteADébiter.débiter(montant);
		}
		catch (CompteException e) {
			e.printStackTrace();
		}

	}

	public void virer(int numCompteEnvoi, int numCompteBeneficiaire, long montant) {
		Compte compteEnvoi = this.trouverCompte(numCompteEnvoi);
		Compte compteBeneficiaire = this.trouverCompte(numCompteBeneficiaire);

		if (compteEnvoi == null || compteBeneficiaire == null) {
			return;
		}

		try {
			compteEnvoi.virer(compteBeneficiaire, montant);
		} catch (CompteException e) {
			e.printStackTrace();
		}
	}
	
	public String comptesADécouvert() {
		return this.listeComptesADécouvert().toString();
	}
	
	/*
	 * Retourne le compte ayant le numéro passé en paramètre.
	 * Retourne null si numéro inexistant.
	 */
	private Compte trouverCompte(int numero) {
		for (Compte c : this.comptes)
			if (c.getNuméro()== numero) return c;
		return null;
	}
	
	/*
	 * Retourne le client ayant le nom passé en paramètre.
	 * Retourne null si aucun client de ce nom-là.
	 */
	private Client trouverClient(String nom) {
		for (Client client : this.clients)
			if (client.getNom().equals(nom)) return client;
		return null;
	}
	
	private ArrayList<Compte> listeComptesADécouvert() {
		ArrayList<Compte> comptesADécouvert = new ArrayList<>();
		for (Compte c : this.comptes)
			if (c.estADécouvert())
				comptesADécouvert.add(c);
		return comptesADécouvert;
	}
	
}
