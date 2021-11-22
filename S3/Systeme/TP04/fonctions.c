#include <stdio.h>
#include <pthread.h>
#include "fonctions.h"

void *bonjour(void *args) {
    printf("\tBonjour, id = %ld\n", *((long *) args));
    pthread_exit(NULL);
}