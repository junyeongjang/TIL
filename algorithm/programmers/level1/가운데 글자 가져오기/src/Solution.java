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
}