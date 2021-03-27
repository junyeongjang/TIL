import javax.sound.sampled.Port;
import java.util.*;
class Point{
    int index;
    int value;
    Point(int index, int value){
        this.index = index;
        this.value = value;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int cnt = 0;
        int flag;
        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0;i<priorities.length;i++)
            arr.add(new Point(i, priorities[i]));
        while(true){
            flag  = 0;
            for(int i=1;i<arr.size();i++){
                if(arr.get(0).value < arr.get(i).value){
                    arr.add(new Point(arr.get(0).index, arr.get(0).value));
                    arr.remove(0);
                    flag = 1;
                    break;
                }
            }
            if(flag == 0 && location == arr.get(0).index)
                return answer + 1;
            else if(flag == 0){
                arr.remove(0);
                answer++;
            }
        }
    }
}