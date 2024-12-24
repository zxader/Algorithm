import java.util.*;
import java.io.*;

public class Main {
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int result;
	
	static class Point {
		int r;
		int c;
		int d;
		
		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		result = 0;
		
		for (int i = 0; i < R; i++) {
			String inputMap = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = inputMap.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L') {
					result = Math.max(result, bfs(i, j));
				}
			}
		}
		
		sb.append(result);
		System.out.print(sb);
	}
	
	static int bfs(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		visited = new boolean[R][C];
		visited[r][c] = true;
		q.add(new Point(r, c, 0));
		int maxDistance = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			maxDistance = Math.max(maxDistance, p.d);
			
			for (int d = 0; d < 4; d++) {
				int dr = p.r + deltas[d][0];
				int dc = p.c + deltas[d][1];
				
				if(0 <= dr && dr < R && 0 <= dc && dc < C && !visited[dr][dc] && map[dr][dc] == 'L') {
					visited[dr][dc] = true;
					q.add(new Point(dr, dc, p.d + 1));
				}
			}
		}
		
		return maxDistance;
	}
}