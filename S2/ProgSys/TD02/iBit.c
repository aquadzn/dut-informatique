#include <stdio.h>

int iBit(unsigned int n, unsigned int i) {
    unsigned int ui = 1;
    // return (n & (1 << (i - 1))) >> (i - 1);
    return (1 >> i) & ui;
}

int main() {
    printf("%d\n", iBit(12, 2));
    return 0;
}