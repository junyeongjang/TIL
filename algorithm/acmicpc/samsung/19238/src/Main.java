import java.util.*;
import java.io.*;
public class Main {
    static int N,M,gas;
    static int board[][], check[][], man[][];
    static int driver_x, driver_y;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static class info{
        int x,y;
        info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void bfs(){
        Queue<info> q = new LinkedList<>();
        q.add(new info(driver_x, driver_y));
        while(!q.isEmpty()) {
            info cur = q.peek();
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= N || nx < 0 || ny >= N || nx < 0) continue;
                if (check[nx][ny] != 0 || board[nx][ny] == 0) continue;
                q.add(new info(nx, ny));
                check[nx][ny] = check[cur.x][cur.y] + 1;
            }
        }
    }
    static void find_man(){
        

    }

    static void sol(){

        for(int i=0;i<M;i++){
            bfs();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        gas = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        man = new int[M][4];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        driver_x = Integer.parseInt(st.nextToken());
        driver_y = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                man[i][j] = Integer.parseInt(st.nextToken());
            }
        }



    }
}
