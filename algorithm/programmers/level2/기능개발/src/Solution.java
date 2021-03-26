import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0;i<progresses.length;i++)
            q1.add(progresses[i]);
        for(int i=0;i<speeds.length;i++)
            q2.add(speeds[i]);
        int day = 1;
        while(!q1.isEmpty()){
            int cnt = 0;
            while(q1.peek() + (q2.peek() * day) < 100)
                day++;
            while (!q1.isEmpty() && q1.peek() + (q2.peek() * day) >= 100){
                q1.remove();
                q2.remove();
                cnt++;
            }
            if(cnt>0) arr.add(cnt);
        }
        answer = new int[arr.size()];
        for(int i=0;i<arr.size();i++)
            answer[i] = arr.get(i);
        return answer;
    }
}