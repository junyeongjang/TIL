package NUM2;

import java.util.*;

class QuickSort {
    void quickSort(int arr[], int begin, int end, int threshold) {
        int size = end - begin  + 1;  //부분 문제의 크기 배열의 사이즈
        if(size > 0 && threshold >= size){ //부분제 크기가 t이하로 줄어들면 삽입정렬 사용
            SelectionSort select = new SelectionSort();
            int [] newArray = Arrays.copyOfRange(arr, begin, end + 1);
            select.selectionSort(newArray); // 삽입 정렬
            for(int i=0;i<size;i++){  //배열 재복사
                arr[i + begin] = newArray[i];
            }
            return ;
        }
        else {
            if (begin < end) {
                int partitionIndex = partition(arr, begin, end);
                quickSort(arr, begin, partitionIndex - 1, threshold);
                quickSort(arr, partitionIndex + 1, end, threshold);
            }
        }
    }
    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end]; //임의의 pivot 설정
        int i = (begin-1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                //swap
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        //swap
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}
