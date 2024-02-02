import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	static int N, M, count;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static int[]arr1;
	static int[] arr2;
	static int idx;
	static int[][] deltas = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] read = in.readLine().split(" ");

		N = Integer.parseInt(read[0]);
		M = Integer.parseInt(read[1]);
		map = new int[N][M];
		arr1 = new int[10];
		arr2 = new int[10];
		idx = 0;

		for (int r = 0; r < N; r++) {
			String[] readmap = in.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(readmap[c]);

				if(map[r][c] == 0) {
					count++;
				}
				if(map[r][c] != 0 && map[r][c] != 6) {
					arr1[idx] = r;
					arr2[idx] = c;
					idx++;
				}
			}
		}
		int[][] check = map;
		dfs(0, count, check);
		
		sb.append(min).append("\n");
		System.out.println(sb);
	}
	static void dfs(int cnt, int safe, int[][] check) {
		if(cnt == idx) {
			if(safe < min) {
				min = safe;
			}
			return;
		}

		switch (check[arr1[cnt]][arr2[cnt]]) {
		case 1:
			for(int d = 0; d < 4; d++) {
				int safecopy3 = safe;
				int[][] checkcopy3= new int[N][M];
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						checkcopy3[r][c] = check[r][c];
						}
					}
					
				
				int dr = arr1[cnt] + deltas[d][0];
				int dc = arr2[cnt] + deltas[d][1];
				while(0 <= dr && dr < N && 0 <= dc && dc < M && checkcopy3[dr][dc] != 6) {
					if (checkcopy3[dr][dc] == 0) {
						safecopy3--;
						checkcopy3[dr][dc] = 7 ;
					}
					dr += deltas[d][0];
					dc += deltas[d][1];
				}
				dfs(cnt + 1, safecopy3, checkcopy3);
			}
			break;
		case 2:
			int safecopy = safe;
			int[][] checkcopy= new int[N][M];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					checkcopy[r][c] = check[r][c];
					}
				}
			for(int d = 0; d < 2; d++) {
				int dr = arr1[cnt] + deltas[d][0];
				int dc = arr2[cnt] + deltas[d][1];

				while(0 <= dr && dr < N && 0 <= dc && dc < M && checkcopy[dr][dc] != 6) {
					if (checkcopy[dr][dc] == 0) {
						safecopy--;
						checkcopy[dr][dc] = 7 ;
					}
					dr += deltas[d][0];
					dc += deltas[d][1];
				}
			}
			dfs(cnt + 1, safecopy, checkcopy);
			safecopy = safe;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					checkcopy[r][c] = check[r][c];
					}
				} 
			for(int d = 2; d < 4; d++) {
				int dr = arr1[cnt] + deltas[d][0];
				int dc = arr2[cnt] + deltas[d][1];

				while(0 <= dr && dr < N && 0 <= dc && dc < M && checkcopy[dr][dc] != 6) {
					if (checkcopy[dr][dc] == 0) {
						safecopy--;
						checkcopy[dr][dc] = 7 ;
					}
					dr += deltas[d][0];
					dc += deltas[d][1];
				}
			}
			dfs(cnt + 1, safecopy, checkcopy);
			break;
		case 3:
			int safecopy1 = safe;
			int[][] checkcopy1= new int[N][M];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					checkcopy1[r][c] = check[r][c];
					}
				}
			for(int d = 0; d < 4; d++) {
				if(d == 1 || d == 2) continue;
				int dr = arr1[cnt] + deltas[d][0];
				int dc = arr2[cnt] + deltas[d][1];

				while(0 <= dr && dr < N && 0 <= dc && dc < M && checkcopy1[dr][dc] != 6) {
					if (checkcopy1[dr][dc] == 0) {
						safecopy1--;
						checkcopy1[dr][dc] = 7 ;
					}
					dr += deltas[d][0];
					dc += deltas[d][1];
				}
			}
			dfs(cnt + 1, safecopy1, checkcopy1);
			safecopy1 = safe;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					checkcopy1[r][c] = check[r][c];
					}
				}
			for(int d = 0; d < 4; d++) {
				if(d == 1 || d == 3) continue;
				int dr = arr1[cnt] + deltas[d][0];
				int dc = arr2[cnt] + deltas[d][1];

				while(0 <= dr && dr < N && 0 <= dc && dc < M && checkcopy1[dr][dc] != 6) {
					if (checkcopy1[dr][dc] == 0) {
						safecopy1--;
						checkcopy1[dr][dc] = 7 ;
					}
					dr += deltas[d][0];
					dc += deltas[d][1];
				}
			}
			dfs(cnt + 1, safecopy1, checkcopy1);
			safecopy1 = safe;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					checkcopy1[r][c] = check[r][c];
					}
				} 
			for(int d = 0; d < 4; d++) {
				if(d == 0 || d == 3) continue;
				int dr = arr1[cnt] + deltas[d][0];
				int dc = arr2[cnt] + deltas[d][1];

				while(0 <= dr && dr < N && 0 <= dc && dc < M && checkcopy1[dr][dc] != 6) {
					if (checkcopy1[dr][dc] == 0) {
						safecopy1--;
						checkcopy1[dr][dc] = 7 ;
					}
					dr += deltas[d][0];
					dc += deltas[d][1];
				}
			}
			dfs(cnt + 1, safecopy1, checkcopy1);
			safecopy1 = safe;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					checkcopy1[r][c] = check[r][c];
					}
				}
			for(int d = 0; d < 4; d++) {
				if(d == 0 || d == 2) continue;
				int dr = arr1[cnt] + deltas[d][0];
				int dc = arr2[cnt] + deltas[d][1];

				while(0 <= dr && dr < N && 0 <= dc && dc < M && checkcopy1[dr][dc] != 6) {
					if (checkcopy1[dr][dc] == 0) {
						safecopy1--;
						checkcopy1[dr][dc] = 7 ;
					}
					dr += deltas[d][0];
					dc += deltas[d][1];
				}
			}
			dfs(cnt + 1, safecopy1, checkcopy1);
			break;
		case 4:
			safecopy1 = safe;
			checkcopy1= new int[N][M];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					checkcopy1[r][c] = check[r][c];
					}
				}
			for(int d = 0; d < 4; d++) {
				if(d == 1) continue;
				int dr = arr1[cnt] + deltas[d][0];
				int dc = arr2[cnt] + deltas[d][1];

				while(0 <= dr && dr < N && 0 <= dc && dc < M && checkcopy1[dr][dc] != 6) {
					if (checkcopy1[dr][dc] == 0) {
						safecopy1--;
						checkcopy1[dr][dc] = 7 ;
					}
					dr += deltas[d][0];
					dc += deltas[d][1];
				}
			}
			dfs(cnt + 1, safecopy1, checkcopy1);
			safecopy1 = safe;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					checkcopy1[r][c] = check[r][c];
					}
				} 
			for(int d = 0; d < 4; d++) {
				if(d == 2) continue;
				int dr = arr1[cnt] + deltas[d][0];
				int dc = arr2[cnt] + deltas[d][1];

				while(0 <= dr && dr < N && 0 <= dc && dc < M && checkcopy1[dr][dc] != 6) {
					if (checkcopy1[dr][dc] == 0) {
						safecopy1--;
						checkcopy1[dr][dc] = 7 ;
					}
					dr += deltas[d][0];
					dc += deltas[d][1];
				}
			}
			dfs(cnt + 1, safecopy1, checkcopy1);
			safecopy1 = safe;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					checkcopy1[r][c] = check[r][c];
					}
				}
			for(int d = 0; d < 4; d++) {
				if(d == 3) continue;
				int dr = arr1[cnt] + deltas[d][0];
				int dc = arr2[cnt] + deltas[d][1];

				while(0 <= dr && dr < N && 0 <= dc && dc < M && checkcopy1[dr][dc] != 6) {
					if (checkcopy1[dr][dc] == 0) {
						safecopy1--;
						checkcopy1[dr][dc] = 7 ;
					}
					dr += deltas[d][0];
					dc += deltas[d][1];
				}
			}
			dfs(cnt + 1, safecopy1, checkcopy1);
			safecopy1 = safe;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					checkcopy1[r][c] = check[r][c];
					}
				} 
			for(int d = 0; d < 4; d++) {
				if(d == 0) continue;
				int dr = arr1[cnt] + deltas[d][0];
				int dc = arr2[cnt] + deltas[d][1];

				while(0 <= dr && dr < N && 0 <= dc && dc < M && checkcopy1[dr][dc] != 6) {
					if (checkcopy1[dr][dc] == 0) {
						safecopy1--;
						checkcopy1[dr][dc] = 7 ;
					}
					dr += deltas[d][0];
					dc += deltas[d][1];
				}
			}
			dfs(cnt + 1, safecopy1, checkcopy1);
			break;
		case 5:
			for(int d = 0; d < 4; d++) {
				int dr = arr1[cnt] + deltas[d][0];
				int dc = arr2[cnt] + deltas[d][1];

				while(0 <= dr && dr < N && 0 <= dc && dc < M && check[dr][dc] != 6) {
					if (check[dr][dc] == 0) {
						safe--;
						check[dr][dc] = 7 ;
					}
					dr += deltas[d][0];
					dc += deltas[d][1];
				}
			}
			dfs(cnt + 1, safe, check);
			break;
		}
	}


}
