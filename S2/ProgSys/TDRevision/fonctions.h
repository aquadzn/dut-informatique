typedef struct point2D {
    float x;
    float y;
} Point2D;

typedef struct element_point2D {
    Point2D p;
    struct element_point2D *suivant;
} Element_Point2D;

Point2D *versTableau(Element_Point2D *l, int *taille);
Element_Point2D *versListe(Point2D *tab, int taille);
Element_Point2D *nouvelle_liste();
void inserer(Element_Point2D *l, Point2D p);
