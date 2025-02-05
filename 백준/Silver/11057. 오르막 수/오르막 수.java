import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];
        
        for (int i = 0; i < 10; i++) {
        	dp[1][i] = 1;
        }
        
        for (int i = 2; i <= N; i++) {
        	for (int j = 0; j < 10; j++) {
        		for (int k = 0; k <= j; k++) {
        			dp[i][j] += dp[i - 1][k] % 10007;
        		}
        	}
        }
        
        int result = 0;
        for (int i = 0; i < 10; i++) {
        	result += dp[N][i] % 10007;
        }
       
        System.out.println(result % 10007);
	}
}