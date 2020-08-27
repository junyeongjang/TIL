#include <stdio.h>

void swap(int * A, int * B){
    int temp;
    temp = *A;
    *A = *B;
    *B = temp; 
}

void BubbleSort(int  array[], int len){
    for(int i=0;i<len-1;i++){
        for(int j=0;j<len-i-1;j++){
            if(array[j]>array[j+1]) swap(&array[j], &array[j+1]);
        }
    }
}


int main(void){
    int arr[5] = { 5, 3, 7, 9, 1 };
    BubbleSort(arr, 5);
    for(int i=0;i<5;i++) printf("%d ", arr[i]);
    return 0;
}