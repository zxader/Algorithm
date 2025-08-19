import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int r, c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int h, w;
	static char[][] map;
	static boolean[][] visited;
	static boolean[] key;
	static List<Point>[] door;
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	StringBuilder sb = new StringBuilder();
    	for (int t = 1; t <= T; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		h = Integer.parseInt(st.nextToken());
    		w = Integer.parseInt(st.nextToken());
    		map = new char[h][w];
    		
    		for (int i = 0; i < h; i++) {
    			String input = br.readLine();
    			for (int j = 0; j < w; j++) {
    				map[i][j] = input.charAt(j);
    			}
    		}
    		
    		key = new boolean[26];
    		door = new List[26];
    		
    		for (int i = 0; i < 26; i++) {
    			door[i] = new ArrayList<>();
    		}
    		
    		String inputKey = br.readLine();
    		if (!inputKey.equals("0")) {
    			for (int i = 0; i < inputKey.length(); i++) {
    				int c = inputKey.charAt(i) - '0' - 49;
    				
    				key[c] = true;
    			}
    		}
    		
    		Queue<Point> q = new ArrayDeque<>();
    		visited = new boolean[h][w];
    		int result = 0;
    		
    		for (int i = 0; i < h; i++) {
    			for (int j = 0; j < w; j++) {
    				if (i == 0 || j == 0 || i == h - 1 || j == w - 1) {
    					if (map[i][j] == '*') continue;
    					if ('a' <= map[i][j] && map[i][j] <= 'z') {
    						int c = map[i][j] - '0' - 49;
    						key[c] = true;
    						map[i][j] = '.';
    						visited[i][j] = true;
    						q.offer(new Point(i, j));
    						
    						if (door[c].size() > 0) {
    							for (Point p : door[c]) {
    								q.offer(new Point(p.r, p.c));
    								map[p.r][p.c] = '.';
    								visited[p.r][p.c] = true;
    							}
    							
    							door[c] = new ArrayList<>();
    						}
    					}
    					else if ('A' <= map[i][j] && map[i][j] <= 'Z') {
    						int c = map[i][j] - '0' - 17;
    						if (key[c]) {
    							map[i][j] = '.';
    							visited[i][j] = true;
    							q.offer(new Point(i, j));
    						}
    						else {
    							door[c].add(new Point(i, j));
    						}
    					}
    					else if (map[i][j] == '$') {
    						visited[i][j] = true;
    						map[i][j] = '.';
    						q.offer(new Point(i, j));
    						result++;
    					}
    					else {
    						visited[i][j] = true;
    						q.offer(new Point(i, j));
    					}
    				}
    			}
    		}
    		
    		while (!q.isEmpty()) {
    			Point p = q.poll();
    			
    			for (int d = 0; d < 4; d++) {
    				int dr = p.r + deltas[d][0];
    				int dc = p.c + deltas[d][1];
    				
    				if (!isIn(dr, dc)) continue;
    				if (map[dr][dc] == '*') continue;
    				if (visited[dr][dc]) continue;
    				if ('a' <= map[dr][dc] && map[dr][dc] <= 'z') {
						int c = map[dr][dc] - '0' - 49;
						key[c] = true;
						map[dr][dc] = '.';
						visited[dr][dc] = true;
						q.offer(new Point(dr, dc));
						
						if (door[c].size() > 0) {
							for (Point point : door[c]) {
								q.offer(new Point(point.r, point.c));
								map[point.r][point.c] = '.';
								visited[point.r][point.c] = true;
							}
							
							door[c] = new ArrayList<>();
						}
					}
					else if ('A' <= map[dr][dc] && map[dr][dc] <= 'Z') {
						int c = map[dr][dc] - '0' - 17;
						if (key[c]) {
							map[dr][dc] = '.';
							visited[dr][dc] = true;
							q.offer(new Point(dr, dc));
						}
						else {
							door[c].add(new Point(dr, dc));
						}
					}
					else if (map[dr][dc] == '$') {
						visited[dr][dc] = true;
						map[dr][dc] = '.';
						q.offer(new Point(dr, dc));
						result++;
					}
					else {
						visited[dr][dc] = true;
						q.offer(new Point(dr, dc));
					}
    			}
    		}
    		
    		sb.append(result).append('\n');
    	}
    	
    	System.out.println(sb);
	}
	
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static boolean isIn(int r, int c) {
		return 0 <= r && r < h && 0 <= c && c < w;
	}
}