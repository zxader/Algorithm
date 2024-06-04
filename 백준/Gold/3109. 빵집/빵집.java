import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int R; // 세로
	static int C; // 가로
	static char[][] map; // 맵
	static int[][] deltas = {{-1, -1}, {0, -1}, {1, -1}}; // 좌상 좌 좌하 이동
	static boolean[][] check; // 방문 체크
	static int max; // 파이프 최대 개수

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		// 입력
		String[] split = in.readLine().split(" ");
		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);
		map = new char[R][C];
		check = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			split = in.readLine().split("");
			for (int c = 0; c < C; c++) {
				map[r][c] = split[c].charAt(0);
			}
		}

		// DFS
		max = 0;
		for (int r = 0; r < R; r++) {
			if(dfs(r, C - 1)) {
				max++;
			}
		}

		sb.append(max).append("\n");

		System.out.println(sb);
	}

	// 범위 체크
	static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	// DFS
	static boolean dfs(int r, int c) {
		if (c == 0) {
			return true;
		}
	
		// 세 방향 탐색
		for (int d = 0; d < 3; d++) {
			int dr = r + deltas[d][0];
			int dc = c + deltas[d][1];

			if (isIn(dr, dc) && !check[dr][dc] && map[dr][dc] != 'x') {
				if(dfs(dr, dc)) {
					check[dr][dc] = true;
					return true;
				}
				check[dr][dc] = true;
			}
		}
		return false;
	}

}