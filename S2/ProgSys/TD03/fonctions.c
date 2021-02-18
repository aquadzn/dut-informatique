#include <stdio.h>
#include "fonctions.h"

void afficheChaineT(char string[]) {
    for (int i = 0; string[i] != '\0'; i++) {
        printf("%c", string[i]);
    }
    printf("\n");
}

void afficheChaineP(char *string) {

    /* autre méthode
    while (*string) {
        printf("%c", *string);
        string++;
    }
    */ 

    for(int i = 0; *(string + i) != '\0'; i++) {
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

    int i, rempl;
    for (i = rempl = 0; i < taille; i++) {
        if (string[i] != c) {
            // string[rempl++] = string[i];
            string[rempl] = string[i];
            rempl++;
        }
    }
    string[rempl] = '\0';

    // squeeze("abc", 'b');
    // >>>
    // condition i < taille = 3
    // i = 0, rempl = 0, "abc" -> "abc"
    // i = 1, rempl = 1, "abc" -> "abc"
    // i = 2, rempl = 1, "abc" -> "acc"
    // fin boucle
    // i = 3, rempl = 2, "acc" -> "ac\0"

    return taille - rempl;
}
