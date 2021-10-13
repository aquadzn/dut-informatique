#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    int i;
    printf("éxécution de ./exec2\n");
    printf("./exec2: %d paramètres\n", argc);
    for (i = 0; i < argc; i++) {
        printf("./exec2: paramètre %d=%s\n", i, argv[i]);
    }

    exit(0);
}