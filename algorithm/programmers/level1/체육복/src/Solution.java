class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n + 2];
        arr[0] = -1;
        arr[n + 1] = - 1;
        for (int i= 1; i <= n; i++)
            arr[i] = 1;
        for (int i=0;i<reserve.length;i++)
            arr[reserve[i]] = 2;
        for (int i=0;i<lost.length;i++)
            arr[lost[i]] -= 1;

        for(int i=1;i <= n;i++){
            if (arr[i] == 0){
                if(arr[i-1] == 2){
                    arr[i] = 1;
                    arr[i-1] -= 1;
                }
                else if(arr[i+1] == 2){
                    arr[i] = 1;
                    arr[i+1] -= 1;
                }
            }
        }
        for(int i=1;i<=n;i++)
            if(arr[i] >= 1) answer++;
        return answer;
    }
}
