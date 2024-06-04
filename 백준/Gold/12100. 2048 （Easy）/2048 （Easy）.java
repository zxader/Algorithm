import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] map;
	static int max = 0;
	static int N;
	static int[][] deltas = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	static int save;
	static int saveR;
	static int saveC;

	static void dfs(int map[][],int d, int count) {
		if(count == 0) {
			return;
		}
		int[][] copymap = new int[N][N];
		
		boolean[][] check = new boolean[N][N];
		if(d == 1 || d == 3) {
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N ; c++) {
					if(map[r][c] != 0) {
						int dr = r + deltas[d][0];
						int dc = c + deltas[d][1];
						save = map[r][c];
						saveR = r;
						saveC = c;
						while(true) {
							if((!isIn(dr, dc))||(map[dr][dc] != save && map[dr][dc] != 0) || check[dr][dc]) {
								break;
							}
							if(map[dr][dc] == save && !check[dr][dc]) {
								map[dr][dc] += save;
								save = map[dr][dc];
								check[dr][dc] = true;
								if(map[dr][dc] > max) {
									max = map[dr][dc];
								}
								map[saveR][saveC] = 0;
								break;
							}else {
								map[dr][dc] = save;
							}
							map[saveR][saveC] = 0;
							saveR = dr;
							saveC = dc;
							dr += deltas[d][0];
							dc += deltas[d][1];
						}
					}
				}
			}

		}else {
			for(int r = N-1; r >= 0 ; r--) {
				for(int c = N-1; c >= 0 ; c--) {
					if(map[r][c] != 0) {
						int dr = r + deltas[d][0];
						int dc = c + deltas[d][1];
						save = map[r][c];
						saveR = r;
						saveC = c;
						while(true) {
							if((!isIn(dr, dc))||(map[dr][dc] != save && map[dr][dc] != 0) || check[dr][dc]) {
								break;
							}
							if(map[dr][dc] == save && !check[dr][dc]) {
								map[dr][dc] += save;
								save = map[dr][dc];
								check[dr][dc] = true;
								if(map[dr][dc] > max) {
									max = map[dr][dc];
								}
								map[saveR][saveC] = 0;
								break;
							}else {
								map[dr][dc] = save;
							}
							map[saveR][saveC] = 0;
							saveR = dr;
							saveC = dc;
							dr += deltas[d][0];
							dc += deltas[d][1];
						}
					}
				}
			}

		}
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				copymap[r][c] = map[r][c];
			}
		}

		dfs(copymap, 0, count-1);
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				copymap[r][c] = map[r][c];
			}
		}
		dfs(copymap, 1, count-1);
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				copymap[r][c] = map[r][c];
			}
		}
		dfs(copymap, 2, count-1);
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				copymap[r][c] = map[r][c];
			}
		}
		dfs(copymap, 3, count-1);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		max = 0;
		int[][] copymap = new int[N][N];
		for(int r = 0; r < N; r++) {
			String[] str = in.readLine().split(" "); 
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(str[c]);
				copymap[r][c] = map[r][c];
				if(map[r][c] > max) {
					max = map[r][c];
				}
			}
		}
		
		dfs(copymap, 0, 5);
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				copymap[r][c] = map[r][c];
			}
		}
		dfs(copymap, 1, 5);
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				copymap[r][c] = map[r][c];
			}
		}
		dfs(copymap, 2, 5);
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				copymap[r][c] = map[r][c];
			}
		}
		dfs(copymap, 3, 5);
		sb.append(max);

		System.out.println(sb);
	}


	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}