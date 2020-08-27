//삽입 정렬 Insertion Sort
#include <stdio.h>
void swap(int * A, int * B){
    int temp;

    temp = *A;
    *A = *B;
    *B = temp;
}

void InsertionSort(int * array, int len){
    int j;
    for(int i=1;i<len;i++){

        int Data = array[i];

        for(j=i-1;j>=0;j--){
            if(array[j] > Data) array[j+1] = array[j]; //뒤로 밈
            else break; // 삽입 위치를 찾았슴
        }
          array[j+1] = Data;
    }

}

int main(void){

    int arr[5] = { 5, 3, 7, 9, 1 };
    InsertionSort(arr,5);
    for(int i=0;i<5;i++) printf("%d ", arr[i]);
    return 0;
    return 0;

}