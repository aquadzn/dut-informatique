#include <stdio.h>

int main(void) {
	int a = 5;
	int b = 10;
	int tmp = a;

	a = b;
	b = tmp;

	printf("%d\n", a);
	printf("%d\n", b);

	printf("Adresse a: %p\nAdresse b: %p\n", &a, &b);
}

