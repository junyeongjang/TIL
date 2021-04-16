import java.util.*;
import java.io.*;
public class Main {
    static int dx[] = {-1, -1, +0, +1, +1, +1, +0, -1};
    static int dy[] = {+0, +1, +1, +1, +0, -1, -1, -1};
    static int new_dir[] = {0,2,4,6};
    static int new_dir2[] = {1,3,5,7};
    static int N,M,K;
    static int mat[][];
    static int ans;
    static ArrayList<info> ball = new ArrayList<>();
    static class info{
        int x,y,m,s,d;
        info(int x, int y, int m, int s, int d){
            this.x = x; this.y = y; this.m = m; this.s = s; this.d = d;
        }
    }
    static void moveFireball(){
        for(int i=0;i<ball.size();i++){
            int d = ball.get(i).d;
            int speed = ball.get(i).s % N;
            int nx = (ball.get(i).x + (dx[d] * speed) + N) % N;
            int ny = (ball.get(i).y + (dy[d] * speed) + N) % N;
            nx = (nx + N) % N;
            ny = (ny + N) % N;
            mat[ball.get(i).x][ball.get(i).y]--;
            mat[nx][ny]++;
            ball.get(i).x = nx;
            ball.get(i).y = ny;
        }
    }
    static void addFireball(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(mat[i][j]>=2){
                    mat[i][j] = 0;
                    int cnt = 0;
                    int odd = 0; //짝수
                    int even = 0; // 홀수
                    int sm = 0;
                    int ss = 0;
                    int sd = 0;
                    for(int k=0;k<ball.size();k++){
                      if(!(ball.get(k).x == i && ball.get(k).y == j)) continue;
                      sm+=ball.get(k).m;
                      ss+=ball.get(k).s;
                      if(ball.get(k).d % 2 == 0) even++;
                      else odd++;
                      ball.remove(k);
                      k--;
                      cnt++;
                    }
                    for(int k=0;k<4;k++){
                        int flag = 1;
                        if((sm / 5) <= 0) continue;
                        if(odd == cnt || even == cnt) flag = 0;
                        if(flag == 0) ball.add(new info(i,j,sm/5,ss/cnt, new_dir[k]));
                        else if(flag == 1 )ball.add(new info(i,j,sm/5,ss/cnt, new_dir2[k]));
                        mat[i][j] = 4;
                    }
                }
            }
        }
    }
    static void sol(){
      for(int i=0;i<K;i++) {
          moveFireball();
          addFireball();
      }
      for(int i=0;i<ball.size();i++){
          ans+=ball.get(i).m;
      }
      System.out.println(ans);
    }

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        mat = new int[N][N];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            ball.add(new info(x-1, y-1, m, s, d));
            mat[x-1][y-1] = 1;
        }
        sol();
    }
}
