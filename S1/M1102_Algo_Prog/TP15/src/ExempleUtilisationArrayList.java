// La classe ArrayList ne fait pas partie des classes disponibles par défaut en Java.
// Il faut indiquer au compilateur où la trouver (dans le package java.util).
import java.util.ArrayList;

// C'est la même chose pour la classe Scanner qui se trouve aussi dans le package java.util.
import java.util.Scanner;

public class ExempleUtilisationArrayList {

    /*
     * Ce programme demande la saisie de noms.
     * On ne sait pas à l'avance combien il y en a... difficile donc de les stocker dans un tableau.
     * Les noms sont stockés dans une liste de textes (type ArrayList<String> en Java).
     */
    public static void main(String[] args) {

        // la liste de textes dans laquelle nous allons stocker les noms saisis
        ArrayList<String> noms;

        // variable de saisie
        String nom;

        // le scanner pour les saisies
        Scanner sc = new Scanner(System.in);

        // création de la liste de textes
        // Lorsqu'on vient de la créer, la liste est vide.
        noms = new ArrayList<String>();

        System.out.println("Il y a " + noms.size() + " éléments dans la liste.");

        // saisie des noms que l'on place dans la liste
        // la saisie s'arrête lorsque l'utilisateur saisit "stop"
        System.out.print("Entrez le premier nom : ");
        nom = sc.nextLine();
        while (!nom.equals("stop")) {  // Pour tester l'égalité de deux types String, on ne peut pas utiliser == car cela comparerait les adresses.
            // equals(String s) est une méthode de la classe String qui permet de réaliser la comparaison souhaitée.
            noms.add(nom);  // La méthode add de la classe ArrayList permet d'ajouter un élément en fin de liste.
            System.out.print("Entrez le nom suivant : ");
            nom = sc.nextLine();
        }

        // Combien de noms ont été saisis ?
        System.out.println("Vous avez saisi " + noms.size() + " nom(s)."); // La méthode size() de la classe ArrayList permet d'obtenir le nombre d'éléments de la liste.

        // Parcours de la liste et affichage de son contenu
        // (version 1 qui utilise un indice comme nous l'avons fait avec les tableaux)
        for (int i = 0; i < noms.size(); i++) {  // On utilise la méthode size() pour obtenir la longueur de la liste...
            System.out.print(noms.get(i) + "\t");   // ... et la méthode get(int i) pour récupérer l'élément d'indice i dans la liste.
        }
        System.out.println();

        // juste pour voir... on supprime le premier élément de la liste
        if (!noms.isEmpty()) {
            System.out.println("Je supprime le premier nom dans la liste");

            noms.remove(0);

            System.out.println("Il reste  " + noms.size() + " nom(s).");

            // Parcours de la liste et affichage de son contenu
            // (version 2 qui utilise une syntaxe simplifiée de type foreach)
            for (String n : noms) { // pour n dans noms. La boucle parcourt tous les éléments de noms.
                System.out.print(n + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}
