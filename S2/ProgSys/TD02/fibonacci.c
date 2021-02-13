#include <stdio.h>

int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }
 
    int prev = 0;
    int curr = 1;
    for (int i = 0; i < n - 1; i++) {
        int next = prev + curr;
        prev = curr;
        curr = next;
    }
 
    return curr;
}

int main() {
    printf("%d\n", fibonacci(10));
    return 0;
}