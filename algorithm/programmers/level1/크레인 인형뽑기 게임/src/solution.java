import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();

        for (int i=0;i<moves.length;i++){
            int now = moves[i] - 1;
            for(int j=0;j< board.length;j++){
                if (board[j][now] > 0){
                    if(!st.empty()) {
                        if(st.peek() == board[j][now]) {
                            st.pop();
                            answer++;
                        }
                        else
                            st.push(board[j][now]);
                    }
                    else
                        st.push(board[j][now]);
                    board[j][now] = 0;
                    break;
                }
            }

        }
        return answer * 2;
    }
}