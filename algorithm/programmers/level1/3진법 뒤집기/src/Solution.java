class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuffer str = new StringBuffer();
        while(n > 0)
        {
            str.append(n%3);
            n /= 3;
        }
        for(int i=0;i<str.length();i++){
           answer += Math.pow(3, str.length() - i - 1) * (str.charAt(i) - '0' );
        }
        return answer;
    }
}
class Main{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(45));
    }
}