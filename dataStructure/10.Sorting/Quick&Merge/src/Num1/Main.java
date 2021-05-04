package Num1;

import java.util.*;
class Main {
     public static void main(String[] args) {
        int T;
        Scanner sc = new Scanner(System.in);
        System.out.println("TestCase의 개수를 입력해주세요");
        T = sc.nextInt();
        for(int i=0;i<T;i++){
            Random rd = new Random(); // 랜덤 함수
            System.out.println("N의 범위를 구해주세요.(단, 너무 큰 수는 메모리가 터질 수도 있습니다 stack overflow 주의)");
            int size = sc.nextInt();
            int m_arr[] = new int[size + 1]; //mergersort array
            int q_arr[] =  new int[size + 1]; // quicksort array
            for(int j=0;j<size;j++) {  //같은 숫자로 비교해야 의미가 있음
                m_arr[j] = rd.nextInt(size) + 1; // 랜덤 값 생성
                q_arr[j] = m_arr[j];
            }
            System.out.println("****************Merget Sort****************");
            MergeSort m = new MergeSort(size);
            long beforeTime = System.currentTimeMillis();
            m.merge_sort(m_arr, 0, size-1); //mergesort
            long afterTime = System.currentTimeMillis();
            long secDiffTime = (afterTime - beforeTime);
            System.out.println("mergeSort의 시간 : " + secDiffTime);
            System.out.println("****************Quick Sort****************");
            QuickSort q = new QuickSort();
            beforeTime = System.currentTimeMillis();
            q.quickSort(q_arr,0, size-1); //Quicksort
            afterTime = System.currentTimeMillis();
            System.out.println("정렬된 배열 출력 ");
            secDiffTime = (afterTime - beforeTime);
            System.out.println("QuickSort의 시간 : " + secDiffTime);
        }
    }
}
