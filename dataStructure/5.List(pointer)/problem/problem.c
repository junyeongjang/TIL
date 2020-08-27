#include "problem.h"
#include <stdio.h>
#include <stdlib.h>

void list_init(List * plist){
    plist->head = (Node*)malloc(sizeof(Node)); //헤더 더미노드 생성
    plist->tail = (Node*)malloc(sizeof(Node)); // 꼬리 더미노드 생성
  
  
    plist->head->prev = NULL;
    plist->head->next = plist->tail;

    plist->tail->next = NULL;
    plist->tail->prev = plist->head;
    

    plist->numOfData = 0;
}
void l_insert(List * plist, Data data){
    Node * newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    //헤더 방향 설정
    newNode->prev = plist->tail->prev;
    plist->tail->prev->next = newNode;
    //꼬리 방향 설정
    newNode->next = plist->tail;
    plist->tail->prev = newNode;

    (plist->numOfData)++;
}

int l_first(List * plist, Data * data){

    if(plist->head->next==plist->tail) return 0;
    else{
        plist->cur = plist->head->next;
        *data = plist->cur->data;
    }
    return 1;
}
int l_next(List * plist, Data * data){
    if(plist->head->next==plist->tail) return 0;
    else{
        plist->cur = plist->cur->next;
        *data = plist->cur->data;
    }
    return 1;
}

Data l_remove(List * plist){
	Node * rpos = plist->cur;
	Data remv = rpos->data;

	plist->cur->prev->next = plist->cur->next;
	plist->cur->next->prev = plist->cur->prev;

	plist->cur = plist->cur->prev;   

	free(rpos);
	(plist->numOfData)--;
	return remv;
}

int LCount(List * plist){
    return plist->numOfData;
}