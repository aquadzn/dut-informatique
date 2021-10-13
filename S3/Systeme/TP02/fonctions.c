#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include "fonctions.h"

void exec1() {
    pid_t pid1, pid2;
    int i, i1, i2;

    pid1 = fork();
    if (pid1 == 0) {
        printf("Fils 1 = %d\n", getpid());
        exit(1);
    }
    pid2 = fork();
    if (pid2 == 0) {
        printf("Fils 2 = %d\n", getpid());
        exit(8);
    }

    i1 = wait(&i);
    printf(
        "Le PID du fils reçu par le père = %d, valeur de exit = %d\n",
        i1,
        (int) (i >> 8)
    );
    i2 = wait(&i);
    printf(
        "Le PID du fils reçu par le père = %d, valeur de exit = %d\n",
        i2,
        (int) (i >> 8)
    );

    exit(0);
}

void exec2() {
    char *path = "./exec2";
    char *argval[] = {
        "exec2", "toto",
        "titi", NULL
    };
    pid_t retour;

    switch (retour = fork()) {
        case -1:
            perror("Erreur fork");
            exit(1);
        case 0:
            printf("Le fils va éxécuter execv\n");
            execv(path, argval);
            // inatteignable
        default:
            printf("Père: a crée processus %d\n", retour);
            wait(NULL);
            printf("Père: a reçu term. fils\n");
    }
}