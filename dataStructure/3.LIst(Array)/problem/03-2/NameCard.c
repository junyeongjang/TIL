#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "NameCard.h"

// NameCard 구조체 변수의 동적 할당 및 초기화 후 주소 값 반환
NameCard * MakeNameCard(char * name, char * phone)
{
    NameCard * card = (NameCard*)malloc(sizeof(NameCard));
    strcpy(card->name, name);
    strcpy(card->phone, phone);
    return card;
}

// NameCard 구조체 변수의 정보 출력
void ShowNameCardInfo(NameCard * pcard){
    printf("이름은 =  %s \n", pcard->name);
    printf("전화번호는 = %s \n", pcard->phone);
    printf("\n");
}

// 이름이 같으면 0, 다르면 0이 아닌 값 반환
int NameCompare(NameCard * pcard, char * name){
    if(strcmp(pcard->name, name) == 0 ) return 0; //strcmp의 반환 값은 같으면 0 
    else return -1;    
}

void ChangePhoneNum(NameCard * pcard, char * phone){
    strcpy(pcard->phone, phone);  //strcy(A,B) -> B를 A에 복사 
}

