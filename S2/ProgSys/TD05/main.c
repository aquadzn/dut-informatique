#include <stdio.h>
#include <stdlib.h>
#include "fonctions.h"

int main() {
    // Exercice 1

    Point2D p = {
        1.0,
        2.0
    };

    Element_Point2D *l = nouvelle_liste(p);
    l = inserer(l, (Point2D){3.0, 4.0});
    l = inserer(l, (Point2D){5.0, 6.0});
    l = inserer(l, (Point2D){7.0, 8.0});
    l = inserer(l, (Point2D){5.0, 6.0});
    l = inserer(l, (Point2D){9.0, 10.0});
    l = inserer(l, (Point2D){11.0, 12.0});
    l = inserer(l, (Point2D){5.0, 6.0});

    parcourir(l);

    l = supprimer_premier(l);
    parcourir(l);

    int *res = rechercher(l, (Point2D){5.0, 6.0});

    // La taille est dans res[0]
    printf("%d indices trouvés: ", res[0]);
    for (int i = 1; i <= res[0]; i++) {
        printf("%d ", res[i]);
    }
    printf("\n");

    free(res);
    free(l);

    // Exercice 2
    printf("\n-----------");

    Element_Etudiant *l_e = nouvelle_liste_etudiants("William", 14., 12.);
    l_e = inserer_etudiant(l_e, "Jean", 11., 8.);
    l_e = inserer_etudiant(l_e, "Pierre", 16.5, 13.);
    l_e = inserer_etudiant(l_e, "Paul", 12.5, 9.);
    afficher_etudiants(l_e);
    
    calcul_moyenne(l_e);
    afficher_notes_etudiant(l_e, "Jean");
    
    char *strs[] = {"Paul", "Pierre"};
    afficher_notes_etudiants(l_e, strs, 2);

    return 0;
}
