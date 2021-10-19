#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>


int main(int argc, char *argv[]) {
    if (argc == 3) {
        printf("éxécution de ./exec2 %d\n", getpid());
        printf("./exec2: %d paramètres\n", argc);

        FILE *fp = fopen(argv[1], "w");
        int n = atoi(argv[2]);

        for (int i = 0; i <= n; i++) {
            fprintf(fp, "%d\n", i);
        }

        fclose(fp);
    }
    exit(0);
}