import java.util.ArrayList;

class Solution {
    public int solution(int[][] needs, int r) {
        int answer = 0;
        int[][] new_arr = new int[needs.length][needs[0].length];

        for (int i = 0; i < new_arr.length; i++) {
            for (int j = 0; j < new_arr[0].length; j++) {
                new_arr[i][j] = -1;
            }
        }

        for (int i = 0; i < needs.length; i++) {
            int k = 0;
            for (int j = 0; j < needs[0].length; j++) {
                if (needs[i][j] == 1) {
                    new_arr[i][k++] = j;
                }
            }
        }
        int len = new_arr.length;
        while(len > 0) {
            int cnt = 0;
            int[][] temp = new int[new_arr.length][new_arr[0].length];
            for (int i = 0; i < new_arr.length; i++) {
                for (int j = 0; j < new_arr[0].length; j++) {
                    temp[i][j] = new_arr[i][j];
                }
            }
                for (int i = 0; i < new_arr.length; i++) {
                    for(int k=0; k<new_arr[0].length;k++){
                        for (int j = 0; j < new_arr[0].length; j++) {
                            if (new_arr[len - 1][k] == temp[i][j]) {
                                temp[i][j] = -2;
                        }
                    }
                }
            }
            for (int i = 0; i < new_arr.length; i++) {
                int flag = 0;
                for (int j = 0; j < new_arr[0].length; j++) {
                    if(temp[i][j]>=0) flag = 1
                }
                if(flag == 0) cnt++;
            }
            if(cnt>answer) answer = cnt;
            len--;
        }
        return answer;
    }
}
class Main{
    public static void main(String[] args) {
        Solution s = new Solution();

    }
}