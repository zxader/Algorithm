import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N;
	static int M;
	static int[][] map;
	static List<Position> list;
	static Position[] result;
	static Queue<Position> q;
	static int max;
	static class Position{
		int r;
		int c;

		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + "]";
		}
	}
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		result = new Position[3];
		q = new ArrayDeque<>();
		int safe = 0;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 0) {
					safe++;
					list.add(new Position(r, c));
				}
			}
		}
		max = Integer.MIN_VALUE;
		cmb(0, 0, safe);

		sb.append(max - 3);
		sb.append("\n");
		System.out.println(sb);
	}

	static void cmb(int cnt, int start, int safe) {
		if(cnt == 3) {
			int[][] copy = new int[N][M];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					copy[r][c] = map[r][c];
				}
			}
			for (Position p : result) {
				copy[p.r][p.c] = 1; 
			}

			max = Math.max(max, safe - count(copy));
			return;
		}

		for (int i = start; i < list.size(); i++) {
			result[cnt] = list.get(i);
			cmb(cnt + 1, i + 1 , safe);
		}
	}

	static int count(int[][] map) {
		int count = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 2) {
					q.offer(new Position(r, c));
				}
			}
		}
		while(!q.isEmpty()) {
			int[][] deltas = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
			Position p = q.poll();

			for (int d = 0; d < 4; d++) {
				int dr = p.r + deltas[d][0];
				int dc = p.c + deltas[d][1];

				if(0 <= dr && dr < N && 0 <= dc && dc < M && map[dr][dc] == 0) {
					map[dr][dc] = 2;
					q.offer(new Position(dr, dc));
					count++;
				}
			}
		}

		return count;
	}
}