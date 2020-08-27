#include <stdio.h>
#include <stdlib.h>
#include "ArrayList.h"
#include "NameCard.h"


int main(void){
    List list;
    ListInit(&list);
    //1. 총 3명의 전화번호를, 앞서 구현한 리스트에 저장한다.
    NameCard * card1 =  MakeNameCard("아이린", "010-1234-1111");
    NameCard * card2 =  MakeNameCard("사쿠라", "010-5678-2222");
    NameCard * card3 =  MakeNameCard("김오찌", "010-1111-3333");
    NameCard * temp =   MakeNameCard(" ", " ");
    LInsert(&list, card1);
    LInsert(&list, card2);
    LInsert(&list, card3);

    //2. 특정 이름을 대상으로 탐색을 진행하여, 그 사람의 정보를 출력한다.
    if(LFirst(&list, &temp)){
        if(NameCompare(temp, "사쿠라")==0)  ShowNameCardInfo(temp);
        while(LNext(&list, &temp)) {
        if(NameCompare(temp, "사쿠라")==0)  ShowNameCardInfo(temp);
        }
    }
    //3. 특정 이름을 대상으로 탐색을 진행하여, 그 사람의 전화번호 정보를 변경한다.
    if(LFirst(&list, &temp)){
        if(NameCompare(temp, "아이린")==0)  ChangePhoneNum(temp, "010-7777-7777");
        while(LNext(&list, &temp)) {
        if(NameCompare(temp, "아이린")==0)  ChangePhoneNum(temp, "010-7777-7777");
        }
    }
    //4. 특정 이름을 대상으로 탐색을 진행하여, 그 사람의 정보를 삭제한다.
    if(LFirst(&list, &temp)){
        if(NameCompare(temp, "김오찌")==0){
           temp = LRemove(&list);
            free(temp);
        }  
        while(LNext(&list, &temp)) {
         if(NameCompare(temp, "김오찌")==0) {
            temp = LRemove(&list);
            free(temp);
         } 
        }
    }

    //5. 끝으로 남아있는 모든 사람의 전화번호 정보를 출력한다.
    if(LFirst(&list, &temp)){
        ShowNameCardInfo(temp);
        while(LNext(&list, &temp)) ShowNameCardInfo(temp);
    }
    return 0;
}