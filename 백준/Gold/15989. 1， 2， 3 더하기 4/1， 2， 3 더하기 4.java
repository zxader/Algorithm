import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int[] arr = {0, 1, 2, 3};
    	int T = Integer.parseInt(br.readLine());
    	
    	StringBuilder sb = new StringBuilder();
    	for (int t = 1; t <= T; t++) {
    		int N = Integer.parseInt(br.readLine());
    		int[][] dp = new int[4][N + 1];
    		Arrays.fill(dp[1], 1);
    		
    		for (int i = 2; i <= 3; i++) {
    			dp[i][0] = 1;
    			for (int j = 1; j <= N; j++) {
    				dp[i][j] = dp[i - 1][j];
    				if (j - arr[i] >= 0) {
    					dp[i][j] += dp[i][j - arr[i]];
    				}
    			}
    		}
    		
    		sb.append(dp[3][N]).append("\n");
    	}

    	System.out.println(sb);
    }
}
