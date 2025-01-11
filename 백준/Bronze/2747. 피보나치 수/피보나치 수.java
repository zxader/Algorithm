import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        
        dp[0] = 0;
        dp[1] = 1;
        if(N > 1) dp[2] = 1;
        
        for (int i = 3; i <= N; i++) {
        	dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        System.out.println(dp[N]);
    }
}