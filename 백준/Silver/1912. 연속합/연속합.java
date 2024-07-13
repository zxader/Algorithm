import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];
		for (int i = 1; i < n; i++) {
			dp[i] = arr[i];
			if (dp[i] < dp[i - 1] + dp[i]) {
				dp[i] = dp[i - 1] + dp[i];
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		sb.append(max);
		System.out.println(sb);
	}
}