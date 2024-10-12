import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static int N;
	static int M;
	static BigInteger result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 결과
		result = comb(N, M);
		sb.append(result);
		System.out.print(sb);
	}
	
	public static BigInteger comb(int n, int m) {
		
		BigInteger[][] dp = new BigInteger[n + 1][m + 1];
		
		for (int i = 0; i <= n; i++) {
			dp[i][0] = BigInteger.ONE;
		}
		for (int i = 0; i <= m; i++) {
			dp[i][i] = BigInteger.ONE;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= Math.min(i, m); j++) {
			    if (dp[i][j] == null) {
	                    dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
                }
			}
		}
		
		return dp[n][m];
	}
}