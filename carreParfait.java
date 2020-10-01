import java.util.Scanner;


public class carreParfait {

    public static void main(String[] args) {
        
        Scanner saisie = new Scanner(System.in);
        int nombre;

        do {
            System.out.print("Veuillez saisir un entier positif: -> ");
            nombre = saisie.nextInt();
        }
        while (nombre < 1);

        boolean estParfait = false;
        int resultat = 0;

        for (int i = 0; i < nombre; i++) {
            if (i * i == nombre) {
                estParfait = true;
                resultat = i;
                break;
            }
        }

        if (estParfait) {
            System.out.printf("%d est un carré parfait car %d*%d = %d\n", nombre, resultat, resultat, nombre);
        }
        else {
            System.out.printf("%d n'est pas un carré parfait\n", nombre);
        }

        saisie.close();
    }


}
