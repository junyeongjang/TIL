import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int arr[] = new int[10];
    static boolean check[] = new boolean[10001];
    static int num[];
    static StringBuilder sb = new StringBuilder();
    static void func(int depth, int idx){
        if (depth == M){
            for(int i=0;i<M;i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        else {
            for (int i = idx; i < N; i++) {
                int temp = num[i];
                arr[depth] = num[i];
                func(depth + 1, i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        num = new int[N];
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        func(0, 0);
        System.out.print(sb);
    }
}
