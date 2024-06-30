import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][2];
		int sum = 0;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			sum += arr[i][1];
		}
		
		int[][] dp = new int[N + 1][K + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (arr[i][0] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				else {
					dp[i][j] = Math.max(arr[i][1] + dp[i - 1][j - arr[i][0]], dp[i - 1][j]);
				}
			}
		}
		
		sb.append(sum - dp[N][K]);
		System.out.println(sb);
	}
}