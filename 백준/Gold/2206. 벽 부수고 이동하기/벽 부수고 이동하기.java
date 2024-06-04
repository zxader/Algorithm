import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Position{
		int r;
		int c;
		int l;
		int w;
		public Position(int r, int c, int l, int w) {
			super();
			this.r = r;
			this.c = c;
			this.l = l;
			this.w = w;
		}
	}
	static int N;
	static int M;
	static int[][] map;
	static boolean used[][][];
	static Position wall;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static int min;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =  new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		min = Integer.MAX_VALUE;
		used = new boolean[N][M][2];
		bfs();
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		sb.append(min);
		System.out.println(sb);
	}

	static void bfs() {
		Queue<Position> q = new ArrayDeque<>();
		q.offer(new Position(0, 0, 1, 0));
		used[0][0][0] = true;
		while(!q.isEmpty()) {
			Position p = q.poll();
			if(p.r == N - 1 && p.c == M - 1) {
				min = Math.min(min, p.l);
				break;
			}
			for (int d = 0; d < 4; d++) {
				int dr = p.r + deltas[d][0];
				int dc = p.c + deltas[d][1];
				if (0 > dr || dr >= N || 0 > dc || dc >= M) continue;

				if(map[dr][dc] == 1 && p.w == 0 && !used[dr][dc][p.w + 1]) {
					used[dr][dc][p.w + 1] = true;
					q.offer(new Position(dr, dc, p.l + 1,p.w + 1));
				}
				if(map[dr][dc] == 0 && !used[dr][dc][p.w]) {
					used[dr][dc][p.w] = true;
					q.offer(new Position(dr, dc, p.l + 1,p.w));
				}
			}
		}
	}
}
