import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        Integer arr[] = new Integer[numbers.length];
        for(int i=0;i<numbers.length;i++){
            arr[i] = numbers[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        String answer = "";
        for(int i=0;i< numbers.length;i++){
            answer += numbers[i] + '0';
        }
        return answer;
    }
}