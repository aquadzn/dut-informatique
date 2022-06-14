#include "fonctions.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <netinet/in.h>
#include <sys/socket.h>

int createServer(struct sockaddr_in *sa) {
    int sd = socket(PF_INET, SOCK_STREAM, 0);
    if (sd == -1) {
        perror("erreur creation serveur");
        exit(0);
    }

    int berr = bind(sd, (struct sockaddr *) sa, sizeof(*sa));
    if (berr == -1) {
        perror("erreur ... pour le bind");
        exit(0);        
    }

    int errlist = listen(sd, SOMAXCONN);
    if (errlist == -1) {
        perror("erreur du listen");
        exit(0);
    }

    return sd;
}

int createConnection(int serverSocket, struct sockaddr_in *sa) {
    int size = sizeof(*sa);
    int socket_connection = accept(serverSocket, (struct sockaddr *) sa, &size);
    
    if (socket_connection == -1) {
        perror("erreur connexion client");
        return -1;
    }

    return socket_connection;
}

int sendMess(int sockId, char *query) {
    int envoie = send(sockId, query, strlen(query) + 1, 0);
    if (envoie == -1) {
        perror("erreur envoie de message");
        return -1;
    }

    return envoie;
}

char *readMess(int sockId) {
    char *message = malloc(sizeof(char));
    char c = 1;
    int i = 0;
    while(c != '\0') {
        recv(sockId, &c, 1, 0);
        *(message + i) = c;
        i++;
        message = realloc(message, (i + 1) * sizeof(char));
    }
    *(message + i) = '\0';

    return message;
}