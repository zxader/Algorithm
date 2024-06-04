import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int K;
	static int W;
	static int H;
	static int min;
	static int[][] map;
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int[][] deltasH = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
			{1, -2}, {2, -1}, {2, 1}, {1, 2}};
	static boolean[][][]check;
	static boolean check2;

	static class Position{
		int r;
		int c;
		int k;
		int count;
		public Position(int r, int c, int k, int count) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.count = count;
		}
		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + ", k=" + k + ", count=" + count + "]";
		}
	}
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();

		K = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		check = new boolean[H][W][K + 1];

		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		check2 = false;
		check[0][0][0] = true;
		Queue<Position> q = new ArrayDeque<>();
		q.offer(new Position(0, 0, 0, 0));

		while(!q.isEmpty()) {
			Position p = q.poll();
			if (p.r == H - 1 && p.c == W - 1) {
				if(p.count < min) {
					min = p.count;
				}
				check2 = true;
				continue;
			}
			if(p.count > min) continue;
			if(p.k != K) {
				for (int d = 0; d < 8; d++) {
					int dr = p.r + deltasH[d][0];
					int dc = p.c + deltasH[d][1];
					if(isIn(dr, dc) && map[dr][dc] == 0 && !check[dr][dc][p.k + 1]) {
						check[dr][dc][p.k + 1] = true;
						q.offer(new Position(dr, dc, p.k + 1, p.count + 1));
					}
				}
			}

			for (int d = 0; d < 4; d++) {
				int dr = p.r + deltas[d][0];
				int dc = p.c + deltas[d][1];
				if(isIn(dr, dc) && map[dr][dc] == 0 && !check[dr][dc][p.k]) {
					check[dr][dc][p.k] = true;
					q.offer(new Position(dr, dc, p.k, p.count + 1));
				}
			}
		}
		if(!check2) {
			min = -1;
		}
		sb.append(min);
		sb.append("\n");
		System.out.println(sb);
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < H && 0 <= c && c < W;
	}
}