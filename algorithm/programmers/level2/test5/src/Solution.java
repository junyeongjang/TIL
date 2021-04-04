import java.util.ArrayList;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer;
        int [][]mat = new int[rows][columns];
        int cnt =1;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                mat[i][j] += cnt;
                cnt++;
            }
        }
        for(int k=0;k<queries.length;k++){
            int row = queries[k][0] -1;
            int col = queries[k][1] -1;
            int m = queries[k][2];
            int n = queries[k][3];
            int prev, curr;
            int small=100000;

            prev = mat[row + 1][col];
            for (int i = col; i < n; i++)
            {
                curr = mat[row][i];
                mat[row][i] = prev;
                prev = curr;
            }
            row++;

            for (int i = row; i < m; i++)
            {
                curr = mat[i][n-1];
                mat[i][n-1] = prev;
                prev = curr;
            }
            n--;

            if (row < m)
            {
                for (int i = n-1; i >= col; i--)
                {
                    curr = mat[m-1][i];
                    mat[m-1][i] = prev;
                    prev = curr;
                }
            }
            m--;

            if (col < n)
            {
                for (int i = m-1; i >= row; i--)
                {
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
            }
            col++;

            row = queries[k][0] -1;
            col = queries[k][1] -1;
            m = queries[k][2] -1 ;
            n = queries[k][3] -1;
            for(int i=col;i<n;i++){
                small = Math.min(mat[row][i], small) ;
            }
            for(int i=row;i<m;i++){
                small = Math.min(mat[i][col], small) ;
            }
            for(int i=n;i>=col;i--){
                small = Math.min(mat[m][i], small) ;
            }
            for(int i=m;i>=row;i--){
                small = Math.min(mat[i][n], small) ;
            }
            arr.add(small);
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
        answer = new int[arr.size()];
        for(int i=0;i< answer.length;i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}