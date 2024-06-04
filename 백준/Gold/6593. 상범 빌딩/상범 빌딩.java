import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] deltas = { {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1} };
	static int L;
	static int R;
	static int C;
	static char[][][] map;
	static boolean[][][] visited;
	static class Point {
		int r;
		int c;
		int l;
		int t;
		public Point(int r, int c, int l, int t) {
			super();
			this.r = r;
			this.c = c;
			this.l = l;
			this.t = t;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", l=" + l + ", t=" + t + "]";
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L == 0 && R == 0 & C == 0) {
				break;
			}
			map = new char[R][C][L];
			visited = new boolean[R][C][L];
			
			Queue<Point> q = new ArrayDeque<>();
			for (int l = 0; l < L; l++) {
				for (int i = 0; i < R; i++) {
					String str2 = br.readLine();
					for (int j = 0; j < C; j++) {
						map[i][j][l] = str2.charAt(j);
						if (map[i][j][l] == 'S') {
							q.offer(new Point(i,j,l,0));
							visited[i][j][l] = true;
						}
					}
				}
				String str1 = br.readLine();
			}
			int dis = 0;
			while(!q.isEmpty()) {
				Point p = q.poll();
				if (map[p.r][p.c][p.l] == 'E') {
					dis = p.t;
					break;
				}
				for (int d = 0; d < 6; d++) {
					int dr = p.r + deltas[d][0];
					int dc = p.c + deltas[d][1];
					int dl = p.l + deltas[d][2];
					if (isIn(dr, dc, dl) && map[dr][dc][dl] !='#' && !visited[dr][dc][dl]) {
						visited[dr][dc][dl] = true;
						q.offer(new Point(dr, dc, dl, p.t + 1));
					}
				}
			}
			if (dis == 0) {
				sb.append("Trapped!").append("\n");
			}
			else {
				sb.append("Escaped in " + dis + " minute(s).").append("\n");
			}
		}
		
		System.out.println(sb);
	}
	static boolean isIn(int r, int c, int l) {
		return 0 <= r && r < R && 0 <= c && c < C && 0 <= l && l < L;
	}
}