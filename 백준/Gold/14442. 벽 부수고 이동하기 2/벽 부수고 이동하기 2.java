import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int r, c, v, k;
		
		public Point(int r, int c, int v, int k) {
			this.r = r;
			this.c = c;
			this.v = v;
			this.k = k;
		}
	}
	
	static int N, M;
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	boolean[][][] visited = new boolean[N][M][K + 1];
    	int[][] map = new int[N][M];
    	
    	for (int i = 0; i < N; i++) {
    		String input = br.readLine();
    		for (int j = 0; j < M; j++) {
    			map[i][j] = input.charAt(j) - '0';
    		}
    	}
    	
    	Queue<Point> q = new ArrayDeque<>();
    	visited[0][0][0] = true;
    	q.offer(new Point(0, 0, 1, 0));
    	int result = -1;
    	
    	while (!q.isEmpty()) {
    		Point p = q.poll();
    		
    		if (p.r == N - 1 && p.c == M - 1) {
    			result = p.v;
    			break;
    		}
    		
    		for (int d = 0; d < 4; d++) {
    			int dr = p.r + deltas[d][0];
    			int dc = p.c + deltas[d][1];
    			
    			if (!isIn(dr, dc)) continue;
    			if (map[dr][dc] == 1 && p.k < K && !visited[dr][dc][p.k + 1]) {
    				visited[dr][dc][p.k + 1] = true;
    				q.offer(new Point(dr, dc, p.v + 1, p.k + 1));
    			}
    			else if (map[dr][dc] == 0 && !visited[dr][dc][p.k]){
    				visited[dr][dc][p.k] = true;
    				q.offer(new Point(dr, dc, p.v + 1, p.k));
    			}
    		}
    		
    	}
    	
    	System.out.println(result);
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
}
