#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>

int main(int argc, char *argv[]) {
    if (argc != 2) {
        exit(1);
    }

    int fd[2], nbytes;
    pid_t child_pid;
    char buffer[80];

    pipe(fd);

    if ((child_pid = fork()) == -1) {
        perror("fork error");
        exit(1);
    }
    // fils
    else if (child_pid == 0) {
        close(fd[0]);
        write(
            fd[1],
            argv[1],
            strlen(argv[1]) + 1
        );
        exit(0);
    }
    // parent
    else {
        close(fd[1]);
        nbytes = read(fd[0], buffer, sizeof(buffer));
        printf("buffer: %s", buffer);
        execl("/usr/bin/wc", "wc", "-c", buffer, NULL);
    }

    return 0;
}
