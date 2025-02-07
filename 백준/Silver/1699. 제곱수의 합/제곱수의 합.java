import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       int[] dp = new int[N + 1];
       final int INF = Integer.MAX_VALUE;
       Arrays.fill(dp, INF);
       
       dp[1] = 1;
       int num = 1;
       for (int i = 2; i <= N; i++) {
    	   if (i == Math.pow(num + 1, 2)) {
    		   num = num + 1;
    		   dp[i] = 1;
    	   }
    	   else {
    		   for (int j = 1; j <= num; j++) {
    			   int value = dp[i - (int)Math.pow(j, 2)] + dp[(int)Math.pow(j, 2)];
    			   dp[i] = Math.min(value, dp[i]);
    		   }
    	   }
       }
       
       System.out.println(dp[N]);
	}
}