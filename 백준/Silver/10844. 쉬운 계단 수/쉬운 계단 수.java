import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];
        
        for (int i = 1; i < 10; i++) {
        	dp[1][i] = 1;
        }
        
        for (int i = 2; i <= N; i++) {
        	for (int j = 0; j < 10; j++) {
        		if (j == 0) {
        			dp[i][j] = dp[i - 1][j + 1] % 1000000000;
        		}
        		else if (j == 9) {
        			dp[i][j] = dp[i - 1][j - 1] % 1000000000;
        		}
        		else {
        			dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000; 
        		}
        	}
        }
        
        long result = 0;
        
        for (int i = 0; i < 10; i++) {
        	result += dp[N][i];
        }
        
        System.out.println(result % 1000000000);
	}
}