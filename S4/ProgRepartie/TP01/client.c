#include "fonctions.h"
#include <stdio.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <sys/socket.h>
 #include <arpa/inet.h>

int connexion_serveur(char *ip, int port) {
    struct sockaddr_in sa;

    sa.sin_family = AF_INET;
    sa.sin_port = htons(port);
    sa.sin_addr.s_addr = inet_addr(ip);
    

    int sd = socket(PF_INET, SOCK_STREAM, 0);
    if (sd == -1) {
        return -1;
    }

    int connexion = connect(sd, (struct sockaddr *) &sa, sizeof(sa));
    if (connexion == -1) {
        perror("connexion");
        return -1;
    }

    return sd;
}

int main(int argc, char **argv) {
    int socket_id = connexion_serveur(argv[1], atoi(argv[2]));
    
    sendMess(socket_id, "BOZO\0");
    char *mesRecu = readMess(socket_id);
    printf("message du serveur %s\n", mesRecu);

    return 0;
}