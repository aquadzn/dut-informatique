package calculatrice;

import java.util.Scanner;

public class CalculatriceMenuConsole {

    private static final Calculatrice calc = new Calculatrice();

    public static void main() {

        Scanner saisie = new Scanner(System.in);
        String choix;

        do {
            afficherMenu();
            choix = saisie.nextLine();

            switch (choix) {
                case "a":
                    System.out.println(calc.nbValeurs());
                    calc.additioner();
                    break;
                case "s":
                    calc.soustraire();
                    break;
                case "m":
                    calc.multiplier();
                    break;
                case "d":
                    try {
                        calc.diviser();
                    } catch (ArithmeticException e) {
                        System.out.println("Vous ne pouvez pas diviser par zéro!");
                        String effacer;
                        do {
                            System.out.print("Entrez e pour effacer le zéro de la pile: ");
                            effacer = saisie.nextLine();
                        } while (! effacer.equals("e"));
                        calc.effacer(1);
                    }
                    break;
                case "n":
                    calc.negation();
                    break;
                case "e":
                    calc.effacer();
                    break;
                case "q":
                    System.out.println("Aurevoir");
                    break;
                case "p":
                    calc.puissance();
                    break;
                // or ||
                case "sin": case "cos": case "tan": case "abs":
                case "ln": case "ln10": case "ln2": case "sqrt":
                    calc.operationAvancee(choix);
                    break;
                default:
                    try {
                        calc.entrerValeur(Integer.parseInt(choix));
                    } catch (NumberFormatException e) {
                        System.out.println("Vous n'avez pas rentré une valeur correcte.");
                    }
                    break;
            }
        } while (! choix.equals("q"));

        saisie.close();
    }

    private static void afficherMenu() {
        System.out.println("\nSommet de la calculatrice: " + calc.sommet()+ " - " + calc.nbValeurs() + " valeur(s) dans la pile");
        System.out.println("---------------------------");
        System.out.println("Entrez une valeur pour l'ajouter");
        System.out.println("a pour addition");
        System.out.println("s pour soustraction");
        System.out.println("m pour multiplication");
        System.out.println("d pour division");
        System.out.println("n pour négation");
        System.out.println("p pour puissance");
        System.out.println("Opérations avancées (sin, cos, tan, abs, ln, ln10, ln2, sqrt)");
        System.out.println("e pour effacer");
        System.out.println("q pour quitter");
        System.out.println("---------------------------");
        System.out.print("Votre choix: ");
    }

}
