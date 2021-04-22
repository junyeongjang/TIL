import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static String alpha[] = new String[12];
    static boolean check[] = new boolean[30];
    static int check_alpha[] = new int[30];
    static int arr[] = new int[12];
    static int board[] = new int[30];
    static int ans=-1;
    static void dfs(int depth){
        if(depth == M){
            int idx = 0;
            for(int i=0;i<M;i++){
                for(int j=idx;j<30;j++){
                    if(check_alpha[j] == 1){
                        board[j] = arr[i];
                        idx = j+1;
                        break;
                    }
                }
            }
            sol();
        }
        else{
            for(int i=0;i<=9;i++){
                if(check[i]) continue;
                arr[depth] = i;
                check[i] = true;
                dfs(depth + 1);
                check[i] = false;
            }
        }
    }


    static void sol(){
        int sum = 0;
        for(int i=0;i<N;i++){
            StringBuffer temp = new StringBuffer();
            StringBuffer s = new StringBuffer();
            s.append(alpha[i]);
            for(int j=0;j<s.length();j++){
                temp.append(board[s.charAt(j) - 'A']);
            }
            String s1 = temp.toString();
            sum+= Integer.parseInt(s1);
        }
        ans = Math.max(sum, ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            alpha[i] = br.readLine();
            StringBuffer s = new StringBuffer();
            s.append(alpha[i]);
            for(int j=0;j<s.length(); j++){
                if(check_alpha[s.charAt(j) - 'A'] == 0) {
                    check_alpha[s.charAt(j) - 'A'] = 1;
                    M++;
                }
            }
        }
        dfs(0);
        System.out.print(ans);
    }
}