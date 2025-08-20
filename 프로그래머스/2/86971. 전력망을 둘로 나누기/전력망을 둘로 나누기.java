import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        List<Integer>[] list = new List[n + 1];
        
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n + 1];
            q.offer(1);
            visited[1] = true;
            
            int sum = 0;
            while(!q.isEmpty()) {
                int p = q.poll();
                sum++;
                
                for (int l : list[p]) {
                    if (visited[l]) continue;
                    if (p == wires[i][0] && l == wires[i][1]) continue;
                    if (p == wires[i][1] && l == wires[i][0]) continue;
                    q.offer(l);
                    visited[l] = true;
                }
            }
            
            answer = Math.min(answer, Math.abs(n - 2 * sum));
        }
    
        return answer;
    }
}