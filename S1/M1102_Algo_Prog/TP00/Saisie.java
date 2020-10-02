import java.util.Scanner;


class Saisie {
	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);

		String nomUtilisateur;
		System.out.print("Votre nom: ");
		nomUtilisateur = saisie.nextLine();

		System.out.println("Bonjour " + nomUtilisateur);
	}
}
