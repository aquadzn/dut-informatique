#include <stdlib.h>
#include <stdio.h>
#include "fonctions.h"

int main() {

    afficheFichier("hello.txt");

    // FILE *fp = fopen("hello.txt", "r");
    // char *str = litLigne(fp);
    // printf("%s\n", str);

    // free(str);

    // int ligne;
    // char **tab = litFichier("hello.txt", &ligne);
    // printf("lignes: %d\n", ligne);


    // ecritFichier("new.txt", tab, 3);

    // free(tab);

    return 0;
}
