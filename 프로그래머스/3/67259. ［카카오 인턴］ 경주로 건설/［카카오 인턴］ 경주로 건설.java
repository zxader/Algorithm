import java.util.*;

class Solution {
    static class Node {
        int r, c, s, l, d;
        Node(int r, int c, int s, int l, int d) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.l = l;
            this.d = d;
        }
    }
    
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int solution(int[][] board) {
        int n = board.length;
        Queue<Node> q = new ArrayDeque<>();
        int[][] visited = new int[n][n];
        q.offer(new Node(n - 1, n - 1, 0, 0, -1));
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        visited[n - 1][n - 1] = 0;
        
        while(!q.isEmpty()) {
            Node p = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int dr = p.r + deltas[d][0];
                int dc = p.c + deltas[d][1];
                
                if (0 > dr || dr >= n) continue;
                if (0 > dc || dc >= n) continue;
                if (board[dr][dc] == 1) continue;
                int temp = p.l;
                if (p.d != -1 && ((p.d % 2 == 0 && d % 2 != 0) ||(p.d % 2 != 0 && d % 2 == 0))) {
                    temp++;
                }
                int v = (p.s + 1) * 100 + temp * 500;
                if (visited[dr][dc] < v) continue;
                visited[dr][dc] = v;
                

                q.offer(new Node(dr, dc, p.s + 1, temp, d));
            }
        }
        return visited[0][0];
    }
}