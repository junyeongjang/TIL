import java.io.*;
import java.util.*;

public class Main {

    static class info{
        int x,y,v;
        info(int x, int y, int v){
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
    static int N;
    static int num[];
    static int matrix[][], board[][];
    static int arr[] = new int[10];
    static boolean check[] = new boolean[10];
    static int ans = Integer.MAX_VALUE;

    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static void dfs(int N, int M, int depth ,int index){
        if(depth == M){
            int cnt1 = 0;
            int cnt2 = 0;
            int area1 = 0;
            int area2 = 0;
            for(int i=0;i<M;i++){
                board[arr[i] - 1][arr[i] - 1] = 1;
//                System.out.print(arr[i] + " ");
                cnt1++;
            }
            for(int i=0;i<N;i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println();
            for(int i=1;i<=N;i++){
                if(check[i] == false){
//                    System.out.print(i + " ");
                    board[i-1][i-1] = 2;
                    cnt2++;
                }
            }
//            System.out.println();
            if(bfs(1, cnt1) == 1 && bfs(2, cnt2) == 1){
                for(int i=0;i<M;i++){
                    if(check[i] == true) area1+=num[i];
                    else if(check[i] == false) area2+=num[i];
                }
                ans =  Math.min(Math.abs(area1 - area2), ans);
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    board[i][j] = 0;
                }
            }
        }
        else{
            for(int i=index;i<=N;i++){
                if(check[i]) continue;
                check[i] = true;
                arr[depth] = i;
                dfs(N,M, depth + 1, i + 1);
                check[i] = false;
            }
        }
    }

    static int bfs(int color, int size){
        Queue<info> q = new LinkedList<>();
        boolean visited[][] = new boolean[10][10];
        int temp = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j] == color){
                    q.add(new info(i,j,0));
                    i = N;
                    break;
                }
            }
        }

        while(!q.isEmpty()){
            info cur = q.poll();
            temp++;
            for(int i=0;i<4;i++){
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if(nx>=N || nx<0 || ny>=N || ny<0) continue;
                if(visited[nx][ny] || board[nx][ny] != color || matrix[nx][ny] == 0) continue;
                q.add(new info(nx,ny,0));
                visited[nx][ny] = true;
            }
        }
        if(temp == size) return 1;
        else return 0;
    }
    static void sol(){
        for(int i=1;i<N;i++){
            dfs(N, i, 0 ,1);
        }
        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        num = new int[N];
        matrix = new int[N][N];
        board = new int[N][N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            num[i] = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            for(int j=0;j<num1;j++){
                int temp = Integer.parseInt(st.nextToken());
                matrix[i][temp - 1] = 1;
            }
        }

        sol();
//        dfs(5,2,0,1);
    }
}
