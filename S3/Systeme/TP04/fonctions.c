#include <stdio.h>
#include <unistd.h>
#include <pthread.h>
#include "fonctions.h"

int TOUR = 0;

void *afficheTab(void *t)
{
    T *args = (T *)t;
    for(int i = 0; i < args->taille; i++) {
       
        while(TOUR != args->id) {
            sleep(3);
        }

        if(i % 2 == args->id) {
            printf("%d", args->tab[i]);
            fflush(stdout);
            TOUR = (args->id + 1) % 2;
        }
    }

    pthread_exit(NULL);
}

void affichageDansOrdre(int *tab, int taille)
{
    pthread_t tids[2];
    T ts[2];

    for(int i = 0; i < 2; i++) {
        ts[i].tab = tab;
        ts[i].taille = taille;
        ts[i].id = i;
        pthread_create(&tids[i], NULL, afficheTab, &ts[i]);
    }
    
    pthread_join(tids[0], NULL);
    pthread_join(tids[1], NULL);
}