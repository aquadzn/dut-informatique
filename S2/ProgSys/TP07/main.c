#include <stdio.h>
#include <stdlib.h>
#include "fonctions.h"

int main() {
    P4 p = initialiserPartie(8, 10, "John", "Doe");
    P4 *ptr = &p;
    poserPiece(ptr, 0);
    poserPiece(ptr, 1);
    poserPiece(ptr, 2);
    poserPiece(ptr, 3);
    poserPiece(ptr, 4);
    poserPiece(ptr, 0);
    poserPiece(ptr, 1);
    poserPiece(ptr, 0);

    afficheGrille(ptr);

    sauvegarder(ptr, "jeu.txt");

    return 0;
}
