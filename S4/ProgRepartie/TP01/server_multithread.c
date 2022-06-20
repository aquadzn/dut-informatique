#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <netinet/in.h>
#include <sys/socket.h>
#include <pthread.h>

int createServer(struct sockaddr_in sa)
{
    int sd = socket(PF_INET, SOCK_STREAM, 0);
    if (sd == -1)
    {
        perror("erreur creation serveur");
        exit(0);
    }

    int berr = bind(sd, (struct sockaddr *)&sa, sizeof(sa));
    if (berr == -1)
    {
        perror("erreur ... pour le bind");
        exit(0);
    }

    int errlist = listen(sd, SOMAXCONN);
    if (errlist == -1)
    {
        perror("erreur du listen");
        exit(0);
    }

    return sd;
}

int createConnection(int serverSocket, struct sockaddr_in *sa)
{
    int socket_connection = accept(serverSocket, NULL, NULL);

    if (socket_connection == -1)
    {
        perror("erreur connexion client");
        return -1;
    }

    return socket_connection;
}

int sendMess(int sockId, char *query)
{
    int envoie = send(sockId, query, strlen(query) + 1, 0);
    if (envoie == -1)
    {
        perror("erreur envoie de message");
        return -1;
    }

    return envoie;
}

char *readMess(int sockId)
{
    char *message = malloc(sizeof(char));
    char c = 1;
    int i = 0;
    while (c != '\0')
    {
        recv(sockId, &c, 1, 0);
        *(message + i) = c;
        i++;
        message = realloc(message, (i + 1) * sizeof(char));
    }
    *(message + i) = '\0';

    return message;
}

void *thread_echo(void *args)
{
    int socketClient = (int) args;

    int nread, n;
    char buffer[1024];
    FILE *fp;

    fp = fopen("downloaded.txt", "wb");

    if (fp == NULL) {
        printf("erreur ouverture fichier\n");
        return NULL;
    }

    while ((n = recv(socketClient, buffer, sizeof buffer, 0)) > 0) {
        fwrite(buffer, sizeof(char), n, fp);
        fprintf(stdout, "Received %d bytess\n", n);
    }

    fclose(fp);
    close(socketClient);
    return NULL;
}

void server_echo(int port)
{
    struct sockaddr_in sa;

    sa.sin_family = AF_INET;
    sa.sin_port = htons(port);
    sa.sin_addr.s_addr = INADDR_ANY;

    int socket_server = createServer(sa);

    pthread_t thId;

    while (1)
    {
        int socket_client = createConnection(socket_server, &sa);
        if (socket_client == -1)
        {
            perror("connexion refusée");
            exit(-1);
        }

        int status = pthread_create(&thId, NULL, thread_echo, (void *) socket_client);

        if (status != 0)
        {
            printf("erreur creation thread.\n");
            exit(1);
        }
    }
    pthread_join(thId, NULL);
}

int main(int argc, char **argv)
{
    server_echo(atoi(argv[1]));

    return 0;
}