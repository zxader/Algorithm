import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 2; i <= N; i++) {
        	if (i >= 2 && dp[i - 2] != Integer.MAX_VALUE) {
        		dp[i] = Math.min(dp[i], dp[i - 2] + 1);
        	}
        	
        	if (i >= 5 && dp[i - 5] != Integer.MAX_VALUE) {
        		dp[i] = Math.min(dp[i], dp[i - 5] + 1);
        	}
        }
        
        if (dp[N] != Integer.MAX_VALUE) {
        	System.out.println(dp[N]);
        }
        else {
        	System.out.println(-1);
        }
    }
}