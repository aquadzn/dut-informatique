public class Conversion {
	
	public static void afficherFenC(double fahrenheit) {
		System.out.println(((fahrenheit - 32) * 5/9));
	}
	
	public static void afficherFenCApprox(int fahrenheit) {
		System.out.println(Math.round((fahrenheit - 32) * 5/9));
	}
	
	public static double convertirFenC(double fahrenheit) {
		return (fahrenheit - 32) * 5/9;
	}
	
	public static boolean caGeleEnF(double fahrenheit) {
		return (fahrenheit <= 0) ? true : false;
	}
	
	public static String caGlisseEnF(double fahrenheit) {
		return (caGeleEnF(fahrenheit)) ? "Attention! ça glisse!" : "Pas de danger.";
	}
	
	public static boolean caBoutEnF(double fahrenheit) {
		return (fahrenheit >= 100) ? true : false;
	}

	public static boolean eauLiquideEnF(double fahrenheit) {
		return (caGeleEnF(fahrenheit) && caBoutEnF(fahrenheit)) ? false : true;
	}

}
