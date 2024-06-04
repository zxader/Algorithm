import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] map1;
	static char[][] map2;

	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int count1;
	static int count2;

	static void dfs(int i, int j, char c) {
		for(int d = 0; d < 4; d++) {
			int dr = i + deltas[d][0];
			int dc = j + deltas[d][1];
			if(0 <= dr && dr < N && 0 <= dc && dc < N && map1[dr][dc] == c) {
				if(map1[dr][dc] == 'G') {
					map2[dr][dc] = 'R';
				}
				map1[dr][dc] = 'A';
				dfs(dr, dc, c);
			}
		}
	}
	
	static void dfs2(int i, int j, char c) {
		for(int d = 0; d < 4; d++) {
			int dr = i + deltas[d][0];
			int dc = j + deltas[d][1];
			if(0 <= dr && dr < N && 0 <= dc && dc < N && map2[dr][dc] == c) {
				map2[dr][dc] = 'A';
				dfs2(dr, dc, c);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		map1 = new char[N][N];
		map2 = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String arr = in.readLine();
			for(int j = 0; j < N; j++) {
				map1[i][j] = arr.charAt(j);
				map2[i][j] = map1[i][j];
			}
		}
		count1 = 0;
		count2 = 0;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map1[r][c] == 'G') {
					map2[r][c] = 'R';
				}
				if(map1[r][c] != 'A') {
					dfs(r, c, map1[r][c]);
					
					count1++;
				}
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map2[r][c] != 'A') {
					dfs2(r, c, map2[r][c]);
					count2++;
				}
			}
		}
		sb.append(count1 + " " + count2).append("\n");
		System.out.println(sb);
	}
}