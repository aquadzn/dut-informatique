package iteration_2;


public class Lancement2 {

	public static void main(String [] args){
		Environnement e = new Environnement(20, 10);
		e.ajouter(new Mouton(2,1,e));
		e.ajouter(new Mouton(6,2,e));
		e.ajouter(new Loup(4,2,e));
		e.ajouter(new Loup(2,8,e));
		VueConsole vue= new VueConsole(e);
		vue.afficher(vue.tableauEnv());
		e.unTour();
		vue.afficher(vue.tableauEnv());
	}
}
