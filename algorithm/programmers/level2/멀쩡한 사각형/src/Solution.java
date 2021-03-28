import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuffer arr = new StringBuffer();
        int[] num = {4,1,2};
        while(n > 0){
            arr.append(num[n % 3]);
            if (n % 3 == 0) n = n / 3 - 1;
            else n = n / 3;
        }
        answer = arr.reverse().toString();
        return answer;
    }
}
class Main{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6));
    }
}