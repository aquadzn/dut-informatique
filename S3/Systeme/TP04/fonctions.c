#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <pthread.h>
#include "fonctions.h"

int TOUR = 0;
int NUM_THREAD = 2;

void *afficheTab(void *t)
{
    T *args = (T *)t;
    for (int i = 0; i < args->taille; i++)
    {

        while (TOUR != args->id)
        {
            sleep(3);
        }

        if (i % 2 == args->id)
        {
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
    T *ts = malloc(sizeof(T) * NUM_THREAD);

    for (int i = 0; i < NUM_THREAD; i++)
    {
        (ts + i)->tab = tab;
        (ts + i)->taille = taille;
        (ts + i)->id = i;
        pthread_create(&tids[i], NULL, afficheTab, (ts + i));
    }

    pthread_join(*(tids), NULL);
    pthread_join(*(tids + 1), NULL);

    free(ts);
}

void *produitMatrice(void *mat)
{
    Mat *args = (Mat *)mat;

    int *row = malloc(sizeof(int) * args->taille);
    for (int i = 0; i < args->taille; i++)
    {
        for (int j = 0; j < args->taille; j++)
        {
            row[j] = args->r1[j] * args->r2[j];
        }
        args->res[args->i] = row;
    }
}

int **calculMatricielParallelise(int **t1, int **t2, int taille)
{
    pthread_t tids[taille * taille];
    Mat *mats = malloc(sizeof(Mat));
    mats->row = malloc(sizeof(int) * taille);
    mats->col = malloc(sizeof(int) * taille);

    for (int i = 0; i < taille; i++)
    {
        for(int j = 0; i < taille; j++) {
            mats->row[i] = 
            
            pthread_create(&tids[i], NULL, produitMatrice, (mats + i));
        }
    }

    pthread_join(*(tids), NULL);
    pthread_join(*(tids + 1), NULL);
}