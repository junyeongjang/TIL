import javax.swing.plaf.synth.SynthUI;
import java.awt.*;
import java.util.*;
import java.io.*;
public class Main {
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static int room_cnt, room_max, remove_wall_room;
    static int n,m;
    static wall_dir board[][] = new wall_dir[][];
    static info[] room = new info[51];
    static boolean check[][] = new boolean[51][51];
    static class info{
        int x, y;
        info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class wall_dir{
        int up,down,left,right;
        wall_dir(int l, int u, int r, int d){
            left = l;
            up = u;
            right = r;
            down = d;
        }
    }
    static int bfs(int x, int y){
        int room_size = 0;
        Queue<info> q = new LinkedList<>();
        q.add(new info(x,y));
        while(!q.isEmpty()){
            info cur = q.poll();
            room_size++;

            for(int i=0;i<4;i++){
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if(nx>=n || nx<0 || ny>=m || ny<0)continue;
                if(check[nx][ny]) continue;
                if(i == 0)
                    if(board[nx][ny].up == 1) continue;
                if(i == 1)
                    if(board[nx][ny].left == 1) continue;
                if(i == 2)
                    if(board[nx][ny].down == 1) continue;
                if(i == 3)
                    if(board[nx][ny].right == 1) continue;
                q.add(new info(nx,ny));
                check[nx][ny] = true;
            }
        }
        return room_size;
    }

    static void bit_to_dir(int n, wall_dir wall_dir){
        String temp = "";
        int wall[] = new int[4];
        while(n>0){
            temp += (n  % 2);
            n /= 2;
        }
        while(temp.length() < 4){
            temp+='0';
        }
        for(int i=0;i<4;i++) {
            if(temp.charAt(i) == '1')
               wall[i] = 1;
            else
                wall[i] = 0;
        }
        if(wall[0] == 1) wall_dir.left = 1;
        if(wall[1] == 1) wall_dir.up = 1;
        if(wall[2] == 1) wall_dir.right = 1;
        if(wall[3] == 1) wall_dir.down = 1;
    }
    static void init_check(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                check[i][j] = false;
            }
        }
    }

    static void sol(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(check[i][j] == false){
                    check[i][j] = true;
                    room_cnt++;
                    int temp = bfs(i,j);
                    room_max = Math.max(temp,room_max);
                }
            }
        }
        int room_ans = room_max;
        room_max = 0;
        init_check();
        System.out.println(room_cnt);
        System.out.println(room_ans);
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                wall_dir temp = new wall_dir(board[i][j].left, board[i][j].up ,board[i][j].right, board[i][j].down);
                for (int k = 0; k < 4; k++) {
                    init_check();
                    if (k == 0 && board[i][j].left == 1) board[i][j].left = 0;
                    else if (k == 1 && board[i][j].right == 1) board[i][j].right = 0;
                    else if (k == 2 && board[i][j].up == 1) board[i][j].up = 0;
                    else if (k == 3 && board[i][j].down == 1) board[i][j].down = 0;
                    for (int i1 = 0; i1 < n; i1++) {
                        for (int j1 = 0; j1 < m; j1++) {
                            if (check[i1][j1] == false) {
                                check[i1][j1] = true;
                                int temp2 = bfs(i1,j1);
                                room_max = Math.max(temp2,room_max);
                            }
                        }
                    }

//                    System.out.println(room_max);
                    init_check();
                    board[i][j].right = temp.right;
                    board[i][j].left = temp.left;
                    board[i][j].up = temp.up;
                    board[i][j].down = temp.down;
                }
            }
        }
        System.out.println(room_max);

    }

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int temp = Integer.parseInt(st.nextToken());
                board[i][j] = new wall_dir(0,0,0,0);
                bit_to_dir(temp, board[i][j]);
            }
        }
        sol();
    }
}
