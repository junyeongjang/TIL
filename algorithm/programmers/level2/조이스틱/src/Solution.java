class Solution {
    public int solution(String name) {
        int answer = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        char []alpha1 = {'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M','N'};
        char []alpha2 = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O','1'};
        for(int i=0;i<alpha1.length;i++){
            if(name.charAt(0) == 'A') break;
            if(alpha1[i] == name.charAt(0))
                cnt1 = i + 1 ;
            if(alpha2[i] == name.charAt(0))
                cnt1 = i + 1;
        }
        answer += cnt1;
        for(int i = name.length() - 1; i>0 ;i--){
            if(name.charAt(i) == 'A'){
                cnt2++;
                continue;
            }
            answer += cnt2;
            cnt2 = 0;
            for(int j=0;j<alpha1.length;j++){
                if(alpha1[j] == name.charAt(i)){
                    cnt1 = j + 1;
                }
                if(alpha2[j] == name.charAt(i)){
                    cnt1 = j + 1;
                }
            }

            answer += cnt1;
            System.out.println(answer);
        }
        return answer;
    }
}