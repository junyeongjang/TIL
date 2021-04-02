class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int[][] arr = new int[n][n];
        int x = 0;
        int y = 0;
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i % 3 == 0) //아래
                    ++x;
                else if(i % 3 ==1) { //오른쪽
                    y++;
                }
                else if(i % 3 ==2){ //대각선
                    x--;
                    y--;
                }
                arr[x][y] = ++cnt;
            }
        }
        answer = new int[cnt];
        int k = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0) break;
                answer[k++] = arr[i][j];
            }
        }
        return answer;
    }
}