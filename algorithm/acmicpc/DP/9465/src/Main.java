import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int board[][] = new int[2][N+1];
            int dp[][] = new int[N+1][3];
            for(int j=0;j<2;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<N;k++){
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j=1; j<=N; j++) {
                dp[j][0] = Math.max(dp[j-1][0],Math.max(dp[j-1][1],dp[j-1][2]));
                dp[j][1] = Math.max(dp[j-1][0],dp[j-1][2])+board[0][j-1];
                dp[j][2] = Math.max(dp[j-1][0],dp[j-1][1])+board[1][j-1];
            }
            System.out.println(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])));
        }
    }
}
