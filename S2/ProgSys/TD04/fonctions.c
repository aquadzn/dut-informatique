#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <string.h>
#include "fonctions.h"

// int *n_premiers_nombres_premiers(int n) {
// 	int *tab = NULL;
// 	tab = malloc(n * sizeof(int));
// 	if (tab == NULL) {
// 		exit(0);
// 	}

// 	for (int i = 0;
// }

// int estPremier(int num) {    
//     if (num < 2) {
//         return 0;
//     }

//     for (int i = 2; i <= sqrt(num); i++) {
//         if (num % i == 0) {
//             return 0;
//         }
//     }
//     return 1;
// }

char *copieChaine(char *ch) {
	char *copy_ch = NULL;
	copy_ch = malloc(strlen(ch) * sizeof(char));
	if (copy_ch == NULL) {
		exit(1);
	}

	int i;
	for (i = 0; ch[i] != '\0'; i++) {
		copy_ch[i] = ch[i];
	}
	copy_ch[i] = '\0';

	return copy_ch;
}

int *saisieTableau(int *taille) {
    int *tab = (int *)malloc(0);
    char reply;
    *taille = 0;

    printf("Voulez-vous continuer [y/n] : ");
    scanf("%c", &reply);
    while(reply != 'n') 
    {
        (*taille) ++;
        tab = (int *)realloc(tab, *taille * sizeof(int));
        if (tab == NULL)
        {
            exit(EXIT_FAILURE);
        }

        printf("Quel nombre voulez vous ajouter : ");
        scanf("%d", &tab[*taille - 1]);

        printf("Voulez-vous continuer [y/n] : ");
        scanf("%c", &reply);
    }

	return tab;
}

char *chaine_sans_caractere_c(char *ch, char c) {

	char *copy_ch = malloc(sizeof(char));
	
	int rempl = 0;
    for (int i = 0; i < strlen(ch); i++) {
		if (ch[i] != c) {
			copy_ch[rempl++] = ch[i];
			copy_ch = realloc(copy_ch, (rempl + 1) * sizeof(char));
		}
	}
	
    copy_ch[rempl] = '\0';

    return copy_ch;
}