#include <stdlib.h>
#include <stdio.h>
#include "fonctions.h"

// Fonction qui prend en entrée une liste chaînée de point 2D,
// renvoie un tableau qui contient ces point2D
// et par effet de bord la taille de ce tableau à l'aide du paramètre taille
Point2D *versTableau(Element_Point2D *l, int *taille) {
    Point2D *res = NULL;
    *taille = 0;

    if (l == NULL) {
        return res;
    }

    Element_Point2D *e = l;
    while(e != NULL) {
        res = realloc(res, (*taille + 1) * sizeof(Point2D));
        Point2D p = {e->p.x, e->p.y};
        res[(*taille)++] = p;
        e = e->suivant;
    }

    return res;
}

// Inverse de la fonction précédente
Element_Point2D *versListe(Point2D *tab, int taille) {
    Element_Point2D *l = (Element_Point2D *) malloc(sizeof(Element_Point2D));

    for(int i = 0; i < taille; i++) {
        inserer(l, tab[i]);
    }

    return l;
}

Element_Point2D *nouvelle_liste() {
    Element_Point2D *head = NULL;

    return head;
}

void inserer(Element_Point2D *l, Point2D p) {
    Element_Point2D *new_head = (Element_Point2D *) malloc(sizeof(Element_Point2D));
    if (l == NULL || new_head == NULL) {
        exit(1);
    }
    
    new_head->p = p;
    new_head->suivant = l;
    l = new_head;
}
