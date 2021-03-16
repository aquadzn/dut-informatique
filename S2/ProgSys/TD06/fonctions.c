#include <stdlib.h>
#include <stdio.h>
#include "fonctions.h"

int afficheFichier(char *chemin) {
    FILE *fp = fopen(chemin, "r");

    if (fp != NULL) {
        char str[100];
        fread(&str, sizeof(char), 100, fp);
        printf("%s\n", str);

        fclose(fp);
        return 1;
    }
    else {
        return -1;
    }
}

char *litLigne(FILE *fp) {
    char *str = malloc(sizeof(char));
    if (str == NULL) {
        exit(1);
    }
    
    char c;
    int i = -1;

    do {
        fread(&c, sizeof(char), 1, fp);
        str[++i] = c;
        str = realloc(str, (i + 2) * sizeof(char));
    } while (c != '\n');
    str[i] = '\0';

    return str;
}

// Pas correct
char **litFichier(char *chemin, int *nbLignes) {
    char **tab = malloc(sizeof(**tab));
    if (tab == NULL) {
        exit(1);
    }

    FILE *fp = fopen(chemin, "r");
    if (fp == NULL) {
        exit(1);
    }

    while (! feof(fp)) {
        (*nbLignes)++;
        tab = realloc(tab, *nbLignes * sizeof(char *));
        tab[*nbLignes - 1] = litLigne(fp);
    }

    fclose(fp);

    return tab;
}

// Pas faite
int ecritFichier(char *chemin, char **contenu, int nbLignes) {}

// Pas faite
void libereTab(char **tab, int nbLignes) {}
