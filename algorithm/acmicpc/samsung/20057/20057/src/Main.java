import java.util.*;
import java.io.*;
public class Main {
    static int N, ans;
    static int board[][];
    static info send;
    static int dx[] = {0,+1,0,-1};
    static int dy[] = {-1,0,+1,0};
    static int move_send_x1[] = {0, -2, -1, -1, -1, 0, 1, 1, 1, 2};
    static int move_send_y1[] = {-1, 0, -1, 0, 1, -2, -1, 0, 1, 0};

    static int move_send_x2[] = {1, 0, 1, 0 ,-1, 2, 1, 0, -1, 0};
    static int move_send_y2[] = {0, -2, -1, -1, -1, 0, 1, 1, 1, 2};

    static int move_send_x3[] = {0, -2, -1, -1, -1, 0, +1, +1, +1, +2};
    static int move_send_y3[] = {1, 0, 1, 0, -1, 2, 1, 0, -1, 0};

    static int move_send_x4[] = {-1, 0, -1, 0, +1, -2, -1, 0, +1, 0};
    static int move_send_y4[] = {0, -2, -1, -1, -1, 0, +1, +1, +1, +2};



    static int val[] = {-1 ,2, 10, 7, 1, 5, 10, 7, 1, 2};


    static class info{
        int x,y,dir;
        info(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static void moveSend(){
        for(int i=1;i<N-1;i++){
                for (int j = 0; j < 2; j++) {
                    for(int k=0;k<i;k++) {
                        int d = send.dir % 4;
                        int nx = (dx[d]) + send.x;
                        int ny = (dy[d]) + send.y;
                        spreadSend(nx, ny, d);
                        send.x = nx;
                        send.y = ny;
                    }
                    send.dir++;
                }
            }

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < N-1; k++) {
                int d = send.dir % 4;
                int nx = (dx[d]) + send.x;
                int ny = (dy[d]) + send.y;
                spreadSend(nx, ny, d);
                send.x = nx;
                send.y = ny;
            }
            send.dir++;
        }
    }


    static void spreadSend(int x, int y, int dir){
        int send = board[x][y];
        int a = send;
        board[x][y] = 0;

        if(dir== 0){
            for(int i=1; i<10;i++){
                int nx = x + move_send_x1[i];
                int ny = y + move_send_y1[i];
                int moving_send = (int)Math.floor(send * (val[i]/100.0));
                a-=moving_send;
                if(nx>=N || nx<0 || ny>=N || ny<0){
                    ans+=moving_send;
                }
                else board[nx][ny] += moving_send;
            }
            int nx = x + move_send_x1[0];
            int ny = y + move_send_y1[0];
            if(nx>=N || nx<0 || ny>=N || ny<0){
                ans+=a;
            }
            else board[nx][ny] += a;
        }
        if(dir== 1){
            for(int i=1; i<10;i++){
                int nx = x + move_send_x2[i];
                int ny = y + move_send_y2[i];
                int moving_send = (int)Math.floor(send * (val[i]/100.0));
                a-=moving_send;
                if(nx>=N || nx<0 || ny>=N || ny<0){
                    ans+=moving_send;
                }
                else board[nx][ny] += moving_send;
            }
            int nx = x + move_send_x2[0];
            int ny = y + move_send_y2[0];
            if(nx>=N || nx<0 || ny>=N || ny<0){
                ans+=a;
            }
            else board[nx][ny] += a;
        }
        if(dir == 2){
            for(int i=1; i<10;i++){
                int nx = x + move_send_x3[i];
                int ny = y + move_send_y3[i];
                int moving_send = (int)Math.floor(send * (val[i]/100.0));
                a-=moving_send;
                if(nx>=N || nx<0 || ny>=N || ny<0){
                    ans+=moving_send;
                }
                else board[nx][ny] += moving_send;
            }
            int nx = x + move_send_x3[0];
            int ny = y + move_send_y3[0];
            if(nx>=N || nx<0 || ny>=N || ny<0){
                ans+=a;
            }
            else board[nx][ny] += a;
        }

        if(dir == 3){
            for(int i=1; i<10;i++){
                int nx = x + move_send_x4[i];
                int ny = y + move_send_y4[i];
                int moving_send = (int)Math.floor(send * (val[i]/100.0));
                a-=moving_send;
                if(nx>=N || nx<0 || ny>=N || ny<0){
                    ans+=moving_send;
                }
                else board[nx][ny] += moving_send;
            }
            int nx = x + move_send_x4[0];
            int ny = y + move_send_y4[0];
            if(nx>=N || nx<0 || ny>=N || ny<0){
                ans+=a;
            }
            else board[nx][ny] += a;
        }

    }

    static void sol(){
        send = new info(N/2, N/2, 0);
        moveSend();
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
    }
}
