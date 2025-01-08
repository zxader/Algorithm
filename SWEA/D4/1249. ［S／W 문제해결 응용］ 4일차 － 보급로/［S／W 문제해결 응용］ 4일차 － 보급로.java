import java.util.*;
import java.io.*;

public class Solution {
	static class Point implements Comparable<Point>{
		int r;
		int c;
		int v;
		
		public Point(int r, int c, int v) {
			this.r = r;
			this.c = c;
			this.v = v;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.v - o.v;
		}
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	sb.append("#" + t + " ");
        	int N = Integer.parseInt(br.readLine());
        	int[][] map = new int[N][N];
        	int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        	int[][] dijk = new int[N][N];
        	boolean[][] visited = new boolean[N][N];
        	
        	for (int i = 0; i < N; i++) {
        		String input = br.readLine();
        		for (int j = 0; j < N; j++) {
        			map[i][j] = input.charAt(j) - '0';
        			dijk[i][j] = Integer.MAX_VALUE;
        		}
        	}
        	
        	PriorityQueue<Point> q = new PriorityQueue<>();
        	dijk[0][0] = 0;
        	q.offer(new Point(0, 0, dijk[0][0]));
        	
        	while (!q.isEmpty()) {
        		Point p = q.poll();
        		
        		if (visited[p.r][p.c]) continue;
        		visited[p.r][p.c] = true;
        		
        		for (int d = 0; d < 4; d++) {
        			int dr = p.r + deltas[d][0];
        			int dc = p.c + deltas[d][1];
        			
        			if (0 <= dr && dr < N && 0 <= dc && dc < N && !visited[dr][dc] &&
        					dijk[dr][dc] > dijk[p.r][p.c] + map[dr][dc]) {
        				dijk[dr][dc] = dijk[p.r][p.c] + map[dr][dc]; 
        				q.offer(new Point(dr, dc, dijk[dr][dc]));
        			}
        		}
        	}
        	
        	sb.append(dijk[N - 1][N - 1]).append("\n");
        }
        
        System.out.println(sb);
    }
}