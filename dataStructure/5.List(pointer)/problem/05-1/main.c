#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "CLinkedList.h"
#include "member.h"
void find_member(List * plist, char * name, int day){
    Member * m ;
    LFirst(plist, &m);
    if(strcmp(m->name, name)==0){
        for(int i=0;i<day;i++){
            LNext(plist, &m);
        }
        printf("당직을 서는 사람은 %s 입니다 \n", m->name);
    }
    else{
        while(1){
            LNext(plist, &m);
              if(strcmp(m->name, name)==0) break;
        }
        for(int i=0;i<day;i++){
            LNext(plist, &m);
        }
        printf("당직을 서는 사람은 %s 입니다 \n", m->name);
    }  
}

int main(void){
    List  list;
    Member * member;
    ListInit(&list);

    //삽입1 
    member = (Member*)malloc(sizeof(Member));
    strcpy(member->name, "아이린");
    member->number= 1111;
    LInsert(&list, member);

    //삽입2
    member = (Member*)malloc(sizeof(Member));
    strcpy(member->name, "황예지");
    member->number= 2222;
    LInsert(&list, member);

    //삽입3 
    member = (Member*)malloc(sizeof(Member));
    strcpy(member->name, "남규리");
    member->number= 3333;
    LInsert(&list, member);

    //삽입4 
    member = (Member*)malloc(sizeof(Member));
    strcpy(member->name, "홍길동");
    member->number= 4444;
    LInsert(&list, member); 


    //조회
    find_member(&list, "아이린",7);
    find_member(&list, "황예지",7);
    find_member(&list, "남규리",7);
    find_member(&list, "홍길동",7);
    return 0;
}
