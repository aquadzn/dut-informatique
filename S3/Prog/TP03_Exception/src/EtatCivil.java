import java.util.ArrayList;


public class EtatCivil {

	private ArrayList<Personne> registre;

	public EtatCivil(ArrayList<Personne> l) {
		registre = l;
	}
	
	public int nombreDeVivant() {
		int c = 0;
		for(Personne p : this.registre) {
			try {
				p.getAnneeMort();
			} catch (PasMort ignored) {
				c++;
			}
		}
		return c;
	}

	public int nombreDeMortApres1960() {
		int c = 0;
		for(Personne p : this.registre) {
			try {
				if (p.getAnneeMort() > 1960) {
					c++;
				}
			} catch (PasMort ignored) {

			}
		}
		return c;
	}

	public boolean tousMort() {
		boolean mort = true;

		try {
			for(Personne p : this.registre) {
				p.getAnneeMort();
			}
		} catch (PasMort pasMort) {
			mort = false;
		}

		return mort;
	}

	public boolean auMoinsUnVivant() {
		boolean vivant = false;
		try {
			for(Personne p : this.registre) {
				p.getAnneeMort();
			}
		} catch (PasMort pasMort) {
			vivant = true;
		}

		return vivant;
	}

	public int nombreDeVivantDe1960() {
		int c = 0;
		for(Personne p : this.registre) {
			if (p.getAnneeNaissance() == 1960) {
				try {
					p.getAnneeMort();
				} catch (PasMort pasMort) {
					c++;
				}
			}
		}

		return c;
	}

	public Personne chercherPremierVivant() throws AucunVivant {
		int i = 0;

		try {
			for(Personne p : this.registre) {
				p.getAnneeMort();
				i++;
			}
			throw new AucunVivant();
		} catch (PasMort ignored) {
		}

		return this.registre.get(i);
	}

	public Personne chercherDernierMort() throws AucunMort {
		int i = 0;
		for(Personne p : this.registre) {
			try {
				p.getAnneeMort();
				i++;
			} catch (PasMort pasMort) {
			}
		}

		if (i == 0) {
			throw new AucunMort();
		}

		return this.registre.get(i);
	}

	public Personne chercherPersonne(String nom) throws PersonneInconnue {
		for(Personne p : this.registre) {
			p.getNom().equals(nom);
		}
	}

	@Override
	public String toString() {
		return "EtatCivil [registre=" + registre + "]";
	}
}
