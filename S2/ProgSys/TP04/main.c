#include <stdio.h>
#include "fonctions.h"

int main() {

    int taille;
    Point2D *p = saisieTabPoints2D(&taille);

    affichePoints2D(p, 3);

    Point2D *p_sym = symetrieOrigine(p, 3);

    affichePoints2D(p_sym, 3);

    return 0;
}