import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;
	static int[][] map;
	static int N;
	static int count;
	static int[][] deltas = {{1,0},{1,1},{1,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		count = 0;
		dfs(0);
		sb.append(count);
		System.out.println(sb);
	}

	static void dfs(int cnt) {
		if(cnt == N) {
			count++;
			return;
		}

		for (int c = 0; c < N; c++) {
			if(map[cnt][c] == 0) {
				check(cnt,c, cnt + 1);
				map[cnt][c] = cnt + 1;
				dfs(cnt + 1);
				map[cnt][c] = 0;
				check(cnt,c, 0);
			}
		}

	}

	static boolean check(int r, int c,int v) {
		for(int d = 0; d < 3; d++) {
			int dr = r + deltas[d][0];
			int dc = c + deltas[d][1];
			while(isIn(dr,dc)) {
				if(v == 0 && map[dr][dc] != r + 1 || v != 0 && map[dr][dc] !=0) {
					dr += deltas[d][0];
					dc += deltas[d][1];
					continue;
				}
				map[dr][dc] = v;

				dr += deltas[d][0];
				dc += deltas[d][1];
			}
		}
		return true;
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}
