package NUM2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int T;
        Scanner sc = new Scanner(System.in);
        System.out.println("TestCase의 개수를 입력해주세요");
        T = sc.nextInt();
        while(T-- > 0){
            Random rd = new Random(); // 랜덤 함수
            System.out.println("N의 범위를 구해주세요.(단, 너무 큰 수는 메모리가 터질 수도 있습니다 stack overflow 주의)");
            int N = sc.nextInt();
            System.out.println("임계 값을 입력해주세요.");
            int threshold = sc.nextInt();
            int q_arr[] =  new int[N + 1]; // quicksort array
            for(int i=0;i<N;i++) {  //같은 숫자로 비교해야 의미가 있음
                q_arr[i] = N-i;
            }
            QuickSort quick = new QuickSort();
            long beforeTime = System.currentTimeMillis();
            quick.quickSort(q_arr, 0, N-1, threshold);
            long afterTime = System.currentTimeMillis();
            long secDiffTime = (afterTime - beforeTime);
            System.out.println("QuickSort의 시간 : " + secDiffTime);
        }
    }
}
