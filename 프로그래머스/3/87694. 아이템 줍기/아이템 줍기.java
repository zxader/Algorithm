import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[104][104];
        
        for (int i = 0; i < rectangle.length; i++) {
            int startX = rectangle[i][0] * 2;
            int startY = rectangle[i][1] * 2;
            int endX = rectangle[i][2] * 2;
            int endY = rectangle[i][3] * 2;
            for (int j = startY; j <= endY; j++) {
                for (int k = startX; k <= endX; k++) {
                    map[j][k] = 1;
                }
            }
        }
        
        for (int i = 0; i < rectangle.length; i++) {
            int startX = rectangle[i][0] * 2;
            int startY = rectangle[i][1] * 2;
            int endX = rectangle[i][2] * 2;
            int endY = rectangle[i][3] * 2;
            for (int j = startY + 1; j <= endY - 1; j++) {
                for (int k = startX + 1; k <= endX - 1; k++) {
                    map[j][k] = 0;
                }
            }
        }
        

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[104][104];
        q.offer(new int[] {characterY * 2, characterX * 2, 0});
        visited[characterY * 2][characterX * 2] = true;
        
        int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
            int[] p = q.poll();
            
            if (p[0] == itemY * 2 && p[1] == itemX * 2){
                return p[2] / 2;
            }
            
            for (int d = 0; d < 4; d++) {
                int dy = p[0] + deltas[d][0];
                int dx = p[1] + deltas[d][1];
                if (visited[dy][dx]) continue;
                if (map[dy][dx] == 0) continue;
                q.offer(new int[] {dy, dx, p[2] + 1});
                visited[dy][dx] = true;
            }
        }
        
        return answer;
    }
}