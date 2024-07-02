import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][100];
		int[][] arr = new int[N + 1][2];

		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++){
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 99; j++) {
				if (arr[i][0] > j) {
					dp[i][j] = dp[i - 1][j]; 
				}
				else {
					dp[i][j] = Math.max(arr[i][1] + dp[i - 1][j - arr[i][0]], dp[i - 1][j]);
				}
			}
		}
		sb.append(dp[N][99]);
		System.out.println(sb);
	}
}