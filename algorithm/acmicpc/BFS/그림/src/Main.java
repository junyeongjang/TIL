import java.nio.channels.Pipe;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static int matrix[][] = new int[501][501];
    static boolean check[][] = new boolean[501][501];
    static int n, m;
    static int cnt = 0;
    static Queue<Point> q = new LinkedList<>();
    static void BFS(Point p){
        int temp = 0;
        q.add(p);
        check[p.x][p.y] = true;
        while(!q.isEmpty()){
            temp++;
            int x = q.peek().x;
            int y = q.peek().y;
            q.remove();
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= n || nx < 0 || ny >= m || ny < 0) continue;
                if(check[nx][ny] == true || matrix[nx][ny] == 0) continue;
                q.add(new Point(nx,ny));
                check[nx][ny] = true;
            }
            cnt = Math.max(cnt, temp);
        }
    }

    public static void main(String[] args) {
        int ans = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(check[i][j] == true || matrix[i][j] == 0) continue;
                BFS(new Point(i,j));
                ans++;
            }
        }
        System.out.println(ans);
        System.out.println(cnt);
    }
}
