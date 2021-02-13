#include <stdio.h>

int sizeIntInBits() {
	int count = 0;
    unsigned int num = 1;

	while (num != 0) {
		num = num << 1;
		count++;
	}

    return count;
}

int iBit(unsigned int n, unsigned int i) {
    unsigned int ui = 1;
    // return (n & (1 << (i - 1))) >> (i - 1);
    return (1 >> i) & ui;
}

void printInBinary(unsigned int num) {
    int intSize = sizeIntInBits();


    for (int i = intSize - 1; i >= 0; i--) {
        int bit = iBit(num, i);
        printf("%d ", bit);
    }
    printf("\n");
} 

int main() {
    printInBinary(12);
    return 0;
}