import java.util.ArrayList;


public class EtatCivil {

	private final ArrayList<Personne> registre;

	public EtatCivil(ArrayList<Personne> l) {
		registre = l;
	}

	public int nombreDeMort() {
		int c = 0;
		for(Personne p : this.registre) {
			try {
				p.getAnneeMort();
				c++;
			} catch (PasMort ignored) {
			}
		}
		return c;
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

	public boolean tousVivant() {
		boolean vivant = true;

		for(Personne p : this.registre) {
			try {
				p.getAnneeMort();
				vivant = false;
			} catch (PasMort ignored) {
			}
		}

		return vivant;
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
		int i = -1;
		for(Personne p : this.registre) {
			try {
				p.getAnneeMort();
				i++;
			} catch (PasMort ignored) {
			}
		}

		if (i == -1) {
			throw new AucunMort();
		}
		// Cas où le dernier mort est la première personne du registre
		if (i == 0) {
			i--;
		}

		return this.registre.get(i + 1);
	}

	public Personne chercherPersonne(String nom) throws PersonneInconnue {
		for(Personne p : this.registre) {
			if (p.getNom().equals(nom)) {
				return p;
			}
		}

		throw new PersonneInconnue();
	}

	public void enregistrerMort(String nom, int anneeMort) throws PersonneInconnue, DeJaMort {
		Personne p = chercherPersonne(nom);
		p.meurt(anneeMort);
	}

	@Override
	public String toString() {
		return "EtatCivil [registre=" + registre + "]";
	}
}
