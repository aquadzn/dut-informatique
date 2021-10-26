#include <unistd.h>
#include <string.h>
#include <stdio.h>
#include "fonctions.h"

#define STRING "bonjour"

void blocage_tube() {
    char buffer[1024];
    int fd[2];
    int nb_r, nb_w;

    nb_r = strlen(STRING);
    nb_w = strlen(STRING);

    strcpy(buffer, STRING);
    pipe(fd);
    for(;;) {
        printf("*");
        write(fd[1], buffer, nb_w);
        read(fd[0], buffer, nb_r);
    }
}