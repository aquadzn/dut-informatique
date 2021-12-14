#include <pthread.h>

struct t
{
    int *tab;
    int taille;
    int id;
} typedef T;

struct mat
{
    int *row;
    int *col;
    int taille;
    int **res;
    int i;
} typedef Mat;

void *afficheTab(void *t);
void affichageDansOrdre(int *tab, int taille);
void *produitMatrice(void *mat);
int **calculMatricielParallelise(int **t1, int **t2, int taille);