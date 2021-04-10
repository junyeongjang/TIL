import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static char mat[][] = new char[1001][1001];
    static int check[][] = new int[1001][1001];
    static int fired[][] = new int[1001][1001];
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static int r,c;
    static Queue<p> q = new LinkedList<>();
    static class p{
        int x,y;
        p(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void BFS(){
        fired[q.peek().x][q.peek().y] = 1;
        while(!q.isEmpty()){
            int x = q.peek().x; int y= q.peek().y; q.remove();
            for(int k=0;k<4;k++){
                int nx = dx[k] + x;
                int ny = dy[k] + y;
                if(nx>=r || nx<0 || ny>=c || ny<0) continue;
                if(fired[nx][ny] > 0 || mat[nx][ny] == '#') continue;
                fired[nx][ny] = fired[x][y] + 1;
                q.add(new p(nx,ny));
            }
        }
    }

    static int BFS2(int x1, int y1){
        q.add(new p(x1,y1));
        check[x1][y1] = 1;
        while(!q.isEmpty()){
            int x = q.peek().x; int y= q.peek().y; q.remove();
            for(int k=0;k<4;k++){
                int nx = dx[k] + x;
                int ny = dy[k] + y;
                if(nx>=r || nx<0 || ny>=c || ny<0) return check[x][y];
                if(check[nx][ny] > 0 || mat[nx][ny] == '#') continue;
                if(fired[nx][ny] != 0 && fired[nx][ny] <= check[x][y]+1) continue;;
                check[nx][ny] = check[x][y] + 1;
                q.add(new p(nx,ny));
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        for(int i=0;i<r;i++){ // 입력
            input = br.readLine().split("");
            for(int j=0;j<c;j++){
                mat[i][j] = input[j].charAt(0);
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j] == 'F'){
                    q.add(new p(i,j));
                }
            }
        }
        BFS();
        while(!q.isEmpty()) q.remove();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j] == 'J') {
                    int temp = BFS2(i,j);
                    if(temp == 0) System.out.println("IMPOSSIBLE");
                    else System.out.println(temp);
                    break;
                }
            }
        }
    }
}
