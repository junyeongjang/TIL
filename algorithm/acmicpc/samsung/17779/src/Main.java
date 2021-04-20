import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int ans = Integer.MAX_VALUE;
    static int board[][], check[][];
    static void draw_line(int x, int y, int d1, int d2){
        //line 1
        for(int i=0;i<=d1;i++){
            int dx = x + i; int dy = y - i;
            check[dx][dy] = 5;
        }
        //line 2
        for(int i=0;i<=d2;i++){
            int dx = x + i; int dy = y + i;
            check[dx][dy] = 5;
        }
        //line 3
        for(int i=0;i<=d2;i++){
            int dx = (x + d1) + i; int dy = (y - d1) + i;
            check[dx][dy] = 5;
        }

        //line 4
        for(int i=0;i<=d1;i++){
            int dx = (x + d2) + i; int dy = (y + d2) - i;
            check[dx][dy] = 5;
        }

    }
    static void draw_area(int x, int y, int d1, int d2){
       //area1
        for(int i=0;i<x+d1;i++){
            for(int j=0;j<=y;j++){
                if(check[i][j] != 0) break;
                check[i][j] = 1;
            }
        }
        //area2
        for(int i=0;i<=x+d2;i++){
            for(int j=N-1;j>y;j--){
                if(check[i][j] != 0) break;
                check[i][j] = 2;
            }
        }

        //area3
        for(int i=x+d1;i<=N - 1;i++){
            for(int j=0;j<(y-d1+d2);j++){
                if(check[i][j] != 0) break;
                check[i][j] = 3;
            }
        }

        //area3
        for(int i=x+d2+1;i<=N - 1;i++){
            for(int j=N-1;j>=y-d1+d2;j--){
                if(check[i][j] != 0) break;
                check[i][j] = 4;
            }
        }

        for(int i=0;i<N;i++){
           for(int j=0;j<N;j++){
               if(check[i][j] == 0) check[i][j] = 5;
           }
        }
    }
    static void cal_area(){
        int cnt = 0;
        int area[] = new int[5];
        for(int i=0;i<5;i++)
            area[i] = 0;
        for(int k=0; k<5;k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(check[i][j] == k + 1) area[k] += board[i][j];
                }
            }
        }
        Arrays.sort(area);
        cnt = area[4] - area[0];
        ans = Math.min(cnt, ans);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                check[i][j] = 0;
            }
        }
    }


    static int check_num(int x, int y, int d1, int d2){
        if (d1 >= 1 && d2 >= 1)
            if (1 <= x && x < x + d1 + d2 && x + d1 + d2 <= N)
                if (1 <= y - d1 && y - d1 < y && y < y + d2 && y + d2 <= N)
                    return 1;
        return 0;
    }
    static void sol(){
        for(int i1=1;i1<=N;i1++) {
            for(int i2=1;i2<=N;i2++){
                for(int i3=1;i3<=N;i3++){
                    for(int i4=1;i4<=N;i4++){
                        if(check_num(i1,i2,i3,i4) == 1){
                            draw_line(i1 - 1,i2 - 1,i3, i4);
                            draw_area(i1 - 1, i2 - 1, i3, i4);
                            cal_area();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        check = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        System.out.println(ans);
    }
}
