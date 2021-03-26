#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "fonctions.h"

P4 initialiserPartie(int l, int h, char *j1, char *j2) {
    int **grille = malloc(h * sizeof(int *));
    for(int i = 0; i < h; i++) {
        grille[i] = malloc(l * sizeof(int));
        for(int j = 0; j < l; j++) {
            grille[i][j] = 0;
        }
    }

    char *joueur1 = malloc(strlen(j1) + 1 * sizeof(char));
    char *joueur2 = malloc(strlen(j2) + 1 * sizeof(char));
    strcpy(joueur1, j1);
    strcpy(joueur2, j2);

    P4 p = {
        l,
        h,
        joueur1,
        joueur2,
        grille,
        1
    };

    return p;
}

int poserPiece(P4 *partie, int col) {
    for(int i = 0; i < partie->largeur; i++) {
        if (partie->grille[0][i] != 0) {
            return -1;
        }
    }

    for(int i = partie->hauteur - 1; i >= 0; i--) {
        if (partie->grille[i][col] == 0) {
            if (partie->num_coup % 2 == 0) {
                partie->grille[i][col] = 1;
            }
            else {
                partie->grille[i][col] = 2;
            }
            partie->num_coup++;
            return (i * partie->hauteur) + col;
        }
    }
    partie->num_coup++;
    return -1;
}

void afficheGrille(P4 *partie) {
    printf("%s (O) vs %s (X)\n", partie->joueur1, partie->joueur2);
    for(int i = 0; i < partie->hauteur; i++) {
        for(int j = 0; j < partie->largeur; j++) {
            printf("|");
            if(partie->grille[i][j] == 0) {
                printf(" ");
            }
            if(partie->grille[i][j] == 1) {
                printf("O");
            }
            if(partie->grille[i][j] == 2) {
                printf("X");
            }
        }
        printf("\n");
    }
}
