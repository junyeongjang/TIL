#include <stdio.h>
#include "CLinkedList.h"

int main(void){
    List list;
    int data;

    //초기화
    ListInit(&list);

    //삽입 
    LInsertFront(&list, 1);
    LInsertFront(&list, 2);
    LInsertFront(&list, 3);
    LInsertFront(&list, 4);
    LInsertFront(&list, 5);

    //조회 
    LFirst(&list,&data);
    printf("%d ", data);

    for(int i=1;i<list.numOfData;i++) {
        LNext(&list,&data);
        printf("%d ", data);
    }
  
    return 0;
}