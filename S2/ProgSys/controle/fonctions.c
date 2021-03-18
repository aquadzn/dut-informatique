#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "fonctions.h"
#define TAILLE_CHAINE 32
#define LARGEUR 12
#define HAUTEUR 8

PartiePossession initialisePartiePossession(char *n1, char *n2) {
    PartiePossession partie;
    strcpy(partie.attaquant, n1);
    strcpy(partie.defenseur, n2);

    int nouvelle_grille[LARGEUR][HAUTEUR];
    for(int i = 0; i < LARGEUR; i++) {
        for(int j = 0; j < HAUTEUR; j++) {
            nouvelle_grille[i][j] = 0;
        }
    }

    partie.aquiletour = 1;
    
    // Pas ok
    partie.grille = nouvelle_grille; 

    return partie;
}

int poseJeton(PartiePossession *p, int colonne) {
    // Pas fini
    
    if (p->grille[colonne][0] != 0) {
        return -1;
    }
}

void changeTour(PartiePossession *p) {
    if (p->aquiletour == 1) {
        p->aquiletour = 2;
    }
    else {
        p->aquiletour = 1;
    }
}

void afficheGrille(PartiePossession p) {
    for(int i = 0; i < LARGEUR; i++) {
        for(int j = 0; j < HAUTEUR; j++) {
            if (p.grille[i][j] == 0) {
                printf(" ");
            }
            if (p.grille[i][j] == 1) {
                printf("O");
            }
            if (p.grille[i][j] == 2) {
                printf("X");
            }
        }
        printf("\n");
    }
}

void afficheEtatPartie(PartiePossession p) {
    afficheGrille(p);
    if (p.aquiletour == 1) {
        printf("%s, à toi de jouer! ", p.attaquant);
    }
    else {
        printf("%s, à toi de jouer! ", p.defenseur);
    }
}

int saisieNumeroColonne() {
    int choix;

    do {
        printf("Choisis une colonne ou placer ton jeton: ");
        scanf("%d", &choix);
    } while (choix < 0 || choix > LARGEUR - 1);
    printf("\n");

    return choix;
}

void deroulerPartie(PartiePossession *p) {
    while (1) {
        afficheEtatPartie(*p);
        
        int choix = saisieNumeroColonne();
        
        int jeton = poseJeton(p, choix);
        
        changeTour(p);
    }
}

PartiePossession copiePartie(PartiePossession p) {
	PartiePossession copie;
    strcpy(copie.attaquant, p.attaquant);
    strcpy(copie.defenseur, p.defenseur);
    copie.grille = p.grille;
    copie.aquiletour = p.aquiletour;

    return copie;
}