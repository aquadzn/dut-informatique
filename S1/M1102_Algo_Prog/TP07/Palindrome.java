import java.util.Scanner;


public class Palindrome {

    public static void main(String[] args) {

        Scanner saisie = new Scanner(System.in);
        
        System.out.print("Ton expression ? : ");
        String expression = saisie.nextString();

        saisie.close();

        System.out.println(parenthèsesCorrectes(expression) ? "C'est un palindrome" : "Pas un palindrome");
    }

    /* Retourne vrai si l'expression est correctement parenthésée. */
    public static boolean parenthèsesCorrectes(String expression) {
        
    }

}