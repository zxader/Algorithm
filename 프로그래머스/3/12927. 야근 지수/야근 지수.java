import java.util.*;

class Solution {
    public long solution(int n, int[] works) { 
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < works.length; i++) {
            q.offer(works[i]);
        }

        for (int i = n; i > 0; i--) {
            if (q.isEmpty()) break;
            int p = q.poll() - 1;
            if (p == 0) continue;
            q.offer(p);
        }
        
        long answer = 0;
        while (!q.isEmpty()) {
            int p = q.poll();
            answer += p * p;
        }
        

        return answer;
    }
}