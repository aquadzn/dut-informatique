typedef struct point2D {
    float x;
    float y;
} Point2D;

Point2D *saisieTabPoints2D(int *taille);
void affichePoints2D(Point2D *tab, int taille);
Point2D *symetrieOrigine(Point2D *tab, int taille);
int supprimePointsDistanceOrigine(Point2D *tab, int taille, double distance);