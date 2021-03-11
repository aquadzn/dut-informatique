#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "fonctions.h"

Element_Point2D *nouvelle_liste(Point2D p) {
    Element_Point2D *head = malloc(sizeof(*head));
    if (head == NULL) {
        exit(1);
    }

    head->p = p;
    head->suivant = NULL;

    return head;
}

Element_Point2D *inserer(Element_Point2D *l, Point2D p) {
    Element_Point2D *new_head = nouvelle_liste(p);
    if (l == NULL || new_head == NULL) {
        exit(1);
    }

    new_head->suivant = l;

    return new_head;
}

Element_Point2D *supprimer_premier(Element_Point2D *l) {
    if (l == NULL) {
        exit(1);
    }

    if (l->suivant != NULL) {
        Element_Point2D *ele_sup = l->suivant;
        l->suivant = l->suivant->suivant;
        free(ele_sup);
    }

    return l;
}

void parcourir(Element_Point2D *l) {
    if (l == NULL) {
        exit(1);
    }

    Element_Point2D *e = l;
    while(e != NULL) {
        printf("Point2D x: %.2f - y: %.2f\n", e->p.x, e->p.y);
        e = e->suivant;
    }
    printf("NULL\n\n");
}

int *rechercher(Element_Point2D *l, Point2D p) {
    // res[0] = nombre de points égaux trouvés
    int *res = (int *) malloc(sizeof(int));
    if (res == NULL) {
        exit(1);
    }

    Element_Point2D *e = l;
    int i = 0;
    int i_element = 0;
    res[0] = i;

    while(e != NULL) {
        if (e->p.x == p.x && e->p.y == p.y) {
            i++;
            res = realloc(res, (i + 1) * sizeof(int));
            if (res == NULL) {
                exit(2);
            }

            // maj nombre de points égaux
            res[0] = i;
            // maj indices Point2D
            res[i] = i_element;
        }
        i_element++;
        e = e->suivant;
    }

    // Ex: != == == !=
    // Ret: [2, 1, 2]

    return res;
}

void calcul_moyenne(Element_Etudiant *l) {
    if (l == NULL) {
        exit(1);
    }

    Element_Etudiant *e = l->suivant;
    while(e != NULL) {
        e->moyenne = (e->sem1 + e->sem2) / 2;
        e = e->suivant;
    }
}

void afficher_notes_etudiant(Element_Etudiant *l, char *rech) {
    if (l == NULL) {
        exit(1);
    }

    printf("\n%s\n", rech);
    Element_Etudiant *e = l->suivant;
    while(e != NULL) {
        if (strcmp(e->nom, rech) == 0) {
            printf("Moyenne: %.2f\nSem 1: %.2f\nSem 2: %.2f\n", e->moyenne, e->sem1, e->sem2);
        }
        e = e->suivant;
    }
}

void afficher_notes_etudiants(Element_Etudiant *l, char **rech, int taille_rech) {
    if (l == NULL) {
        exit(1);
    }
    printf("\n");

    for (int i = 0; i < taille_rech; i++) {
        printf("%s\n", rech[i]);
        Element_Etudiant *e = l->suivant;
        while(e != NULL) {
            if (strcmp(e->nom, rech[i]) == 0) {
                printf("Moyenne: %.2f\nSem 1: %.2f\nSem 2: %.2f\n", e->moyenne, e->sem1, e->sem2);
            }
            e = e->suivant;
        }
    }
}

Element_Etudiant *filtre(Element_Etudiant *l, float seuil) {
    Element_Etudiant *new_list = malloc(sizeof(*new_list));
    if (new_list == NULL || l == NULL) {
        exit(1);
    }
    new_list->suivant = NULL;

    Element_Etudiant *e = l->suivant;
    while(e != NULL) {
        if (e->moyenne > seuil) {
            Element_Etudiant *new_head = malloc(sizeof(*new_head));
             
            new_head->moyenne = e->moyenne; 
            new_head->nom = e->nom; 
            new_head->sem1 = e->sem1; 
            new_head->sem2 = e->sem2; 
    
            new_head->suivant = new_list->suivant;
            new_list->suivant = new_head;
        }
        e = e->suivant;
    }

    return new_list;
}

Element_Etudiant *nouvelle_liste_etudiants(char *nom, float sem1, float sem2) {
    Element_Etudiant *head = malloc(sizeof(*head));
    if (head == NULL) {
        exit(1);
    }

    head->moyenne = 0;
    head->nom = nom;
    head->sem1 = sem1;
    head->sem2 = sem2;
    head->suivant = NULL;

    return head;

}

Element_Etudiant *inserer_etudiant(Element_Etudiant *l, char *nom, float sem1, float sem2) {
    Element_Etudiant *new_head = malloc(sizeof(*new_head));
    if (l == NULL || new_head == NULL) {
        exit(1);
    }

    new_head->moyenne = 0;
    new_head->nom = nom;
    new_head->sem1 = sem1;
    new_head->sem2 = sem2;
    new_head->suivant = l->suivant;
    l->suivant = new_head;

    return l;
}

void afficher_etudiants(Element_Etudiant *l) {
    if (l == NULL) {
        exit(1);
    }
    printf("\nEtudiants:\n");

    Element_Etudiant *e = l->suivant;
    while(e != NULL) {
        printf("%s\n", e->nom);
        e = e->suivant;
    }
    printf("NULL\n\n");
}
