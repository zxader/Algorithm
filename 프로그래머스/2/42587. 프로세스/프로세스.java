import java.util.*;

class Solution {
    static class Process {
        int idx, v;
        Process(int idx, int v){
            this.idx = idx;
            this.v = v;
        }
    }
    public int solution(int[] priorities, int location) {
        PriorityQueue<Process> pq = new PriorityQueue<>((a, b) -> {
            return b.v - a.v;
        });
        
        Queue<Process> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            Process p = new Process(i, priorities[i]);
            pq.offer(p);
            q.offer(p);
        }
        
        int answer = 1;
        while (!q.isEmpty()) {
            Process p = q.poll();
            
            if (pq.peek().v == p.v) {
                pq.poll();
                
                if(p.idx == location) return answer;
                
                answer++;
            }
            else {
                
                q.offer(p);
                continue;
            }
            

        }
        return answer;
    }
}