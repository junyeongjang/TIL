import java.util.*;
import java.io.*;
public class Main {
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static int N;
    static int arr[];
    static int board[][];
    static int check[][], check2[][];
    static info student[];
    static int ans;
    static class info{
        int me,n1,n2,n3,n4;
        info(int me, int n1, int n2, int n3, int n4){
            this.me = me;
            this.n1 = n1;
            this.n2 = n2;
            this.n3 = n3;
            this.n4 = n4;
        }
    }
    static void init_check(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                check[i][j] = 0;
                check2[i][j] = 0;
            }
        }
    }
    static void sol(){
        for(int t=0;t<N*N;t++) {
            int flag = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] > 0) continue;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                        if(board[nx][ny] == 0) check[i][j]++;
                        if(board[nx][ny] == student[t].n1
                                || board[nx][ny] == student[t].n2
                                || board[nx][ny] == student[t].n3
                                || board[nx][ny] == student[t].n4){
                            check2[i][j]++;
                            flag = 1;
                        }
                    }
                }
            }
            int target_i = 0;
            int target_j = 0;
            int max = -1;
            if(flag == 0){ //인접한 학생들을 못찾았음
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(board[i][j] > 0) continue;
                        if(check[i][j] > max){
                            max = check[i][j];
                            target_i = i;
                            target_j = j;
                        }
                        else if(check[i][j] == max){
                            if(target_i > i){
                                max = check[i][j];
                                target_i = i;
                                target_j = j;
                            }
                            else if(target_i == i){
                                if(target_j > j){
                                    max = check[i][j];
                                    target_i = i;
                                    target_j = j;
                                }
                            }

                        }
                    }
                }
            }
            else if(flag == 1){
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(board[i][j] > 0) continue;
                        if(check2[i][j] > max){
                            max = check2[i][j];
                            target_i = i;
                            target_j = j;
                        }
                        else if(check2[i][j] == max){
                            if(check[i][j] > check[target_i][target_j]) {
                                max = check2[i][j];
                                target_i = i;
                                target_j = j;
                            }
                            else if(check[i][j] == check[target_i][target_j]) {
                                if (target_i > i) {
                                    max = check2[i][j];
                                    target_i = i;
                                    target_j = j;
                                } else if (target_i == i) {
                                    if (target_j > j) {
                                        max = check2[i][j];
                                        target_i = i;
                                        target_j = j;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            board[target_i][target_j] = student[t].me;
            init_check();
        }
    }
    static void couting_ans(){
        init_check();
        for(int t=0;t<N*N;t++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(student[t].me != board[i][j]) continue;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                        if (board[nx][ny] == student[t].n1 || board[nx][ny] == student[t].n2 || board[nx][ny] == student[t].n3 || board[nx][ny] == student[t].n4) {
                            check2[i][j]++;
                        }
                    }
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(check2[i][j] == 1) ans+=1;
                if(check2[i][j] == 2) ans+=10;
                if(check2[i][j] == 3) ans+=100;
                if(check2[i][j] == 4) ans+=1000;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N*N+1];
        student = new info[N*N+1];
        board = new int[N+1][N+1];
        check = new int[N+1][N+1];
        check2 = new int[N+1][N+1];
        for(int i=0;i<(N*N);i++){
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            int t3 = sc.nextInt();
            int t4 = sc.nextInt();
            int t5 = sc.nextInt();
            student[i] = new info(t1,t2,t3,t4,t5);
        }
        sol();
        couting_ans();
        System.out.println(ans);

    }
}
