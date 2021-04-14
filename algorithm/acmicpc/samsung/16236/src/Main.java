import java.io.*;
import java.util.*;

public class Main {
    static int mat[][] = new int[20][20];
    static int N,shark_x, shark_y, shark_size, shark_time, eat;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static class p {
        int x, y, time;
        p(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
                if(mat[i][j] == 9){
                    shark_x = i; shark_y = j; shark_time = 0; shark_size = 2;
                    mat[i][j] = 0;
                }
            }
        }
        boolean is_eat = true;
        while(is_eat) {
            Queue<p> q = new LinkedList<>();
            boolean check[][] = new boolean[20][20];
            p fish = new p(20,0,-1); // 탈출 조건 및 좌표위를 찾아야하기 떄문
            is_eat = false;
            q.add(new p(shark_x, shark_y, shark_time));
            check[shark_x][shark_y] = true;
            while (!q.isEmpty()) {
                p cur = q.peek(); q.poll();
                if(fish.time != -1 && fish.time < cur.time)
                    break;
                if(mat[cur.x][cur.y] < shark_size && mat[cur.x][cur.y] != 0){
                    is_eat = true;
                   if (fish.x > cur.x || (fish.x == cur.x && fish.y > cur.y)) {
                        fish = cur; // 가장 상위권 좌표를 저장해놓음
                    }
                }
                for(int i=0;i<4;i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if(nx>=N || nx<0 || ny>=N || ny<0) continue;
                    if(check[nx][ny] == false && shark_size >= mat[nx][ny]){
                        check[nx][ny] = true;
                        q.add(new p(nx,ny, cur.time+1));
                    }
                }
            }
            if(is_eat){
                shark_x = fish.x;
                shark_y = fish.y;
                shark_time = fish.time;
                eat++;
                if(eat == shark_size){
                    shark_size++;
                    eat = 0;
                }
                mat[shark_x][shark_y] = 0;
            }
        }
    System.out.println(shark_time);
    }
}
