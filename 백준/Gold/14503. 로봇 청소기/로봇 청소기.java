import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] deltas = {{-1,0}, {0,1}, {1,0},{0,-1}};
	static int cr, cc, cd;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] read = in.readLine().split(" ");
		N = Integer.parseInt(read[0]);
		M = Integer.parseInt(read[1]);

		String[] readrcd = in.readLine().split(" ");
		cr = Integer.parseInt(readrcd[0]);
		cc = Integer.parseInt(readrcd[1]);
		cd = Integer.parseInt(readrcd[2]);
		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			String[] readmap = in.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(readmap[c]);
			}
		}
		int d = cd;
		int count = 0;
		map[cr][cc] = 2;
		while(true) {

			boolean check = false;

			for (int f = 0; f < 4; f++) {
				int dr = cr + deltas[f][0];
				int dc = cc + deltas[f][1];
				if(isIn(dr, dc) && map[dr][dc] == 0) {
					check = true;
				}
			}

			if(check) {
				while(true) {
					d -= 1;
					if (d == -1) {
						d = 3;
					}
					int dr = cr + deltas[d][0];
					int dc = cc + deltas[d][1];
					if(isIn(dr, dc) && map[dr][dc] == 0) {
						map[dr][dc] = 2;
						cr = dr;
						cc = dc;
						break;
					}
				}
			}else {
				int dr = cr - deltas[d][0];
				int dc = cc - deltas[d][1];
				if(!isIn(dr, dc) || map[dr][dc] == 1) {
					break;
				}
				cr = dr;
				cc = dc;
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 2) {
					count++;
				}
			}
		}

		sb.append(count);
		System.out.println(sb);
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}

}