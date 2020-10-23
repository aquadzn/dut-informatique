import java.util.Scanner;


public class Menu {

    public static void run() {

		Scanner saisie = new Scanner(System.in);
        int choix;

		do {
			System.out.println("1. Afficher Fahrenheit en Celsius");
			System.out.println("2. Afficher Fahrenheit en Celsius (approximation)");
			System.out.println("3. Convertir Fahrenheit en Celsius");
			System.out.println("4. Ca gèle ?");
			System.out.println("5. Ca glisse ?");
			System.out.println("6. Ca bout ?");
			System.out.println("7. Eau liquide ?");
			System.out.println("8. Quitter le programme");
            System.out.println("");
			System.out.print("Choix: ");
			choix = saisie.nextInt();
		}
		while (choix < 1 || choix > 8);

        double fahrenheit;
        int fahrenheit_approx;

		switch(choix) {
			case 1:
				System.out.print("Température (F): ");
				fahrenheit = saisie.nextDouble();

				Conversion.afficherFenC(fahrenheit);
				break;

			case 2:
				System.out.print("Température (F): ");
				fahrenheit_approx = saisie.nextInt();

				Conversion.afficherFenCApprox(fahrenheit_approx);
				break;

			case 3:
				System.out.print("Température (F): ");
				fahrenheit = saisie.nextDouble();

				double celsius = Conversion.convertirFenC(fahrenheit);
				System.out.println(fahrenheit + " --> " + celsius);
                break;

			case 4:
				System.out.print("Température (F): ");
				fahrenheit = saisie.nextDouble();

				boolean gelee = Conversion.caGeleEnF(fahrenheit);
				System.out.println(gelee ? "Gelée" : "Pas gelée");
                break;

			case 5:
				System.out.print("Température (F): ");
				fahrenheit = saisie.nextDouble();

				String reponse = Conversion.caGlisseEnF(fahrenheit);
				System.out.println(reponse);
                break;

			case 6:
				System.out.print("Température (F): ");
				fahrenheit = saisie.nextDouble();

				boolean bouillante = Conversion.caBoutEnF(fahrenheit);
				System.out.println(bouillante ? "Bouillante" : "Pas bouillante");
                break;

			case 7:
				System.out.print("Température (F): ");
				fahrenheit = saisie.nextDouble();

				boolean liquide = Conversion.eauLiquideEnF(fahrenheit);
				System.out.println(liquide ? "Eau liquide" : "Eau gelée ou bouillante");
                break;

			default:
				System.out.println("Au revoir!");
				break;
		}

        saisie.close();
    }
}