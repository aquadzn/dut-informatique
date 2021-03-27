package iteration_4;

public class VueConsole {

	private Environnement env;

	public VueConsole(Environnement env) {
		this.env = env;
	}

	public void afficher(String [][] tab){

		System.out.print("\t");
		for (int i = 0; i < tab[0].length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();

		for (int i = 0; i < tab.length; i++) {
			System.out.print((i + "\t"));
			for (int j = 0; j < tab[0].length; j++) {
				System.out.print("|" + tab[i][j]);
			}
			System.out.print("|\n");
		}
	}

	public String [][] tableauEnv(){
		String [][]  tab = new String[env.getHauteur()][env.getLargeur()];
		for(int i=0; i<tab.length;i++){
			for(int j=0;j<tab[0].length;j++){
				tab[i][j]= "___";
			}
		}
		for(Acteur a : env.getActeurs() ){
			tab[a.getY()][a.getX()]= a.getId();
		}
		return tab;
	}

	public int menuEtSaisie() {
		int rep = 0;
		try {
			System.out.println("1: creer 5 loups");
			System.out.println("2: creer 10 moutons");
			System.out.println("3: faire 1 tour");
			System.out.println("4 : faire 10 tours ");
			System.out.println("5 : quitter");
			System.out.println("   Entrez votre choix: ");
			rep = UtilSaisie.lireEntierPositifInferieurA(6);
		} catch (SaisieEntierException e) {
			System.out.println(e.getMessage());
			menuEtSaisie();
		}
		return rep;
	}

	public void go() {
		afficher(this.tableauEnv());
		boolean encore = true;
		while (encore) {
			int choix = menuEtSaisie();
			switch (choix) {
			case 1: {
				for(int i=0;i<5;i++){
					this.env.ajouter(new Loup(this.env));
				}
				break;
			}
			case 2: {
				for(int i=0;i<10;i++){
					this.env.ajouter(new Mouton(this.env));
				}
				break;
			}
			case 3: {
				this.env.unTour();
				afficher(this.tableauEnv());
				break;
			}
			case 4: {
				for (int i = 0; i < 10; i++) {
					this.env.unTour();
					afficher(this.tableauEnv());
				}
				break;
			}
			case 5: {
				System.out.println("au revoir");
				encore = false;
				break;
			}
			}
		}
	}

}
