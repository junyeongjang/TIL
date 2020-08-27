#include <stdio.h>
//  n! = n * (n-1)!
int Fac(int n){
    if(n == 0) return 1;
    else return n * Fac(n-1);
}