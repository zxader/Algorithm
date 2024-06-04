

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
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
	static int[][] deltas = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
	static int R;
	static int C;
	static char[][] map;
	static int[][] move;
	static Point end;
	static Queue<Point> q;
	static Queue<Point> qW;
	static boolean[][] used;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		move = new int[R][C];
		used = new boolean[R][C];
		q = new ArrayDeque<>();
		qW = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				move[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					q.offer(new Point(i,j));
					used[i][j] = true;
					move[i][j] = 0;
				}
				if(map[i][j] == '*') {
					qW.offer(new Point(i,j));
				}
				if(map[i][j] == 'D') {
					end = new Point(i,j);
				}
			}
		}
		
		while(!q.isEmpty()) {
			int size1 =  qW.size();
			while(--size1>=0) {
				Point pw = qW.poll();
				for (int d = 0; d < 4; d++) {
					int dr = pw.r + deltas[d][0];
					int dc = pw.c + deltas[d][1];
					if(isIn(dr,dc) && map[dr][dc] =='.') {
						map[dr][dc] = '*';
						qW.offer(new Point(dr,dc));
					}
				}
			}
			int size2 =  q.size();
			while(--size2>=0) {
				Point p = q.poll();
				if(p.r == end.r && p.c == end.c) {
					break;
				}
				for (int d = 0; d < 4; d++) {
					int dr = p.r + deltas[d][0];
					int dc = p.c + deltas[d][1];
					if(isIn(dr,dc) && !used[dr][dc] && (map[dr][dc] =='.' || map[dr][dc] == 'D') ) {
						used[dr][dc] = true;
						if(move[dr][dc] > move[p.r][p.c] + 1) {
							move[dr][dc] = move[p.r][p.c] + 1; 
							q.offer(new Point(dr,dc));
						}
					}
				}
			}
		}
		if(move[end.r][end.c] == Integer.MAX_VALUE) {
			sb.append("KAKTUS");
		}else {
			sb.append(move[end.r][end.c]);
		}
		System.out.println(sb);
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
}
