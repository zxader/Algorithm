import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static int[][] map;
	static int[][] deltas = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
	static int count = 0;
	static boolean[][] visited;
	static boolean[][] visited2;
	static int[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		visited2 = new boolean[M][N];
		check = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = 0;
		visited[0][0] = true;
		check[0][0] = 1;
		dfs(0, 0);
		sb.append(count);
		System.out.println(sb);
	}
	
	static void dfs(int r, int c) {
		if (r == M - 1 && c == N - 1) {
			count++;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (visited2[i][j]) {
						check[i][j]++;
					}
				}
			}
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int dr = r + deltas[d][0];
			int dc = c + deltas[d][1];
			if(isIn(dr, dc) && map[r][c] > map[dr][dc]) {
				if (check[dr][dc] >= 1) {
					count += check[dr][dc];
					for (int i = 0; i < M; i++) {
						for (int j = 0; j < N; j++) {
							if (visited2[i][j]) {
								check[i][j] += check[dr][dc];
							}
						}
					}
					continue;
				}
				if (visited[dr][dc]) continue;
				visited[dr][dc] = true;
				visited2[dr][dc] = true;
				dfs(dr, dc);
				visited2[dr][dc] = false;
			}
		}
		
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < M && 0 <= c && c < N;
	}
}