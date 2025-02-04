import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	int[][] arr = new int[2][N];
        	for (int i = 0; i < 2; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for (int j = 0; j < N; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	int[][] dp = new int[2][N + 1];
        	dp[0][1] = arr[0][0];
        	dp[1][1] = arr[1][0];
        	
        	for (int i = 0; i < 2; i++) {
        		for (int j = 2; j <= N; j++) {
        			dp[0][j] = arr[0][j - 1] + Math.max(dp[1][j - 2], dp[1][j - 1]);
        			dp[1][j] = arr[1][j - 1] + Math.max(dp[0][j - 2], dp[0][j - 1]);
        		}
        	}
        	
        	sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
        }
        
        System.out.println(sb);
	}
}