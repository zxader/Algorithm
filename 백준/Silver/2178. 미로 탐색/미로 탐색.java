import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map;
	
	static class Position {
		int r;
		int c;
		int result;
		
		public Position(int r, int c, int result) {
			this.r = r;
			this.c = c;
			this.result = result;
		}
		
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = input.charAt(j - 1) - '0';
			}
		}
		
		sb.append(bfs());
		System.out.println(sb);
	}
	
	static int bfs() {
		boolean[][] checkMap = new boolean[N + 1][M + 1];
		Queue<Position> q = new ArrayDeque<>();
		q.add(new Position(1, 1, 1));
		checkMap[1][1] = true;
		
		while(!q.isEmpty()) {
			Position p = q.poll();
			
			if (p.r == N && p.c == M) {
				return p.result;
			}
			
			for (int d = 0; d < 4; d++) {
				int dr = p.r + dx[d];
				int dc = p.c + dy[d];
				
				if (isIn(dr, dc) && !checkMap[dr][dc] && map[dr][dc] == 1) {
					q.add(new Position(dr, dc, p.result + 1));
					checkMap[dr][dc] = true;
				}
			}
		}
		return 1;
	}
	
	static boolean isIn(int r, int c) {
		return 0 < r && r <= N && 0 < c && c <= M;
	}
}