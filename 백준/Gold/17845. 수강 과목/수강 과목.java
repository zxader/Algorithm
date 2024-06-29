import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[K + 1][N + 1];
		int[][] arr = new int[K + 1][2];
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				if (arr[i][1] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				else {
					dp[i][j] = Math.max(arr[i][0] + dp[i - 1][j - arr[i][1]], dp[i - 1][j]);
				}
			}
		}
		
		sb.append(dp[K][N]);
		System.out.println(sb);
	}
}