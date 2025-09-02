class Solution {
    static int[][] dp;
    static int[][] map;
    static boolean[][] visited;
    
    public int solution(int m, int n, int[][] puddles) {
        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        
        for (int i = 0; i < puddles.length; i++) {
            int c = puddles[i][0];
            int r = puddles[i][1];
            map[r][c] = 1;
        }
        visited[1][1] = true;
        int answer = dfs(1, 1, n, m);
        return answer;
    }
    
    static int[][] deltas = {{0, 1}, {1, 0}};
    static int dfs(int r, int c, int n, int m) {
        if (dp[r][c] != 0) return dp[r][c];
        if (r == n && c == m) return 1;
        
        int result = 0;
        for (int d = 0; d < 2; d++) {
            int dr = r + deltas[d][0];
            int dc = c + deltas[d][1];

            if (!isIn(dr, dc, n, m)) continue;
            if (visited[dr][dc]) continue;
            if (map[dr][dc] == 1) continue;
            
            visited[dr][dc] = true;
            result += dfs(dr, dc, n, m) % 1000000007;
            visited[dr][dc] = false;
        }
        
        return dp[r][c] = result % 1000000007;
    }
    
    static boolean isIn(int r, int c, int n, int m) {
        return 0 < r && r <= n && 0 < c && c <= m;
    }
}