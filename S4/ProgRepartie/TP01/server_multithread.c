#include "fonctions.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <netinet/in.h>
#include <sys/socket.h>
#include <pthread.h>

void *thread_echo(void *args) {
    int *socketClient = (int *) args;
    char *message = readMess(*socketClient);

    sendMess(*socketClient, message);
    close(*socketClient);
}

void server_echo(int port) {
    struct sockaddr_in sa;

    sa.sin_family = AF_INET;
    sa.sin_port = htons(port);
    sa.sin_addr.s_addr = inet_addr(ip);


    int socket_server = createServer(&sa);
    pthread_t thId;

    while(1) {
        int socket_client = createConnection(socket_server, &sa);
        if (socket_client == -1) {
            perror("connexion refusée");
            exit(-1);
        }

        thId = (pthread_t *) malloc(sizeof(pthread_t));

        pthread_create(thId, NULL, thread_echo, socket_client);
        pthread_join(thId, NULL);

        close(socket_client);
    }
}

int main(int argc, char **argv) {
    server_echo(atoi(argv[1]));
    
    return 0;
}