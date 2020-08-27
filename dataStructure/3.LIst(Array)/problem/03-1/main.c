#include "ArrayList.h"
#include <stdio.h>

int main(void){
    //1.리스트를 생성 및 초기화 한 다음, 정수 1부터 9까지 리스트에 저장한다.
    int sum = 0;
    int data;
    List list;
    ListInit(&list);
    for(int i=0;i<10;i++) LInsert(&list, i+1);
    //2. 리스트에 저장된값을 순차적으로 참조하여 그 합을 계산하여 출력한다.
    if(LFirst(&list, &data)){
        sum+=data;
        while(LNext(&list, &data)) sum+=data;
    }
    printf("정수의 합은 %d \n", sum);
    //3. 리스트에 저장된 값들 중 2의 배수와 3의 배수에 해당하는 값을 모두 삭제한다.
    if(LFirst(&list, &data)){
        if(data%2==0 || data%3 ==0 ) LRemove(&list);
        while(LNext(&list, &data)){
            if(data%2==0 || data%3 ==0 ) LRemove(&list);
        }
    }

    //4. 마지막으로 리스트에 저장된 데이터를 순서대로 출력한다.
    if(LFirst(&list, &data)){
        printf("%d ", data);
        while(LNext(&list, &data)){
            printf("%d ", data);
        }
    }
    return 0;
}