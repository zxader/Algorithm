import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	arr = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	dp = new int[N][80001];
    	
    	int K = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < K; i++) {
    		int k = Integer.parseInt(st.nextToken()) + 40000;
    		
			if (dfs(0, k) == 2) {
				sb.append("Y");
			}
			else {
				sb.append("N");
			}

    		sb.append(" ");
    	}
    	
    	System.out.println(sb);
	}
	
	static int dfs(int n, int k) {
		if (k > 80000) return 1;
		if (k == 40000) return 2;
		if (n == N) return 1;
		if (dp[n][k] != 0) return dp[n][k];
	
		int max = Math.max(dfs(n + 1, k + arr[n]), dfs(n + 1, k));
		max = Math.max(dfs(n + 1, k - arr[n]), max);
		
		return dp[n][k] = max;
	}
	
}