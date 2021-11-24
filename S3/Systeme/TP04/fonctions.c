#include <stdio.h>
#include <unistd.h>
#include <pthread.h>
#include "fonctions.h"

int TOUR = 0;

void *afficheTab(void *t)
{
    T *t_unpack = (T *)t;

    printf("tid: %ld - tour: %d\n", t_unpack->tid, TOUR);

    // for (int i = 0; i < t_unpack->taille; i++)
    // {
    //     if (TOUR == t_unpack->tid)
    //     {
    //         printf("%d ", t_unpack->tab[TOUR]);
    //     }
    //     else
    //     {
    //         sleep(1);
    //     }
    // }
    TOUR++;
}

void affichageDansOrdre(int *tab, int taille)
{
    pthread_t tids[2];

    for (int i = 0; i < 2; i++)
    {
        T Tstruct = {tab, taille, tids[i]};
        pthread_create(&tids[i], NULL, afficheTab, &Tstruct);
    }

    pthread_exit(NULL);
}