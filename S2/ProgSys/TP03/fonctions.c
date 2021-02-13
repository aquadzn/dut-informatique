#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "fonctions.h"

void intro() {
    int i = 3;
    int *p1;
    int **p2;

    p1 = &i;
    // p2 = *p1; pas valide
    // p2 = &i; pas valide
    p2 = &p1;

    // int j = *p2; pas valide
    int j = *p1; // 3
    // int j = **p2 + 1; pas valide car on redéfini j mais sinon valide
}

void distance2D(Point2D p1, Point2D p2) {
    double distance = sqrt(pow((p1.x - p2.x), 2) + pow((p1.y - p2.y), 2));
    printf("Distance entre deux points: %f\n", distance);
}

double distance2DOrigine(Point2D p) {
    return sqrt(pow(p.x, 2) + pow(p.y, 2));
}

Point2D milieuSegment(Point2D p1, Point2D p2) {
    Point2D milieu = {
        (p1.x + p2.x) / 2,
        (p1.y + p2.y) / 2
    };
    return milieu;
}

Point2D symetrieOrigine(Point2D p) {
    Point2D symetrie = {
        - (p.x),
        - (p.y)
    };
    return symetrie;
}

void symetrieOriginePointeur(Point2D *p) {
    *p = symetrieOrigine(*p);
}

void reinitialisePoint(Point2D *p) {
    p->x = 0.;
    p->y = 0.;
};

void setPoint(Point2D *p1, Point2D *p2) {
    p1->x = p2->x;
    p1->y = p2->y;
}

void affichePoint2D(Point2D p) {
    printf("Coordonnées point:\n\tx: %f\n\tx: %f\n", p.x, p.y);
}

Point2D *symetrieTableauPoint2D(Point2D *tab, int taille) {
    Point2D *symetriques = NULL;
    symetriques = malloc(sizeof(Point2D) * taille);
    if (symetriques == NULL) {
        exit(0);
    }

    for(int i = 0; i < taille; i++) {
        symetriques[i] = symetrieOrigine(tab[i]);
    }

    return symetriques;
}

int *initTable(int taille, int chiffre) {
    int *array = NULL;
    array = malloc(sizeof(int) * taille);
    if (array == NULL) {
        exit(0);
    }

    for (int i = 0; i < taille; i++) {
        array[i] = (i + 1) * chiffre;
    }

    return array;
}

void afficheTable(int *table, int taille) {
    for (int i = 0; i < taille; i++) {
        printf("%d ", table[i]);
    }
    printf("\n");
}