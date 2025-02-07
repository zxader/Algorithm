import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int K = Integer.parseInt(st.nextToken());
       int[] dp = new int[K + 1];
       final int INF = Integer.MAX_VALUE;
       
       int[] coins = new int[N];
       for (int i = 0; i < N; i++) {
    	   coins[i] = Integer.parseInt(br.readLine());
       }
       
       Arrays.fill(dp, INF);
       dp[0] = 0;
       
       for (int i = 1; i <= K; i++) {
    	   for (int j = 0; j < N; j++) {
    		   if (i - coins[j] >= 0 && dp[i - coins[j]] != INF) {
    			   dp[i] = Math.min(1 + dp[i - coins[j]], dp[i]);
    		   }
    	   }
       }
       
       System.out.println(dp[K] == INF ? -1 : dp[K]);
	}
}