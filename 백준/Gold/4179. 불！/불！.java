import java.util.*;
import java.io.*;

public class Main {
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	static class Point {
		int r;
		int c;
		int time;
		public Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		Queue<Point> q = new ArrayDeque<>();
		Queue<Point> f = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'J') {
					q.offer(new Point(i, j, 0));
					visited[i][j] = true;
					map[i][j] = '.';
				}
				if (map[i][j] == 'F') {
					f.offer(new Point(i, j, 0));
				}
			}
		}
		int time = 0;
		boolean check = false;
		while(!q.isEmpty()){
			int size = f.size();
			while(--size >= 0) {
				Point fire = f.poll();
				for (int d = 0; d < 4; d++) {
					int dr = fire.r + deltas[d][0];
					int dc = fire.c + deltas[d][1];
					if (isIn(dr, dc) && map[dr][dc] == '.') {
						map[dr][dc] = 'F';
						f.offer(new Point(dr, dc, 0));
					}
				}
			}
			size = q.size();
			while(--size >= 0) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					int dr = p.r + deltas[d][0];
					int dc = p.c + deltas[d][1];

					if (!isIn(dr, dc)) {
						time = p.time + 1;
						check = true;
						break;
					}
					if (!visited[dr][dc] && map[dr][dc] == '.') {
						visited[dr][dc] = true;
						q.offer(new Point(dr, dc, p.time + 1));
					}
				}
				if (check){
					break;
				}
			}
			if (check){
				break;
			}
		}
		if (time == 0){
			sb.append("IMPOSSIBLE");
		}
		else {
			sb.append(time);
		}
		System.out.println(sb);
	}

	static boolean isIn(int r, int c) {
		return  0 <= r && r < R &&  0 <= c && c < C;
	}
}