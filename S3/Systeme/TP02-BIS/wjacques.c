#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int compare(const void *aa, const void *bb)
{
    const int *a = aa, *b = bb;
    return (*a < *b) ? -1 : (*a > *b);
}

void executeTrieur(char *fichier, int taille, int *tab) {
    char **argval = malloc((4 + taille) * sizeof(char *));
    argval[0] = malloc(7 * sizeof(char));
    argval[0] = "trieur";
    argval[1] = malloc((strlen(fichier) + 1) * sizeof(char));
    argval[1] = fichier;
    argval[2] = malloc(3 * sizeof(char));
    sprintf(argval[2], "%d", taille);

    for(int i = 3; i < 3 + taille; i++) {
        argval[i] = malloc(3 * sizeof(char));
        sprintf(argval[i], "%d", tab[i - 3]);
    }
    argval[3 + taille] = NULL;

    execv("./trieur", argval);
    free(argval);
}

void trieEnParallele(int *tab1, int t1, int *tab2, int t2) {
    pid_t p1, p2;
    if ((p1 = fork()) == 0) {
        executeTrieur("f1.txt", t1, tab1);
        exit(0);
    }
    if ((p2 = fork()) == 0) {
        executeTrieur("f2.txt", t2, tab2);
        exit(0);
    }
    while(wait(NULL) != -1);

    int t3 = t1 + t2;
    int i = 0;
    char entier[t3];
    int *tab3 = malloc(sizeof(t3));
    FILE *f1 = fopen("f1.txt", "r");
    FILE *f2 = fopen("f2.txt", "r");

    while (fgets(entier, sizeof(entier), f1))
    {
        *(tab3 + i) = atoi(entier);
        i++;
    }
    fclose(f1);
    while (fgets(entier, sizeof(entier), f2))
    {
        *(tab3 + i) = atoi(entier);
        i++;
    }
    fclose(f2);

    qsort(tab3, t3, sizeof(int), compare);

    for (int j = 0; j < t3; j++)
    {
        printf("%d", *(tab3 + j));
        if (j >= 0 && j < t3 - 1)
        {
            printf(" ");
        }
    }
    printf("\n");
    free(tab3);
}

void rechercheEnParallele(char *fichier) {
    FILE *fp = fopen(fichier, "r");

    chdir("out/");
    for(char i = 'a'; i <= 'z'; i++) {
        pid_t pid = fork();
        if (pid == 0) {
            printf("%c", i);
            if (i != 'z') {
                printf(" ");
            }
            int count = 0;
            char c;
            char *fname = malloc(6 * sizeof(char));
            fname[0] = i;
            strcat(fname, ".txt\0");
            FILE *out = fopen(fname, "w");

            while((c = fgetc(fp)) != EOF) {
                if (c == i) {
                    count++;   
                }
            }
            fprintf(out, "%d", count);
            fclose(out);
            rewind(fp);
            exit(0);
        }
    }
    while(wait(NULL) != -1);
    
    printf("\n");
    for(char i = 'a'; i <= 'z'; i++) {
        char *fname = malloc(6 * sizeof(char));
        fname[0] = i;
        strcat(fname, ".txt\0");
        FILE *f = fopen(fname, "r");
        int count;
        fscanf(f, "%d", &count);

        printf("%i", count);
        if (i != 'z') {
            printf(" ");
        }

        fclose(f);
    }

    printf("\n");

    fclose(fp);
}

int main() {
    // int t[] = {5, 2, 7, 1};
    // executeTrieur("test.txt", 4, t);

    int t1[] = {7, 4, 6};
    int t2[] = {8, 3, 6, 7, 4};
    trieEnParallele(t1, 3, t2, 5);

    rechercheEnParallele("input");
    return 0;
}