package kakao;
import java.util.*;
class Solution1 {
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static int sol(String[] temp){
        int board[][] = new int[6][6];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(temp[i].charAt(j) == 'P'){ //man
                    board[i][j] = 2;
                }
                if(temp[i].charAt(j) == 'O'){ //table
                    board[i][j] = 1;
                }
                if(temp[i].charAt(j) == 'X'){ //partion
                    board[i][j] = 0;
                }
            }
        }
        int flag = 0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(board[i][j] == 2){
                    for(int k=0;k<4;k++){
                        int nx = dx[k] + i;
                        int ny = dy[k] + j;
                        if(nx>=5 || nx<0 || ny>=5 || ny<0) continue;
                        if(board[nx][ny] == 2) flag = 1; //사람을 만나
                        if(board[nx][ny] == 1){ //테이블이면
                            for(int m=0;m<4;m++){
                                int mx = dx[m] + nx;
                                int my = dy[m] + ny;
                                if(mx == i && my==j) continue;
                                if(mx>=5 || mx<0 || my>=5 || my<0) continue;
                                if(board[mx][my] == 2) flag = 1;
                            }
                        }
                    }
                }
            }
        }
        if(flag == 1) return 0;
        else return 1;



//        for(int i=0;i<5;i++){
//            for(int j=0;j<5;j++){
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0;i<places.length;i++){
            answer[i] = sol(places[i]);
        }

        return answer;
    }
}