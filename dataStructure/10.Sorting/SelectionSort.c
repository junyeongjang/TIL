#include<stdio.h>
void swap(int * A, int * B){
    int temp;
    temp = *A;
    *A = *B;
    *B = temp;
}

void SelectionSort(int * array, int len ){
    
    
    for(int i=0;i<len-1;i++){ //최솟값을 찾는다.
        int MinIdx = i;
        for(int j=i+1;j<len;j++){
            if(array[MinIdx]>array[j]) MinIdx = j;
        }
        swap(&array[i], &array[MinIdx]);
    }
}


int main(void){

    int arr[5] = { 5, 3, 7, 9, 1 };
    SelectionSort(arr,5);
    for(int i=0;i<5;i++) printf("%d ", arr[i]);
    return 0;
}