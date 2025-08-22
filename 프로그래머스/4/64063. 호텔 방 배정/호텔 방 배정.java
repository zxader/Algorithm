import java.util.*;

class Solution {
    static Map<Long, Long> map;
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        map = new HashMap<>();
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = find(room_number[i]);
        }
        
        return answer;
    }
    
    static long find(long n) {
        if (!map.containsKey(n)) {
            map.put(n, n + 1);
            return n;
        }
        long v = find(map.get(n));
        map.put(n, v);
        
        return v;
    }
}