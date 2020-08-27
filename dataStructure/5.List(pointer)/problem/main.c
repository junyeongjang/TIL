#include "problem.h"
#include <stdio.h>
#include <stdlib.h>

int main(void){
    int data = 5;
    List list;
    list_init(&list);
    l_insert(&list, 5);
    l_insert(&list, 4);
    l_insert(&list, 3);
    l_insert(&list, 2);
    l_insert(&list, 1);
    l_first(&list,&data);
     printf("첫번 쨰 값 %d\n",data);
    l_next(&list, &data);
    printf("%d\n",data);
        l_next(&list, &data);
    printf("%d\n",data);
        l_next(&list, &data);
    printf("%d\n",data);
        l_next(&list, &data);
    printf("%d\n",data);


    return 0;
}