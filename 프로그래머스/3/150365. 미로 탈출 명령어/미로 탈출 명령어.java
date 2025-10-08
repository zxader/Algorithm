import java.util.*;

class Solution {
    static class Point implements Comparable<Point> {
        int r, c;
        String path;
        Point(int r, int c, String path) {
            this.r = r;
            this.c = c;
            this.path = path;
        }
        
        @Override
        public int compareTo(Point o) {
            return this.path.compareTo(o.path);
        }
    }
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static String[] str = {"r", "l", "d", "u"};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        int temp = Math.abs(x - r) + Math.abs(y - c);
        if ((k - temp) % 2 != 0) return "impossible";
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.offer(new Point(x, y, ""));
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            
            if (p.r == r && p.c == c && p.path.length() == k) {
                return p.path;
            }
            
            for (int d = 0; d < 4; d++) {
                int dr = p.r + deltas[d][0];
                int dc = p.c + deltas[d][1];
                String path = p.path + str[d];
                if (dr < 1 || dr > n) continue;
                if (dc < 1 || dc > m) continue;
                if (path.length() > k) continue;
                int v = Math.abs(dr - r) + Math.abs(dc - c);
                if (path.length() + v > k) continue;
                q.offer(new Point(dr, dc, path));
            }
        }
        
        return "impossible";
    }
}