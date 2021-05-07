package Num1;

class QuickSort {
    void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end); //pivot 구함
            quickSort(arr, begin, partitionIndex-1); //재귀
            quickSort(arr, partitionIndex+1, end); //재
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
