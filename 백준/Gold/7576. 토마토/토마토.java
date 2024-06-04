import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Position{
		int r;
		int c;
		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =  new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] used = new boolean[N][M];
		Queue<Position> q = new ArrayDeque<>();
		boolean check = false;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.offer(new Position(i,j));		
					used[i][j] = true;
				}
				if(map[i][j] == 0) {
					check = true;
				}
			}
		}
		int time = 0;
		if(check) {
			int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
			while(true) {
				int size = q.size();
				while(--size>=0) {
					Position p = q.poll();
					for (int d = 0; d < 4; d++) {
						int dr = p.r + deltas[d][0];
						int dc = p.c + deltas[d][1];
						if (0 <= dr && dr < N && 0 <= dc && dc < M && map[dr][dc] == 0 && !used[dr][dc]) {
							used[dr][dc] = true;
							map[dr][dc] = 1;
							q.offer(new Position(dr,dc));
						}
					}
				}
				if(q.isEmpty()) {
					break;
				}
				time++;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 0) {
						time = -1;
					}
				}
			}
		}
		sb.append(time);
		System.out.println(sb);
	}
}
