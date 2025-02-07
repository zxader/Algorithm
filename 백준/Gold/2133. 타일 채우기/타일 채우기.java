import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       int[] dp = new int[N + 1];
       dp[0] = 1;
       dp[1] = 0;
       if (N > 1) dp[2] = 3;
       if (N > 3) dp[4] = 11;
       
       for (int i = 5; i <= N; i++) {
    	   if (i % 2 == 0) {
    		   dp[i] = 3 * dp[i - 2];
    		   for (int j = i - 4; j >= 0; j -= 2) {
    			   dp[i] += 2 * dp[j];
    		   }
    	   }
    	   else {
    		   dp[i] = 0;
    	   }
       }
       
       System.out.println(dp[N]);
	}
}