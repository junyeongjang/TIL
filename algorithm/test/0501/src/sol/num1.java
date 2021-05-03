package sol;

import java.util.*;

class Solution {
    static class info {
        char val;
        int index;

        info(char val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    static Stack<info> st = new Stack<info>();
    static Queue<Integer> ans = new LinkedList<>();
    StringBuffer sb = new StringBuffer();
//'line [({<plus>)}]
//    line [({<plus>})

    public int solution(String inputString) {
        int answer = 0;
        int cnt = 0;
        sb.append(inputString);
        for (int i = 0; i < sb.length(); i++) {
//            ( ), { }, [ ], < >
            if (sb.charAt(i) == '(') {
                st.add(new info(sb.charAt(i), i));
            }
            else if (sb.charAt(i) == ')') {
                if(st.empty()){
                    answer = i * -1;
                    break;
                }
                if(st.peek().val == '(') st.pop();
                else{
                    answer = i * -1;
                    break;
                }
                cnt++;
            }
            else if (sb.charAt(i) == '{') {
                st.add(new info(sb.charAt(i), i));
            }
            else if (sb.charAt(i) == '}') {
                if(st.empty()){
                    answer = i * -1;
                    break;
                }
                if(st.peek().val == '{') st.pop();
                else{
                    answer = i * -1;
                    break;
                }
                cnt++;
            }
            else if (sb.charAt(i) == '[') {
                st.add(new info(sb.charAt(i), i));
            }
            else if (sb.charAt(i) == ']') {
                if(st.empty()){
                    answer = i * -1;
                    break;
                }
                if(st.peek().val == '[') st.pop();
                else{
                    answer = i * -1;
                    break;
                }
                cnt++;
            }
            else if (sb.charAt(i) == '<') {
                st.add(new info(sb.charAt(i), i));
            }
            else if (sb.charAt(i) == '>') {
                if(st.empty()){
                    answer = i * -1;
                    break;
                }
                if(st.peek().val == '<') st.pop();
                else{
                    answer = i * -1;
                    break;
                }
                cnt++;
            }
        }
        if(st.empty() && answer == 0) answer = cnt;
        else if(!st.empty() && answer == 0) answer = (sb.length()-1) * -1;
        return answer;
    }
}