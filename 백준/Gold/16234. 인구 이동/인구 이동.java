import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Point> q = new ArrayDeque<>();
		int time = 0;
		int[][] deltas = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
		while (true) {
			boolean[][] used = new boolean[N][N];
			boolean check = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (used[i][j]) {
						continue;
					}
					Queue<Point> q2 = new ArrayDeque<>();
					q.offer(new Point(i, j));
					q2.offer(new Point(i, j));
					used[i][j] = true;
					int sum = arr[i][j];
					int count = 1;
					while (!q.isEmpty()) {
						Point p = q.poll();
						
						for (int d = 0; d < 4; d++) {
							int dr = p.r + deltas[d][0];
							int dc = p.c + deltas[d][1];
							if (0 <= dr && dr < N && 0 <= dc && dc < N && !used[dr][dc] && Math.abs(arr[dr][dc] - arr[p.r][p.c]) >= L
									&& Math.abs(arr[dr][dc] - arr[p.r][p.c]) <= R) {
								check = true;
								count++;
								sum += arr[dr][dc];
								used[dr][dc] = true;
								q.offer(new Point(dr, dc));
								q2.offer(new Point(dr, dc));
							}
						}
					}
					int total = sum/count;
					while (!q2.isEmpty()) {
						Point p = q2.poll();
						arr[p.r][p.c]= total; 
					}
				}
			}
			if (!check) {
				break;
			}
			time++;
		}
		sb.append(time);
		System.out.println(sb);
	}
}