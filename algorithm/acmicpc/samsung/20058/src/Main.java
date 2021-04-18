import java.util.*;
import java.io.*;
public class Main {
    static int N,Q,r;
    static int board[][];
    static int L[];
    static int dx[] = {-1,0,+1,0};
    static int dy[] = {0,+1,0,-1};


    static void rotate(int n, int x, int y){
        int temp[][] = new int[n][n];
        for(int i=x; i<n;i++){
            for(int j=y;j<n;j++){
                temp[i][j] = board[n - 1 - j][i];
            }
        }
        for(int i=x; i<n;i++){
            for(int j=y;j<n;j++){
                board[i][j] = temp[i][j];
            }
        }
    }

    static void sol(){
        for(int i=0;i<L.length;i++){
            int n = L[i];
        }

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

        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<r;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        st = new StringTokenizer(br.readLine());
        for(int i=0;i<Q;i++){
            L[i] = Integer.parseInt((st.nextToken()));
        }

/*        for(int i=0;i<r;i++){
            for(int j=0;j<r;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }*/

    }
}
