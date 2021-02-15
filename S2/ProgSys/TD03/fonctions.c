#include <stdio.h>
#include "fonctions.h"

void afficheChaineT(char string[]) {
    printf("%s\n", string);
}

void afficheChaineP(char *string) {
    for(int i = 0; *string != '\0'; i++) {
        printf("%c", *(string + i));
    }
    printf("\n");
}

int max(int tab[], int taille) {
    int max = tab[0];
    for (int i = 0; i < taille; i++) {
        if (tab[i] > max) {
            max = tab[i];
        }
    }
    return max;
}

int somme(int tab[], int taille) {
    int somme = 0;
    for (int i = 0; i < taille; i++) {
        somme += tab[i];
    }
    return somme;
}

int estPalindrome(char string[]) {
    int taille = 0;
    while (string[taille] != '\0') {
        taille++;
    }

    for (int i = 0; i < taille; i++) {
        if (string[i] != string[taille - i - 1]) {
            // Pas palindrome
            return 0;
        }
    }
    // Palindrome
    return 1;
}

int squeeze(char string[], char c) {
    int taille = 0;
    while (string[taille] != '\0') {
        taille++;
    }

    int i, nouveau;
    for (i = nouveau = 0; i < taille; i++) {
        if (string[i] != c) {
            // string[nouveau++] = string[i];
            string[nouveau] = string[i];
            nouveau++;
        }
    }
    string[nouveau] = '\0';

    return taille - nouveau;
}
