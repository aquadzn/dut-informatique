#include <pthread.h>

struct t {
    int *tab;
    int taille;
    int id;
} typedef T;

void *afficheTab(void *t);
void affichageDansOrdre(int *tab, int taille);