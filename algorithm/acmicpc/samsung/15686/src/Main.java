import java.io.*;
import java.util.*;
public class Main {
    static class info{
        int x,y;
        info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int ans = Integer.MAX_VALUE;
    static int N,M;
    static int arr[] = new int[14];
    static int dfs_check[] = new int[14];
    static int board[][], new_board[][];
    static boolean check2[] = new boolean[14];
    static info check[] = new info[14];

    static void init_board(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                new_board[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    static void dfs(int idx, int depth){
        if(depth == M){
            init_board();
            for(int i=0;i<M;i++){
                sol(arr[i]);
            }
            int sum = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(board[i][j] == 1){
                        sum+=new_board[i][j];
                    }
                }
            }
            ans = Math.min(sum,ans);
        }
        else{
            for(int i=idx;i<14;i++){
                if(dfs_check[i] == 1 || check2[i] == false) continue;
                arr[depth] = i;
                dfs_check[i] = 1;
                dfs(i+1, depth + 1);
                dfs_check[i] = 0;
            }
        }
    }

    static void sol(int k){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j] == 1){
                    int temp = Math.abs((check[k].x + 1) - (i + 1)) + Math.abs((check[k].y + 1) - (j + 1));
                    new_board[i][j] = Math.min(temp, new_board[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        new_board = new int[N][N];
        int k =0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2){
                    check[k] = new info(i,j);
                    check2[k++] = true;
                }
            }
        }
        dfs(0,0);
        System.out.println(ans);
    }
}
