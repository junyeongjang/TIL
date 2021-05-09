package kakao;
import java.util.*;
class Solution2 {
    static class info{
        int idx, val;
        info(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    static List<Integer> arr = new LinkedList<>();
    static int compare_arr[];
    static Stack<info> st = new Stack<>();
    static int now_idx;
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        now_idx = k;
        compare_arr= new int[n+1];
        for(int i=0;i<n;i++){
            arr.add(i);
        }
        int len = cmd.length;
        for(int i=0;i<len;i++){
            StringBuffer sb = new StringBuffer();
            sb.append(cmd[i]);
            if(sb.charAt(0) == 'U'){
                String temp = "";
                for(int j = 2; j<sb.length();j++){
                    temp+=sb.charAt(j);
                }
                int move = Integer.parseInt(temp);
                now_idx -= move;
            }
            else if(sb.charAt(0) == 'D'){
                String temp = "";
                for(int j = 2; j<sb.length();j++){
                    temp+=sb.charAt(j);
                }
                int move = Integer.parseInt(temp);
                now_idx += move;
            }
            else if(sb.charAt(0) == 'C'){
                if(arr.size()-1 == now_idx) { //마지막 행인 경우
                    st.push(new info(now_idx, arr.get(now_idx)));
                    arr.remove(now_idx);
                    now_idx--;
                }
                else {
                    st.push(new info(now_idx, arr.get(now_idx)));
                    arr.remove(now_idx);
                }
            }
            else if(sb.charAt(0) == 'Z'){
                if(st.peek().idx <= now_idx) now_idx++;
                arr.add(st.peek().idx, st.peek().val);
                st.pop();
            }
        }

        for(int i=0;i<arr.size();i++){
            compare_arr[arr.get(i)] = 1;
        }
        for(int i=0;i<n;i++){
            if(compare_arr[i] == 1) answer+='O';
            else answer+='X';
        }

        return answer;
    }
}
