import java.util.*;
import java.io.*;
public class Main {
    static int N,Q,r,ans,sum;
    static int board[][];
    static int check[][];
    static int L[];
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,+1,0,-1};
    static Queue<info> q = new LinkedList<>();
    static class info{
        int x,y;
        info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void rotate(int n, int x, int y) {
        int temp[][] = new int[r][r];
        for (int i = x; i < n + x; i++) {
            for (int j = y; j < n + y; j++) {
                temp[i][j] = board[x + y + n - 1 - j][y - x + i];
            }
        }
        for (int i = x; i < n + x; i++) {
            for (int j = y; j < n + y; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }
    static void melt(){
        ArrayList<info> arr = new ArrayList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<r;j++){
                if(board[i][j] <= 0) continue;
                int cnt = 0;
                for(int k=0;k<4;k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx>=r || nx<0 || ny>=r || ny<0) continue;
                    if(board[nx][ny] <= 0) continue;
                    cnt++;
                }
                if(cnt < 3){
                    arr.add(new info(i,j));
                }
            }
        }
        for(int i=0;i<arr.size();i++){
            board[arr.get(i).x][arr.get(i).y]--;
            sum--;
        }

    }
    static void bfs(){
        int temp = 0;
        while(!q.isEmpty()){
            info cur = q.peek(); q.poll();
            temp++;
            for(int i=0;i<4;i++){
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if(nx>=r || nx<0 || ny>=r || ny<0) continue;
                if(check[nx][ny] > 0 || board[nx][ny] <= 0) continue;
                q.add(new info(nx,ny));
                check[nx][ny] = 1;
            }
        }
        ans = Math.max(ans,temp);
    }

    static void sol(){
        for(int i=0;i<L.length;i++){
            int n = (int)Math.pow(2,L[i]);
            for(int j=0;j<r;j+=n) {
                for(int k=0;k<r;k+=n) {
                    int temp_j = j;
                    int temp_k = k;
                    int temp = n;
                    while(temp/2 > 0) {
                        rotate(temp, temp_j++, temp_k++);
                        temp/=2;
                    }
                }
            }
            melt();
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<r;j++){
                if(check[i][j] == 0) {
                    check[i][j] = 1;
                    q.add(new info(i, j));
                    bfs();
                    while(!q.isEmpty()) q.poll();
                 }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<r;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(sum);
        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        r = (int)Math.pow(2,N);
        System.out.println(r);
        L = new int[Q];
        board = new int[r][r];
        check = new int[r][r];
        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<r;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                sum+=board[i][j];
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<Q;i++){
            L[i] = Integer.parseInt((st.nextToken()));
        }
        sol();
    }
}
