#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include "fonctions.h"

int main() {
    int t[8] = {1, 4, 6, 2, 8, 4, 5, 2};
    affichageDansOrdre(t, 8);
}