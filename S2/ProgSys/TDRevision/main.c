#include <stdio.h>
#include <stdlib.h>
#include "fonctions.h"

int main() {
    Element_Point2D *l = nouvelle_liste();
    inserer(l, (Point2D){1.5, 2.5});
    inserer(l, (Point2D){3.5, 4.5});
    inserer(l, (Point2D){5.5, 6.5});

    int taille;
    Point2D *res = versTableau(l, &taille);
    for(int i = 0; i < taille; i++) {
        printf("%f, %f\n", res[i].x, res[i].y);
    }

    return 0;
}
