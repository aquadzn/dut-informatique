typedef struct point2D {
    float x;
    float y;
} Point2D;

void afficher_point2D(Point2D p);

// Exercice 1

typedef struct element_point2D {
    Point2D p;
    struct element_point2D *suivant;
} Element_Point2D;

Element_Point2D *nouvelle_liste(Point2D p);
Element_Point2D *inserer(Element_Point2D *l, Point2D p);
Element_Point2D *supprimer_premier(Element_Point2D *l);
void parcourir(Element_Point2D *l);
int *rechercher(Element_Point2D *l, Point2D p);

// Exercice 2

typedef struct element_etudiant {
    char *nom;
    float sem1;
    float sem2;
    float moyenne;
    struct element_etudiant *suivant;
} Element_Etudiant;

void calcul_moyenne(Element_Etudiant *l);
void afficher_notes_etudiant(Element_Etudiant *l, char *rech);
void afficher_notes_etudiants(Element_Etudiant *l, char **rech, int taille_rech);
Element_Etudiant *filtre(Element_Etudiant *l, float seuil);

Element_Etudiant *nouvelle_liste_etudiants(char *nom, float sem1, float sem2);
Element_Etudiant *inserer_etudiant(Element_Etudiant *l, char *nom, float sem1, float sem2);
