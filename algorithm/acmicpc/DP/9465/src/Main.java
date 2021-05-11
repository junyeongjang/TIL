import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[N+1];
        int dp[] = new int[N+1];
        int check[] = new int[1001];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=N-1;i>=0;i--){
            dp[i] = 1;
            for (int j=N-1; j>i; j--){
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<N;i++){
            ans = Math.max(dp[i], ans);
        }
        System.out.println(ans);
    }
}