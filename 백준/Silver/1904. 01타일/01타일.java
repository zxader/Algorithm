import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (N > 1) dp[2] = 2;
        
        for (int i = 3; i <= N; i++) {
        	dp[i] = (2 * dp[i - 2] + dp[i - 3]) % 15746; 
        }
        
        System.out.println(dp[N] % 15746);
	}
}