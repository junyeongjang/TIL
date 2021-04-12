import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int n,m;
    private static boolean visit[];
    private static int arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visit = new boolean[10];
        arr = new int[10];
        func(0);
    }
    private static void func(int depth){
        if (depth == m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (visit[i] == true) continue;
                visit[i] = true;
                arr[depth] = i;
                func(depth + 1);
                visit[i] = false;
            }
        }
    }

}
