#include <stdlib.h>
#include <stdio.h>
#include "fonctions.h"

int main() {

    int code = afficheFichier("hello.txt");
    printf("%d\n", code);
    code = afficheFichier("AHHH.txt");
    printf("%d\n\n", code);

    FILE *fp = fopen("hello.txt", "r");
    char *str = litLigne(fp);
    printf("%s\n", str);

    free(str);

    int ligne = 1;
    litFichier("hello.txt", &ligne);
    printf("lignes: %d\n", ligne);

    return 0;
}
