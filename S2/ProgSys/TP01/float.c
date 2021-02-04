#include <stdio.h>

int main() {

    float nb;
    printf("Saisir float: ");
    scanf("%f", &nb);

    printf("%.5f\n", nb);
    printf("%d\n", (int) nb);
    printf("%7.4f\n", nb);
    printf("%-7.4f\n", nb);

    // ça attend un (int) normalement
    printf("Octal: %o\n", nb);
    printf("Hexadécimal: %x\n", nb);

    return 0;
}