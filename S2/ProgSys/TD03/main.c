#include <stdio.h>
#include "fonctions.h"

int main() {

    afficheChaineT("Salut");
    afficheChaineP("Pointeur");

    int tableau[] = {3, 4, 1, 8, 6, 2};
    printf("Max tableau: %d\n", max(tableau, 6));
    printf("Somme tableau: %d\n", somme(tableau, 6));

    // Saisie matrice
    int taille = 2;
    int mat[taille][taille];
    for (int i = 0; i < taille; i++) {
        for (int j = 0; j < taille; j++) {
            int val;
            printf("x%dy%d: ", i, j);
            scanf("%d", &val);
            mat[i][j] = (val * val);
        }
    }

    // affichage
    printf("Matrice:\n");
    for (int i = 0; i < taille; i++) {
        for (int j = 0; j < taille; j++) {
            printf("%d ", mat[i][j]);
        }
        printf("\n");
    }

    char kayak[] = "kayak";
    if (estPalindrome(kayak) == 1) {
        printf("\n%s: palindrome\n", kayak);
    }
    char salut[] = "salut";
    if (estPalindrome(salut) == 0) {
        printf("%s: pas palindrome\n", salut);
    }

    char bonjour[] = "bonjour";
    char o = 'o';
    printf("%s", bonjour);
    printf(" a enlevé '%c' %d fois et devient %s\n", o, squeeze(bonjour, o), bonjour);

    return 0;
}