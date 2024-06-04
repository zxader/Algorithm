import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][4];
		int[][] dp_min = new int[N][4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int num3 = Integer.parseInt(st.nextToken());
		dp[0][1] = num1;
		dp[0][2] = num2;
		dp[0][3] = num3;
		dp_min[0][1] = num1;
		dp_min[0][2] = num2;
		dp_min[0][3] = num3;
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			num3 = Integer.parseInt(st.nextToken());
			
			dp[i][1] = Math.max(dp[i - 1][1] + num1, dp[i - 1][2] + num1);
			dp[i][2] = Math.max(dp[i - 1][1] + num2, dp[i - 1][2] + num2);
			dp[i][2] = Math.max(dp[i][2], dp[i - 1][3] + num2);
			dp[i][3] = Math.max(dp[i - 1][2] + num3, dp[i - 1][3] + num3);
			dp_min[i][1] = Math.min(dp_min[i - 1][1] + num1, dp_min[i - 1][2] + num1);
			dp_min[i][2] = Math.min(dp_min[i - 1][1] + num2, dp_min[i - 1][2] + num2);
			dp_min[i][2] = Math.min(dp_min[i][2], dp_min[i - 1][3] + num2);
			dp_min[i][3] = Math.min(dp_min[i - 1][2] + num3, dp_min[i - 1][3] + num3);
		}
		
		int result_max = Math.max(dp[N - 1][1], dp[N - 1][2]);
		result_max = Math.max(result_max, dp[N - 1][3]);
		int result_min = Math.min(dp_min[N - 1][1], dp_min[N - 1][2]);
		result_min = Math.min(result_min, dp_min[N - 1][3]);
		System.out.println(result_max + " " + result_min);
	}
}
