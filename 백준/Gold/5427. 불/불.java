import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int r, c, v;
		
		public Point(int r, int c, int v) {
			this.r = r;
			this.c = c;
			this.v = v;
		}
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int w, h;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringBuilder sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	for (int t = 1; t <= T; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		w = Integer.parseInt(st.nextToken());
    		h = Integer.parseInt(st.nextToken());
    		char[][] map = new char[h][w];
    		
    		Queue<Point> fire = new ArrayDeque<>();
    		Queue<Point> person = new ArrayDeque<>();
    		boolean[][] visited = new boolean[h][w];
    		
    		for (int i = 0; i < h; i++) {
    			String input = br.readLine();
    			for (int j = 0; j < w; j++) {
    				map[i][j] = input.charAt(j);
    				if (map[i][j] == '*') fire.offer(new Point(i, j));
    				if (map[i][j] == '@') {
    					person.offer(new Point(i, j));
    					map[i][j] = '.';
    					visited[i][j] = true;
    				}
    			}
    		}
    		
    		boolean isImpossible = true;
    		int result = 0;
    		
    		while (person.size() > 0) {
    			if (!isImpossible) break;
    			
    			int size = fire.size();
    			while (--size >= 0) {
    				Point p = fire.poll();
    				
    				for (int d = 0; d < 4; d++) {
    					int dr = p.r + deltas[d][0];
    					int dc = p.c + deltas[d][1];
    					
    					if (!isIn(dr, dc)) continue;
    					if (map[dr][dc] == '#') continue;
    					if (map[dr][dc] == '*') continue;
    					
    					map[dr][dc] = '*';
    					fire.offer(new Point(dr, dc));
    				}
    			}
    			
    			size = person.size();
    			while (--size >= 0) {
    				Point p = person.poll();
    				
    				if (!isImpossible) break;
    				
    				for (int d = 0; d < 4; d++) {
    					int dr = p.r + deltas[d][0];
    					int dc = p.c + deltas[d][1];
    					
    					if (!isIn(dr, dc)) {
    						isImpossible = false;
    						result = p.v + 1;
    						break;
    					}
    					
    					if (map[dr][dc] == '#') continue;
    					if (map[dr][dc] == '*') continue;
    					if (visited[dr][dc]) continue;
    					
    					visited[dr][dc] = true;
    					person.offer(new Point(dr, dc, p.v + 1));
    				}
    			}
    		}
    		
    		sb.append(isImpossible ? "IMPOSSIBLE" : result).append("\n");
    	}
    	System.out.println(sb);
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < h && 0 <= c && c < w;
	}
}
