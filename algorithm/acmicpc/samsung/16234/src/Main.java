import java.util.*;
import java.io.*;
public class Main {
    static int N,L,R,ans;
    static int board[][];
    static boolean check[][], visited[][];
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};

    static class info{
        int x,y;
        info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    static int bfs(int x, int y){
        Queue<info> q = new LinkedList<>();
        visited[x][y] = true;
        int cnt = 0;
        int sum = 0;
        q.add(new info(x,y));
        while(!q.isEmpty()){
            info cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx>=N || nx<0 || ny<0 || ny>=N) continue;
                if(visited[nx][ny] || check[nx][ny] == false) continue;
                int temp = Math.abs(board[nx][ny] - board[x][y]);
                if(temp>=L && temp<=R) {
                    sum+=board[cur.x][cur.y];
                    cnt++;
                    visited[nx][ny] = true;
                    q.add(new info(nx, ny));
                }
            }
        }

        if(cnt>0) {
            sum = (int)(sum/cnt);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j]) board[i][j] = sum;
                }
            }
            ans++;
            return 1;
        }
        return 0;
    }
    static void init_visit(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
               visited[i][j] = false;
            }
        }
    }
    static void init_check(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                check[i][j] = false;
            }
        }
    }
    static void sol(){
        while(true) {
            int flag = 0;


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j] && visited[i][j] == false) {
                        if (bfs2(i, j) == 1) flag = 1;
                    }
                }
            }
            init_visit();
            init_check();
            if(flag == 0) break;
        }
    }
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        check = new boolean[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        System.out.println(ans);
    }
}
