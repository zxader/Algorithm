import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int C;
	static char[] alp;
	static char[][] map;
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int max;
	static boolean[][] check;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);
		alp = new char[26];
		map = new char[N][C];
		
		for (int r = 0; r < N; r++) {
			split = in.readLine().split("");
			for (int c = 0; c < C; c++) {
				map[r][c] = split[c].charAt(0);
			}
		}
		max = Integer.MIN_VALUE;
		check = new boolean[N][C];
		alp[0] = map[0][0];
		check[0][0] = true;
		dfs(0, 0, 1);
		sb.append(max);
		System.out.println(sb);
	}
	
	static void dfs(int r, int c, int cnt) {
		
		for (int d = 0; d < 4; d++) {
			int dr = r + deltas[d][0];
			int dc = c + deltas[d][1];
			boolean check1 = false;
			
			if (isIn(dr, dc) && !check[dr][dc]) {
				for (int a = 0; a < 26; a++) {
					if (map[dr][dc] == alp[a]) {
						check1 = true;
					}
					if (alp[a] == ' ') {
						break;
					}
				}
				if(!check1) {
					alp[cnt] = map[dr][dc];
					check[dr][dc] = true;
					dfs(dr, dc, cnt + 1);
					check[dr][dc] = false;
					alp[cnt] = ' ';
				}
			}
		}
		if(cnt > max) {
			max = cnt;
		}
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < C;
	}
}