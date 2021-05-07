import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[N+1];
        int dp[][] = new int[N+1][3];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++){
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1],dp[i-1][2])); // 0연속
            dp[i][1] = dp[i-1][0] + arr[i];  //1번연속
            dp[i][2] = dp[i-1][1] + arr[i];  //2번연속
        }
        System.out.println(Math.max(dp[N][0], Math.max(dp[N][1],dp[N][2])));
    }
}
