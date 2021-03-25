#include <stdlib.h>
#include <stdio.h>
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

int main() {

    afficheFichier("hello.txt");

    // FILE *fp = fopen("hello.txt", "r");
    // char *str = litLigne(fp);
    // printf("%s\n", str);

    // free(str);

    // int ligne;
    // char **tab = litFichier("hello.txt", &ligne);
    // printf("lignes: %d\n", ligne);


    // ecritFichier("new.txt", tab, 3);

    // free(tab);

    Element_Point2D *l = nouvelle_liste((Point2D){1.1, 2.2});
    l = inserer(l, (Point2D){3.3, 4.4});
    l = inserer(l, (Point2D){5.5, 6.6});

    printf("%d\n", stocke("new.txt", l));

    free(l);
    return 0;
}
