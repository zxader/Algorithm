import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] used;
	static int[][] deltas = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1} };
	static int count;
	static boolean[][] used2;
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		used2 = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(used2[i][j]) continue;
				check(i, j);
			}
		}
		sb.append(count);
		System.out.println(sb);
	}
	
	static void check(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(r, c));
		used = new boolean[N][M];
		used[r][c] = true;
		used2[r][c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 8; d++) {
				int dr = p.r + deltas[d][0];
				int dc = p.c + deltas[d][1];
				
				if(!isIn(dr, dc) || used[dr][dc]) continue;
				if(map[dr][dc] > map[p.r][p.c]) return;
				if(map[dr][dc] == map[p.r][p.c]) {
					q.offer(new Point(dr, dc));
					used[dr][dc] = true;
					used2[dr][dc] = true;
				}
			}
		}
		count++;
	}
	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M; 
	}
}