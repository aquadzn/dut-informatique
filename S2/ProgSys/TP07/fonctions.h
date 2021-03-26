typedef struct puissance4 {
    int largeur;
    int hauteur;
    char *joueur1;
    char *joueur2;
    int **grille;
    int num_coup;
} P4;

P4 initialiserPartie(int l, int h, char *j1, char *j2);
int poserPiece(P4 *partie, int col);
void afficheGrille(P4 *partie);
