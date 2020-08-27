#include<stdio.h>
#include<stdlib.h>

typedef struct _node{
    int data;
    struct _node * next;
} Node;

int main(void){
    Node * head = NULL;
    Node * tail = NULL;
    Node * cur = NULL;

    Node * newNode = NULL;
    int readData;

    //데이터 입력
    while(1){
        printf("자연수 입력: ");
        scanf("%d", &readData);
        if(readData<1) break;

        //노드 추가 
        newNode = (Node*)malloc(sizeof(Node));
        newNode->data = readData;
        newNode->next= NULL;

        if(tail == NULL){
            head = newNode;
            tail = newNode; 
        } 
        else {
           newNode->next = head;
           head = newNode; 
        }
    }
    printf("\n");

    //데이터 출력

    if(head==NULL) printf("저장된 값이 없습니다 \n");
    else{
        cur = head;
        printf("%d ", cur->data);
        while(cur->next!=NULL){
            cur = cur->next;
            printf("%d ", cur->data);
        }
    }
    printf("\n\n");
    

    //메모리 해제

    if(head == NULL) return 0;

    else{

        Node * delNode = head;
        Node * delNextNode = head->next;

        printf("%d을(를) 삭제합니다. \n", head->data);
        free(delNode);
        while(delNextNode != NULL){
            delNode = delNextNode;
            delNextNode= delNextNode->next;
            printf("%d을(를) 삭제합니다. \n", delNode->data);
            free(delNode);
        }
    }


    return 0;
}