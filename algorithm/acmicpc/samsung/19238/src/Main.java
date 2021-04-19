import java.util.*;
import java.io.*;
public class Main {
    static int N,M,gas;
    static int board[][], check[][];
    static client c[];
    static int driver_x, driver_y;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static int client_idx;
    static int check_client[];
    static class info{
        int x,y;
        info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class client{
        int x1,x2,y1,y2;
        client(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    static void bfs(){
        Queue<info> q = new LinkedList<>();
        q.add(new info(driver_x, driver_y));
        check[driver_x][driver_y] = 1;
        while(!q.isEmpty()) {
            info cur = q.peek();q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                if (check[nx][ny] != 0 || board[nx][ny] == 1) continue;
//                System.out.println(nx + " " + ny);
                q.add(new info(nx, ny));
                check[nx][ny] = check[cur.x][cur.y] + 1;
            }
        }
    }
    static void find_man(){
        int min = 100000;
        int min_x = 100000;
        int min_y =  100000;
        for(int i=0;i<M;i++){
            if(check_client[i] == 0 && check[c[i].x1][c[i].y1] < min){
                min = check[c[i].x1][c[i].y1];
                min_x = c[i].x1;
                min_y = c[i].y1;
                client_idx = i;
            }
            else if(check_client[i] == 0 && check[c[i].x1][c[i].y1] == min){
                if(c[i].x1 < min_x){
                    min = check[c[i].x1][c[i].y1];
                    min_x = c[i].x1;
                    min_y = c[i].y1;
                    client_idx = i;
                }
                else if(c[i].x1 == min_x){
                    if(c[i].y1 < min_y){
                        min = check[c[i].x1][c[i].y1];
                        min_x = c[i].x1;
                        min_y = c[i].y1;
                        client_idx = i;
                    }
                }
            }
        }
    }

    static void init_check(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                check[i][j] = 0;
            }
        }
    }
    static void test_check(){
        System.out.println(driver_x + " " + driver_y + " " +gas);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(check[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int sol(){

        for(int i=0;i<M;i++){
            init_check();

            bfs();
            find_man();
            if(check[c[client_idx].x1][c[client_idx].y1] == 0) return  -1;
            if(check[c[client_idx].x1][c[client_idx].y1] - 1 > gas) return -1;
//            test_check();
            check_client[client_idx] = 1;
            driver_x = c[client_idx].x1;
            driver_y = c[client_idx].y1;
            gas -= (check[c[client_idx].x1][c[client_idx].y1] -1) ;
            init_check();
            bfs(); //start
//            test_check();
            if(check[c[client_idx].x2][c[client_idx].y2] - 1  > gas) return -1;
            if(check[c[client_idx].x2][c[client_idx].y2] == 0) return  -1;
            driver_x = c[client_idx].x2;
            driver_y = c[client_idx].y2;
            gas -= check[c[client_idx].x2][c[client_idx].y2] - 1;
            gas += ((check[c[client_idx].x2][c[client_idx].y2] - 1) * 2);
        }

        return gas;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        gas = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        check = new int[N][N];
        c = new client[M];
        check_client = new int[M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        driver_x = Integer.parseInt(st.nextToken());
        driver_y = Integer.parseInt(st.nextToken());
        driver_x--;
        driver_y--;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());
            int n4 = Integer.parseInt(st.nextToken());
            c[i] = new client(n1 - 1,n2 - 1,n3 - 1,n4 - 1);
        }
        System.out.println(sol());
    }
}
