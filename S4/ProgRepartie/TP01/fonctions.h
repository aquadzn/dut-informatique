#include <netinet/in.h>

int createServer(struct sockaddr_in *sa);
int createConnection(int serverSocket, struct sockaddr_in *sa);
int sendMess(int sockId, char *query);
char *readMess(int sockId);