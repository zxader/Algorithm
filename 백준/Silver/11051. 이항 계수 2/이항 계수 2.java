import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	dp = new int[N + 1][N + 1];
    	
    	for (int i = 0; i <= N; i++) {
    		for (int j = 0; j <= i; j++) {
    			if (j == 0 || j == i) {
    				dp[i][j] = 1;
    			}
    			else {
    				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
    			}
    		}
    	}
    	
    	System.out.println(dp[N][K]);
	}
	
}	
