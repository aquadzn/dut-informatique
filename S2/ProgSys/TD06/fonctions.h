#include <stdlib.h>
#include <stdio.h>

typedef struct point2D {
    float x;
    float y;
} Point2D;

typedef struct element_point2D {
    Point2D p;
    struct element_point2D *suivant;
} Element_Point2D;

int afficheFichier(char *chemin);
char *litLigne(FILE *fp);
char **litFichier(char *chemin, int *nbLignes);
int ecritFichier(char *chemin, char **contenu, int nbLignes);
void libereTab(char **tab, int nbLignes);

int stocke(char *chemin, Element_Point2D *l);
int charge(char *chemin, Element_Point2D *l);
