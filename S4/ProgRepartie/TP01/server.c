#include "fonctions.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <netinet/in.h>
#include <sys/socket.h>

void server_echo(int port) {
    struct sockaddr_in sa;

    sa.sin_family = AF_INET;
    sa.sin_port=htons(port);
    sa.sin_addr.s_addr= INADDR_ANY;

    int socket_server = createServer(&sa);

    while(1) {
        int socket_client = createConnection(socket_server, &sa);
        if (socket_client == -1) {
            perror("connexion refusée");
            exit(-1);
        }
        printf("%s\n", readMess(socket_client));

        close(socket_client);
    }
}

int main(int argc, char **argv) {
    server_echo(atoi(argv[1]));
    
    return 0;
}