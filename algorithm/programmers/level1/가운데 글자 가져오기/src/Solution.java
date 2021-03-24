import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuffer str = new StringBuffer();
        str.append(s);
        if(str.length() % 2 == 1){
            answer = str.substring(str.length() / 2, str.length()/2 + 1);
        }
        else
            answer = str.substring(str.length() / 2 - 1, str.length()/2 + 1);
        return answer;
    }

    public long solution(int a, int b) {
        long answer = 0;
     if(a>b) {
         int temp;
         temp = a;
         a= b;
         b = temp;
     }

            for (int i = a; i <= b; i++) {
                answer += i;
            }

        return answer;
    }
}