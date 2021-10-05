#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include "fonctions.h"

void creationProcessus() {
    int i = 0;
    pid_t pid;

    pid = fork();
    i++;
    if (pid == 0) {
        i++;
        printf("fils: ");
        printf("i = %d et ", i);
        printf("pid = %d\n", getpid());
    }

    sleep(1);
    printf("i = %d et ", i);
    printf("pid = %d\n", getpid());
    exit(0);
}

void tracesExecution() {
    pid_t pid1;
    pid_t pid2;
    pid1 = fork();
    pid2 = fork();

    if (pid1 == 0) {
        if (pid2 == 0) {
            printf("pid2 = %d\n", getpid());
            exit(0);
        }

        printf("pid1 = %d\n", getpid());
        exit(0);    
    }

    printf("pid3 = %d\n", getpid());
    exit(0);
}

void accesFichiers(char *chemin) {
    pid_t pid;
    int i;
    
    FILE *fp = fopen(chemin, "a");
    pid = fork();
    if (pid == 0) {
        for(i = 0; i < 6; i++) {
            fprintf(fp, "%d", i);
        }
        exit(0);
    }

    fclose(fp);

    for(i = 6; i < 10; i++) {
        fprintf(fp, "%d", i);
    }

    exit(0);
}