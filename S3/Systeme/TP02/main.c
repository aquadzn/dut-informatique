#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include "fonctions.h"

int main() {
    // exec1();
    /*
    

    */


    exec2();
    /*
    Père: a crée processus 17810
    Le fils va éxécuter execv
    éxécution de ./exec2
    ./exec2: 3 paramètres
    ./exec2: paramètre 0=exec2
    ./exec2: paramètre 1=toto
    ./exec2: paramètre 2=titi
    Père: a reçu term. fils
    */

    return 0;
}