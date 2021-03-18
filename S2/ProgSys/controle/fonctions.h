#define TAILLE_CHAINE 32
#define LARGEUR 12
#define HAUTEUR 8

typedef struct partiePossession {
    char attaquant[TAILLE_CHAINE];
    char defenseur[TAILLE_CHAINE];
    int (*grille)[LARGEUR];
    int aquiletour;
} PartiePossession;

PartiePossession initialisePartiePossession(char *n1, char *n2);
int poseJeton(PartiePossession *p, int colonne);
void changeTour(PartiePossession *p);
void afficheGrille(PartiePossession p);
void afficheEtatPartie(PartiePossession p);
int saisieNumeroColonne();
void deroulerPartie(PartiePossession *p);
PartiePossession copiePartie(PartiePossession p);