#include <stdio.h>
#include <stdlib.h>
#include "fonctions.h"

int main() {
    P4 p = initialiserPartie(1, 2, "A", "B");
    P4 *ptr = &p;
    // poserPiece(ptr, 0);
    // poserPiece(ptr, 1);
    // poserPiece(ptr, 2);
    // poserPiece(ptr, 3);
    // poserPiece(ptr, 4);
    // poserPiece(ptr, 0);
    // poserPiece(ptr, 1);
    // poserPiece(ptr, 0);

    // afficheGrille(ptr);

    // sauvegarder(ptr, "jeu.txt");

    charger(ptr, "jeu.txt");

    // afficheGrille(ptr);

    return 0;
}
