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
        "exec2",
        "nombres.txt",
        "5",
        NULL
    };
    pid_t retour;

    switch (retour = fork()) {
        case -1:
            perror("Erreur fork");
            exit(1);
        case 0:
            printf("Le fils va éxécuter execv %d\n", getpid());
            execv(path, argval);
            // inatteignable
        default:
            printf("Père: a crée processus %d\n", retour);
            wait(NULL);

            FILE *fp = fopen(argval[1], "a");
            int n = atoi(argval[2]);

            for (int i = n + 1; i <= 2 * n; i++) {
                fprintf(fp, "%d", i);
                if (i != 2 * n) {
                    fputc('\n', fp);
                }
            }


            fclose(fp);

            printf("Père: a reçu term. fils\n");
    }
}

void multiprocessus(int argc, char *argv[]) {
    if (argc < 2) {
        exit(1);
    }

    int n = atoi(argv[1]);
    
    for (int i = 0; i < n; i++) {
        if (fork() == 0) {
            printf("Fils %d\n", getpid());
            exit(i);
        }
    }

    for (int i = 0; i < n; i++) {
        int p = wait(NULL);
        printf("Parent: fils %d terminé\n", p);
    }

}