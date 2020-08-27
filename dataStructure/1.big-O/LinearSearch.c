#include <stdio.h>

// 선형탐색, linearsearch
int LSearch(int arr[], int len, int target){
    for(int i=0;i<len;i++){
        if(arr[i] == target)
            return i;
    }
    return -1;
}

// 이분탐색, binary search 정렬된 데이터에서만 가능
int BSearch(int arr[], int len, int target){
    int first = 0;
    int last = len-1;
    int mid;

    while(first<=last){
        mid = (first + last )/2;
        if(target == arr[mid]) return mid;
        else{
            if(target < arr[mid]) last = mid-1;
            else first = mid+1;
        }
    }
    return -1 ;//못찾음
}