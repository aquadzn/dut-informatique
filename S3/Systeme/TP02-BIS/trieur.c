#include <stdio.h>
#include <stdlib.h>

int compare(const void *aa, const void *bb)
{
    const int *a = aa, *b = bb;
    return (*a < *b) ? -1 : (*a > *b);
}

int main(int argc, char *argv[]) {
    FILE *fp = fopen(argv[1], "w");

    int n = atoi(argv[2]);
    int tab[n];

    for(int i = 3; i < 3 + n; i++) {
        tab[i - 3] = atoi(argv[i]);
    }
    qsort(tab, n, sizeof(int), compare);

    for(int i = 0; i < n; i++) {
        fprintf(fp, "%d\n", tab[i]);
    }

    fclose(fp);
}