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

int main() {
    printf("Taille en bits: %d\n", sizeIntInBits());
    return 0;
}
