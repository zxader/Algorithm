import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static class Point {
		int r, c, v;
		
		public Point(int r, int c, int v) {
			this.r = r;
			this.c = c;
			this.v = v;
		}
	}
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	map = new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int idx = 2;
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			if (map[i][j] != 1) continue;
    			
    			Queue<int[]> q = new ArrayDeque<>();
    			q.offer(new int[] {i, j});
    			map[i][j] = idx;
    			while (!q.isEmpty()) {
    				int[] p = q.poll();
    				
    				for (int d = 0; d < 4; d++) {
    					int dr = p[0] + deltas[d][0];
    					int dc = p[1] + deltas[d][1];
    					
    					if (isIn(dr, dc) && map[dr][dc] == 1) {
    						q.offer(new int[] {dr, dc});
    						map[dr][dc] = idx;
    					}
    				}
    			}
    			idx++;
    		}
    	}
    	
    	int result = Integer.MAX_VALUE;
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			if (map[i][j] == 0) continue;
    			int temp = map[i][j];
    			
    			boolean[][] visited = new boolean[N][N];
    			Queue<Point> q = new ArrayDeque<>();
    			q.offer(new Point(i, j, 0));
    			visited[i][j] = true;
    			
    			while (!q.isEmpty()) {
    				Point p = q.poll();
    				
    				if (p.v >= result) continue;
    				
    				for (int d = 0; d < 4; d++) {
    					int dr = p.r + deltas[d][0];
    					int dc = p.c + deltas[d][1];
    					
    					if (!isIn(dr, dc) || visited[dr][dc] || map[dr][dc] == temp) continue;
    					
    					if (map[dr][dc] == 0) {
    						q.offer(new Point(dr, dc, p.v + 1));
    						visited[dr][dc] = true;
    					} else {
    						result = Math.min(p.v, result);
    					}
    				}
    			}

    		}
    	}
    	
    	System.out.println(result);
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}
