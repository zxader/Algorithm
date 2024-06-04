import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int N;
	static int[][] map;
	static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static boolean[][] check;
	static int min;
	static int dp[][];

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int t = 1;
		while(true) {
			N = Integer.parseInt(in.readLine());
			if (N == 0) {
				break;
			}
			map = new int[N][N];
			dp = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					dp[r][c] = Integer.MAX_VALUE;
				}
			}
			
			for (int r = 0; r < N; r++) {
				String[] split = in.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(split[c]);
				}
			}
			dp[0][0] = map[0][0];
			Queue<Integer> qr = new ArrayDeque<>();
			Queue<Integer> qc = new ArrayDeque<>();
			
			qr.offer(0);
			qc.offer(0);
			
			while(!qr.isEmpty()) {
				int r = qr.poll();
				int c = qc.poll(); 
				for (int d = 0; d < 4; d++) {
					int dr = r + deltas[d][0];
					int dc = c + deltas[d][1];
					if (isIn(dr, dc)) {
						if(dp[r][c] + map[dr][dc] < dp[dr][dc]) {
							dp[dr][dc] = dp[r][c] + map[dr][dc];
							qr.offer(dr);
							qc.offer(dc);
						}
					}
				}
			}

			sb.append("Problem " + t + ": " + dp[N-1][N-1]).append("\n");
			t++;
		}
		System.out.println(sb);

	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}