import java.util.*;
import java.io.*;
public class Main {
    static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1 };
    static int dy[] = {0, -1, -1, -1, 0, 1, 1, 1};
    static int ans;
    static class info{
        int x,y,dir;
        info(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    static void dfs(info Fish[], int mat[][], int shark_x, int shark_y ,int sum){
        //copy
        info temp_Fish[] = new info[16];
        int temp_mat[][] = new int[4][4];
        for(int i=0;i<16;i++){
            temp_Fish[i] = new info(Fish[i].x, Fish[i].y, Fish[i].dir); // warring
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                temp_mat[i][j] = mat[i][j];
            }
        }
        //eat
        int fish_number = temp_mat[shark_x][shark_y];
        int shark_dir = temp_Fish[fish_number].dir;
        temp_Fish[fish_number].x = -1;
        temp_Fish[fish_number].y = -1;
        temp_Fish[fish_number].dir = -1;
        temp_mat[shark_x][shark_y] = -1;

        sum += (fish_number + 1);
        if(sum > ans)
            ans = sum;

        //fish move
        for(int i=0;i<16;i++){
            if(temp_Fish[i].x == -1) continue;
                int x = temp_Fish[i].x;
                int y = temp_Fish[i].y;
                int d = temp_Fish[i].dir;
                int nx = x + dx[d];
                int ny = y + dy[d];
                int nd = d;
                 while (ny < 0 || ny >= 4 || nx < 0 || nx >= 4 || (ny == shark_y && nx == shark_x)) {
                    nd = (nd + 1) % 8;
                    ny = y + dy[nd];
                    nx = x + dx[nd];
                 }

                if (temp_mat[nx][ny] != -1){  //swap 해야함
                    int target = temp_mat[nx][ny];
                    temp_Fish[target].x = x;
                    temp_Fish[target].y = y;

                    temp_Fish[i].x = nx;
                    temp_Fish[i].y  = ny;
                    temp_Fish[i].dir = nd;

                    temp_mat[x][y] = target;
                    temp_mat[nx][ny] = i;
                }
                else{
                    temp_Fish[i].x = nx;
                    temp_Fish[i].y  = ny;
                    temp_Fish[i].dir = nd;

                    temp_mat[x][y] = -1;
                    temp_mat[nx][ny] = i;
                }

            }

        for(int i=1;i<4;i++){
            int x = shark_x + dx[shark_dir]  * i;
            int y = shark_y + dy[shark_dir]  * i;
            if(x>=4 || x< 0 || y>=4 || y<0) break;
            if(temp_mat[x][y] != -1){
                dfs(temp_Fish, temp_mat, x, y, sum);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        info Fish[] = new info[16];
        int mat[][] = new int[4][4];
        int sum = 0;
        for(int i=0;i<4;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                int a = Integer.parseInt(st.nextToken());  //val
                int b = Integer.parseInt(st.nextToken());  //dir
                Fish[a - 1] = new info(i, j, b - 1);
                mat[i][j] = a - 1;
            }
        }
        dfs(Fish, mat, 0,0,0);
        System.out.println(ans);
    }
}
