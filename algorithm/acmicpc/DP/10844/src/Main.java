import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[][] = new int[n+1][10];

        for(int i=1;i<=9;i++){
            dp[1][i] = 1;
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                if(j == 9 || j == 0) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + 1;
            }
        }
        long res = 0;
        for(int i=0;i<=9;i++){
            res += dp[n][i];
        }
        System.out.print(res%1000000000);

    }
}
