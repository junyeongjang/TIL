import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] answer = {};
        int[] man1 = {1, 2, 3, 4, 5};
        int[] man2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] man3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = {0,0,0};
        int winner;
        int len = answers.length;

        for(int i=0;i<len;i++) {
            if (answers[i] == man1[i % man1.length]) cnt[0]++;
            if (answers[i] == man2[i % man2.length]) cnt[1]++;
            if (answers[i] == man3[i % man3.length]) cnt[2]++;
        }
        winner = Math.max(Math.max(cnt[0], cnt[1]), cnt[2]);
        for(int i=0;i<3;i++){
            if(winner == cnt[i])
                arr.add(i+1);
        }
        answer = new int[arr.size()];
        for(int i=0;i<arr.size();i++)
            answer[i] = arr.get(i);
        return answer;
    }
}