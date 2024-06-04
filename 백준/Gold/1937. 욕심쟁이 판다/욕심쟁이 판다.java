import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[][] deltas = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
	static boolean[][] visited;
	static int[][] check;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		check = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				check[i][j] = 1;
			}
		}
		max = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				// 이미 체크한 곳 넘기기
				if (visited[i][j]) continue;
				visited[i][j] = true;
				dfs(i, j, 1);
			}
		}
		
		// max 값 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, check[i][j]);
			}
		}
		sb.append(max);
		System.out.println(sb);
	}

	static int dfs(int r, int c, int cnt) {

		for (int d = 0; d < 4; d++) {
			int dr = r + deltas[d][0];
			int dc = c + deltas[d][1];

			if(isIn(dr, dc)  && map[r][c] < map[dr][dc]) {
				
				// 이미 체크한 곳이면 그 값 +1과 현재 위치 값 중 큰 값을 넣음
				if (check[dr][dc] != 1) {
					check[r][c] = Math.max(check[r][c], check[dr][dc] + 1);
					continue;
				}
				visited[dr][dc] = true;

				int num = dfs(dr, dc, cnt + 1) + 1;
				check[r][c] = Math.max(check[r][c], num); 
			}
		}
		return check[r][c];
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}