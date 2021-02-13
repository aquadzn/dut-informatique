#include <stdio.h>

void print_bits(unsigned int nb) {
    for (int i = 0; i < sizeof(nb) * 8; i++) {
        printf("%i", nb & 0x01);
        nb = nb >> 1;
    }
    printf("\n");
}

int main() {
    unsigned int nb;
    printf("Saisir un entier non signé: ");
    scanf("%d",&nb);
    
    print_bits(nb);

    return 0;
}
