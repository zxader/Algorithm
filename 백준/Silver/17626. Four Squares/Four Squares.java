import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] dp = new int[n + 1];
    	Arrays.fill(dp, 4);
    	dp[0] = 0;
    	
    	for (int i = 1; i <= n; i++) {
    		for (int j = (int)Math.sqrt(i); j >= 1; j--) {
    			dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
    		}
    	}
    	
    	System.out.println(dp[n]);
	}
}
