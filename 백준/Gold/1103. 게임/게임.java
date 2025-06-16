import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[][] detlas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int[][] dp;
	static boolean hasCycle;
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new char[N][M];
    	visited = new boolean[N][M];
    	dp = new int[N][M];
    	hasCycle = false;
    	
    	for (int i = 0; i < N; i++) {
    		String input = br.readLine();
    		for (int j = 0; j < M; j++) {
    			map[i][j] = input.charAt(j);
    		}
    	}

    	int result = dfs(0, 0);
    	System.out.println(hasCycle ? -1 : result);
	}
	
	static int dfs(int r, int c) {
		if (hasCycle) return 0;
		if (!isIn(r, c) || map[r][c] == 'H') {
			return 0;
		}
		if (visited[r][c]) {
			hasCycle = true;
			return 0;
		}
		if (dp[r][c] != 0) return dp[r][c];
		
		int v = map[r][c] - '0';
		int result = 0;
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int dr = r + detlas[d][0] * v;
			int dc = c + detlas[d][1] * v;
			
			result = Math.max(dfs(dr, dc), result);
		}
		visited[r][c] = false;
		
		return dp[r][c] = result + 1;
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
}
