import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            q.offer(scoville[i]);
        }
        
        while (!q.isEmpty() && q.peek() < K) {
            int p = q.poll();
            
            if (q.isEmpty()) return -1;
            
            int p2 = q.poll();
            int v = p + p2*2;
            
            q.offer(v);
            answer++;
        }
        
        return answer;
    }
}