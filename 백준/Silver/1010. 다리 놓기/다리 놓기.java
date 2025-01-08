import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] dp;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	dp = new int[N + 1][M + 1];
        	
        	for (int i = 0; i <= M; i++) {
        		dp[0][i] = 1;
        	}
        	
        	for (int i = 1; i <= N; i++) {
        		for (int j = i; j <= M; j++) {
        			dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
        		}
        	}
        	
        	sb.append(dp[N][M]).append("\n");
        }
        
        System.out.println(sb);
    }
    
}