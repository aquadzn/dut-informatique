#include <stdio.h>
#include <stdlib.h>
#include "fonctions.h"

int main() {

    char *ch = "Bonjour";
    // char *copy_ch = copieChaine(ch);
    // printf("Originale: %s\nCopie: %s\n", ch, copy_ch);
    // free(copy_ch);

    char *new_copy = chaine_sans_caractere_c(ch, 'o');
    printf("Originale: %s\nCopie: %s\n", ch, new_copy);
    free(new_copy);

    return 0;
}