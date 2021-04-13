import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int check[];
    static int robot[];
    static int N, K;
    static int ans = 1;
    static void rotate_check(){
        int temp = check[2*N];
        for(int i= 2*N; i > 1;i--){
            check[i] = check[i - 1];
        }
        check[1] = temp;
        for(int i = N;i > 1 ;i--){
            robot[i] = robot[i - 1];
        }
        robot[1] = 0;
    }
    static void rotate_robot(){
        robot[N] = 0;
        for(int i = N; i > 1;i--){
            if(check[i] > 0 && robot[i - 1] == 1 && robot[i] == 0){
                robot[i] = 1;
                robot[i - 1] = 0;
                check[i]--;
            }
         }
    }
    static void create_robot(){
        if(check[1] > 0) {
            robot[1] = 1;
            check[1]--;
        }
    }
    static int check_break(){
        int cnt = 0;
        for(int i=1;i<=2 * N;i++){
            if(check[i] <= 0) cnt++;
        }
        if(cnt >= K) return 1;
        else return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        check = new int[2 * N + 1];
        robot = new int[N + 1];
        st = new StringTokenizer(rd.readLine());
        for(int i=1;i<=2*N;i++){
            check[i] = Integer.parseInt(st.nextToken());
        }
        while(true){
            rotate_check();
            rotate_robot();
            create_robot();
            if(check_break() == 1) break;
            ans++;
        }
        System.out.print(ans);
    }
}
