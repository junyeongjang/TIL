import java.util.*;
class Solution {
    int check(ArrayList<Integer> arr){
        for(int i=0;i<arr.size();i++){
            for(int j=i+1;j<arr.size();j++)
                if(arr.get(i) > arr.get(j)) return 0;
        }
        return 1;
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i< skill_trees.length;i++){
            for(int j=0;j<skill.length();j++){
                if(skill_trees[i].indexOf(skill.charAt(j))>=0){
                    arr.add(skill_trees[i].indexOf(skill.charAt(j)));
                }
                else
                    arr.add(skill_trees[i].length());

            }
            if(check(arr) == 1)
                answer++;
            while(!arr.isEmpty()) arr.remove(0);
        }
        return answer;
    }
}