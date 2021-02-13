#include <stdio.h>
#include <math.h>

int estPremier(int num) {    
    if (num < 2) {
        return 0;
    }

    for (int i = 2; i <= sqrt(num); i++) {
        if (num % i == 0) {
            return 0;
        }
    }
    return 1;
}

int main() {
    printf("%d premier? : %d\n", 4, estPremier(4));
    return 0;
}