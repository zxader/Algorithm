import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			dp[i] = arr[i];
			for (int j = 0; j <= i - 1; j++) {
				if (arr[j] < arr[i] && dp[i] < dp[j] + arr[i]) {
					dp[i] = dp[j] + arr[i];
				}
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		sb.append(max);
		System.out.println(sb);
	}
}