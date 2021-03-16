#include <stdlib.h>
#include <stdio.h>

int afficheFichier(char *chemin);
char *litLigne(FILE *fp);
char **litFichier(char *chemin, int *nbLignes);
int ecritFichier(char *chemin, char **contenu, int nbLignes);
void libereTab(char **tab, int nbLignes);
