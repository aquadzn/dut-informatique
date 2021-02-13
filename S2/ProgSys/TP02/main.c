#include <stdio.h>

int longueurChaine(char ch[]);
int remplaceCaractere(char ch[], char c, char remp);
int recherchePremier(char ch[], char c);
int chainesEgales(char ch1[], char ch2[]);
double prodScalaire(double vec1[], double vec2[], int dim);

int main() {
    char salut[] = "salutations";
    printf("%s\n", salut);
    printf("%d\n", longueurChaine(salut));
    
    int occ = remplaceCaractere(salut, 'a', 'o');
    printf("%s - %d changements\n", salut, occ);

    printf("Charactère %c indice %d\n", 'l', recherchePremier(salut, 'l'));
    printf("Charactère %c indice %d\n", 'z', recherchePremier(salut, 'z'));

    printf("Identique? %d\n", chainesEgales("hello", "hello"));
    printf("Identique? %d\n", chainesEgales("hello", "olleh"));
    printf("Identique? %d\n", chainesEgales("hello", "hell"));

    double vec1[] = {1.3, 3.1, 5., 7.6};
    double vec2[] = {-3.1, 6.6, -2.3, 9.};

    printf("[1.3, 3.1, 5., 7.6] * [-3.1, 6.6, -2.3, 9.] = %f\n", prodScalaire(vec1, vec2, 4));

    return 0;
}

int longueurChaine(char ch[]) {
    int i = 0;
    while (ch[i] != '\0') {
        i++;
    }

    return i;
}

int remplaceCaractere(char ch[], char c, char remp) {
    int length = longueurChaine(ch);
    int occurences = 0;

    for (int i = 0; i < length; i++) {
        if (ch[i] == c) {
            ch[i] = remp;
            occurences++;
        }
    }
    
    return occurences;
}

int recherchePremier(char ch[], char c) {
    int length = longueurChaine(ch);

    for (int i = 0; i < length; i++) {
        if (ch[i] == c) {
            return i;
        }
    }

    return -1;
}

int chainesEgales(char ch1[], char ch2[]) {
    int length1 = longueurChaine(ch1);
    int length2 = longueurChaine(ch2);

    if (length1 != length2) {
        return 0;
    }
    else {
        for (int i = 0; i < length1; i++) {
            if (ch1[i] != ch2[i]) {
                return 0;
            }
        }
        return 1;
    }
}

double prodScalaire(double vec1[], double vec2[], int dim) {
    double produit = 0.;

    if (dim == 0) {
        return produit;
    }

    for (int i = 0; i < dim; i++) {
        produit += vec1[i] * vec2[i];
    }

    return produit;
}