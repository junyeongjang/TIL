#include<stdio.h>


void hanoi(int num, char from, char by, char to){
    if(num==1) printf("원반 1을 %c에서 %c로 이동\n", from, to);
    else{
        hanoi(num-1, from, to, by);
        printf("원반 %d를 %c에서 %c로 이동", num,from,to);
        hanoi(num-1, from, to, by);
    }

}