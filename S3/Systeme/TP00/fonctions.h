char *inverseChaine(char *chaine);
char *litChaine();
char *litFichier(char *chemin);
char *litLigne(char *chemin);

char *relierChaines(char **tab);
char **copierChaines(char **tab);
char **trierChaines(char **tab);

int **saisirMatrice(int taille);
void afficherMatrice(int taille, int **mat);
void afficherMatriceFichier(int taille, int **mat, char *chemin);
void libererMatrice(int taille, int **mat);
int **multiplierMatrices(int n, int **m1, int **m2);

typedef struct point {
    float x;
    float y;
} Point;

Point *saisirPoint();
Point *milieuPoint(Point *A, Point *B);