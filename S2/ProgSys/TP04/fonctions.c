#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "fonctions.h" 

Point2D *saisieTabPoints2D(int *taille) {
    Point2D *p = malloc(0);
    int choix = 0;
    *taille = 0;

    while(choix != 1) {
        
        (*taille) ++;
        p = realloc(p, *taille * sizeof(Point2D));
        
        if (p == NULL) {
            exit(1);
        }

        float x, y;
        printf("X: ");
        scanf(" %f", &x);
        printf("Y: ");
        scanf(" %f", &y);

        p[*taille - 1].x = x;
        p[*taille - 1].y = y;

        printf("\nVoulez-vous continuer [0/1] : ");
        scanf("%d", &choix);
    }

	return p;
}

void affichePoints2D(Point2D *tab, int taille) {
    for (int i = 0; i < taille; i++) {
        printf("Coordonnées point %d - x: %f - y: %f\n", i, tab[i].x, tab[i].y);
    }
}

Point2D *symetrieOrigine(Point2D *tab, int taille) {
    Point2D *symetriques = NULL;
    symetriques = malloc(sizeof(Point2D) * taille);
    if (symetriques == NULL) {
        exit(0);
    }

    for(int i = 0; i < taille; i++) {
        symetriques[i].x = - (tab[i].x);
        symetriques[i].y = - (tab[i].y);
    }

    return symetriques;
}

int supprimePointsDistanceOrigine(Point2D *tab, int taille, double distance) {

}