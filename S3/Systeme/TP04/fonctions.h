#include <pthread.h>

struct t {
    int *tab;
    int taille;
    pthread_t tid;
} typedef T;

void *afficheTab(void *t);
void affichageDansOrdre(int *tab, int taille);