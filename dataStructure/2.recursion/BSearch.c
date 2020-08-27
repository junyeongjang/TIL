#include <stdio.h>
int BSearch(int arr[], int first, int last, int target){
    if(first>last) return -1;
    int mid = (first+last)/2;

    if(arr[mid] == target) return mid;
    else if(arr[mid] > target) return (BSearch(arr, first, mid-1, target)); 
    else return BSearch(arr, mid+1, last, target);
}