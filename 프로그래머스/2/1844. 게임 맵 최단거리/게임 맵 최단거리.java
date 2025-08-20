import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while(!q.isEmpty()) {
            int[] p = q.poll();
            
            if (p[0] == n - 1 && p[1] == m - 1) {
                return p[2];
            }
            
            for (int d = 0; d < 4; d++) {
                int dr = p[0] + deltas[d][0];
                int dc = p[1] + deltas[d][1];
                
                if (dr < 0 || dr >= n || dc < 0 || dc >= m) continue;
                if (visited[dr][dc]) continue;
                if (maps[dr][dc] == 0) continue;
                q.offer(new int[] {dr, dc, p[2] + 1});
                visited[dr][dc] = true;
            }
        }
        
        return answer;
    }
}