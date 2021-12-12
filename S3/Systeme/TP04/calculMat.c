#include <pthread.h>#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

typedef struct Mat
{
    int **M1;
    int **M2;
    int taille;
    int i;
    int j;
} mat;

int main(int argc, char const *argv[])
{
    int **M1 = saisitMatrice(2);
    int **M2 = saisitMatrice(2);
    calculMatricielEnParallele(M1, M2, 2);
    afficher_matrice(matFinal, 2);
    return 0;
}

int **calculMatricielEnParallele(int **tab1, int **tab2, int taille)
{

    pthread_t mythreads[taille * taille];
    mat *strc = (mat *)malloc(sizeof(mat) * (taille * taille));
    matFinal = (int **)malloc(sizeof(int *) * taille);
    int nbT = 0, n;

    for (int i = 0; i < taille * taille; i++)
    {
        (strc + i)->M1 = (int **)malloc(sizeof(int *) * taille);
        (strc + i)->M2 = (int **)malloc(sizeof(int *) * taille);
        for (int k = 0; k < taille; k++)
        {
            (*(((strc + i)->M1) + k)) = (int *)malloc(sizeof(int) * taille);
            (*(((strc + i)->M2) + k)) = (int *)malloc(sizeof(int) * taille);
        }
    }

    for (int i = 0; i < taille; i++)
    {
        *(matFinal + i) = (int *)malloc(sizeof(int) * taille);

        for (int j = 0; j < taille; j++)
        {
            (strc + nbT)->M1 = tab1;
            (strc + nbT)->M2 = tab2;
            (strc + nbT)->taille = taille;
            (strc + nbT)->i = i;
            (strc + nbT)->j = j;
            n = pthread_create(&mythreads[nbT], NULL, fct, (strc + nbT));
            nbT++;
        }
    }

    for (int i = 0; i < taille * taille; i++)
        pthread_join(mythreads[i], NULL);
    return 0;
}

void *fct(void *strc)
{
    mat *b = (mat *)strc;
    int res = 0;
    printf("\n");
    for (int i = 0; i < b->taille; i++)
    {
        res = res + (*((*((b->M1) + i)) + b->i)) * (*((*((b->M2) + b->j)) + i));
    }

    *((*(matFinal + b->i)) + b->j) = res;

    return 0;
}
