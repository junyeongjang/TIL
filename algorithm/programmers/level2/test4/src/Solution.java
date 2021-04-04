class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int []arr = {6,6,5,4,3,2,1};
        int cnt=0;
        int res=0;
        for(int i=0;i<lottos.length;i++){
            for(int j=0;j< win_nums.length;j++){
                if(lottos[i] == win_nums[j]) cnt++;
            }
        }
        for(int i=0;i<lottos.length;i++){
          if(lottos[i] == 0) res++;
        }

        int[] answer = {arr[cnt+res], arr[cnt]};
        return answer;
    }
}