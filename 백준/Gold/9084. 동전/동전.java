import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int N;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringBuilder sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	for (int t = 1; t <= T; t++) {
    		N = Integer.parseInt(br.readLine());
    		arr = new int[N + 1];
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int i = 1; i <= N; i++) {
    			arr[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		int M = Integer.parseInt(br.readLine());
    		dp = new int[N + 1][M + 1];
    		
    		for (int i = 0; i <= N; i++) {
    			dp[i][0] = 1;
    		}
    		
    		for (int i = 1; i <= N; i++) {
    			for (int j = 1; j <= M; j++) {
    				dp[i][j] = dp[i - 1][j];
    				if (j >= arr[i]) dp[i][j] += dp[i][j - arr[i]];
    			}
    		}
    		
    		sb.append(dp[N][M]).append("\n");
    	}
    	
    	System.out.println(sb);
	}
}