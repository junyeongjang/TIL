import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hash_map = new HashMap<>();
        for (String str : participant)
            hash_map.put(str, hash_map.getOrDefault(str, 0) + 1);
        for (String str : completion)
            hash_map.put(str, hash_map.get(str) - 1);

        for (String key : hash_map.keySet()) {
            if (hash_map.get(key) != 0)
                answer = key;
        }
        return answer;
    }
}