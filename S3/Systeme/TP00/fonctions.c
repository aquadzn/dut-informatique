#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "fonctions.h"

char *inverseChaine(char *chaine) {
    int taille = strlen(chaine);
	char *chaine_inversee = NULL;
	chaine_inversee = malloc((taille + 1) * sizeof(char));
	if (chaine_inversee == NULL) {
		exit(1);
	}

    for(int i = 0; i < taille; i++) {
        *(chaine_inversee + i) = *(chaine + taille - i - 1);
    }

    *(chaine_inversee + taille) = '\0';

    return chaine_inversee;
}

char *litChaine() {
    int i = 0;
    char c = ' ';
    char *str = malloc(sizeof(char));

    printf("Entrez caractère: ");
    while (c != '\n') {
        c = getc(stdin);
        *(str + i) = c;
        i++;

        str = realloc(str, i * sizeof(char));
    }

    *(str + i - 1) = '\0';

    return str;
}


char *litFichier(char *chemin) {
    char *str = malloc(sizeof(char));
    if (str == NULL) {
        exit(1);
    }

    FILE *fp = fopen(chemin, "r");
    if (fp == NULL) {
        exit(1);
    }

    int i = 0;
    while (! feof(fp)) {
        *(str + i) = fgetc(fp);
        i++;
        str = realloc(str, i * sizeof(char));
    }

    printf("%d\n", i);

    *(str + i - 1) = '\0';

    fclose(fp);

    return str;
}

char *litLigne(char *chemin) {
    FILE *fp = fopen(chemin, "r");
    if (fp == NULL) {
        exit(1);
    }

    char *str = malloc(sizeof(char));
    if (str == NULL) {
        exit(1);
    }
    
    char c = ' ';
    int i = 0;

    while (c != '\n') {
        // fread(&c, sizeof(char), 1, fp);
        c = getc(fp);
        *(str + i) = c;
        i++;
        str = realloc(str, i * sizeof(char));
    }

    *(str + i - 1) = '\0';

    return str;
}

char *relierChaines(char **tab) {
    char *str = malloc(sizeof(char));
    int i = 0;

    while (*(tab + i) != NULL) {
        str = realloc(str, (strlen(*(tab + i))) * sizeof(char));
        str = strcat(str, *(tab + i));
        i++;
    }
    str = realloc(str, ((strlen(str) + 1) * sizeof(char)));
    str[strlen(str)] = '\0';

    return str;
}

char **copierChaines(char **tab) {
    char **copie = malloc(sizeof(char *));
    int i = 0;

    while (*(tab + i) != NULL) {
        *(copie + i) = realloc(*(copie + i), strlen(*(tab + i)) * sizeof(char));

        strcpy(*(copie + i), *(tab + i));
        i++;
        copie = realloc(copie, i + 1 * sizeof(char *));
    }

    *(copie + i) = NULL;

    return copie;
}

char **trierChaines(char **tab) {
    char **tries = copierChaines(tab);
    int len_tab = 0;

    while (*(tab + len_tab) != NULL) {
        len_tab++;
    }

    for(int i = 0; i < len_tab; i++) {
        if (strcmp(*(tries + i), *(tries + i + 1)) > 0) {
            // swap pas fonctionnel
            // char *tmp = *(tries + i);
            // *(tries + i) = *(tries + i + 1);
            // *(tries + i + 1) = tmp; 
        }
    }

    return tries;
}

int **saisirMatrice(int taille) {
    int **mat = malloc(taille * sizeof(int *));
    for (int i = 0; i < taille; i++) {
        *(mat + i) = malloc(taille * sizeof(int));
        for (int j = 0; j < taille; j++) {
            printf("x%dy%d: ", i, j);
            // scanf("%d", &mat[i][j]);
            scanf("%d", (*(mat + i) + j));
        }
    }

    return mat;
}

void afficherMatrice(int taille, int **mat) {
    printf("Matrice:\n");
    for (int i = 0; i < taille; i++) {
        for (int j = 0; j < taille; j++) {
            printf("%d ", *(*(mat + i) + j));
        }
        printf("\n");
    }
}

void afficherMatriceFichier(int taille, int **mat, char *chemin) {
    FILE *fp = fopen(chemin, "w");
    if (fp == NULL) {
        exit(1);
    }

    for(int i = 0; i < taille; i++) {
        for(int j = 0; j < taille; j++) {
            fprintf(fp, "%d\n", *(*(mat + i) + j));
        }
    }

    fclose(fp);
}

void libererMatrice(int taille, int **mat) {
    for (int i = 0; i < taille; i++) {
        free(*(mat + i));
    }
    printf("%d octets libérés\n", 4 * taille * taille);
}

int **multiplierMatrices(int n, int **m1, int **m2) {
    int **res = malloc(n * sizeof(int *));
    for (int i = 0; i < n; i++) {
        *(res + i) = malloc(n * sizeof(int));
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                *(*(res + i) + j) += *(*(m1 + i) + k) * *(*(m2 + k) + j);
            }
        }
    }

    return res;
}

Point *saisirPoint() {
    Point *p = malloc(sizeof(Point));
    if (p == NULL) {
        exit(1);
    }

    printf("P.x = ");
    scanf("%f", &p->x);
    printf("P.y = ");
    scanf("%f", &p->y);

    return p;
}

Point *milieuPoint(Point *A, Point *B) {
    Point *milieu = malloc(sizeof(Point));
    if (milieu == NULL) {
        exit(1);
    }

    milieu->x = (A->x + B->x) / 2; 
    milieu->y = (A->y + B->y) / 2; 

    return milieu;
}