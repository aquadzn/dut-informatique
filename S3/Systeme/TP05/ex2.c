#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <time.h>
#include <semaphore.h>

int compteur = 0;
sem_t semaphore;

void *incremente(void *arg)
{
    int id = *((int *) arg);
    int tmp;
    sem_wait(&semaphore);

    for(int i = 0; i < 10; i++) {
        tmp = compteur;
        printf("%d - avant tmp: %d\n", id, tmp);
        sleep(1);
        tmp++;
        printf("%d - pendant tmp: %d\n", id, tmp);
        sleep(1);
        compteur = tmp;
        printf("%d - apres tmp: %d\n", id, tmp);
    }
    sem_post(&semaphore);

    pthread_exit(NULL);
}

int main()
{
    pthread_t tids[2];
    sem_init(&semaphore, PTHREAD_PROCESS_SHARED, 1);
    
    for (int i = 0; i < 2; i++) {
        int *arg = malloc(sizeof(*arg));
        *arg = i;
        pthread_create(&tids[i], NULL, incremente, arg);
    }

    for (int i = 0; i < 2; i++)
    {
        pthread_join(*(tids + i), NULL);
    }

    return 0;
}