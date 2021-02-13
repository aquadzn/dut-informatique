#include <stdio.h>

int main() {
	unsigned int num = 1;
	int count = 0;

	while (num != 0) {
		num = num << 1;
		count++;
	}
	
	printf("%d\n", count);
	return 0;
}
