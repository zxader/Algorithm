import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
            else {
                map.put(clothes[i][1], 2);
            }
        }
        
        answer = 1;
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue();
        }
        answer -= 1;
        return answer;
    }
}