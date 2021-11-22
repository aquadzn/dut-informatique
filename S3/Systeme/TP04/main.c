#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include "fonctions.h"

int main(int argc, char *argv[]) {
    if (argc != 2) {
        exit(-1);
    }
    
    int n_thread = atoi(argv[1]);
    pthread_t threads[n_thread];
    int rc;

    for(long t_id = 0; t_id < n_thread; t_id++) {
        printf("Main: crée thread %ld\n", t_id);
        rc = pthread_create(
            &threads[t_id],
            NULL,
            bonjour,
            &t_id
        );

        // 0 false 1 true
        if (rc) {
            printf("ERROR; rc: %d\n", rc);
            exit(-1);
        }
    }

    pthread_exit(NULL);
}