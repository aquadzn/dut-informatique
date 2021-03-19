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
        printf("%c", c);
        str[++i] = c;
        str = realloc(str, (i + 2) * sizeof(char));
    } while (c != '\n');
    str[i] = '\0';

    return str;
}

// Erreur!
char **litFichier(char *chemin, int *nbLignes) {
    char **tab = malloc(sizeof(char *));
    if (tab == NULL) {
        exit(1);
    }

    FILE *fp = fopen(chemin, "r");
    if (fp == NULL) {
        exit(1);
    }

    *nbLignes = 0;
    while (! feof(fp)) {
        (*nbLignes)++;
        tab = realloc(tab, *nbLignes * sizeof(char *));
        tab[*nbLignes - 1] = litLigne(fp);
    }

    fclose(fp);

    return tab;
}

// Ecrit dans un fichier donné
int ecritFichier(char *chemin, char **contenu, int nbLignes) {
    FILE *fp = fopen(chemin, "w");
    if (fp == NULL) {
        return -1;
    }
    
    for (int i = 0; i < nbLignes; i++) {
        fwrite(contenu[i], sizeof(contenu[i]), 1, fp);
        fwrite("\n", sizeof(char), 1, fp);
    }

    return 0;
}

// Libère la mémoire de chaque *tab dans **tab
void libereTab(char **tab, int nbLignes) {
    for (int i = 0; i < nbLignes; i++) {
        free(tab[i]);
    }
}

int stocke(char *chemin, Element_Point2D *l) {
    FILE *fp = fopen(chemin, "r");
    if (fp == NULL) {
        exit(1);
    }

    if (l == NULL) {
        exit(1);
    }

    int i = 0;
    Element_Point2D *e = l;
    while(e != NULL) {
        fwrite((char *) e->p.x, sizeof(char *), 1, fp);
        fwrite("\n", sizeof(char), 1, fp);
        e = e->suivant;
        i++;
    }
}

int charge(char *chemin, Element_Point2D *l) {

}
