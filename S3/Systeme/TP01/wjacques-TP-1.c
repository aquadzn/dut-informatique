#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

// desolez mais les consignes ne sont pas claires du tout...

void afficheNom() {
    pid_t pid1;
    pid_t pid2;
    pid1 = fork();
    pid2 = fork();

    if (pid1 == 0) {
        sleep(3);
        if (pid2 == 0) {
            sleep(1);
            printf("%s\n", "P11");
            exit(0);
        }
        sleep(2);
        printf("%s\n", "P1");
        exit(0);    
    }

    printf("%s\n", "P2");
    exit(0);
}

void affichePID(int n) {
    pid_t pid1;
    pid_t pid2;
    pid1 = fork();
    
    if (pid1 != 0) {
        pid2 = fork(); 
    }

    sleep(1);
    fclose(fopen("P1.txt", "w"));

    if (pid1 == 0) { 
        for (int i = 0; i < n; i++) { 
            while (fopen("P1.txt", "r") == NULL);
            printf("%s\n", "P1"); 
            fflush(stdout); 
            remove("P1.txt");
            fclose(fopen("P2.txt", "w")); 
        }
        exit(0);
    }
    
    if (pid2 == 0) {
        for (int j = 0; j < n; j++) {
            while (fopen("P2.txt", "r") == NULL);
            printf("%s\n", "P2");
            fflush(stdout);
            remove("P2.txt");
            fclose(fopen("P1.txt", "w")); 
        }
        waitpid(pid1, NULL, 0);
        waitpid(pid2, NULL, 0);
        exit(0);
    }

    remove("P1.txt");
    remove("P2.txt");
}

// marche pas
void comptage() {
    int CHILD = 100;
    int status = 0;

    for(int i = 0; i < CHILD; i++) {
        pid_t pid = fork();
        if (pid == 0) {
            int occurences = 0;
            char fname[255];
            sprintf(fname, "txt/PID_%d.txt", getpid());
            FILE *f_pid = fopen(fname, "r");
            int num_pid;
            fscanf(f_pid, "%d", &num_pid);

            FILE *f_codes = fopen("txt/codes.txt", "r");
            int num_codes;
            while (fscanf(f_codes, "%d\n", &num_codes) != EOF) {
                if (num_pid == num_codes) {
                    occurences++;
                }
            }

            fclose(f_codes);
            fclose(f_pid);

            sprintf(fname, "txt/RES_PID_%d.txt", getpid());
            FILE *f_res = fopen(fname, "w");
            fprintf(f_res, "%d", occurences);
            fclose(f_res);
            exit(0);
        }
        wait(&status);
    }

    for(int j = 0; j < CHILD; j++) {
        char fname[255];
        sprintf(fname, "txt/PID_%d.txt", getpid());

        FILE *f = fopen(fname, "w");
        fprintf(f, "%d", rand() % 100);
        fclose(f);
    }

    exit(0);
}

void creerCodes() {
    FILE *fp = fopen("txt/codes.txt", "w");
    for (int i = 0; i < 100; i++) {
        fprintf(fp, "%d\n", rand() % 100);
    }

    fclose(fp);
}


int main() {
    // afficheNom();
    // affichePID(3);
    // comptage();

    return 0;
}