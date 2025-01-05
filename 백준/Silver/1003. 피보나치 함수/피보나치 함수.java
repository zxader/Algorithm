import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	N = Integer.parseInt(br.readLine());
        	dp = new int[N + 1][2];
        	
        	dp[0][0] = 1;
        	dp[0][1] = 0;
        	if (N > 0) {
        		dp[1][0] = 0;
        		dp[1][1] = 1;
        	}
        	
        	for (int i = 2; i <= N; i++) {
        		dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
        		dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        	}
        	
        	sb.append(dp[N][0] + " " + dp[N][1]).append("\n");
        }
        System.out.println(sb);
    }
    
    static int fibonacci(int n) {
    	if (n == 0) {
    		return 0;
    	} else if (n == 1) {
    		return 1;
    	} else {
    		return fibonacci(n - 1) + fibonacci(n - 2);
    	}
    }
}