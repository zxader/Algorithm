import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T + 1];
        int N = 0;
        
        for (int t = 1; t <= T; t++) {
        	arr[t] = Integer.parseInt(br.readLine());
        	N = Math.max(arr[t], N);
        }
        
    	long[] dp = new long[N + 1];
    	
    	dp[1] = 1;
    	if (N >= 2) {
    		dp[2] = 1;
    	}
    	if (N >= 3) {
    		dp[3] =1;
    	}
    	if (N >= 4) {
    		dp[4] = 2;
    	}
    	if (N >= 5) {
    		dp[5] = 2;
    	}
    	
    	for (int i = 6; i <= N; i++) {
    		dp[i] = dp[i - 1] + dp[i - 5];
    	}
    	
    	for (int i = 1; i <= T; i++) {
    		sb.append(dp[arr[i]]).append("\n");
    	}
    	
        System.out.println(sb);
        
    }
}