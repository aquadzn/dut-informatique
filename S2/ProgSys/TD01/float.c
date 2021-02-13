// ex 4

#include <stdio.h>

int main() {

    float nb;
    printf("Saisir réel: ");
    scanf("%f", &nb);

    printf("%.5f\n", nb);
    printf("%+d\n", (int) nb);
    printf("%7.4f\n", nb);
    printf("%-7.4f\n", nb);

    // %o %x attendent normalement (int) nb 
    printf("\nOctal: %o\n", nb);
    printf("Hexadécimal: %x\n", nb);

    return 0;
}