import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0; int e = 0; int ans = 0;
        int sum = 0;
        while(true){
            if(sum>=M)
                sum = sum - arr[s++];
            else if(e == N)
                break;
            else
                sum = sum + arr[e++];
            if(sum == M)
                ans++;
        }
        System.out.println(ans);
    }
}
