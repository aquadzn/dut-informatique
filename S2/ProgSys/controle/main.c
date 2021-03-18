#include <stdio.h>
#include <stdlib.h>
#include "fonctions.h"

int main() {
    PartiePossession partie = initialisePartiePossession("William", "Jacques");
    deroulerPartie(&partie);
    
    return 0;
}