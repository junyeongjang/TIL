import java.util.*;
class Solution {
    int check_weight(ArrayList<Integer>arr){
        int sum = 0;
        for(int i=0;i<arr.size();i++)
            sum+=arr.get(i);
        return sum;
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> truck = new ArrayList<>();
        for(int i=0;i<truck_weights.length;i++)
            truck.add(truck_weights[i]);
        truck.add(0);
        int answer = 0;
        int k = 0;
        while(true){
            if(check_weight(arr) + truck.get(k) <= weight){
                arr.add(truck.get(k));
                if(k < truck_weights.length) k++;
                if(check_weight(arr) == 0) break;
            }
            else
                arr.add(0);
            if(arr.size() == bridge_length)
                arr.remove(0);
            answer++;
        }
        return answer + 1;
    }
}