typedef struct point2D {
    float x;
    float y;
} Point2D;

void intro();
void distance2D(Point2D p1, Point2D p2);
double distance2DOrigine(Point2D p);
Point2D milieuSegment(Point2D p1, Point2D p2);
Point2D symetrieOrigine(Point2D p);
void symetrieOriginePointeur(Point2D *p);
void reinitialisePoint(Point2D *p);
void setPoint(Point2D *p1, Point2D *p2);
void affichePoint2D(Point2D p);
Point2D *symetrieTableauPoint2D(Point2D *tab, int taille);
int *initTable(int taille, int chiffre);
void afficheTable(int *table, int taille);