import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static boolean check[][] = new boolean[501][501];
    static int board[][] = new int[501][501];
    static int ans = Integer.MIN_VALUE;
    static void dfs(int depth, int x, int y, int sum){
        if(depth == 4){
            ans = Math.max(ans, sum);
            return ;
        }
        else {
            for(int i=0;i<4;i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx>=N || nx<0 || ny>=M || ny<0) continue;
                if(check[nx][ny]) continue;
                check[nx][ny] = true;
                dfs(depth + 1, nx, ny, sum + board[nx][ny]);
                check[nx][ny] = false;
            }
        }
    }
    static void init_check(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                check[i][j] = false;
            }
        }
    }
    static boolean point_check(int x, int y){
        if(x>=N || x<0 || y>=M || y<0) return false;
        return true;
    }
    static void last_check(int x, int y){
        if(point_check(x,y-1) && point_check(x,y) && point_check(x,y+1) && point_check(x+1,y)) {
            int sum = 0;
            sum = board[x][y-1] + board[x][y] + board[x][y+1] + board[x+1][y];
            ans = Math.max(sum ,ans);
        }
        if(point_check(x-1,y) && point_check(x,y) && point_check(x,y+1) && point_check(x+1,y)) {
            int sum = 0;
            sum = board[x-1][y] + board[x][y] + board[x][y+1] + board[x+1][y];
            ans = Math.max(sum ,ans);
        }
        if(point_check(x,y-1) && point_check(x,y) && point_check(x,y+1) && point_check(x-1,y)) {
            int sum = 0;
            sum = board[x][y-1] + board[x][y] + board[x][y+1] + board[x-1][y];
            ans = Math.max(sum ,ans);
        }
        if(point_check(x-1,y) && point_check(x,y) && point_check(x+1,y) && point_check(x,y-1)) {
            int sum = 0;
            sum = board[x-1][y] + board[x][y] + board[x+1][y] + board[x][y-1];
            ans = Math.max(sum ,ans);
        }
    }
    static void sol(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                check[i][j] = true;
               dfs(1,i,j,board[i][j]);
               last_check(i,j);
               init_check();
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();

    }
}
