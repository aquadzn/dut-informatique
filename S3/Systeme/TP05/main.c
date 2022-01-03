#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <semaphore.h>

static int *tabAdd = NULL;
static sem_t semaphore;

typedef struct thread_data
{
    int thread_id;
    int valiTab1;
    int valiTab2;
} TD;

void *add_function(void *td)
{
    TD *args = (TD *)td;

    sem_wait(&semaphore);
    printf("ID %d: %d + %d = %d\n", args->thread_id, args->valiTab1, args->valiTab2, args->valiTab1 + args->valiTab2);
    tabAdd[args->thread_id] = args->valiTab1 + args->valiTab2;
    sem_post(&semaphore);

    pthread_exit(NULL);
}

void add2Tabs(int *tab1, int *tab2, int taille)
{
    pthread_t tids[taille];
    TD *td = malloc(sizeof(TD) * taille);

    sem_init(&semaphore, PTHREAD_PROCESS_SHARED, 1);
    for (int i = 0; i < taille; i++)
    {
        (td + i)->thread_id = i;
        (td + i)->valiTab1 = tab1[i];
        (td + i)->valiTab2 = tab2[i];

        pthread_create(&tids[i], NULL, add_function, (td + i));
    }

    for (int i = 0; i < taille; i++)
    {
        pthread_join(*(tids + i), NULL);
    }

    printf("Résultat: [");
    for (int i = 0; i < taille; i++)
    {
        printf("%d, ", tabAdd[i]);
    }
    printf("]\n");

    free(td);
}

int main()
{
    int t = 3;
    tabAdd = malloc(sizeof(int) * t);
    int *t1 = malloc(sizeof(int) * t);
    int *t2 = malloc(sizeof(int) * t);

    t1[0] = 1;
    t1[1] = 2;
    t1[2] = 3;
    t2[0] = 4;
    t2[1] = 5;
    t2[2] = 6;

    add2Tabs(t1, t2, t);

    return 0;
}