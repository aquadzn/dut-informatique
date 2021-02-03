#include <stdio.h>

int main() {

    float nb;
    printf("Saisir float: ");
    scanf("%f", &nb);

    int nb_entier = (int) nb;

    printf("%.5f\n%d\n%7.4f\n", nb, nb_entier, nb);

    return 0;
}