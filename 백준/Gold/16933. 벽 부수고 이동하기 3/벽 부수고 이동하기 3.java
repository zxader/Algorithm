import java.io.*;
import java.util.*;

public class Main {
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static class Point {
		int r, c, k, d;
		boolean time;
		
		public Point(int r, int c, int k, int d, boolean time) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.d = d;
			this.time = time;
		}
	}
	static int N, M;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	int[][] map = new int[N][M];
    	boolean[][][][] visited = new boolean[N][M][K + 1][2];
    
    	for (int i = 0; i < N; i++) {
    		String input = br.readLine();
    		for (int j = 0; j < M; j++) {
    			map[i][j] = input.charAt(j) - '0';
    		}
    	}
    	
    	Queue<Point> q = new ArrayDeque<>();
    	q.offer(new Point(0, 0, 0, 1, true));
    	visited[0][0][0][0] = true;
    	int result = Integer.MAX_VALUE;
    	
    	while (!q.isEmpty()) {
    		Point p = q.poll();
    		
    		if (p.r == N - 1 && p.c == M - 1) {
    			result = Math.min(result, p.d);
    		}
    		
    		int time = p.time ? 1 : 0;
    		for (int d = 0; d < 4; d++) {
    			int dr = p.r + deltas[d][0];
    			int dc = p.c + deltas[d][1];
    			
    			if (!isIn(dr, dc)) continue;
    			if (map[dr][dc] == 1 && p.k < K && p.time && !visited[dr][dc][p.k + 1][1]) {
    				q.offer(new Point(dr, dc, p.k + 1, p.d + 1, false));
    				visited[dr][dc][p.k + 1][1] = true;
    			}
    			else if (map[dr][dc] == 0 && !visited[dr][dc][p.k][time]) {
    				q.offer(new Point(dr, dc, p.k, p.d + 1, !p.time));
    				visited[dr][dc][p.k][time] = true;
    			}
    		}
    		
    		if (visited[p.r][p.c][p.k][time]) continue;
    		q.offer(new Point(p.r, p.c, p.k, p.d + 1, !p.time));
    		visited[p.r][p.c][p.k][time] = true;
    	}
    	
    	System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
}
