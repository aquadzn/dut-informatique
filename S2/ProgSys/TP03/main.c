#include <stdio.h>
#include <stdlib.h>
#include "fonctions.h"

int main() {
    
    // Exercice 1

    intro();

    // Exercice 2

    Point2D p1 = {3.1, -1.3};
    Point2D p2 = {2.7, 6.5};
    distance2D(p1, p2);

    printf("Distance de p1 à l'origine:  %f\n", distance2DOrigine(p1));

    Point2D milieuP2 = milieuSegment(p1, p2);
    printf("Milieu de [p1p2]: x= %f y= %f\n", milieuP2.x, milieuP2.y);

    Point2D symetrieP1 = symetrieOrigine(p1);
    printf("Symétrie de p1: x= %f y= %f\n", symetrieP1.x, symetrieP1.y);

    printf("p2 avant symétrie: x= %f y= %f\n", p2.x, p2.y);
    symetrieOriginePointeur(&p2);
    printf("p2 après symétrie: x= %f y= %f\n", p2.x, p2.y);

    reinitialisePoint(&p2);
    printf("p2 après reset: x= %f y= %f\n", p2.x, p2.y);

    affichePoint2D(p2);
    setPoint(&p2, &p1);
    affichePoint2D(p2);
    
    Point2D p3 = {7.3, 4.1};
    Point2D p4 = {0.5, 3.8};

    Point2D tabP[] = {p1, p2, p3, p4};
    Point2D *symetriquesP = symetrieTableauPoint2D(tabP, 4);

    printf("\nAvant - Après symétriques:\n");
    for (int i = 0; i < 4; i++) {
        affichePoint2D(tabP[i]);
        affichePoint2D(symetriquesP[i]);
        printf("--------------\n");
    }

    free(symetriquesP);
    printf("\n");

    // Exercice 3
    int length = 10;
    int *array = initTable(length, 15);
    afficheTable(array, length);
    free(array);

    return 0;
}
