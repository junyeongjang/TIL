import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int dp[] = new int[12];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int j=4;j<=N;j++){
                dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
            }
            System.out.println(dp[N]);
        }
    }
}
