import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

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
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] deltas = {{0,1},{0,-1},{-1,0},{1,0}};
		int time = 0;
		while(true) {
			boolean[][] used = new boolean[N][M];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] != 0 && !used[i][j]) {
						count++;
						Queue<Point> q = new ArrayDeque<>();
						q.offer(new Point(i,j));
						while(!q.isEmpty()) {
							Point p = q.poll();
							used[p.r][p.c] = true;
							for (int d = 0 ; d < 4; d++) {
								int dr = p.r + deltas[d][0];
								int dc = p.c + deltas[d][1];
								if (0 <= dr && dr < N && 0 <= dc && dc < M && map[dr][dc] != 0 && !used[dr][dc]) {
									used[dr][dc] = true;
									q.offer(new Point(dr,dc));
								}
							}
						}
					}
				}
			}
			if(count >= 2) break;
			if(count == 0) {
				time = -1;
				break;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] != 0) {
						for (int d = 0 ; d < 4; d++) {
							int dr = i + deltas[d][0];
							int dc = j + deltas[d][1];
							if (0 <= dr && dr < N && 0 <= dc && dc < M && map[dr][dc] == 0 && !used[dr][dc]) {
								if(map[i][j] > 0) {
									map[i][j]--;
								}
							}
						}
					}
				}
			}
			time++;
		}
		if(time == -1) {
			sb.append(0);
		}
		else {
			sb.append(time);
		}
		System.out.println(sb);
	}


}