import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j <= i; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken()); 
        	}
        }
        
        dp[0][0] = arr[0][0];
        
        for (int i = 1; i < N; i++) {
        	for (int j = 0; j <= i; j++) {
        		if (j == 0) {
        			dp[i][j] = arr[i][j] + dp[i - 1][j];
        		}
        		else if (j == i) {
        			dp[i][j] = arr[i][j] + dp[i - 1][j - 1];
        		}
        		else {
        			dp[i][j] = Math.max(arr[i][j] + dp[i - 1][j - 1], arr[i][j] + dp[i - 1][j]);
        		}
        	}
        }
        
        int result = 0;
        for (int i = 0; i < N; i++) {
        	result = Math.max(result, dp[N - 1][i]);
        }
        
        System.out.println(result);
    }
}