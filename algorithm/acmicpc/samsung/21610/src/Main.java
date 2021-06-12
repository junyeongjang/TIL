import java.util.*;

//방향은 총 8개의 방향이 있으며, 8개의 정수로 표현한다. 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
public class Main {

    static class info{
        int x;
        int y;
    }
    static class dir {
        int d,s;
        dir(int d, int s) {
            this.d = d;
            this.s = s;
        }
    }

    static int N,M;
    static int board[][], check[][], cloud[][], cloud2[][];
    static dir dir_arr[];
    //direct
    static int dx[] = {0,-1,-1,-1,0,+1,+1,+1};
    static int dy[] = {-1,-1,0,1,1,1,0,-1};


    static int dx2[] ={-1, +1, -1, +1};
    static int dy2[] = {-1,-1,+1,+1};

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N+1][N+1];
        cloud = new int[N+1][N+1];
        check = new int[N+1][N+1];
        cloud2 = new int[N+1][N+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                board[i][j] = sc.nextInt();
            }
        }
        dir_arr = new dir[M+1];
        for(int i=0;i<M;i++){
            int tmp1 = sc.nextInt();
            int tmp2 = sc.nextInt();
            dir_arr[i] = new dir(tmp1, tmp2);
        }
        //input finish

        System.out.println(sol());
    }
    static int sol(){
        // 비구름 위치 (N, 1), (N, 2), (N-1, 1), (N-1, 2)
        int ans = 0;
        //cloud initial setting
        cloud[N-1][0] = 1;
        cloud[N-1][1] = 1;
        cloud[N-2][0] = 1;
        cloud[N-2][1] = 1;
        int cloud_index = 0;
        while(M--> 0){
            //cloud move
            int dir = dir_arr[cloud_index].d;
            int cnt = dir_arr[cloud_index].s;
            cloud_index++;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(cloud[i][j] == 1) {

                        int nx = (i + dx[dir-1] * cnt) % N;
                        int ny = (j + dy[dir-1] * cnt) % N;
                        if(nx < 0 || ny < 0){ //neg
                            if(nx < 0) nx += N;
                            if(ny < 0) ny += N;
                        }
                        if(nx >= N || ny>=N ){ //pos
                            if(nx>=N) nx -=N;
                            if(ny>=N) ny -=N;
                        }
                        cloud2[nx][ny] = 1;
                        cloud[i][j] = 0;
                    }
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(cloud2[i][j] == 1) cloud[i][j] = 1;
                }
            }

            // cloud disappear
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(cloud[i][j] == 1){
                        board[i][j]++;
                        check[i][j]++;
                        cloud[i][j]=0;
                    }
                }
            }

            //copy water
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(check[i][j] == 1){
                        for(int k=0;k<4;k++){
                            int nx = dx2[k] + i;
                            int ny = dy2[k] + j;
                            if(nx>= N || ny>=N || nx<0 || ny<0 )continue;
                            if(board[nx][ny] <= 0) continue;
                            board[i][j]++;
                        }
                    }
                }
            }

            //create cloud
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(board[i][j] >= 2 && check[i][j] == 0){
                        cloud[i][j] = 1;
                        board[i][j] -=2;
                    }
                }
            }

            //init check
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    check[i][j] = 0;
                    cloud2[i][j] = 0;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                ans+=board[i][j];
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                check[i][j] = 0;
                cloud2[i][j] = 0;
            }
        }
        return ans;
    }
}
