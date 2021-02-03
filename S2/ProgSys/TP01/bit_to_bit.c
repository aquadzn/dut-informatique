#include <stdio.h>

int main() {
    unsigned int a;
    int compteur=0;
    printf("Saisir un entier non signé :");
    scanf("%d",&a);
    
    while (a!=0){
        a=a<<1;
        compteur++;
    }
    int b=a;
    
    for (int i=0;i<compteur;i++) {
        a=a<<i;
        a=a>>compteur-1;
        printf("%d",a);
        a=b;
    }

    return 0;
}